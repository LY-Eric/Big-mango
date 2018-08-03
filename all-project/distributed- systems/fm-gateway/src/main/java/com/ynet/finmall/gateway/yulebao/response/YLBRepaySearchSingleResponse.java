package com.ynet.finmall.gateway.yulebao.response;

/**
 * 备注：贷款归还结果查询（单笔）
 * 
 * @author liaoyy@belink.com
 */
public class YLBRepaySearchSingleResponse extends AbstractYLBResponse {
	private YLBRepaySearchSingleInfo data;

	public YLBRepaySearchSingleInfo getData() {
		return data;
	}

	public void setData(YLBRepaySearchSingleInfo data) {
		this.data = data;
	}

}
