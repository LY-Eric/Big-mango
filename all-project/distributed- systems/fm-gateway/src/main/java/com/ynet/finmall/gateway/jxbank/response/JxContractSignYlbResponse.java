package com.ynet.finmall.gateway.jxbank.response;


/**
 * @Description 合同盖章响应数据
 * @Author 刘俊重
 * @Date 2018/1/5
 */
public class JxContractSignYlbResponse extends AbstractJxBankLoanResponse{

	private ContractFileList data;

	public ContractFileList getData() {
		return data;
	}

	public void setData(ContractFileList data) {
		this.data = data;
	}

	
}
