package com.ynet.finmall.gateway.jxbank.service;

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

/**
 * 嘉兴银行网关通讯接口
 * 
 * @author liuxin
 */
public interface JxbankGateway {

	/**
	 * 查询账户交易明细
	 */
	TradeDetailsQueryTradeListResponse tradeDetails_queryTradeList(TradeDetailsQueryTradeListRequest request);

	/**
	 * 对账文件下载 /api/v1/order/downfile.do
	 */
	JxOrderDownFileResponse order_downfile(JxOrderDownFileRequest request);

	/**
	 * 贷款归还批量接口
	 * 
	 * @author xuhui
	 *
	 */
	JxLoanReturnResponse loanReturn(JxLoanReturnRequest jxLoanReturnRequest);

	/**
	 * 贷款发放接口
	 * 
	 * @author xuhui
	 */
	JxLoanGrantResponse loanGrant(JxLoanGrantRequest jxLoanGrantRequest);

	/**
	 * 贷款申请接口
	 */
	JxLoanApplyResponse loanApply(JxLoanApplyRequest jxLoanApplyRequest);

	/**
	 * 文件上传接口
	 */
	JxFileUploadResponse upload(JxFileUploadRequest jxFileUploadRequest);

	/**
	 * 二类账户的开户 /accInfo/openAcc
	 */
	AccInfoOpenAccResponse accInfo_openAcc(AccInfoOpenAccRequest request);

	/**
	 * 查余额 /accInfo/queryBalance
	 */
	AccInfoQueryBalanceResponse accInfo_queryBalance(AccInfoQueryBalanceRequest request);

	/**
	 * 商户取现（娱乐宝） /merTrade/mer_withdraw
	 */
	MerTradeMerWithdrawResponse merTrade_mer_withdraw(MerTradeMerWithdrawRequest request);
	/**
	 * 商户取现查证接口 /merTrade/mer_withdraw_check
	 */
	AerWithdrawCheckResponse mer_withdraw_check(AerWithdrawCheckRequest request);

	/**
	 * 查询交易
	 */
	TradeDetailsQueryTradeInfoResponse tradeDetails_queryTradeInfo(TradeDetailsQueryTradeInfoRequest request);

	/**
	 * 绑定账号新增
	 */
	AccInfoAddPrimAccResponse accInfo_addPrimAcc(AccInfoAddPrimAccRequest request);

	/**
	 * 绑定账号设定
	 */
	AccInfoSetPrimAccResponse accInfo_setPrimAcc(AccInfoSetPrimAccRequest request);

	/**
	 * @Description 合同盖章
	 * @Author 刘俊重
	 * @Date 2018/1/5
	 */
	JxContractVoucherYlbResponse contractVoucherYlb(JxContractVoucherYlbRequest request);

	/**
	 * @Description 合同盖章
	 * @Author 刘俊重
	 * @Date 2018/1/5
	 */
	JxContractSignYlbResponse contractSignYlb(JxContractSignYlbRequest request);

	/**
	 * @Description 贷款申请
	 * @Author 刘俊重
	 * @Date 2018/1/5
	 */
	JxApplyYlbResponse applyYlb(JxApplyYlbRequest request);

	/**
	 * @Description 贷款审批查询
	 * @Author 刘俊重
	 * @Date 2018/3/15
	 */
	JxIngApprovalYlbResponse ingApprovalYlb(JxIngApprovalYlbRequest request);
	
	/**
	 * 备注：贷款放款查询
	 * @author liaoyy@belink.com
	 * @param jxInqGrantRequest
	 * @return
	 */
	JxInqGrantResponse inqGrant(JxInqGrantRequest jxInqGrantRequest);

	/**
	 * 备注：贷款归还批量查询
	 * @author liaoyy@belink.com
	 * @param jxLoanReturnQueryRequest
	 * @return
	 */
	JxLoanReturnQueryResponse loanReturnQuery(JxLoanReturnQueryRequest jxLoanReturnQueryRequest);
	
	/**
	 * 备注：贷款归还（单笔实时）
	 * @author liaoyy@belink.com
	 * @param jxRepaySingleRequest
	 * @return
	 */
	JxRepaySingleResponse repaySingle(JxRepaySingleRequest jxRepaySingleRequest);
	
	/**
	 * 备注：贷款归还结果查询（单笔）
	 * @author liaoyy@belink.com
	 * @param searchSingleRequest
	 * @return
	 */
	JxRepaySearchSingleResponse repaySearchSingle(JxRepaySearchSingleRequest searchSingleRequest);
	
	
}
