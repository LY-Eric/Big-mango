package com.ynet.finmall.gateway.jxbank.response;


/**
 * @Description 合同存证
 * @Author 刘俊重
 * @Date 2018/1/5
 */
public class JxContractVoucherYlbResponse extends AbstractJxBankLoanResponse{

	private VoucherList data;

	public VoucherList getData() {
		return data;
	}

	public void setData(VoucherList data) {
		this.data = data;
	}
	
}
