package com.ynet.finmall.gateway.aliyuncs.response;

/**
 * 阿里云公共响应报文头
 * @author liuxin
 *
 */
public class AbstractAliyunResponse {

	private String RequestId;

	public String getRequestId() {
		return RequestId;
	}

	public void setRequestId(String requestId) {
		RequestId = requestId;
	}
	
}
