package com.ynet.finmall.gateway.jxbank.controller;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ynet.finmall.gateway.exception.GatewayErrorConstants;
import com.ynet.finmall.gateway.exception.JxBankEamsGatewayException;
import com.ynet.finmall.gateway.exception.JxBankLoanGatewayException;
import com.ynet.finmall.gateway.jxbank.client.request.ApplyYlbCallBackRequest;
import com.ynet.finmall.gateway.jxbank.client.response.ApplyYlbCallBackResponse;
import com.ynet.finmall.gateway.jxbank.response.ApplyYlbCallBack;
import com.ynet.finmall.gateway.yulebao.client.request.ApplyYlbCallBackEventRequest;
import com.ynet.finmall.gateway.yulebao.client.response.ApplyYlbCallBackEvnetResponse;
import com.ynet.finmall.gateway.yulebao.service.YlbGateway;
import com.ynet.scm.api.gateway.yulebao.ScmApplyAndContractService;

/**
 * @Description 贷款申请异步通知接口，提供给嘉兴银行调用
 * @Author 刘俊重
 * @Date 2018/1/5
 */
@Controller
@ResponseBody
@RequestMapping("/api/jxbank/loan")
public class ApplyYlbCallBackController {
	private static final Logger logger = LoggerFactory.getLogger(ApplyYlbCallBackController.class);

	@Autowired(required = false)
	private ScmApplyAndContractService scmApplyAndContractService;

	@Autowired
	private YlbGateway ylbGateway;
	
	@PostMapping("applyYlbCallBack.do")
	public ApplyYlbCallBackResponse applyYlbCallBack(@RequestBody JSONObject jsonObj){
		ApplyYlbCallBackRequest request = JSONObject.parseObject(jsonObj.toJSONString(), ApplyYlbCallBackRequest.class);
		logger.info("请求参数>>>>>>>>>>>>>"+request.toString());

		String applyId = request.getApply_id();
		if(StringUtils.isEmpty(applyId) || StringUtils.isBlank(applyId)){
			throw new JxBankLoanGatewayException(GatewayErrorConstants.PARAM_IS_NULL);
		}
		String url = "";
		try{
			//查询回调地址
			String loanInfoStr = scmApplyAndContractService.getCallBackUrl(applyId);
			JSONObject map = JSONObject.parseObject(loanInfoStr);
			Map<String,Object> callBackUrl = (Map<String,Object>)map.get("callBackUrl");
			url = callBackUrl.get("receive_url").toString();
		} catch (Exception e) {
			logger.error("嘉兴银行请求回调URL异常");
			throw new JxBankEamsGatewayException(GatewayErrorConstants.JX_REQ_RECEIVE_URL_ERROR);
		}
		//设置娱乐宝请求数据
		ApplyYlbCallBackEventRequest ylbRequest = new ApplyYlbCallBackEventRequest();
		ylbRequest.setApply_id(request.getApply_id());
		ylbRequest.setComerchant_apply_no(request.getComerchant_apply_no());
		ylbRequest.setCustomer(request.getCustomer());
		String approvalStatus = request.getApproval_status();
		ylbRequest.setApproval_status(approvalStatus);
		if("2".equals(approvalStatus)){
			//拒绝
			ylbRequest.setApproval_note(request.getApproval_note());
		}
		ylbRequest.setVoucher_no(request.getVoucher_no());
		ylbRequest.setTrans_date(request.getTrans_date());
		ylbRequest.setTrans_tradetime(request.getTrans_tradetime());

		//调用娱乐宝接口，通知其事件处理结果
		ApplyYlbCallBackEvnetResponse ylbResponse = ylbGateway.applyYlbCallBack(url, ylbRequest);

		//组织给嘉兴银行的返回数据
		ApplyYlbCallBackResponse applyYlbCallBackResponse = new ApplyYlbCallBackResponse();
		if("000000".equals(ylbResponse.getReturnCode())){
			//调用娱乐宝接口成功
			ApplyYlbCallBack applyYlbCallBack = new ApplyYlbCallBack();
			applyYlbCallBack.setApply_id(applyId);
			applyYlbCallBackResponse.setData(applyYlbCallBack);
		}else{
			applyYlbCallBackResponse.setCode(GatewayErrorConstants.YLB_SYS_ERROR);
			applyYlbCallBackResponse.setMsg("娱乐宝系统异常");
		}

		//更新贷款信息表
		String s = scmApplyAndContractService.updateApplyYlb(JSON.toJSONString(request));
		logger.info("写库结果>>>>>>>>>>>>>"+s);

		return applyYlbCallBackResponse;

	}
}
