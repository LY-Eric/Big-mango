package com.ynet.finmall.gateway.yulebao.response;

import com.ynet.finmall.gateway.jxbank.response.ApplyYlbListRes;

import java.util.List;

/**
 * @Description 贷款申请响应数据
 * @Author 刘俊重
 * @Date 2018/1/5
 */
public class YLBApplyYlbResponse extends AbstractYLBResponse{

	private ApplyYlbListRes data;

	public ApplyYlbListRes getData() {
		return data;
	}

	public void setData(ApplyYlbListRes data) {
		this.data = data;
	}
	 
}
