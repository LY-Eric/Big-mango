package com.ynet.finmall.gateway.yulebao.response;

/**
 * 查询余额响应参数
 * 
 * @author qiangjiyi
 * @date 2018年1月5日 上午10:46:04
 */
public class YLBQueryBalanceResponse extends AbstractYLBResponse {

	private QueryBalanceInfo data;

	public QueryBalanceInfo getData() {
		return data;
	}

	public void setData(QueryBalanceInfo data) {
		this.data = data;
	}

}
