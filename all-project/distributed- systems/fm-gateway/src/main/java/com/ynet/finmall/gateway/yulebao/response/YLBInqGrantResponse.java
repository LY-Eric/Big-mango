package com.ynet.finmall.gateway.yulebao.response;


/**
 * 备注：贷款放款查询
 * 
 * @author liaoyy@belink.com
 */
public class YLBInqGrantResponse extends AbstractYLBResponse {

	private InqGrantInfo data;

	public InqGrantInfo getData() {
		return data;
	}

	public void setData(InqGrantInfo data) {
		this.data = data;
	}


}
