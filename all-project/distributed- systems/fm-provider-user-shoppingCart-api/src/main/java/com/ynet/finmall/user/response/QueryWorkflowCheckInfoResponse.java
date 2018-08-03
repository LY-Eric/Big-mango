package com.ynet.finmall.user.response;

import java.util.List;

import com.ynet.finmall.common.response.AbstractResponse;
import com.ynet.finmall.user.model.WorkflowCheckDetail;

/**
 * 查询审核记录
 */
public class QueryWorkflowCheckInfoResponse extends AbstractResponse {

//	private String check_id	  	;//审批流审核表ID
//	private String project_id	;//项目ID
//	private String service_id	;//业务ID
//	private String service_type	;//业务类型 1-融资单表 2-资产单 3-核心企业入网 4-供应商入网
//	private String workflow_id	;//审批流ID
//	private String workflow_type;//审批流类型
//	private String workflow_name;//审批流名称
//	private String is_common	;//是否通用
//	private String remark		;//审批流描述
//	private String status		;//状态（1有效,2无效）默认有效
//	private String admin_id		;//创建人
	
	List<WorkflowCheckDetail> workflowCheckDetailList;//审核记录步骤集合

	public List<WorkflowCheckDetail> getWorkflowCheckDetailList() {
		return workflowCheckDetailList;
	}

	public void setWorkflowCheckDetailList(List<WorkflowCheckDetail> workflowCheckDetailList) {
		this.workflowCheckDetailList = workflowCheckDetailList;
	}
	

	
}
