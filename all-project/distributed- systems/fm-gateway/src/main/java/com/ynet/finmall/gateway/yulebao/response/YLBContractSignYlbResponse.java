package com.ynet.finmall.gateway.yulebao.response;

import com.ynet.finmall.gateway.jxbank.response.ContractFileList;

/**
 * @Description 合同盖章响应数据
 * @Author 刘俊重
 * @Date 2018/1/5
 */
public class YLBContractSignYlbResponse extends AbstractYLBResponse{

	private ContractFileList data;

	public ContractFileList getData() {
		return data;
	}

	public void setData(ContractFileList data) {
		this.data = data;
	}

}
