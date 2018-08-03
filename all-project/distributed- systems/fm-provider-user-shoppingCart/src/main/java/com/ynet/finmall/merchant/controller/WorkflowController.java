package com.ynet.finmall.merchant.controller;
//package com.ynet.finmall.workflow.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.ynet.finmall.workflow.request.ChangeWorkflowRequest;
//import com.ynet.finmall.workflow.request.CreateWorkflowCheckInfoRequest;
//import com.ynet.finmall.workflow.request.CreateWorkflowRequest;
//import com.ynet.finmall.workflow.request.QueryWorkflowCheckInfoRequest;
//import com.ynet.finmall.workflow.request.QueryWorkflowDetailRequest;
//import com.ynet.finmall.workflow.request.QueryWorkflowRequest;
//import com.ynet.finmall.workflow.response.ChangeWorkflowResponse;
//import com.ynet.finmall.workflow.response.CreateWorkflowCheckInfoResponse;
//import com.ynet.finmall.workflow.response.CreateWorkflowResponse;
//import com.ynet.finmall.workflow.response.QueryWorkflowCheckInfoResponse;
//import com.ynet.finmall.workflow.response.QueryWorkflowDetailResponse;
//import com.ynet.finmall.workflow.response.QueryWorkflowResponse;
//import com.ynet.finmall.workflow.server.WorkflowServer;
//
///**
// * 审核流
// * 
// * @author liuxin
// *
// */
//@Controller
//@ResponseBody
//public class WorkflowController {
//
//	@Autowired
//	private WorkflowServer workflowServer;
//
//	/**
//	 * 创建审核流模板接口
//	 */
//	@RequestMapping("/workflow/createWorkflow.do")
//	public CreateWorkflowResponse createWorkflow(@RequestBody CreateWorkflowRequest request) {
//
//		CreateWorkflowResponse response = workflowServer.createWorkflow(request);
//		return response;
//	}
//
//	/**
//	 * 查询审核流模板接口
//	 */
//	@RequestMapping("/workflow/queryWorkflow.do")
//	public QueryWorkflowResponse queryWorkflow(@RequestBody QueryWorkflowRequest request) {
//
//		QueryWorkflowResponse response = workflowServer.queryWorkflow(request);
//		return response;
//	}
//
//	/**
//	 * 查询审核流模板明细信息
//	 */
//	@RequestMapping("/workflow/queryWorkflowDetail.do")
//	public QueryWorkflowDetailResponse queryWorkflowDetail(@RequestBody QueryWorkflowDetailRequest request) {
//
//		QueryWorkflowDetailResponse response = workflowServer.queryWorkflowDetail(request);
//		return response;
//	}
//	
//	/**
//	 * 修改审批流模板信息
//	 */
//	@RequestMapping("/workflow/changeWorkflow.do")
//	public ChangeWorkflowResponse changeWorkflow(@RequestBody ChangeWorkflowRequest request) {
//		
//		ChangeWorkflowResponse response = workflowServer.changeWorkflow(request);
//		return response;
//	}
//
//	/**
//	 * 创建审核记录
//	 */
//	@RequestMapping("/workflow/createWorkflowCheckInfo.do")
//	public CreateWorkflowCheckInfoResponse createWorkflowCheckInfo(@RequestBody CreateWorkflowCheckInfoRequest request) {
//
//		CreateWorkflowCheckInfoResponse response = workflowServer.createWorkflowCheckInfo(request);
//		return response;
//	}
//
//	/**
//	 * 查询审核记录
//	 */
//	@RequestMapping("/workflow/queryWorkflowCheckInfo.do")
//	public QueryWorkflowCheckInfoResponse queryWorkflowCheckInfo(@RequestBody QueryWorkflowCheckInfoRequest request) {
//
//		QueryWorkflowCheckInfoResponse response = workflowServer.queryWorkflowCheckInfo(request);
//		return response;
//	}
//
//}
