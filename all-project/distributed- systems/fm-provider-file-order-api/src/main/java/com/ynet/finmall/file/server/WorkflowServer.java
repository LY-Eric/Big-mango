package com.ynet.finmall.file.server;

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

/**
 * 审核流信息表
 * 
 * @author liuxin
 *
 */
public interface WorkflowServer {

	/**
	 * 创建审核流模板接口
	 */
	public CreateWorkflowResponse createWorkflow(CreateWorkflowRequest request);

	/**
	 * 查询审核流模板接口
	 */
	public QueryWorkflowResponse queryWorkflow(QueryWorkflowRequest request);

	/**
	 * 查询审核流模板明细信息
	 */
	public QueryWorkflowDetailResponse queryWorkflowDetail(QueryWorkflowDetailRequest request);

	/**
	 * 查询审核后业务状态接口
	 */
	public QueryWorkflowOrderStatusResponse queryWorkflowOrderStatus(QueryWorkflowOrderStatusRequest request);
	
	/**
	 * 修改审批流模板信息
	 */
	public ChangeWorkflowResponse changeWorkflow(ChangeWorkflowRequest request);

	/**
	 * 创建审核记录
	 */
	public CreateWorkflowCheckInfoResponse createWorkflowCheckInfo(CreateWorkflowCheckInfoRequest request);

	/**
	 * 查询审核记录
	 */
	public QueryWorkflowCheckInfoResponse queryWorkflowCheckInfo(QueryWorkflowCheckInfoRequest request);

	/**
	 * 查询待审核记录
	 */
	public QueryWorkflowWaitCheckInfoResponse queryWorkflowWaitCheckInfo(QueryWorkflowWaitCheckInfoRequest request);
}
