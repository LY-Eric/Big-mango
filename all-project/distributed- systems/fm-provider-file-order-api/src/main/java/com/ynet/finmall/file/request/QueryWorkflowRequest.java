package com.ynet.finmall.file.request;

import com.ynet.finmall.common.request.AbstractRequest;

/**
 * 查询审核流模板接口
 * 
 * @author liuxin
 *
 */
public class QueryWorkflowRequest extends AbstractRequest {

	private String workflowId;// 审批流ID
	private String workflowType;// 审批流类型
	private String workflowName;// 审批流名称
	private String isCommon;// 是否通用
	private String status;// 状态（1有效2无效）
	private String adminId;// 创建人
	private String pageNo;//当前页数
	private String pageSize;//每页显示条数
	
	private String createTimeStart;//添加日期查询开始时间
	private String createTimeEnd;//添加日期查询结束时间
	
	public String getWorkflowId() {
		return workflowId;
	}
	public void setWorkflowId(String workflowId) {
		this.workflowId = workflowId;
	}
	public String getWorkflowType() {
		return workflowType;
	}
	public void setWorkflowType(String workflowType) {
		this.workflowType = workflowType;
	}
	public String getWorkflowName() {
		return workflowName;
	}
	public void setWorkflowName(String workflowName) {
		this.workflowName = workflowName;
	}
	public String getIsCommon() {
		return isCommon;
	}
	public void setIsCommon(String isCommon) {
		this.isCommon = isCommon;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getPageNo() {
		return pageNo;
	}
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	public String getPageSize() {
		return pageSize;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	public String getCreateTimeStart() {
		return createTimeStart;
	}
	public void setCreateTimeStart(String createTimeStart) {
		this.createTimeStart = createTimeStart;
	}
	public String getCreateTimeEnd() {
		return createTimeEnd;
	}
	public void setCreateTimeEnd(String createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}
	
	
//	private String remark;// 审批流描述
//	private String create_time;// 创建时间
//	private String update_time;// 更新时间
	

}
