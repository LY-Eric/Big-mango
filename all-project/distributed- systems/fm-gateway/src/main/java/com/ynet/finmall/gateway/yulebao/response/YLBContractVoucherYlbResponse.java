package com.ynet.finmall.gateway.yulebao.response;

import com.ynet.finmall.gateway.jxbank.response.VoucherList;

/**
 * @Description 合同存证
 * @Author 刘俊重
 * @Date 2018/1/5
 */
public class YLBContractVoucherYlbResponse extends AbstractYLBResponse{

	private VoucherList data;

	public VoucherList getData() {
		return data;
	}

	public void setData(VoucherList data) {
		this.data = data;
	}
}
