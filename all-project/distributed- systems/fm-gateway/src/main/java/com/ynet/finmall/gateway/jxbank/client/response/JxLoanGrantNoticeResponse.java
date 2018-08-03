package com.ynet.finmall.gateway.jxbank.client.response;


/**
 * 贷款发放异步通知返回参数
 * @author xuhui
 *
 */
public class JxLoanGrantNoticeResponse extends AbstractLoanResponse {
	private String apply_id;//贷款编号
	private String receipt_id;//借据编号
	
	public String getApply_id() {
		return apply_id;
	}
	public void setApply_id(String apply_id) {
		this.apply_id = apply_id;
	}
	public String getReceipt_id() {
		return receipt_id;
	}
	public void setReceipt_id(String receipt_id) {
		this.receipt_id = receipt_id;
	}
	
}
