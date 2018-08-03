package com.ynet.finmall.gateway.jxbank.response;

/**
 * 嘉兴银行商户取现异常回调通知响应参数
 * @author qiangjiyi
 * @date 2018年1月25日 下午2:40:04
 */
public class JxWithdrawExceptionNoticeResponse extends AbstractJxBankResponse {

	// 帐号
	private String account_no;

	public String getAccount_no() {
		return account_no;
	}

	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}

}
