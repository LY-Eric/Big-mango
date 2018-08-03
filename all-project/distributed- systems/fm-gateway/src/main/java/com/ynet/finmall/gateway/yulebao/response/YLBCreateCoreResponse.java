package com.ynet.finmall.gateway.yulebao.response;

/**
 * 备注：核心企业入驻 响应参数
 * 
 * @author liaoyy@belink.com
 */
public class YLBCreateCoreResponse extends AbstractYLBResponse {
	private CreateCoreInfo data;

	public CreateCoreInfo getData() {
		return data;
	}

	public void setData(CreateCoreInfo data) {
		this.data = data;
	}

}
