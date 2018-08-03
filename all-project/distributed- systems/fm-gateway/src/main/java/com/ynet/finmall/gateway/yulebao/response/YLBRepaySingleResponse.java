package com.ynet.finmall.gateway.yulebao.response;

/**
 * 
 * 备注：贷款归还（单笔实时）
 * 
 * @author liaoyy@belink.com
 */
public class YLBRepaySingleResponse extends AbstractYLBResponse {

	private RepaySingle data;

	public RepaySingle getData() {
		return data;
	}

	public void setData(RepaySingle data) {
		this.data = data;
	}

}
