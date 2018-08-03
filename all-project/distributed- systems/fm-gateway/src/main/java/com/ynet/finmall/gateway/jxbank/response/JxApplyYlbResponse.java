package com.ynet.finmall.gateway.jxbank.response;

/**
 * @Description 贷款申请响应数据
 * @Author 刘俊重
 * @Date 2018/1/5
 */
public class JxApplyYlbResponse extends AbstractJxBankLoanResponse{

	private ApplyYlbListRes data;

	public ApplyYlbListRes getData() {
		return data;
	}

	public void setData(ApplyYlbListRes data) {
		this.data = data;
	}

}
