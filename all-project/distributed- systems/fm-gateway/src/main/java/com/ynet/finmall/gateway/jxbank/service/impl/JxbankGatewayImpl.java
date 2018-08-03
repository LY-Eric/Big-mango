package com.ynet.finmall.gateway.jxbank.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.ynet.finmall.gateway.jxbank.JxBankHttpGateway;
import com.ynet.finmall.gateway.jxbank.event.BalanceDetail;
import com.ynet.finmall.gateway.jxbank.event.OrderDownFileDetail;
import com.ynet.finmall.gateway.jxbank.request.AccInfoAddPrimAccRequest;
import com.ynet.finmall.gateway.jxbank.request.AccInfoOpenAccRequest;
import com.ynet.finmall.gateway.jxbank.request.AccInfoQueryBalanceRequest;
import com.ynet.finmall.gateway.jxbank.request.AccInfoSetPrimAccRequest;
import com.ynet.finmall.gateway.jxbank.request.AerWithdrawCheckRequest;
import com.ynet.finmall.gateway.jxbank.request.JxApplyYlbRequest;
import com.ynet.finmall.gateway.jxbank.request.JxContractSignYlbRequest;
import com.ynet.finmall.gateway.jxbank.request.JxContractVoucherYlbRequest;
import com.ynet.finmall.gateway.jxbank.request.JxFileUploadRequest;
import com.ynet.finmall.gateway.jxbank.request.JxIngApprovalYlbRequest;
import com.ynet.finmall.gateway.jxbank.request.JxInqGrantRequest;
import com.ynet.finmall.gateway.jxbank.request.JxLoanApplyRequest;
import com.ynet.finmall.gateway.jxbank.request.JxLoanGrantRequest;
import com.ynet.finmall.gateway.jxbank.request.JxLoanReturnQueryRequest;
import com.ynet.finmall.gateway.jxbank.request.JxLoanReturnRequest;
import com.ynet.finmall.gateway.jxbank.request.JxOrderDownFileRequest;
import com.ynet.finmall.gateway.jxbank.request.JxRepaySearchSingleRequest;
import com.ynet.finmall.gateway.jxbank.request.JxRepaySingleRequest;
import com.ynet.finmall.gateway.jxbank.request.MerTradeMerWithdrawRequest;
import com.ynet.finmall.gateway.jxbank.request.TradeDetailsQueryTradeInfoRequest;
import com.ynet.finmall.gateway.jxbank.request.TradeDetailsQueryTradeListRequest;
import com.ynet.finmall.gateway.jxbank.response.AccInfoAddPrimAccResponse;
import com.ynet.finmall.gateway.jxbank.response.AccInfoOpenAccResponse;
import com.ynet.finmall.gateway.jxbank.response.AccInfoQueryBalanceResponse;
import com.ynet.finmall.gateway.jxbank.response.AccInfoSetPrimAccResponse;
import com.ynet.finmall.gateway.jxbank.response.AerWithdrawCheckResponse;
import com.ynet.finmall.gateway.jxbank.response.JxApplyYlbResponse;
import com.ynet.finmall.gateway.jxbank.response.JxContractSignYlbResponse;
import com.ynet.finmall.gateway.jxbank.response.JxContractVoucherYlbResponse;
import com.ynet.finmall.gateway.jxbank.response.JxFileUploadResponse;
import com.ynet.finmall.gateway.jxbank.response.JxIngApprovalYlbResponse;
import com.ynet.finmall.gateway.jxbank.response.JxInqGrantResponse;
import com.ynet.finmall.gateway.jxbank.response.JxLoanApplyResponse;
import com.ynet.finmall.gateway.jxbank.response.JxLoanGrantResponse;
import com.ynet.finmall.gateway.jxbank.response.JxLoanReturnQueryResponse;
import com.ynet.finmall.gateway.jxbank.response.JxLoanReturnResponse;
import com.ynet.finmall.gateway.jxbank.response.JxOrderDownFileResponse;
import com.ynet.finmall.gateway.jxbank.response.JxRepaySearchSingleResponse;
import com.ynet.finmall.gateway.jxbank.response.JxRepaySingleResponse;
import com.ynet.finmall.gateway.jxbank.response.MerTradeMerWithdrawResponse;
import com.ynet.finmall.gateway.jxbank.response.TradeDetailsQueryTradeInfoResponse;
import com.ynet.finmall.gateway.jxbank.response.TradeDetailsQueryTradeListResponse;
import com.ynet.finmall.gateway.jxbank.service.JxbankGateway;
import com.ynet.finmall.gateway.yulebao.response.YLBLoanGrant;

/**
 * 嘉兴银行网关通讯接口
 * 
 * @author liuxin
 * 
 */
@Component("jxbankGateway")
public class JxbankGatewayImpl implements JxbankGateway {
	private static final Logger logger = LoggerFactory.getLogger(JxbankGatewayImpl.class);

	/**
	 * 嘉兴银行二类户网关地址
	 */
	@Value("${gateway.jxbank.eams.url}")
	private String jxbankEamsUrl;

	/**
	 * 嘉兴银行贷款系统网关地址
	 */
	@Value("${gateway.jxbank.loan.url}")
	private String jxbankLoanUrl;

	/**
	 * 是开启挡板
	 */
	@Value("${gateway.jxbank.virtual:false}")
	private String virtual;

	/**
	 * 查询账户交易明细
	 */
	@Override
	public TradeDetailsQueryTradeListResponse tradeDetails_queryTradeList(TradeDetailsQueryTradeListRequest request) {
		if ("true".equalsIgnoreCase(virtual)) {
			TradeDetailsQueryTradeListResponse response = new TradeDetailsQueryTradeListResponse();

			response.setRecode("000000");
			response.setRecode_info("成功");
			return response;
		}

		String url = jxbankEamsUrl + request.getServerCode();
		String resp = JxBankHttpGateway.doEamsPostObj(url, request);

		TradeDetailsQueryTradeListResponse response = JSONObject.parseObject(resp,
				TradeDetailsQueryTradeListResponse.class);
		return response;
	}

	/**
	 * 对账文件下载
	 * 
	 * @author qiangjiyi
	 */
	@Override
	public JxOrderDownFileResponse order_downfile(JxOrderDownFileRequest request) {
		if ("true".equalsIgnoreCase(virtual)) {
			logger.debug("嘉兴银行网关通讯挡板已启动");
			JxOrderDownFileResponse response = new JxOrderDownFileResponse();
			OrderDownFileDetail downFileDetail = new OrderDownFileDetail();
			downFileDetail.setBatch_file("00001");
			downFileDetail.setSerial_no("6534892832");
			downFileDetail.setChannel_no("543479032");
			// response.setData(downFileDetail);
			return response;
		}

		String url = jxbankEamsUrl + request.getServerCode();
		String req = JxBankHttpGateway.doEamsPostObj(url, request);

		JxOrderDownFileResponse response = JSONObject.parseObject(req, JxOrderDownFileResponse.class);

		return response;
	}

	/**
	 * 贷款归还批量接口
	 * 
	 * @author xuhui
	 */
	@Override
	public JxLoanReturnResponse loanReturn(JxLoanReturnRequest jxLoanReturnRequest) {
		JxLoanReturnResponse response = new JxLoanReturnResponse();
		if ("true".equals(virtual)) {
			response.setCode("000000");
			response.setMsg("成功");
			response.setSign("13214324");
			response.setSign_type("MD5");
			return response;
		}

		String url = jxbankLoanUrl + jxLoanReturnRequest.getServerCode();
		String req = JxBankHttpGateway.doLoanPostObj(url, jxLoanReturnRequest);
		response = JSONObject.parseObject(req, JxLoanReturnResponse.class);
		return response;
	}

	/**
	 * 贷款发放接口
	 * 
	 * @author xuhui
	 *
	 */
	@Override
	public JxLoanGrantResponse loanGrant(JxLoanGrantRequest jxLoanGrantRequest) {
		JxLoanGrantResponse response = new JxLoanGrantResponse();
		if ("true".equals(virtual)) {
			YLBLoanGrant jxLoanGrant = new YLBLoanGrant();
			jxLoanGrant.setApply_id("12121");
			jxLoanGrant.setReceipt_id("12121");
			response.setData(jxLoanGrant);
			response.setCode("000000");
			response.setMsg("交易成功");
			response.setSign("41432432");
			response.setSign_type("MD5");
			return response;
		}

		String url = jxbankLoanUrl + jxLoanGrantRequest.getServerCode();
		String req = JxBankHttpGateway.doLoanPostObj(url, jxLoanGrantRequest);
		response = JSONObject.parseObject(req, JxLoanGrantResponse.class);
		return response;
	}

	/**
	 * 贷款申请接口
	 */
	@Override
	public JxLoanApplyResponse loanApply(JxLoanApplyRequest jxLoanApplyRequest) {
		String url = jxbankLoanUrl + jxLoanApplyRequest.getServerCode();
		String req = JxBankHttpGateway.doEamsPostObj(url, jxLoanApplyRequest);
		JxLoanApplyResponse response = JSONObject.parseObject(req, JxLoanApplyResponse.class);

		return response;
	}

	/**
	 * 文件上传接口
	 */
	@Override
	public JxFileUploadResponse upload(JxFileUploadRequest request) {
		String url = jxbankEamsUrl + request.getServerCode();
		String req = JxBankHttpGateway.doEamsPostObj(url, request);
		JxFileUploadResponse response = JSONObject.parseObject(req, JxFileUploadResponse.class);
		return response;
	}

	/**
	 * 二类账户的开户 /accInfo/openAcc
	 */
	@Override
	public AccInfoOpenAccResponse accInfo_openAcc(AccInfoOpenAccRequest request) {

		if ("true".equalsIgnoreCase(virtual)) {
			logger.debug("嘉兴银行网关通讯挡板已启动");
			AccInfoOpenAccResponse response = new AccInfoOpenAccResponse();
			response.setOriginal_serialno("2015033100001000040049250764");
			response.setAccount_no("1111111");
			response.setCustomer_no("1111111");
			response.setRecode("000000");
			response.setRecode_info("成功");
			return response;
		}

		String url = jxbankEamsUrl + request.getServerCode();
		String req = JxBankHttpGateway.doEamsPostObj(url, request);

		AccInfoOpenAccResponse response = JSONObject.parseObject(req, AccInfoOpenAccResponse.class);

		return response;
	}

	/**
	 * 查余额 /accInfo/queryBalance
	 */
	@Override
	public AccInfoQueryBalanceResponse accInfo_queryBalance(AccInfoQueryBalanceRequest request) {

		if ("true".equalsIgnoreCase(virtual)) {
			logger.debug("嘉兴银行网关通讯挡板已启动");
			AccInfoQueryBalanceResponse response = new AccInfoQueryBalanceResponse();
			response.setAccount_name("赵化龙");
			response.setId_type("2");
			response.setId_no("110323198703241873");
			response.setMobile("18745951078");
			List<BalanceDetail> detailList = new ArrayList<BalanceDetail>();
			BalanceDetail detail = new BalanceDetail();
			detail.setAccount_no("1010101017981");
			detail.setAccount_relation("3");
			detail.setCur_balance(new BigDecimal("827.71"));
			detail.setAvail_balance(new BigDecimal("600"));
			detail.setWithdraw_balance(new BigDecimal("600"));
			detail.setPre_balance(new BigDecimal("450"));
			detailList.add(detail);
			response.setDetail_list(detailList);
			response.setRecode("000000");
			response.setRecode_info("成功");
			return response;
		}

		String url = jxbankEamsUrl + request.getServerCode();
		String resp = JxBankHttpGateway.doEamsPostObj(url, request);

		AccInfoQueryBalanceResponse response = JSONObject.parseObject(resp, AccInfoQueryBalanceResponse.class);
		return response;
	}

	/**
	 * 商户取现（娱乐宝） /merTrade/mer_withdraw
	 */
	@Override
	public MerTradeMerWithdrawResponse merTrade_mer_withdraw(MerTradeMerWithdrawRequest request) {
		if ("true".equalsIgnoreCase(virtual)) {
			logger.debug("嘉兴银行网关通讯挡板已启动");

			MerTradeMerWithdrawResponse response = new MerTradeMerWithdrawResponse();

			response.setAccount_no("1010101017981");
			response.setOriginal_tradeno("201801051408280057");
			response.setOriginal_serialno("2015033100001000040049250764");
			response.setSerial_no("2015082600001000040061749694");
			response.setTrans_amount(BigDecimal.valueOf(100));
			response.setAccount_name("赵化龙");

			response.setRecode("000000");
			response.setRecode_info("成功");
			return response;
		}

		String url = jxbankEamsUrl + request.getServerCode();
		String resp = JxBankHttpGateway.doEamsPostObj(url, request);

		MerTradeMerWithdrawResponse response = JSONObject.parseObject(resp, MerTradeMerWithdrawResponse.class);
		return response;
	}

	/**
	 * 查询交易
	 */
	@Override
	public TradeDetailsQueryTradeInfoResponse tradeDetails_queryTradeInfo(TradeDetailsQueryTradeInfoRequest request) {
		if ("true".equalsIgnoreCase(virtual)) {
			TradeDetailsQueryTradeInfoResponse response = new TradeDetailsQueryTradeInfoResponse();

			response.setRecode("000000");
			response.setRecode_info("成功");
			return response;
		}

		String url = jxbankEamsUrl + request.getServerCode();
		String resp = JxBankHttpGateway.doEamsPostObj(url, request);

		TradeDetailsQueryTradeInfoResponse response = JSONObject.parseObject(resp,
				TradeDetailsQueryTradeInfoResponse.class);
		return response;
	}

	/**
	 * 绑定账号新增
	 */
	@Override
	public AccInfoAddPrimAccResponse accInfo_addPrimAcc(AccInfoAddPrimAccRequest request) {
		if ("true".equalsIgnoreCase(virtual)) {
			AccInfoAddPrimAccResponse response = new AccInfoAddPrimAccResponse();
			response.setRecode("000000");
			response.setRecode_info("成功");
			return response;
		}

		String url = jxbankEamsUrl + request.getServerCode();
		String resp = JxBankHttpGateway.doEamsPostObj(url, request);
		AccInfoAddPrimAccResponse response = JSONObject.parseObject(resp, AccInfoAddPrimAccResponse.class);
		return response;
	}

	/**
	 * 绑定账号设定
	 */
	@Override
	public AccInfoSetPrimAccResponse accInfo_setPrimAcc(AccInfoSetPrimAccRequest request) {
		if ("true".equalsIgnoreCase(virtual)) {
			AccInfoSetPrimAccResponse response = new AccInfoSetPrimAccResponse();

			response.setRecode("000000");
			response.setRecode_info("成功");
			return response;
		}

		String url = jxbankEamsUrl + request.getServerCode();
		String resp = JxBankHttpGateway.doEamsPostObj(url, request);

		AccInfoSetPrimAccResponse response = JSONObject.parseObject(resp, AccInfoSetPrimAccResponse.class);
		return response;
	}

	/**
	 * @Description 合同盖章
	 * @Author 刘俊重
	 * @Date 2018/1/5
	 */
	@Override
	public JxContractVoucherYlbResponse contractVoucherYlb(JxContractVoucherYlbRequest request) {
		if ("true".equalsIgnoreCase(virtual)) {
			JxContractVoucherYlbResponse response = new JxContractVoucherYlbResponse();
			response.setCode("000000");
			response.setMsg("成功");
		}

		String url = jxbankLoanUrl + request.getServerCode();
		String res = JxBankHttpGateway.doLoanPostObj(url, request);

		JxContractVoucherYlbResponse response = JSONObject.parseObject(res, JxContractVoucherYlbResponse.class);

		return response;
	}

	/**
	 * @Description 合同盖章接口
	 * @Author 刘俊重
	 * @Date 2018/1/5
	 */
	@Override
	public JxContractSignYlbResponse contractSignYlb(JxContractSignYlbRequest request) {
		if ("true".equalsIgnoreCase(virtual)) {
			JxContractSignYlbResponse response = new JxContractSignYlbResponse();
			response.setCode("000000");
			response.setMsg("成功");
		}

		String url = jxbankLoanUrl + request.getServerCode();
		String res = JxBankHttpGateway.doLoanPostObj(url, request);

		JxContractSignYlbResponse response = JSONObject.parseObject(res, JxContractSignYlbResponse.class);

		return response;
	}

	/**
	 * 贷款申请
	 */
	@Override
	public JxApplyYlbResponse applyYlb(JxApplyYlbRequest request) {
		if ("true".equalsIgnoreCase(virtual)) {
			JxApplyYlbResponse response = new JxApplyYlbResponse();
			response.setCode("000000");
			response.setMsg("成功");
		}

		String url = jxbankLoanUrl + request.getServerCode();
		String res = JxBankHttpGateway.doLoanPostObj(url, request);
		JxApplyYlbResponse response = JSONObject.parseObject(res, JxApplyYlbResponse.class);
		return response;
	}

	@Override
	public JxInqGrantResponse inqGrant(JxInqGrantRequest jxInqGrantRequest) {
		if ("true".equalsIgnoreCase(virtual)) {
			JxInqGrantResponse response = new JxInqGrantResponse();
			response.setCode("000000");
			response.setMsg("成功");
		}
		String url = jxbankLoanUrl + jxInqGrantRequest.getServerCode();
		String res = JxBankHttpGateway.doLoanPostObj(url, jxInqGrantRequest);

		JxInqGrantResponse response = JSONObject.parseObject(res, JxInqGrantResponse.class);
		return response;
	}

	/**
	 * @Description 贷款审批查询
	 * @Author 刘俊重
	 * @Date 2018/3/15
	 */
	@Override
	public JxIngApprovalYlbResponse ingApprovalYlb(JxIngApprovalYlbRequest request) {
		if ("true".equalsIgnoreCase(virtual)) {
			JxIngApprovalYlbResponse response = new JxIngApprovalYlbResponse();
			response.setCode("000000");
			response.setMsg("成功");
		}
		String url = jxbankLoanUrl + request.getServerCode();
		String res = JxBankHttpGateway.doLoanPostObj(url, request);

		JxIngApprovalYlbResponse response = JSONObject.parseObject(res, JxIngApprovalYlbResponse.class);

		return response;
	}

	@Override
	public JxLoanReturnQueryResponse loanReturnQuery(JxLoanReturnQueryRequest jxLoanReturnQueryRequest) {
		if ("true".equalsIgnoreCase(virtual)) {
			JxLoanReturnResponse response = new JxLoanReturnResponse();
			response.setCode("000000");
			response.setMsg("成功");
		}
		String url = jxbankLoanUrl + jxLoanReturnQueryRequest.getServerCode();
		String res = JxBankHttpGateway.doLoanPostObj(url, jxLoanReturnQueryRequest);

		JxLoanReturnQueryResponse response = JSONObject.parseObject(res, JxLoanReturnQueryResponse.class);

		return response;
	}

	/**
	 * 商户取现查证接口 /merTrade/mer_withdraw_check
	 */
	@Override
	public AerWithdrawCheckResponse mer_withdraw_check(AerWithdrawCheckRequest request) {

		if ("true".equalsIgnoreCase(virtual)) {
			AerWithdrawCheckResponse response = new AerWithdrawCheckResponse();
			response.setRecode("000000");
			response.setRecode_info("成功");
			return response;
		}
		String url = jxbankEamsUrl + request.getServerCode();
		String res = JxBankHttpGateway.doEamsPostObj(url, request);

		AerWithdrawCheckResponse response = JSONObject.parseObject(res, AerWithdrawCheckResponse.class);

		return response;
	}

	@Override
	public JxRepaySingleResponse repaySingle(JxRepaySingleRequest request) {

		if ("true".equalsIgnoreCase(virtual)) {
			JxRepaySingleResponse response = new JxRepaySingleResponse();
			response.setCode("000000");
			response.setMsg("成功");
			return response;
		}
		String url = jxbankLoanUrl + request.getServerCode();
		String res = JxBankHttpGateway.doLoanPostObj(url, request);

		JxRepaySingleResponse response = JSONObject.parseObject(res, JxRepaySingleResponse.class);

		return response;
	}

	@Override
	public JxRepaySearchSingleResponse repaySearchSingle(JxRepaySearchSingleRequest request) {
		if ("true".equalsIgnoreCase(virtual)) {
			JxRepaySearchSingleResponse response = new JxRepaySearchSingleResponse();
			response.setCode("000000");
			response.setMsg("成功");
			return response;
		}
		String url = jxbankLoanUrl + request.getServerCode();
		String res = JxBankHttpGateway.doLoanPostObj(url, request);

		JxRepaySearchSingleResponse response = JSONObject.parseObject(res, JxRepaySearchSingleResponse.class);

		return response;
	}

}
