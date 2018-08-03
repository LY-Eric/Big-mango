package com.ynet.finmall.gateway.yulebao.response;

import com.ynet.finmall.gateway.jxbank.response.IngApprovalYlbListRes;

/**
 * @Description 贷款申请响应数据
 * @Author 刘俊重
 * @Date 2018/1/5
 */
public class YLBIngApprovalYlbResponse extends AbstractYLBResponse {

	private IngApprovalYlbListRes data;

	public IngApprovalYlbListRes getData() {
		return data;
	}

	public void setData(IngApprovalYlbListRes data) {
		this.data = data;
	}

}
