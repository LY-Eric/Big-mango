package com.ynet.finmall.gateway.jxbank.response;

/**
 * @Description 贷款审批查询
 * @Author 刘俊重
 * @Date 2018/3/15
 */
public class JxIngApprovalYlbResponse extends AbstractJxBankLoanResponse {

	IngApprovalYlbListRes data;

	public IngApprovalYlbListRes getData() {
		return data;
	}

	public void setData(IngApprovalYlbListRes data) {
		this.data = data;
	}

}
