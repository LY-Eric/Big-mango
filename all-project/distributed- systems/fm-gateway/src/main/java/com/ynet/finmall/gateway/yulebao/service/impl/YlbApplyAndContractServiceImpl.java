package com.ynet.finmall.gateway.yulebao.service.impl;

import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.ynet.finmall.gateway.exception.GatewayErrorConstants;
import com.ynet.finmall.gateway.exception.YLBGatewayException;
import com.ynet.finmall.gateway.jxbank.request.JxApplyYlbRequest;
import com.ynet.finmall.gateway.jxbank.request.JxContractSignYlbRequest;
import com.ynet.finmall.gateway.jxbank.request.JxContractVoucherYlbRequest;
import com.ynet.finmall.gateway.jxbank.request.JxIngApprovalYlbRequest;
import com.ynet.finmall.gateway.jxbank.response.ApplyYlbListRes;
import com.ynet.finmall.gateway.jxbank.response.ContractFileList;
import com.ynet.finmall.gateway.jxbank.response.IngApprovalYlbListRes;
import com.ynet.finmall.gateway.jxbank.response.JxApplyYlbResponse;
import com.ynet.finmall.gateway.jxbank.response.JxContractSignYlbResponse;
import com.ynet.finmall.gateway.jxbank.response.JxContractVoucherYlbResponse;
import com.ynet.finmall.gateway.jxbank.response.JxIngApprovalYlbResponse;
import com.ynet.finmall.gateway.jxbank.service.JxbankGateway;
import com.ynet.finmall.gateway.utils.UploadFileUtil;
import com.ynet.finmall.gateway.yulebao.request.YLBApplyYlbRequest;
import com.ynet.finmall.gateway.yulebao.request.YLBContractSignYlbRequest;
import com.ynet.finmall.gateway.yulebao.request.YLBContractVoucherYlbRequest;
import com.ynet.finmall.gateway.yulebao.request.YLBIngApprovalYlbRequest;
import com.ynet.finmall.gateway.yulebao.response.YLBApplyYlbResponse;
import com.ynet.finmall.gateway.yulebao.response.YLBContractSignYlbResponse;
import com.ynet.finmall.gateway.yulebao.response.YLBContractVoucherYlbResponse;
import com.ynet.finmall.gateway.yulebao.response.YLBIngApprovalYlbResponse;
import com.ynet.finmall.gateway.yulebao.service.YlbApplyAndContractService;
import com.ynet.finmall.gateway.yulebao.utils.CopyUtils;
import com.ynet.scm.api.gateway.yulebao.ScmAccountInfoService;
import com.ynet.scm.api.gateway.yulebao.ScmApplyAndContractService;

/**
 * @Description 娱乐宝贷款申请和盖章相关接口
 * @Author 刘俊重
 * @Date 2018/1/16
 */
@Service
public class YlbApplyAndContractServiceImpl implements YlbApplyAndContractService {

	private static Logger logger = LoggerFactory.getLogger(YlbApplyAndContractServiceImpl.class);

	@Autowired
	private JxbankGateway jxbankGateway;

	@Autowired(required = false)
	private ScmApplyAndContractService scmApplyAndContractService;

	@Autowired
	private ScmAccountInfoService scmAccountInfoService;

	// 文件临时存放地址
	@Value("${locationTemp.url}")
	private String locationTempUrl;

	// 贷款申请回调地址（供嘉兴银行调用）
	// @Value("${gateway.jxbank.loan.apply.url}")
	// private String loanApplyUrl;

	/**
	 * @Description 贷款申请
	 * @Author 刘俊重
	 * @Date 2018/1/16
	 */
	@Override
	public YLBApplyYlbResponse applyYlb(YLBApplyYlbRequest request) {
		// 验证finmallid 正确性
//		HashMap<String, Object> map = new HashMap<String, Object>();
//		map.put("finmallId", request.getFinmall_id());
//		map.put("idNo", request.getCustomer_idcard());
//		int checkFinmallId = scmAccountInfoService.checkFinmallIdByIdNo(JSON.toJSONString(map));
//
//		if (0 == checkFinmallId) {
//			throw new YLBGatewayException(GatewayErrorConstants.YLB_FINMALLID_NOT_MATCH_ID_NO);
//		}

		JxApplyYlbRequest jxApplyYlbRequest = new JxApplyYlbRequest();
		CopyUtils.Copy(request, jxApplyYlbRequest);

		JxApplyYlbResponse jxApplyYlbResponse = jxbankGateway.applyYlb(jxApplyYlbRequest);
		YLBApplyYlbResponse ylbApplyYlbResponse = new YLBApplyYlbResponse();
		CopyUtils.Copy(jxApplyYlbResponse, ylbApplyYlbResponse);

		ApplyYlbListRes data = jxApplyYlbResponse.getData();
		if (null != jxApplyYlbResponse && "000000".equals(jxApplyYlbResponse.getCode()) && null != data) {
			request.setApply_id(data.getApply_id());
			request.setApproval_status(data.getApproval_status());
			request.setApproval_note(data.getApproval_note());
			try {
				String s = scmApplyAndContractService.saveApplyYlb(JSON.toJSONString(request));
				logger.info("写库结果>>>>>>>>>>>>>" + s);
			} catch (Exception e) {
				logger.error("--->>" + e);
				// 2.外部接口调用失败，抛出具体 外部系统调用失败异常如：YLB0004 用户中心访问失败
			}
		}

		ylbApplyYlbResponse.setReturnCode(jxApplyYlbResponse.getCode());
		ylbApplyYlbResponse.setReturnMsg(jxApplyYlbResponse.getMsg());
		return ylbApplyYlbResponse;
	}

	/**
	 * @Description 合同盖章
	 * @Author 刘俊重
	 * @Date 2018/1/16
	 */
	@Override
	public YLBContractSignYlbResponse contractSignYlb(YLBContractSignYlbRequest request) {

		// 验证finmall 正确性
		//checkFinmallId(request.getFinmall_id(), request.getApply_id());

		JxContractSignYlbRequest jxContractSignYlbRequest = new JxContractSignYlbRequest();
		CopyUtils.Copy(request, jxContractSignYlbRequest);

		JxContractSignYlbResponse jxContractSignYlbResponse = jxbankGateway.contractSignYlb(jxContractSignYlbRequest);
		logger.info("嘉兴银行响应结果>>>>>>>>>>>>" + jxContractSignYlbResponse.toString());
		YLBContractSignYlbResponse ylbContractSignYlbResponse = new YLBContractSignYlbResponse();
		CopyUtils.Copy(jxContractSignYlbResponse, ylbContractSignYlbResponse);

		if (null != jxContractSignYlbResponse && "000000".equals(jxContractSignYlbResponse.getCode())) {
			// 将行方盖章后的合同保存至oss
			ContractFileList contractFileList = jxContractSignYlbResponse.getData();
			if (contractFileList != null) {
				String contract_file = contractFileList.getContract_file();
				if (StringUtils.isNotEmpty(contract_file)) {
					String fileUrl = UploadFileUtil.uploadBase64Text(contract_file, "pdf", locationTempUrl);
					request.setContract_file_url(fileUrl); // 文件保存路径
				}
				request.setService_id(contractFileList.getBank_service_id());
			}

			// 保存至供应链系统的数据库
			try {
				String s = scmApplyAndContractService.contractSignYlb(JSON.toJSONString(request));
				logger.info("写库结果>>>>>>>>>>>>>" + s);
			} catch (Exception e) {
				logger.error("--->>" + e);
				// 2.外部接口调用失败，抛出具体 外部系统调用失败异常如：YLB0004 用户中心访问失败
			}

		}

		ylbContractSignYlbResponse.setReturnCode(jxContractSignYlbResponse.getCode());
		ylbContractSignYlbResponse.setReturnMsg(jxContractSignYlbResponse.getMsg());
		return ylbContractSignYlbResponse;
	}

	/**
	 * @Description 合同存证
	 * @Author 刘俊重
	 * @Date 2018/1/16
	 */
	@Override
	public YLBContractVoucherYlbResponse contractVoucherYlb(YLBContractVoucherYlbRequest request) {

		// 验证finmall 正确性
		//checkFinmallId(request.getFinmall_id(), request.getApply_id());

		// 获取盖章完成之后的合同文件
		String contract_file = request.getContract_file();

		JxContractVoucherYlbRequest jxContractVoucherYlbRequest = new JxContractVoucherYlbRequest();
		CopyUtils.Copy(request, jxContractVoucherYlbRequest);

		JxContractVoucherYlbResponse jxContractVoucherYlbResponse = jxbankGateway
				.contractVoucherYlb(jxContractVoucherYlbRequest);
		logger.info("嘉兴银行响应结果>>>>>>>>>>>>" + jxContractVoucherYlbResponse.toString());

		YLBContractVoucherYlbResponse ylbContractVoucherYlbResponse = new YLBContractVoucherYlbResponse();
		CopyUtils.Copy(jxContractVoucherYlbResponse, ylbContractVoucherYlbResponse);

		if (null != jxContractVoucherYlbResponse && "000000".equals(jxContractVoucherYlbResponse.getCode())) {

			String fileUrl = UploadFileUtil.uploadBase64Text(contract_file, "pdf", locationTempUrl);
			request.setContract_file_url(fileUrl); // 文件保存路径

			// 设置返回存证编号和地址
			request.setVoucher_no(jxContractVoucherYlbResponse.getData().getVoucher_no());
			request.setVoucher_url(jxContractVoucherYlbResponse.getData().getVoucher_url());
			// 保存至供应链系统的数据库
			try {
				// messageProducer.send("queue.contractVoucherYlb",JSON.toJSONString(request));
				String s = scmApplyAndContractService.contractVoucherYlb(JSON.toJSONString(request));
				logger.info("写库结果>>>>>>>>>>>>>" + s);

			} catch (Exception e) {
				logger.error("--->>" + e);
				// 2.外部接口调用失败，抛出具体 外部系统调用失败异常如：YLB0004 用户中心访问失败
			}

		}
		ylbContractVoucherYlbResponse.setReturnCode(jxContractVoucherYlbResponse.getCode());
		ylbContractVoucherYlbResponse.setReturnMsg(jxContractVoucherYlbResponse.getMsg());
		return ylbContractVoucherYlbResponse;
	}

	/**
	 * @Description 贷款审批查询
	 * @Author 刘俊重
	 * @Date 2018/3/15
	 */
	@Override
	public YLBIngApprovalYlbResponse ingApprovalYlb(YLBIngApprovalYlbRequest request) {
		JxIngApprovalYlbRequest jxIngApprovalYlbRequest = new JxIngApprovalYlbRequest();
		CopyUtils.Copy(request, jxIngApprovalYlbRequest);

		JxIngApprovalYlbResponse jxIngApprovalYlbResponse = jxbankGateway.ingApprovalYlb(jxIngApprovalYlbRequest);
		logger.info("嘉兴银行响应结果>>>>>>>>>>>>" + jxIngApprovalYlbResponse.toString());

		YLBIngApprovalYlbResponse ylbIngApprovalYlbResponse = new YLBIngApprovalYlbResponse();
		CopyUtils.Copy(jxIngApprovalYlbResponse, ylbIngApprovalYlbResponse);

		if (null != jxIngApprovalYlbResponse && "000000".equals(jxIngApprovalYlbResponse.getCode())) {
			// 获取嘉兴银行返回的每条结果并更新我们的数据库
			try {
				IngApprovalYlbListRes ingApprovalYlb = jxIngApprovalYlbResponse.getData();
				String s = scmApplyAndContractService.updateApplyYlb(JSON.toJSONString(ingApprovalYlb));
				logger.info("写库结果>>>>>>>>>>>>>" + s);
			} catch (Exception e) {
				logger.error("--->>" + e);
				// 2.外部接口调用失败，抛出具体 外部系统调用失败异常如：YLB0004 用户中心访问失败
			}

		}
		ylbIngApprovalYlbResponse.setReturnCode(jxIngApprovalYlbResponse.getCode());
		ylbIngApprovalYlbResponse.setReturnMsg(jxIngApprovalYlbResponse.getMsg());

		return ylbIngApprovalYlbResponse;
	}

	private void checkFinmallId(Long finmallId, String applyId) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("finmallId", finmallId);
		map.put("applyId", applyId);
		int checkFinmallId = scmApplyAndContractService.checkFinmallId(JSON.toJSONString(map));

		if (0 == checkFinmallId) {
			throw new YLBGatewayException(GatewayErrorConstants.YLB_FINMALLID_NOT_MACTCH_APPLY_ID);
		}
	}
}
