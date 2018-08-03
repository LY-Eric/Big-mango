package com.ynet.finmall.merchant.server;

import com.ynet.finmall.merchant.request.ChangeWorkflowRequest;
import com.ynet.finmall.merchant.request.CreateWorkflowCheckInfoRequest;
import com.ynet.finmall.merchant.request.CreateWorkflowRequest;
import com.ynet.finmall.merchant.request.QueryWorkflowCheckInfoRequest;
import com.ynet.finmall.merchant.request.QueryWorkflowDetailRequest;
import com.ynet.finmall.merchant.request.QueryWorkflowOrderStatusRequest;
import com.ynet.finmall.merchant.request.QueryWorkflowRequest;
import com.ynet.finmall.merchant.request.QueryWorkflowWaitCheckInfoRequest;
import com.ynet.finmall.merchant.response.ChangeWorkflowResponse;
import com.ynet.finmall.merchant.response.CreateWorkflowCheckInfoResponse;
import com.ynet.finmall.merchant.response.CreateWorkflowResponse;
import com.ynet.finmall.merchant.response.QueryWorkflowCheckInfoResponse;
import com.ynet.finmall.merchant.response.QueryWorkflowDetailResponse;
import com.ynet.finmall.merchant.response.QueryWorkflowOrderStatusResponse;
import com.ynet.finmall.merchant.response.QueryWorkflowResponse;
import com.ynet.finmall.merchant.response.QueryWorkflowWaitCheckInfoResponse;

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
