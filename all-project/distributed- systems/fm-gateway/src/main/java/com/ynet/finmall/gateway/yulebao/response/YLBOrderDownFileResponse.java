package com.ynet.finmall.gateway.yulebao.response;

/**
 * 娱乐宝对账文件下载响应参数
 * 
 * @author qiangjiyi
 * @date 2018年1月16日 上午11:23:43
 */
public class YLBOrderDownFileResponse extends AbstractYLBResponse {

	private OrderDownFileInfo data;

	public OrderDownFileInfo getData() {
		return data;
	}

	public void setData(OrderDownFileInfo data) {
		this.data = data;
	}

}
