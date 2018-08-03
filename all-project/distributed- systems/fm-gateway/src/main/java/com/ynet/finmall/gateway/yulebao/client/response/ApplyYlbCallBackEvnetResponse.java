package com.ynet.finmall.gateway.yulebao.client.response;

import com.ynet.finmall.gateway.jxbank.response.ApplyYlbCallBack;

/**
 * @Description 贷款申请回调
 * @Author 刘俊重
 * @Date 2018/1/5
 */
public class ApplyYlbCallBackEvnetResponse extends AbstractYLBEventResponse {

	private ApplyYlbCallBack data;

	public ApplyYlbCallBack getData() {
		return data;
	}

	public void setData(ApplyYlbCallBack data) {
		this.data = data;
	}

}
