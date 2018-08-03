package com.ynet.finmall.order.server.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ynet.exception.FinMallException;
import com.ynet.finmall.common.constant.ParamConstants;
import com.ynet.finmall.common.server.SerialNumber;
import com.ynet.finmall.file.model.EsWorkflow;
import com.ynet.finmall.file.model.EsWorkflowCheck;
import com.ynet.finmall.file.model.EsWorkflowCheckDetail;
import com.ynet.finmall.file.model.EsWorkflowCheckDetailQuery;
import com.ynet.finmall.file.model.EsWorkflowCheckQuery;
import com.ynet.finmall.file.model.EsWorkflowDetail;
import com.ynet.finmall.file.model.EsWorkflowDetailQuery;
import com.ynet.finmall.file.model.EsWorkflowQuery;
import com.ynet.finmall.file.model.Workflow;
import com.ynet.finmall.file.model.WorkflowCheckDetail;
import com.ynet.finmall.file.model.WorkflowCheckList;
import com.ynet.finmall.file.model.WorkflowDetail;
import com.ynet.finmall.file.request.ChangeWorkflowRequest;
import com.ynet.finmall.file.request.CreateWorkflowCheckInfoRequest;
import com.ynet.finmall.file.request.CreateWorkflowRequest;
import com.ynet.finmall.file.request.QueryWorkflowCheckInfoRequest;
import com.ynet.finmall.file.request.QueryWorkflowDetailRequest;
import com.ynet.finmall.file.request.QueryWorkflowOrderStatusRequest;
import com.ynet.finmall.file.request.QueryWorkflowRequest;
import com.ynet.finmall.file.request.QueryWorkflowWaitCheckInfoRequest;
import com.ynet.finmall.file.response.ChangeWorkflowResponse;
import com.ynet.finmall.file.response.CreateWorkflowCheckInfoResponse;
import com.ynet.finmall.file.response.CreateWorkflowResponse;
import com.ynet.finmall.file.response.QueryWorkflowCheckInfoResponse;
import com.ynet.finmall.file.response.QueryWorkflowDetailResponse;
import com.ynet.finmall.file.response.QueryWorkflowOrderStatusResponse;
import com.ynet.finmall.file.response.QueryWorkflowResponse;
import com.ynet.finmall.file.response.QueryWorkflowWaitCheckInfoResponse;
import com.ynet.finmall.file.server.WorkflowServer;
import com.ynet.finmall.order.dao.EsWorkflowCheckDao;
import com.ynet.finmall.order.dao.EsWorkflowCheckDetailDao;
import com.ynet.finmall.order.dao.EsWorkflowDao;
import com.ynet.finmall.order.dao.EsWorkflowDetailDao;
import com.ynet.finmall.order.enums.CheckResult;
import com.ynet.finmall.order.enums.RollbackStatus;
import com.ynet.finmall.order.enums.StepCode;
import com.ynet.finmall.order.enums.StepType;
import com.ynet.finmall.order.exception.ErrorConstants;

/**
 * 审核流信息表
 * 
 * @author liuxin
 *
 */
@Service("workflowServer")
public class WorkflowServerImpl implements WorkflowServer {

	// 审批流模板信息表
	@Autowired
	private EsWorkflowDao esWorkflowDao;

	// 审批流模板步骤表
	@Autowired
	private EsWorkflowDetailDao esWorkflowDetailDao;

	// 审核记录表
	@Autowired
	private EsWorkflowCheckDao esWorkflowCheckDao;

	// 审核记录步骤表
	@Autowired
	private EsWorkflowCheckDetailDao esWorkflowCheckDetailDao;

	@Autowired
	@Qualifier("serialNumber")
	private SerialNumber serialNumber;
	
	/**
	 * 创建审核流模板接口
	 */
	@Override
	public CreateWorkflowResponse createWorkflow(CreateWorkflowRequest request) {
				
		if(StringUtils.isBlank(request.getWorkflowName())){
			throw new FinMallException(ErrorConstants.WF_ID_NOT_NULL, "审批流名称不能为空");//审批流模板名称不能为空
		}
		//查询审批流名称是否已存在

		EsWorkflowQuery query = new EsWorkflowQuery();
		query.createCriteria().andWorkflowNameEqualTo(request.getWorkflowName());
		List<EsWorkflow> esWorkflow1 = esWorkflowDao.selectByExample(query);
		
		if(esWorkflow1 != null && esWorkflow1.size() != 0){
			throw new FinMallException(ErrorConstants.WF_NAME_NOT_DOUBLE, "审批流名称已经存在请更换审批流名称");//审批流名称已经存在请更换审批流名称
		}
		
		// 审批记录步骤检查
		List<WorkflowDetail> workflowDetailList = request.getWorkflowDetailList();

		// TODO 检查 stepType 步骤类型 必须有 1、2、3，检查所属步骤 必须有 1、2、3。。。
		// for(int i = 0; i < workflowDetailList.size(); i ++){
		// workflowDetailList.contains(i);
		// workflowDetailList.get(i).getStepType();
		// }

		CreateWorkflowResponse response = new CreateWorkflowResponse();

		EsWorkflow esWorkflow = new EsWorkflow();

		esWorkflow.setWorkflowId(serialNumber.getFlow(ParamConstants.WORKFLOW));// 审批流ID
		esWorkflow.setAdminId(request.getAdminId());// 创建人
		esWorkflow.setIsCommon(request.getIsCommon());// 是否通用
		esWorkflow.setRemark(request.getRemark());
		if(StringUtils.isBlank(request.getStatus())){
			esWorkflow.setStatus("1");
		}else{
			esWorkflow.setStatus(request.getStatus());// 状态（1-正常,2-冻结，3删除）默认1正常
		}
		esWorkflow.setWorkflowName(request.getWorkflowName());// 审批流名称
		esWorkflow.setWorkflowType(request.getWorkflowType());// 审批流类型
		esWorkflow.setCreateTime(new Date());
		esWorkflow.setUpdateTime(new Date());

		esWorkflowDao.insert(esWorkflow);

		response.setWorkflowId(esWorkflow.getWorkflowId());

		// List<WorkflowDetail> workflowDetailList =
		// request.getWorkflowDetailList();
		// System.out.println(" workflowDetailList : " + workflowDetailList);

		if (workflowDetailList != null) {
			for (WorkflowDetail workflowDetail : workflowDetailList) {
				EsWorkflowDetail esWorkflowDetail = new EsWorkflowDetail();

				esWorkflowDetail.setAuditor(workflowDetail.getAuditor());
				esWorkflowDetail.setCreateTime(new Date());
				esWorkflowDetail.setFailStatus(workflowDetail.getFailStatus());
				if(StringUtils.isBlank(workflowDetail.getIsRollback())){
					esWorkflowDetail.setIsRollback("2");
				}else{
//					审批流是否有驳回不能为空
					if("1".equals(workflowDetail.getIsRollback().trim()) && StringUtils.isBlank(workflowDetail.getRollbackStepCode()) ){
						throw new FinMallException(ErrorConstants.ROLLBACKSTEPCODE_NOT_NULL, "审批流可以驳回时，驳回步骤不能为空");//审批流可以驳回时，驳回步骤不能为空
					}
					esWorkflowDetail.setIsRollback(workflowDetail.getIsRollback());
				}
				esWorkflowDetail.setParentDetailId(workflowDetail.getParentDetailId());
				esWorkflowDetail.setRemark(workflowDetail.getRemark());
				esWorkflowDetail.setRollbackStatus(workflowDetail.getRollbackStatus());
				esWorkflowDetail.setRollbackStepCode(workflowDetail.getRollbackStepCode());
				esWorkflowDetail.setStatus(workflowDetail.getStatus());
				esWorkflowDetail.setStepCode(workflowDetail.getStepCode());
				esWorkflowDetail.setStepName(workflowDetail.getStepName());
				esWorkflowDetail.setStepType(workflowDetail.getStepType());
				esWorkflowDetail.setSuccessStatus(workflowDetail.getSuccessStatus());
				esWorkflowDetail.setUpdateTime(new Date());
				esWorkflowDetail.setWorkflowDetailId(serialNumber.getFlow(ParamConstants.WORKFLOW));// TODO
																					// 审批流详情ID
				esWorkflowDetail.setWorkflowId(esWorkflow.getWorkflowId());// 审批流ID

				esWorkflowDetailDao.insert(esWorkflowDetail);
			}
		}

		return response;
	}

	/**
	 * 查询审核流模板接口
	 */
	@Override
	public QueryWorkflowResponse queryWorkflow(QueryWorkflowRequest request) {

		String workflowId = request.getWorkflowId();// 审批流ID
		String workflowType = request.getWorkflowType();// 审批流类型
		String workflowName = request.getWorkflowName();// 审批流名称
		String isCommon = request.getIsCommon();// 是否通用
		String status = request.getStatus();// 状态（1-正常,2-冻结，3删除）默认1正常
		String adminId = request.getAdminId();// 创建人
		String pageNo = request.getPageNo();
		String pageSize = request.getPageSize();
		String createTimeStart = request.getCreateTimeStart();// 查询开始时间
		String createTimeEnd = request.getCreateTimeEnd();// 查询结束时间

		EsWorkflowQuery query = new EsWorkflowQuery();
		query.setOrderByClause("create_time desc");
		EsWorkflowQuery.Criteria criteria = query.createCriteria();
		
		if (!StringUtils.isBlank(adminId)) {
			criteria.andAdminIdEqualTo(adminId);
		}
		if (!StringUtils.isBlank(status)) {
			criteria.andStatusEqualTo(status);
		}else{
			criteria.andStatusNotEqualTo("3");//删除状态的不查询
		}
		if (!StringUtils.isBlank(isCommon)) {
			criteria.andIsCommonEqualTo(isCommon);
		}
		if (!StringUtils.isBlank(workflowName)) {
			criteria.andWorkflowNameLike(workflowName);
		}
		if (!StringUtils.isBlank(workflowType)) {
			criteria.andWorkflowTypeEqualTo(workflowType);
		}
		if (!StringUtils.isBlank(workflowId)) {
			criteria.andWorkflowIdEqualTo(workflowId);
		}
		if (!StringUtils.isBlank(pageNo)) {
			query.setPageNo(Integer.parseInt(pageNo));
		}
		if (!StringUtils.isBlank(pageSize)) {
			query.setPageSize(Integer.parseInt(pageSize));
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// TODO
																			// 注意前端上送时间格式
		if (!StringUtils.isBlank(createTimeStart) || !StringUtils.isBlank(createTimeEnd)) {

			Date createTimeStartDate;
			Date createTimeEndDate;

			try {
				if (!StringUtils.isBlank(createTimeStart)) {
					createTimeStartDate = sdf.parse(createTimeStart);
				} else {
					Calendar calendar = Calendar.getInstance();
					calendar.add(Calendar.YEAR, -99);
					createTimeStartDate = calendar.getTime();
				}
				if (!StringUtils.isBlank(createTimeEnd)) {
					createTimeEndDate = sdf.parse(createTimeEnd);
				} else {
					Calendar calendar = Calendar.getInstance();
					calendar.add(Calendar.YEAR, -99);
					createTimeEndDate = calendar.getTime();
				}
				criteria.andCreateTimeBetween(createTimeStartDate, createTimeEndDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		List<EsWorkflow> esWorkflowList = esWorkflowDao.selectByExample(query);
		QueryWorkflowResponse response = new QueryWorkflowResponse();

		if (esWorkflowList != null) {

			List<Workflow> workflowList = new ArrayList<Workflow>();

			for (int i = 0; i < esWorkflowList.size(); i++) {

				Workflow workflow = new Workflow();
				workflow.setAdminId(esWorkflowList.get(i).getAdminId());
				workflow.setCreateTime(esWorkflowList.get(i).getCreateTime());
				workflow.setIsCommon(esWorkflowList.get(i).getIsCommon());
				workflow.setRemark(esWorkflowList.get(i).getRemark());
				workflow.setStatus(esWorkflowList.get(i).getStatus());
				workflow.setUpdateTime(esWorkflowList.get(i).getUpdateTime());
				workflow.setWorkflowId(esWorkflowList.get(i).getWorkflowId());
				workflow.setWorkflowName(esWorkflowList.get(i).getWorkflowName());
				workflow.setWorkflowType(esWorkflowList.get(i).getWorkflowType());

				workflowList.add(workflow);
			}
			int totalCount = esWorkflowDao.countByExample(query);
			response.setWorkflowList(workflowList);
			response.setTotalCount(totalCount);

		}

		return response;
	}

	/**
	 * 查询审核流模板明细信息
	 */
	@Override
	public QueryWorkflowDetailResponse queryWorkflowDetail(QueryWorkflowDetailRequest request) {
		QueryWorkflowDetailResponse response = new QueryWorkflowDetailResponse();

		String workflow = request.getWorkflowId();

		EsWorkflowDetailQuery query = new EsWorkflowDetailQuery();
		query.createCriteria().andWorkflowIdEqualTo(workflow);
		query.setOrderByClause("step_code ");//排序
		List<EsWorkflowDetail> esWorkflowDetailList = esWorkflowDetailDao.selectByExample(query);

		List<WorkflowDetail> workflowDetailList = new ArrayList<WorkflowDetail>();
		for (int i = 0; i < esWorkflowDetailList.size(); i++) {
			WorkflowDetail workflowDetail = new WorkflowDetail();
			EsWorkflowDetail esWorkflowDetail = esWorkflowDetailList.get(i);
			workflowDetail.setAuditor(esWorkflowDetail.getAuditor());
			// esWorkflowDetail.getCreateTime()
			workflowDetail.setFailStatus(esWorkflowDetail.getFailStatus());
			workflowDetail.setIsRollback(esWorkflowDetail.getIsRollback());
			workflowDetail.setParentDetailId(esWorkflowDetail.getParentDetailId());
			workflowDetail.setRemark(esWorkflowDetail.getRemark());
			workflowDetail.setRollbackStatus(esWorkflowDetail.getRollbackStatus());
			workflowDetail.setRollbackStepCode(esWorkflowDetail.getRollbackStepCode());
			workflowDetail.setStatus(esWorkflowDetail.getStatus());
			workflowDetail.setStepCode(esWorkflowDetail.getStepCode());
			workflowDetail.setStepName(esWorkflowDetail.getStepName());
			workflowDetail.setStepType(esWorkflowDetail.getStepType());
			workflowDetail.setSuccessStatus(esWorkflowDetail.getSuccessStatus());
			// esWorkflowDetail.getWorkflowDetailId()
			// esWorkflowDetail.getWorkflowId());

			workflowDetailList.add(workflowDetail);
		}
		response.setWorkflowDetailList(workflowDetailList);

		return response;
	}

	/**
	 * 修改审批流模板信息
	 */
	@Override
	public ChangeWorkflowResponse changeWorkflow(ChangeWorkflowRequest request) {
		ChangeWorkflowResponse response = new ChangeWorkflowResponse();

		String isCommon = request.getIsCommon();// 是否通用 1-是 2-否
		String remark = request.getRemark();// 审批流模板描述
		String status = request.getStatus();// 状态（1-正常,2-冻结，3删除）
		String workflowId = request.getWorkflowId();// 审批流模板ID
		String workflowName = request.getWorkflowName();// 审批流模板名称
		String workflowType = request.getWorkflowType();// 审批流模板类型

		EsWorkflow record = new EsWorkflow();
		if(!StringUtils.isBlank(workflowId)){
			record.setWorkflowId(workflowId);
		}else{
			throw new FinMallException(ErrorConstants.WORKFLOWID_NOT_NULL);//审批流模板ID不能为空
		}
		if (StringUtils.isBlank(isCommon) && StringUtils.isBlank(remark) && StringUtils.isBlank(status) && StringUtils.isBlank(workflowName) && StringUtils.isBlank(workflowType)) {
			throw new FinMallException(ErrorConstants.ALL_NOT_NULL);//需要修改的审批流模板信息不能都为空
		}
		if(!StringUtils.isBlank(isCommon)){
			record.setIsCommon(isCommon);
		}
		if(!StringUtils.isBlank(remark)){
			record.setRemark(remark);
		}
		if(!StringUtils.isBlank(status)){
			record.setStatus(status);
		}
		if(!StringUtils.isBlank(workflowName)){
			record.setWorkflowName(workflowName);
		}
		if(!StringUtils.isBlank(workflowType)){
			record.setWorkflowType(workflowType);
		}
		
		esWorkflowDao.updateByPrimaryKeySelective(record);

		return response;
	}

	/**
	 * 创建审核记录
	 */
	@Override
	public CreateWorkflowCheckInfoResponse createWorkflowCheckInfo(CreateWorkflowCheckInfoRequest request) {
		
		String adminId = request.getAdminId();// 审核人ID
		String auditor = request.getAuditor();// 审核方
		String checkResult = request.getCheckResult();// 审核结果(1通过，2拒绝，3打回修改)	// 不为空时审核人ID、渠道编号不能为空
		String companyId = request.getCompanyId();// 企业ID
		String parentProjectId = request.getParentProjectId();// 父项目
		String remark = request.getRemark();
		String workflowId = request.getWorkflowId();// 审批流模板ID
		String serviceId = request.getServiceId();// 业务ID
		String serviceType = request.getServiceType();// 业务类型 1-融资单表 2-资产单 3-核心企业入网 4-供应商入网
		String sonProjectId = request.getSonProjectId();// 子项目id
		String channelNo = request.getChannel_no();
		String checkId = "";//serialNumber.getFlow(ParamConstants.WORKFLOW);// 审核记录表ID
		String currentStepCode = StepCode.ONE.getCode();// 当前所属步骤，默认第一步
		String rollbackStatus = request.getRollbackStatus();// 驳回状态(1-不驳回,2-驳回)
		String rollbackStepCode = request.getRollbackStepCode();// 驳回步骤
		String nextAuditorId = request.getNextAuditorId();//下一步审核方ID(企业ID营业执照号...)
		
		String orderStatus = "";//根据审批结果 判断审核后 的业务状态
		// 入参校验
		createWorkflowCheckInfoCheck(workflowId, parentProjectId, serviceId, serviceType, rollbackStatus, rollbackStepCode, checkResult, adminId, auditor, channelNo);

		// 查询审核记录 是否已经存在 如果不存在需要添加，如果已经存在则更新审核记录表，添加审核记录步骤表
		EsWorkflowCheckQuery query = new EsWorkflowCheckQuery();
		query.createCriteria().andWorkflowIdEqualTo(workflowId).andServiceIdEqualTo(serviceId).andServiceTypeEqualTo(serviceType);
		List<EsWorkflowCheck> esWorkflowCheckList = esWorkflowCheckDao.selectByExample(query);

		// 不存在审批记录 第一次添加
		if (esWorkflowCheckList == null || esWorkflowCheckList.size() == 0) {
			EsWorkflowDetail esWorkflowDetailOne = null;// 所属步骤第一步
			EsWorkflowDetail esWorkflowDetailTwo = null;// 所属步骤第二步
			
			// 审批流模板步骤表
			EsWorkflowDetailQuery esWorkflowDetailQuery = new EsWorkflowDetailQuery();
			esWorkflowDetailQuery.createCriteria().andWorkflowIdEqualTo(workflowId).andStepCodeBetween(StepCode.ONE.getCode(), StepCode.TWO.getCode());
			List<EsWorkflowDetail> esWorkflowDetailList = esWorkflowDetailDao.selectByExample(esWorkflowDetailQuery);

			if (esWorkflowDetailList == null) {//审批模板步骤不能为空
				throw new FinMallException(ErrorConstants.WORKFLOWIDID_IS_NULL);//审批流模板步骤查询为空，请联系管理员查询审批流模板步骤表
			}
		
			for (int i = 0; i < esWorkflowDetailList.size(); i++) {
				if (StepCode.ONE.getCode().equals(esWorkflowDetailList.get(i).getStepCode())) {
					esWorkflowDetailOne = esWorkflowDetailList.get(i);
				} else if (StepCode.TWO.getCode().equals(esWorkflowDetailList.get(i).getStepCode())) {
					esWorkflowDetailTwo = esWorkflowDetailList.get(i);
				}
			}

			if (esWorkflowDetailOne == null) {
				throw new FinMallException(ErrorConstants.WORKFLOWID_IS_NULL);//审核模板步骤未查询到请检查输入参数
			}
			
			checkId = serialNumber.getFlow(ParamConstants.WORKFLOW);// 审核记录表ID
			if(esWorkflowDetailTwo == null){//只有一步审核

				// 创建审批记录步骤
				if (!StringUtils.isBlank(checkResult)) {// 审批结果
					//根据审批结果 判断审核后 的业务状态
					orderStatus = this.getOrderStatus(checkResult, esWorkflowDetailOne);
					
					String workflowDetailId = esWorkflowDetailOne.getWorkflowDetailId();
					saveEsWorkflowCheckDetail(adminId, auditor, channelNo, checkId, checkResult, currentStepCode, rollbackStatus, rollbackStepCode, remark, workflowDetailId, orderStatus);
					
					// 保存审核记录表
					saveEsWorkflowCheck(checkId, workflowId, companyId, esWorkflowDetailOne.getAuditor(), 
							"", "", parentProjectId, serviceId, serviceType, sonProjectId, 
							esWorkflowDetailOne.getStepType(), esWorkflowDetailOne.getStepCode(), orderStatus, nextAuditorId);
				}else{//没有审批结果只创建审批记录

					// 保存审核记录表
					saveEsWorkflowCheck(checkId, workflowId, companyId, "", 
							esWorkflowDetailOne.getAuditor(), esWorkflowDetailOne.getStepCode(), parentProjectId, 
							serviceId, serviceType, sonProjectId, "", "", orderStatus, nextAuditorId);
				}
				
			}else{//多步审核

				// 创建审批记录步骤
				if (!StringUtils.isBlank(checkResult)) {// 审批结果
					//根据审批结果 判断审核后 的业务状态
					orderStatus = this.getOrderStatus(checkResult, esWorkflowDetailOne);
					
					String workflowDetailId = esWorkflowDetailOne.getWorkflowDetailId();
					saveEsWorkflowCheckDetail(adminId, auditor, channelNo, checkId, checkResult, currentStepCode, rollbackStatus, rollbackStepCode, remark, workflowDetailId, orderStatus);
					
					// 保存审核记录表
					saveEsWorkflowCheck(checkId, workflowId, companyId, esWorkflowDetailOne.getAuditor(), 
							esWorkflowDetailTwo.getAuditor(), esWorkflowDetailTwo.getStepCode(), parentProjectId, 
							serviceId, serviceType, sonProjectId, esWorkflowDetailOne.getStepType(), esWorkflowDetailOne.getStepCode(), orderStatus, nextAuditorId);
				}else{//没有审批结果只创建审批记录

					// 保存审核记录表
					saveEsWorkflowCheck(checkId, workflowId, companyId, "", 
							esWorkflowDetailOne.getAuditor(), esWorkflowDetailOne.getStepCode(), parentProjectId, 
							serviceId, serviceType, sonProjectId, "", "", orderStatus, nextAuditorId);
				}
			}
			
		} else if (esWorkflowCheckList.size() == 1) {// 如果已经存在则更新审核记录表，添加审核记录步骤表, 更新审核记录表 审核后业务状态
			
			if (StringUtils.isBlank(checkResult)) {// 审批记录已经存在，请输入审批结果
				throw new FinMallException(ErrorConstants.CHECKRESULT_NOT_NULL);
			}
			
			// 判断是否有下一步
			EsWorkflowCheck esWorkflowCheck = esWorkflowCheckList.get(0);
			checkId = esWorkflowCheck.getCheckId();
			String nextStepType = esWorkflowCheck.getStepType();// 步骤类型
			String nextStepCode = esWorkflowCheck.getNextStepCode();// 下一步

			if (!StepType.END.getCode().equals(nextStepType)) {
				// 更新下一步
				currentStepCode = nextStepCode;

				//当前步骤模板信息
				List<EsWorkflowDetail> esWorkflowDetailListCurrent = this.esWorkflowDetailList(workflowId, currentStepCode);
				if (esWorkflowDetailListCurrent == null || esWorkflowDetailListCurrent.size() != 1) {
					throw new FinMallException(ErrorConstants.STEP_CODE_INFO_ERROR);//步骤信息不正确，请检查审批步骤模板和审批步骤记录信息
				}

				//根据审批结果 判断审核后 的业务状态
				orderStatus = this.getOrderStatus(checkResult, esWorkflowDetailListCurrent.get(0));
				
				// 创建审批记录步骤
				String workflowDetailId = esWorkflowDetailListCurrent.get(0).getWorkflowDetailId();
				saveEsWorkflowCheckDetail(adminId, auditor, channelNo, esWorkflowCheck.getCheckId(), checkResult, currentStepCode, rollbackStatus, rollbackStepCode, remark, workflowDetailId, orderStatus);

				//判断是否驳回
				if(RollbackStatus.ROLLBACK.getCode().equals(rollbackStatus)){//驳回 

					// 查询审批流模板步骤表 获取驳回下一步 步骤信息
					List<EsWorkflowDetail> esWorkflowDetailListOne = this.esWorkflowDetailList(workflowId, (Integer.parseInt(rollbackStepCode) + 1) + "");
					
					// 更新审核记录表
					updateEsWorkflowCheck(esWorkflowCheck, esWorkflowDetailListCurrent, esWorkflowDetailListOne, currentStepCode, orderStatus);
				}else{
					// 查询审批流模板步骤表 获取下两步 步骤信息
					List<EsWorkflowDetail> esWorkflowDetailListTwo = this.esWorkflowDetailList(workflowId, (Integer.parseInt(currentStepCode) + 1) + "");
					
					// 更新审核记录表
					updateEsWorkflowCheck(esWorkflowCheck, esWorkflowDetailListCurrent, esWorkflowDetailListTwo, currentStepCode, orderStatus);
				}
				
			} else {
				throw new FinMallException(ErrorConstants.WORKFLOWEND_ERROR);//审批流程已经结束，无法插入下一步
			}

		} else if (esWorkflowCheckList.size() != 1) {// 存在多条审批记录
			throw new FinMallException(ErrorConstants.WORKFLOWE_ERROR);//请检查审批记录存在多条数据
		}
		
		CreateWorkflowCheckInfoResponse response = new CreateWorkflowCheckInfoResponse();
		
		response.setCheckId(checkId);
		response.setOrderStatus(orderStatus);
		
		return response;
	}

	/**
	 * 查询审核操作记录接口
	 */
	@Override
	public QueryWorkflowCheckInfoResponse queryWorkflowCheckInfo(QueryWorkflowCheckInfoRequest request) {
		QueryWorkflowCheckInfoResponse response = new QueryWorkflowCheckInfoResponse();

		// 审核记录ID 不为空时 其他字段可以不输入。
		// 父项目子项目输入时候 查询的是核心企业和资金方的审批记录
		// 企业ID实际是指供应商的企业ID，此字段输入时候查询的是供应商的审核记录
		// 业务ID 业务类型输入的时候查询的是 一笔交易(例如 订单交易、资产单交易)的审核信息。
		String checkId = request.getCheckId();					// 审核记录ID
		String parentProjectId = request.getParentProjectId();	// 父项目ID
		String sonProjectId = request.getSonProjectId();	// 子项目ID
		String companyId = request.getCompanyId();			// 企业ID
		String serviceId = request.getServiceId();			// 业务ID
		String serviceType = request.getServiceType();		// 业务类型 1-融资单表 2-资产单
															// 3-核心企业入网 4-供应商入网
		String auditor = request.getAuditor();		// 当前审核方
		String stepCode = request.getStepCode();	// 所属步骤类型

		if (StringUtils.isBlank(checkId) && StringUtils.isBlank(parentProjectId) && StringUtils.isBlank(sonProjectId) && StringUtils.isBlank(companyId) && StringUtils.isBlank(serviceId) && StringUtils.isBlank(serviceType)) {
			throw new FinMallException(ErrorConstants.PARAM_IS_NULL);//请输入查询参数
		}

		EsWorkflowCheckQuery example = new EsWorkflowCheckQuery();
		EsWorkflowCheckQuery.Criteria query = example.createCriteria();
		if (!StringUtils.isBlank(checkId)) {
			query.andCheckIdEqualTo(checkId);
		}
		if (!StringUtils.isBlank(parentProjectId)) {
			query.andParentProjectIdEqualTo(parentProjectId);
		}
		if (!StringUtils.isBlank(sonProjectId)) {
			query.andSonProjectIdEqualTo(sonProjectId);
		}
		if (!StringUtils.isBlank(companyId)) {
			query.andCompanyIdEqualTo(companyId);
		}
		if (!StringUtils.isBlank(serviceId)) {
			query.andServiceIdEqualTo(serviceId);
		}
		if (!StringUtils.isBlank(serviceType)) {
			query.andServiceTypeEqualTo(serviceType);
		}
		if (!StringUtils.isBlank(auditor)) {
			query.andAuditorEqualTo(auditor);
		}
		if (!StringUtils.isBlank(stepCode)) {
			query.andStepCodeEqualTo(stepCode);
		}

		List<EsWorkflowCheck> esWorkflowCheckList = esWorkflowCheckDao.selectByExample(example);
		if (esWorkflowCheckList != null) {
			List<WorkflowCheckDetail> workflowCheckDetailList = new ArrayList<WorkflowCheckDetail>();
			for (int i = 0; i < esWorkflowCheckList.size(); i++) {
				EsWorkflowCheck esWorkflowCheck = esWorkflowCheckList.get(i);

				EsWorkflowCheckDetailQuery queryCheckDetail = new EsWorkflowCheckDetailQuery();
				queryCheckDetail.createCriteria().andCheckIdEqualTo(esWorkflowCheck.getCheckId());
				List<EsWorkflowCheckDetail> esWorkflowCheckDetailList = esWorkflowCheckDetailDao.selectByExample(queryCheckDetail);
				
				if(esWorkflowCheckDetailList != null){
					for(int j = 0; j < esWorkflowCheckDetailList.size(); j ++){
						EsWorkflowDetail esWorkflowDetail = esWorkflowDetailDao.selectByPrimaryKey(esWorkflowCheckDetailList.get(j).getWorkflowDetailId());
						
						WorkflowCheckDetail workflowCheckDetail = new WorkflowCheckDetail();
						workflowCheckDetail.setStepName(esWorkflowDetail.getStepName());
						
						workflowCheckDetail.setServiceId(esWorkflowCheckList.get(i).getServiceId());
						workflowCheckDetail.setServiceType(esWorkflowCheckList.get(i).getServiceType());
						workflowCheckDetail.setParentProjectId(esWorkflowCheckList.get(i).getParentProjectId());
						workflowCheckDetail.setCompanyId(esWorkflowCheckList.get(i).getCompanyId());
						
						workflowCheckDetail.setStepCode(esWorkflowCheckDetailList.get(j).getCurrentStepCode());
						workflowCheckDetail.setAdminId(esWorkflowCheckDetailList.get(j).getAdminId());
						workflowCheckDetail.setAuditor(esWorkflowCheckDetailList.get(j).getAuditor());
						workflowCheckDetail.setChannelNo(esWorkflowCheckDetailList.get(j).getChannelNo());
						workflowCheckDetail.setCheckId(esWorkflowCheckDetailList.get(j).getCheckId());
						workflowCheckDetail.setCheckResult(esWorkflowCheckDetailList.get(j).getCheckResult());
						workflowCheckDetail.setOrderStatus(esWorkflowCheckDetailList.get(j).getOrderStatus());
						workflowCheckDetail.setRollbackStepCode(esWorkflowCheckDetailList.get(j).getRollbackStepCode());
						workflowCheckDetail.setRollbackStatus(esWorkflowCheckDetailList.get(j).getRollbackStatus());
						workflowCheckDetail.setRemark(esWorkflowCheckDetailList.get(j).getRemark());
						workflowCheckDetail.setSonProjectId(sonProjectId);
						workflowCheckDetail.setStartStatus(esWorkflowCheckDetailList.get(j).getStartStatus());
						workflowCheckDetail.setStatus(esWorkflowCheckDetailList.get(j).getStatus());
						workflowCheckDetail.setWorkflowDetailId(esWorkflowCheckDetailList.get(j).getWorkflowDetailId());
						workflowCheckDetail.setWorkflowResultId(esWorkflowCheckDetailList.get(j).getWorkflowResultId());
						workflowCheckDetail.setCreateTime(esWorkflowCheckDetailList.get(j).getCreateTime());
						
						workflowCheckDetailList.add(workflowCheckDetail);
						response.setWorkflowCheckDetailList(workflowCheckDetailList);
						
					}
				}
			}
		}

		return response;
	}
	
	/**
	 * 查询审核后业务状态接口
	 */
	@Override
	public QueryWorkflowOrderStatusResponse queryWorkflowOrderStatus(QueryWorkflowOrderStatusRequest request){
		QueryWorkflowOrderStatusResponse response = new QueryWorkflowOrderStatusResponse();

		String checkId = request.getCheckId();
		String serviceId = request.getServiceId();
		String serviceType = request.getServiceType();
		
		EsWorkflowCheckQuery query = new EsWorkflowCheckQuery();
		EsWorkflowCheckQuery.Criteria criteria = query.createCriteria();
		if(!StringUtils.isBlank(checkId)){
			criteria.andCheckIdEqualTo(checkId);	
		}
		if(!StringUtils.isBlank(serviceId)){
			criteria.andServiceIdEqualTo(serviceId);
		}
		if(!StringUtils.isBlank(serviceType)){
			criteria.andServiceTypeEqualTo(serviceType);
		}
		
		List<EsWorkflowCheck> esWorkflowCheckList = esWorkflowCheckDao.selectByExample(query);
		if(esWorkflowCheckList != null && esWorkflowCheckList.size() == 1){
			response.setOrderStatus(esWorkflowCheckList.get(0).getOrderStatus());
			response.setNextAuditor(esWorkflowCheckList.get(0).getNextAuditor());
		}
		
		return response;
	}

	/**
	 * 查询待审核记录接口
	 */
	@Override
	public QueryWorkflowWaitCheckInfoResponse queryWorkflowWaitCheckInfo(QueryWorkflowWaitCheckInfoRequest request){
		
		QueryWorkflowWaitCheckInfoResponse response = new QueryWorkflowWaitCheckInfoResponse();
		
		String nextAuditor = request.getNextAuditor();			//审核方（1finmall运营，2核心企业，3供应商，4业务方，5资金方）
		String parentProjectId = request.getParentProjectId();	//父项目ID
		String sonProjectId = request.getSonProjectId();		//子项目ID
		String nextAuditorId = request.getNextAuditorId();		//下一步审核方ID(企业ID\营业执照号。。。)
		String serviceType = request.getServiceType();			//业务类型
		
		EsWorkflowCheckQuery query = new EsWorkflowCheckQuery();
		EsWorkflowCheckQuery.Criteria criteria = query.createCriteria();
		if(!StringUtils.isBlank(nextAuditor)){
			criteria.andNextAuditorEqualTo(nextAuditor);
		}
		if(!StringUtils.isBlank(parentProjectId)){
			criteria.andParentProjectIdEqualTo(parentProjectId);
		}
		if(!StringUtils.isBlank(sonProjectId)){
			criteria.andSonProjectIdEqualTo(sonProjectId);
		}
		if(!StringUtils.isBlank(nextAuditorId)){
			criteria.andNextAuditorIdEqualTo(nextAuditorId);
		}
		if(!StringUtils.isBlank(serviceType)){
			criteria.andServiceTypeEqualTo(serviceType);
		}

		criteria.andStepTypeNotEqualTo(StepType.END.getCode());//已经结束的步骤不再查询
		
		List<EsWorkflowCheck> esWorkflowCheckList = esWorkflowCheckDao.selectByExample(query);
		
		List<WorkflowCheckList> workflowCheckList = new ArrayList<WorkflowCheckList>();
		
		if(esWorkflowCheckList != null){
			for(int i = 0 ; i < esWorkflowCheckList.size(); i ++){
				EsWorkflowCheck esWorkflowCheck = esWorkflowCheckList.get(i);
				
				WorkflowCheckList workflowCheck = new WorkflowCheckList();
				workflowCheck.setAuditor(esWorkflowCheck.getAuditor());
				workflowCheck.setCheckId(esWorkflowCheck.getCheckId());
				workflowCheck.setCompanyId(esWorkflowCheck.getCompanyId());
				workflowCheck.setCreateTime(esWorkflowCheck.getCreateTime());
				workflowCheck.setNextAuditor(esWorkflowCheck.getNextAuditor());
				workflowCheck.setNextStepCode(esWorkflowCheck.getNextStepCode());
				workflowCheck.setOrderStatus(esWorkflowCheck.getOrderStatus());
				workflowCheck.setParentProjectId(esWorkflowCheck.getParentProjectId());
				workflowCheck.setRemark(esWorkflowCheck.getRemark());
				workflowCheck.setServiceId(esWorkflowCheck.getServiceId());
				workflowCheck.setServiceType(esWorkflowCheck.getServiceType());
				workflowCheck.setSonProjectId(esWorkflowCheck.getSonProjectId());
				workflowCheck.setStatus(esWorkflowCheck.getStatus());
				workflowCheck.setStepCode(esWorkflowCheck.getStepCode());
				workflowCheck.setStepType(esWorkflowCheck.getStepType());
				workflowCheck.setUpdateTime(esWorkflowCheck.getUpdateTime());
				workflowCheck.setWorkflowId(esWorkflowCheck.getWorkflowId());
				
				workflowCheckList.add(workflowCheck);
			}
		}

		response.setWorkflowCheckDetailList(workflowCheckList);
		
		return response;
	}
	
	/**
	 * 保存审核流记录步骤
	 */
	private void saveEsWorkflowCheckDetail(String adminId, String auditor, String channelNo, String checkId, String checkResult, String currentStepCode, String rollbackStatus, String rollbackStepCode, String remark, String workflowDetailId, String orderStatus) {

		EsWorkflowCheckDetail record = new EsWorkflowCheckDetail();

		record.setAdminId(adminId);
		record.setAuditor(auditor);
		record.setChannelNo(channelNo);
		record.setCheckId(checkId);
		record.setCheckResult(checkResult);
		record.setCreateTime(new Date());
		record.setCurrentStepCode(currentStepCode);// 当前所属步骤
		record.setRollbackStatus(rollbackStatus);// 驳回状态(1-不驳回,2-驳回) rallbackStatus
		record.setRollbackStepCode(rollbackStepCode);
		record.setRemark(remark);// 备注
		record.setUpdateTime(new Date());
		record.setWorkflowDetailId(workflowDetailId);// 审批流模板详情表ID
		record.setWorkflowResultId(serialNumber.getFlow(ParamConstants.WORKFLOW));// 审核记录步骤ID
		record.setOrderStatus(orderStatus);
		
		// record.setStartStatus(startStatus);//审核前状态
		// record.setStatus(status);//预留字段
		esWorkflowCheckDetailDao.insert(record);
	}

	/**
	 * 保存审核记录表
	 */
	private void saveEsWorkflowCheck(String checkId, String workflowId, String companyId, String oneAuditor, String twoAuditor, 
			String twoStepCode, String parentProjectId, String serviceId, String serviceType, String sonProjectId, String stepType,
			String stepCode, String orderStatus, String nextAuditorId) {

		// 创建审批记录
		EsWorkflowCheck esWorkflowCheck = new EsWorkflowCheck();

		esWorkflowCheck.setCheckId(checkId); // 审核记录表ID
		esWorkflowCheck.setWorkflowId(workflowId);// 审批流模板ID
		esWorkflowCheck.setCompanyId(companyId);
		esWorkflowCheck.setAuditor(oneAuditor);// 审核方
												// esWorkflowDetailOne.getAuditor()
		esWorkflowCheck.setNextAuditor(twoAuditor);// 下一步审核方esWorkflowDetailTwo.getAuditor()
		esWorkflowCheck.setNextStepCode(twoStepCode);// 下一步所属步骤esWorkflowDetailTwo.getStepCode()
		esWorkflowCheck.setParentProjectId(parentProjectId);// 父项目ID
		// esWorkflowCheck.setRemark(request.getRemark());
		esWorkflowCheck.setServiceId(serviceId);
		esWorkflowCheck.setServiceType(serviceType);
		esWorkflowCheck.setSonProjectId(sonProjectId);
		// esWorkflowCheck.setStatus(status);// 预留字段
		esWorkflowCheck.setStepType(stepType);
		esWorkflowCheck.setCreateTime(new Date());
		esWorkflowCheck.setUpdateTime(new Date());
		esWorkflowCheck.setStepCode(stepCode);
		esWorkflowCheck.setOrderStatus(orderStatus);
		if(!StringUtils.isBlank(nextAuditorId)){
			esWorkflowCheck.setNextAuditorId(nextAuditorId);			
		}
		
		esWorkflowCheckDao.insert(esWorkflowCheck);
	}

	/**
	 * 更新审核记录表
	 */
	private void updateEsWorkflowCheck(EsWorkflowCheck esWorkflowCheck, List<EsWorkflowDetail> esWorkflowDetailCurrentList, List<EsWorkflowDetail> esWorkflowDetailTwoList, String currentStepCode, String orderStatus) {
		EsWorkflowDetail esWorkflowDetailOne = null;
		EsWorkflowDetail esWorkflowDetailTwo = null;
		
		if(esWorkflowDetailCurrentList != null && esWorkflowDetailCurrentList.size() != 0){
			esWorkflowDetailOne = esWorkflowDetailCurrentList.get(0);
			esWorkflowCheck.setStepType(esWorkflowDetailOne.getStepType());
		}
		if(esWorkflowDetailTwoList != null && esWorkflowDetailTwoList.size() != 0){
			esWorkflowDetailTwo = esWorkflowDetailTwoList.get(0);
		}
		
		esWorkflowCheck.setStepCode(currentStepCode);

		// 当前所属步骤类型
		esWorkflowCheck.setUpdateTime(new Date());

		esWorkflowCheck.setOrderStatus(orderStatus);
		
		if(esWorkflowDetailTwo != null){
			if (!StringUtils.isBlank(esWorkflowDetailTwo.getStepCode())) {
				esWorkflowCheck.setNextStepCode(esWorkflowDetailTwo.getStepCode());// 下一步所属步骤
			}
			if (!StringUtils.isBlank(esWorkflowDetailTwo.getAuditor())) {
				esWorkflowCheck.setNextAuditor(esWorkflowDetailTwo.getAuditor());// 下一步审核方
			}
			if (!StringUtils.isBlank(esWorkflowDetailOne.getAuditor())) {
				esWorkflowCheck.setAuditor(esWorkflowDetailOne.getAuditor());// 下一步审核方
			}
		}

		esWorkflowCheckDao.updateByPrimaryKeySelective(esWorkflowCheck);
	}

	private void createWorkflowCheckInfoCheck(String workflowId, String parentProjectId, String serviceId, String serviceType, String rollbackStatus, String rollbackStepCode, String checkResult, String adminId, String auditor, String channelNo) {

		if (StringUtils.isBlank(workflowId)) {
			throw new FinMallException(ErrorConstants.WORKFLOWEID_NOT_NULL);//审批流模板ID,不能为空
		}
		if (StringUtils.isBlank(parentProjectId)) {
			throw new FinMallException(ErrorConstants.PARENT_PROJECT_ID_NOT_NULL);//父项目ID,不能为空
		}
		if (StringUtils.isBlank(serviceId)) {
			throw new FinMallException(ErrorConstants.SERVICE_ID_NOT_NULL);//业务ID,不能为空
		}
		if (StringUtils.isBlank(serviceType)) {
			throw new FinMallException(ErrorConstants.SERVICE_TYPE_NOT_NULL);//业务类型,不能为空
		}
		if (!StringUtils.isBlank(rollbackStatus) && RollbackStatus.ROLLBACK.getCode().equals(rollbackStatus) && StringUtils.isBlank(rollbackStepCode)) {
			throw new FinMallException(ErrorConstants.ROLLBACK_STEP_CODE_NOT_NULL);//审核记录被驳回时，驳回步骤不能为空
		}
		if (!StringUtils.isBlank(checkResult)) {
			if (StringUtils.isBlank(adminId)) {
				throw new FinMallException(ErrorConstants.ADMIN_ID_NOT_NULL);//有审核结果时候，审核人ID不能为空
			}
//			if (StringUtils.isBlank(auditor)) {
//				throw new FinMallException(ErrorConstants.AUDITOR_NOT_NULL);//有审核结果时候，审核方不能为空
//			}
			if (StringUtils.isBlank(channelNo)) {
				throw new FinMallException(ErrorConstants.CHANNEL_NO_NOT_NULL);//有审核结果时候，审核渠道编号不能为空
			}
		}
	}

	/**
	 * 查询审批流模板步骤表
	 */
	public List<EsWorkflowDetail> esWorkflowDetailList(String workflowId, String stepCode){
		// 查询审批流模板步骤表
		EsWorkflowDetailQuery esWorkflowDetailQuery = new EsWorkflowDetailQuery();
		esWorkflowDetailQuery.createCriteria().andWorkflowIdEqualTo(workflowId).andStepCodeEqualTo(stepCode);
		List<EsWorkflowDetail> esWorkflowDetailList = esWorkflowDetailDao.selectByExample(esWorkflowDetailQuery);
		return esWorkflowDetailList;
	}


	/**
	 * 根据审批结果 判断审核后 的业务状态
	 * @param checkResult          审批结果
	 * @param esWorkflowDetailOne  审批流模板
	 * @return
	 */
	public String getOrderStatus(String checkResult, EsWorkflowDetail esWorkflowDetailOne){
		String orderStatus = "";
		
		if(CheckResult.CONCENT.getCode().equals(checkResult)){//通过修改
			orderStatus = esWorkflowDetailOne.getSuccessStatus();
		}
		if(CheckResult.REFUSE.getCode().equals(checkResult)){//拒绝
			orderStatus = esWorkflowDetailOne.getFailStatus();
		}
		if(CheckResult.MODIFY.getCode().equals(checkResult)){//回滚
			orderStatus = esWorkflowDetailOne.getRollbackStatus();
		}
		return orderStatus;
	}

	
}
