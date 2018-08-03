package com.ynet.finmall.gateway.yulebao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.ynet.finmall.gateway.exception.GatewayErrorConstants;
import com.ynet.finmall.gateway.yulebao.request.YLBApplyYlbRequest;
import com.ynet.finmall.gateway.yulebao.request.YLBIngApprovalYlbRequest;
import com.ynet.finmall.gateway.yulebao.request.YLBInqGrantRequest;
import com.ynet.finmall.gateway.yulebao.request.YLBLoanGrantRequest;
import com.ynet.finmall.gateway.yulebao.response.YLBApplyYlbResponse;
import com.ynet.finmall.gateway.yulebao.response.YLBIngApprovalYlbResponse;
import com.ynet.finmall.gateway.yulebao.response.YLBInqGrantResponse;
import com.ynet.finmall.gateway.yulebao.response.YLBLoanGrantResponse;
import com.ynet.finmall.gateway.yulebao.service.YlbApplyAndContractService;
import com.ynet.finmall.gateway.yulebao.service.YlbLoanGrantService;
import com.ynet.finmall.gateway.yulebao.utils.AssertUtils;

/**
 * 贷款相关
 * 
 * @author xuhui
 *
 */
@RestController
public class LoanController {
	@Autowired(required = false)
	private YlbLoanGrantService ylbLoanGrantService;
	@Autowired
	private YlbApplyAndContractService ylbApplyAndContractService;

	/**
	 * @Description 贷款申请
	 * @Author 刘俊重
	 * @Date 2018/1/5
	 */
	@PostMapping(name = "调用娱乐宝贷款申请接口", value = "/api/ylb/loan/applyYlb.do")
	public YLBApplyYlbResponse applyYlb(@RequestBody JSONObject jsonObj) {
		YLBApplyYlbRequest request = JSONObject.parseObject(jsonObj.toJSONString(), YLBApplyYlbRequest.class);
		AssertUtils.notNull(request.getFinmall_id(), GatewayErrorConstants.YLB_FINMALLID_NOT_NULL);
		YLBApplyYlbResponse ylbApplyYlbResponse = ylbApplyAndContractService.applyYlb(request);
		return ylbApplyYlbResponse;
	}

	/**
	 * @Description 贷款审批查询
	 * @Author 刘俊重
	 * @Date 2018/3/15
	 */
	@PostMapping(name = "调用娱乐宝贷贷款审批查询接口", value = "api/ylb/loan/inqApprovalYlb.do")
	public YLBIngApprovalYlbResponse ingApprovalYlb(@RequestBody JSONObject jsonObj) {
		YLBIngApprovalYlbRequest request = JSONObject.parseObject(jsonObj.toJSONString(),
				YLBIngApprovalYlbRequest.class);
		YLBIngApprovalYlbResponse ylbIngApprovalYlbResponse = ylbApplyAndContractService.ingApprovalYlb(request);
		return ylbIngApprovalYlbResponse;
	}

	@PostMapping(name = "调用娱乐宝贷款发放接口", value = "api/ylb/loan/grantYlb.do")
	public YLBLoanGrantResponse loanGrant(@RequestBody JSONObject jsonObj) {
		YLBLoanGrantRequest loanGrantRequest = JSONObject.parseObject(jsonObj.toJSONString(),
				YLBLoanGrantRequest.class);
		YLBLoanGrantResponse loanGrant = ylbLoanGrantService.loanGrant(loanGrantRequest);
		return loanGrant;
	}

	/**
	 * 备注：贷款放款查询
	 * 
	 * @author liaoyy@belink.com
	 * @param jsonObj
	 * @return
	 */
	@PostMapping(name = "娱乐宝调用贷款发放查询接口", value = "api/ylb/loan/inqGrantYlb.do")
	public YLBInqGrantResponse infoGrant(@RequestBody JSONObject jsonObj) {
		YLBInqGrantRequest inqGrantRequest = JSONObject.parseObject(jsonObj.toJSONString(), YLBInqGrantRequest.class);
		YLBInqGrantResponse inqgrant = ylbLoanGrantService.inqGrant(inqGrantRequest);
		return inqgrant;
	}

}