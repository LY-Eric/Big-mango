package com.ynet.finmall.gateway.yulebao.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ynet.finmall.gateway.jxbank.request.*;
import com.ynet.finmall.gateway.jxbank.response.*;
import com.ynet.finmall.gateway.jxbank.service.JxbankGateway;
import com.ynet.finmall.gateway.yulebao.request.*;
import com.ynet.finmall.gateway.yulebao.response.*;
import com.ynet.finmall.gateway.yulebao.service.YlbAccountInfoService;
import com.ynet.scm.api.gateway.yulebao.ScmAccountInfoService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 帐户相关的业务接口实现
 * 
 * @author qiangjiyi
 * @date 2018年1月5日 下午4:30:14
 */
@Service
public class YlbAccountInfoServiceImpl implements YlbAccountInfoService {

	private static Logger logger = LoggerFactory.getLogger(YlbAccountInfoServiceImpl.class);

	@Autowired
	private JxbankGateway jxbankGateway;

	@Autowired(required = false)
	private ScmAccountInfoService scmAccountInfoService;

	@Override
	public YLBOpenAccResponse openSecondAccount(YLBOpenAccRequest request) {
		// 这里先要将YLBOpenAccRequest转换为AccInfoOpenAccRequest
		AccInfoOpenAccRequest jx_request = new AccInfoOpenAccRequest();
		jx_request = JSONObject.parseObject(JSON.toJSONString(request), AccInfoOpenAccRequest.class);

		// 1.向嘉兴银行发起开二类户请求
		AccInfoOpenAccResponse jx_response = jxbankGateway.accInfo_openAcc(jx_request);
		// 这里要将AccInfoOpenAccResponse转换为YLBOpenAccResponse
		OpenAccInfo accInfo = JSONObject.parseObject(JSON.toJSONString(jx_response), OpenAccInfo.class);
		YLBOpenAccResponse response = new YLBOpenAccResponse();
		response.setReturnCode(jx_response.getRecode());
		response.setReturnMsg(jx_response.getRecode_info());

		// 2.判断响应代码
		if (StringUtils.isNotBlank(response.getReturnCode())) {
			// 2.1如果响应代码为“000000”，则代表开户成功
			if ("000000".equals(response.getReturnCode())) {
				response.setData(accInfo);
				// 2.2向供应链业务模块发起接口调用，进行二类户开户数据存储
				// 供应链业务模块属于内部服务，即使出错也只通过日志打印来留痕，对外娱乐宝还是以嘉兴银行调用结果为准
				JSONObject json = JSONObject.parseObject(JSON.toJSONString(request));
				json.put("original_serialno", response.getData().getOriginal_serialno());
				json.put("account_no", response.getData().getAccount_no());
				json.put("customer_no", response.getData().getCustomer_no());

				try {
					String resp = scmAccountInfoService.openSecondAccount(JSON.toJSONString(json));

					JSONObject parseObject = JSONObject.parseObject(resp);
					if ("000000".equals(parseObject.get("returnCode"))) {
						response.getData().setFinmall_id(parseObject.get("finmallId").toString());
						logger.info("供应链端存储二类户开户数据成功");
					} else {
						logger.error("供应链端存储二类户开户数据失败");
					}
				} catch (Exception e) {
					e.printStackTrace();
					logger.error("供应链端存储二类户开户数据出现错误", e.getMessage());
				}

				return response;
			}
			// 2.2否则直接返回错误代码及错误信息
			logger.error(response.getReturnCode() + "-" + response.getReturnMsg());
			return response;
		}

		// 3.如果响应代码为空，则直接报错并返回
		logger.error("向嘉兴银行发起开二类户请求出错");
		return response;
	}

	@Override
	public YLBQueryBalanceResponse queryBalance(YLBQueryBalanceRequest request) {
		// 这里先要将YLBQueryBalanceRequest转换为AccInfoQueryBalanceRequest
		AccInfoQueryBalanceRequest jx_request = new AccInfoQueryBalanceRequest();
		jx_request = JSONObject.parseObject(JSON.toJSONString(request), AccInfoQueryBalanceRequest.class);

		// 1.向嘉兴银行发起查询余额请求
		AccInfoQueryBalanceResponse jx_response = jxbankGateway.accInfo_queryBalance(jx_request);

		// 这里要将AccInfoQueryBalanceResponse转换为YLBQueryBalanceResponse
		// YLBQueryBalanceResponse response =
		// JSONObject.parseObject(JSON.toJSONString(jx_response),
		// YLBQueryBalanceResponse.class);
		QueryBalanceInfo info = JSONObject.parseObject(JSON.toJSONString(jx_response), QueryBalanceInfo.class);
		YLBQueryBalanceResponse response = new YLBQueryBalanceResponse();
		response.setReturnCode(jx_response.getRecode());
		response.setReturnMsg(jx_response.getRecode_info());

		// 2.判断响应代码
		if (StringUtils.isNotBlank(response.getReturnCode())) {
			// 2.1如果响应代码为“000000”，则代表查询余额成功
			if ("000000".equals(response.getReturnCode())) {
				response.setData(info);
				return response;
			}
			// 2.2否则直接返回错误代码及错误信息
			logger.error(response.getReturnCode() + "-" + response.getReturnMsg());
			return response;
		}

		// 3.如果响应代码为空，则直接报错并返回
		logger.error("向嘉兴银行发起查余额请求出错");
		return response;
	}

	@Override
	public YLBMerTradeMerWithdrawResponse merWithdraw(YLBMerTradeMerWithdrawRequest request) {
		// 这里先要将YLBMerTradeMerWithdrawRequest转换为MerTradeMerWithdrawRequest
		MerTradeMerWithdrawRequest jx_request = new MerTradeMerWithdrawRequest();
		jx_request = JSONObject.parseObject(JSON.toJSONString(request), MerTradeMerWithdrawRequest.class);
		// 1.将娱乐宝发起的商户取现信息保存至Finmall平台
		try {
			String result = scmAccountInfoService.saveMerWithdrawInfo(JSON.toJSONString(request));
			if (StringUtils.isNotBlank(result)) {
				JSONObject json = JSONObject.parseObject(result);
				if (StringUtils.isBlank(json.getString("returnCode"))
						|| !"000000".equals(json.getString("returnCode"))) {
					// 如果FinMall平台响应结果不正确，则直接报错并返回
					logger.error("娱乐宝发起商户取现请求出错");
				}
			}
		} catch (Exception e) {
			logger.error("保存商户取现信息错误");
		}

		// 2.向嘉兴银行发起商户取现请求
		MerTradeMerWithdrawResponse jx_response = jxbankGateway.merTrade_mer_withdraw(jx_request);

		// 这里要将MerTradeMerWithdrawResponse转换为YLBMerTradeMerWithdrawResponse
		MerTradeMerWithdrawInfo merTradeMerWithdrawInfo = JSONObject.parseObject(JSON.toJSONString(jx_response),
				MerTradeMerWithdrawInfo.class);
		YLBMerTradeMerWithdrawResponse response = new YLBMerTradeMerWithdrawResponse();
		response.setReturnCode(jx_response.getRecode());
		response.setReturnMsg(jx_response.getRecode_info());

		// 3.判断响应代码
		if (StringUtils.isNotBlank(response.getReturnCode())) {
			// 3.1如果响应代码为“000000”，则代表商户取现成功
			if ("000000".equals(response.getReturnCode())) {
				response.setData(merTradeMerWithdrawInfo);
				return response;
			}
			// 3.2否则直接返回错误代码及错误信息
			logger.error(response.getReturnCode() + "-" + response.getReturnMsg());
			return response;
		}

		// 4.如果响应代码为空，则直接报错并返回
		logger.error("向嘉兴银行发起商户取现请求出错");
		return response;
	}

	/**
	 * 商户取现查证接口
	 */
	@Override
	public YLBAerWithdrawCheckResponse merWithdrawCheck(YLBAerWithdrawCheckRequest request) {

		AerWithdrawCheckRequest jx_request = new AerWithdrawCheckRequest();
		jx_request = JSONObject.parseObject(JSON.toJSONString(request), AerWithdrawCheckRequest.class);

		AerWithdrawCheckResponse jx_res = jxbankGateway.mer_withdraw_check(jx_request);

		AerWithdrawCheckInfo checkInfo = JSONObject.parseObject(JSON.toJSONString(jx_res), AerWithdrawCheckInfo.class);

		YLBAerWithdrawCheckResponse response = new YLBAerWithdrawCheckResponse();
		if ("000000".equals(jx_res.getRecode())) {
			response.setData(checkInfo);
		}
		response.setReturnCode(jx_res.getRecode());
		response.setReturnMsg(jx_res.getRecode_info());

		return response;
	}

	/**
	 * 查询交易
	 */
	@Override
	public YLBTradeDetailsQueryTradeInfoResponse tradeDetailsQueryTradeInfo(
			YLBTradeDetailsQueryTradeInfoRequest request) {
		TradeDetailsQueryTradeInfoRequest jsonRequest = new TradeDetailsQueryTradeInfoRequest();
		jsonRequest = JSON.parseObject(JSON.toJSONString(request), TradeDetailsQueryTradeInfoRequest.class);
		// 1.向嘉兴银行发起查询交易
		TradeDetailsQueryTradeInfoResponse jx_response = jxbankGateway.tradeDetails_queryTradeInfo(jsonRequest);
		TradeDetailsQueryTradeInfo tradeDetailsQueryTradeInfo = JSON.parseObject(JSON.toJSONString(jx_response),
				TradeDetailsQueryTradeInfo.class);

		YLBTradeDetailsQueryTradeInfoResponse response = new YLBTradeDetailsQueryTradeInfoResponse();
		if ("000000".equals(jx_response.getRecode())) {
			response.setData(tradeDetailsQueryTradeInfo);
		}
		response.setReturnCode(jx_response.getRecode());
		response.setReturnMsg(jx_response.getRecode_info());
		return response;
	}

	/**
	 * 绑定账号新增
	 */
	@Override
	public YLBAccInfoAddPrimAccResponse accInfoAddPrimAcc(YLBAccInfoAddPrimAccRequest request) {
		// 这里要先将YlbAccInfoAddPrimAccRequest装换为AccInfoAddPrimAccRequest
		AccInfoAddPrimAccRequest jsonRequest = new AccInfoAddPrimAccRequest();
		jsonRequest = JSONObject.parseObject(JSON.toJSONString(request), AccInfoAddPrimAccRequest.class);
		// 1.向嘉兴银行发起绑定账号新增
		AccInfoAddPrimAccResponse response = jxbankGateway.accInfo_addPrimAcc(jsonRequest);
		// 这里要将AccInfoAddPrimAccResponse转换为YlbAccInfoAddPrimAccResponse
		AccInfoAddPrimAccInfo accInfo = JSONObject.parseObject(JSON.toJSONString(response),
				AccInfoAddPrimAccInfo.class);

		YLBAccInfoAddPrimAccResponse jsonResponse = new YLBAccInfoAddPrimAccResponse();
		if ("000000".equals(response.getRecode())) {
			jsonResponse.setData(accInfo);
		}
		jsonResponse.setReturnCode(response.getRecode());
		jsonResponse.setReturnMsg(response.getRecode_info());
		jsonResponse.setSign_data(response.getSign_data());
		return jsonResponse;
	}

	/**
	 * 绑定账号设定
	 */
	@Override
	public YLBAccInfoSetPrimAccResponse accInfoSetPrimAcc(YLBAccInfoSetPrimAccRequest request) {
		// 先将YlbAccInfoSetPrimAccRequest 转换为 AccInfoSetPrimAccRequest
		AccInfoSetPrimAccRequest jsonRequest = new AccInfoSetPrimAccRequest();
		jsonRequest = JSONObject.parseObject(JSON.toJSONString(request), AccInfoSetPrimAccRequest.class);
		// 1.向嘉兴银行发起绑定账号设定
		AccInfoSetPrimAccResponse jx_response = jxbankGateway.accInfo_setPrimAcc(jsonRequest);
		// 这里将AccInfoSetPrimAccResponse 转换为 YlbAccInfoSetPrimAccResponse
		AccInfoSetPrimAccInfo accInfoSetPrimAccInfo = JSONObject.parseObject(JSON.toJSONString(jx_response),
				AccInfoSetPrimAccInfo.class);
		
		YLBAccInfoSetPrimAccResponse response = new YLBAccInfoSetPrimAccResponse();
		response.setReturnCode(jx_response.getRecode());
		response.setReturnMsg(jx_response.getRecode_info());
		response.setSign_data(jx_response.getSign_data());
		// 2.判断响应代码
		if (StringUtils.isNotBlank(response.getReturnCode())) {
			// 2.1如果响应代码为“000000”，则代表开户成功
			if ("000000".equals(response.getReturnCode())) {
				response.setData(accInfoSetPrimAccInfo);
				Map<String, String> m = new HashMap<String, String>();
				m.put("account_no", request.getAccount_no());
				m.put("primary_account", request.getPrimary_account());
				String jsonString = JSON.toJSONString(m);
				try {
					String resp = scmAccountInfoService.accInfoSetPrimAcc(jsonString);
					if (BaseResponse.SUCCESS.equals(JSONObject.parseObject(resp).get("returnCode"))) {
						logger.info("绑定账号设定成功");
					} else {
						logger.error("绑定账号设定失败");
					}
				} catch (Exception e) {
					logger.error("绑定账号设定失败");
				}
				return response;
			}
		}
		return response;
	}
}
