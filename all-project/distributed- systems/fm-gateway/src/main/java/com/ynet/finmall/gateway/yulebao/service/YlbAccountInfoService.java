package com.ynet.finmall.gateway.yulebao.service;

import com.ynet.finmall.gateway.yulebao.request.YLBAerWithdrawCheckRequest;
import com.ynet.finmall.gateway.yulebao.request.YLBMerTradeMerWithdrawRequest;
import com.ynet.finmall.gateway.yulebao.request.YLBOpenAccRequest;
import com.ynet.finmall.gateway.yulebao.request.YLBQueryBalanceRequest;
import com.ynet.finmall.gateway.yulebao.request.YLBTradeDetailsQueryTradeInfoRequest;
import com.ynet.finmall.gateway.yulebao.request.YLBAccInfoAddPrimAccRequest;
import com.ynet.finmall.gateway.yulebao.request.YLBAccInfoSetPrimAccRequest;
import com.ynet.finmall.gateway.yulebao.response.YLBAerWithdrawCheckResponse;
import com.ynet.finmall.gateway.yulebao.response.YLBMerTradeMerWithdrawResponse;
import com.ynet.finmall.gateway.yulebao.response.YLBOpenAccResponse;
import com.ynet.finmall.gateway.yulebao.response.YLBQueryBalanceResponse;
import com.ynet.finmall.gateway.yulebao.response.YLBTradeDetailsQueryTradeInfoResponse;
import com.ynet.finmall.gateway.yulebao.response.YLBAccInfoAddPrimAccResponse;
import com.ynet.finmall.gateway.yulebao.response.YLBAccInfoSetPrimAccResponse;

/**
 * 帐户相关的接口
 * @author qiangjiyi
 * @date 2018年1月5日 下午4:29:08
 */
public interface YlbAccountInfoService {

	/**
	 * 二类户开户
	 */
	YLBOpenAccResponse openSecondAccount(YLBOpenAccRequest request);
	
	/**
	 * 查询余额
	 */
	YLBQueryBalanceResponse queryBalance(YLBQueryBalanceRequest request);

	/**
	 * 商户（娱乐宝）取现
	 */
	YLBMerTradeMerWithdrawResponse merWithdraw(YLBMerTradeMerWithdrawRequest request);

	/**
	 * 商户取现查证接口
	 */
	YLBAerWithdrawCheckResponse merWithdrawCheck(YLBAerWithdrawCheckRequest request);
	/**
	 * 查询交易
	 */
	YLBTradeDetailsQueryTradeInfoResponse tradeDetailsQueryTradeInfo(YLBTradeDetailsQueryTradeInfoRequest request);
	
	/**
	 * 绑定账号新增
	 */
	YLBAccInfoAddPrimAccResponse accInfoAddPrimAcc(YLBAccInfoAddPrimAccRequest request);
	
	/**
	 * 绑定账号设定
	 */
	YLBAccInfoSetPrimAccResponse accInfoSetPrimAcc(YLBAccInfoSetPrimAccRequest request);
	
	
}
