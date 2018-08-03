package com.ynet.finmall.gateway.yulebao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.ynet.finmall.gateway.exception.GatewayErrorConstants;
import com.ynet.finmall.gateway.yulebao.request.YLBAccInfoAddPrimAccRequest;
import com.ynet.finmall.gateway.yulebao.request.YLBAccInfoSetPrimAccRequest;
import com.ynet.finmall.gateway.yulebao.request.YLBAerWithdrawCheckRequest;
import com.ynet.finmall.gateway.yulebao.request.YLBMerTradeMerWithdrawRequest;
import com.ynet.finmall.gateway.yulebao.request.YLBOpenAccRequest;
import com.ynet.finmall.gateway.yulebao.request.YLBQueryBalanceRequest;
import com.ynet.finmall.gateway.yulebao.request.YLBTradeDetailsQueryTradeInfoRequest;
import com.ynet.finmall.gateway.yulebao.response.YLBAccInfoAddPrimAccResponse;
import com.ynet.finmall.gateway.yulebao.response.YLBAccInfoSetPrimAccResponse;
import com.ynet.finmall.gateway.yulebao.response.YLBAerWithdrawCheckResponse;
import com.ynet.finmall.gateway.yulebao.response.YLBMerTradeMerWithdrawResponse;
import com.ynet.finmall.gateway.yulebao.response.YLBOpenAccResponse;
import com.ynet.finmall.gateway.yulebao.response.YLBQueryBalanceResponse;
import com.ynet.finmall.gateway.yulebao.response.YLBTradeDetailsQueryTradeInfoResponse;
import com.ynet.finmall.gateway.yulebao.service.YlbAccountInfoService;
import com.ynet.finmall.gateway.yulebao.utils.AssertUtils;

/**
 * 帐户相关的请求控制
 * 
 * @author qiangjiyi
 * @date 2018年1月5日 下午3:49:05
 */
@RestController
public class AccountInfoController {
	@Autowired
	private YlbAccountInfoService accountInfoService;

	/**
	 * 1.2.2二类户开户
	 */
	@PostMapping(name = "调用娱乐宝贷二类户开户接口", value = "/api/ylb/accInfo/openAcc.do")
	public YLBOpenAccResponse openSecondAccount(@RequestBody JSONObject jsonObj) {
		YLBOpenAccRequest request = JSONObject.parseObject(jsonObj.toJSONString(), YLBOpenAccRequest.class);
		AssertUtils.notNull(request.getFinmall_id(), GatewayErrorConstants.YLB_FINMALLID_NOT_NULL);
		YLBOpenAccResponse result = accountInfoService.openSecondAccount(request);
		return result;
	}

	/**
	 * 1.2.11查询余额
	 */
	@PostMapping(name = "调用娱乐宝贷查询余额接口", value = "/api/ylb/accInfo/queryBalance.do")
	public YLBQueryBalanceResponse queryBalance(@RequestBody JSONObject jsonObj) {
		YLBQueryBalanceRequest request = JSONObject.parseObject(jsonObj.toJSONString(), YLBQueryBalanceRequest.class);
		YLBQueryBalanceResponse result = accountInfoService.queryBalance(request);
		return result;
	}

	/**
	 * 1.2.12商户（娱乐宝）取现
	 */
	@PostMapping(name = "调用娱乐宝商户（娱乐宝）取现接口", value = "/api/ylb/merTrade/merWithdraw.do")
	public YLBMerTradeMerWithdrawResponse merWithdraw(@RequestBody JSONObject jsonObj) {
		YLBMerTradeMerWithdrawRequest request = JSONObject.parseObject(jsonObj.toJSONString(),
				YLBMerTradeMerWithdrawRequest.class);
		YLBMerTradeMerWithdrawResponse result = accountInfoService.merWithdraw(request);
		return result;
	}

	/**
	 * 1.2.21 商户取现查证接口
	 */
	@PostMapping(name = "调用娱乐宝商户商户取现查证接口", value = "/api/ylb/loan/merTrade/merWithdrawCheck.do")
	public YLBAerWithdrawCheckResponse merWithdrawCheck(@RequestBody JSONObject jsonObj) {
		YLBAerWithdrawCheckRequest request = JSONObject.parseObject(jsonObj.toJSONString(),
				YLBAerWithdrawCheckRequest.class);

		YLBAerWithdrawCheckResponse result = accountInfoService.merWithdrawCheck(request);
		return result;
	}

	/**
	 * 查询交易
	 */
	@PostMapping(name = "调用娱乐宝查询交易接口", value = "/api/ylb/tradeDetails/queryTradeInfo.do")
	public YLBTradeDetailsQueryTradeInfoResponse tradeDetailsQueryTradeInfo(@RequestBody JSONObject jsonObject) {
		YLBTradeDetailsQueryTradeInfoRequest request = JSONObject.parseObject(jsonObject.toJSONString(),
				YLBTradeDetailsQueryTradeInfoRequest.class);
		YLBTradeDetailsQueryTradeInfoResponse response = accountInfoService.tradeDetailsQueryTradeInfo(request);
		return response;
	}

	/**
	 * 绑定账号新增
	 */
	@PostMapping(name = "调用娱乐宝商户 绑定账号新增接口", value = "/api/ylb/accInfo/addPrimAcc.do")
	public YLBAccInfoAddPrimAccResponse accInfoAddPrimAcc(@RequestBody JSONObject jsonObject) {
		YLBAccInfoAddPrimAccRequest request = JSONObject.parseObject(jsonObject.toJSONString(),
				YLBAccInfoAddPrimAccRequest.class);
		YLBAccInfoAddPrimAccResponse response = accountInfoService.accInfoAddPrimAcc(request);
		return response;
	}

	/**
	 * 绑定账号设定
	 */
	@PostMapping(name = "调用娱乐宝商户 绑定账号设定接口", value = "/api/ylb/accInfo/setPrimAcc.do")
	public YLBAccInfoSetPrimAccResponse accInfoSetPrimAcc(@RequestBody JSONObject jsonObject) {
		YLBAccInfoSetPrimAccRequest request = JSONObject.parseObject(jsonObject.toJSONString(),
				YLBAccInfoSetPrimAccRequest.class);

		YLBAccInfoSetPrimAccResponse result = accountInfoService.accInfoSetPrimAcc(request);
		return result;
	}

}
