package com.ynet.finmall.gateway.yulebao.service;

import com.ynet.finmall.gateway.yulebao.request.YLBOrderDownFileRequest;
import com.ynet.finmall.gateway.yulebao.response.YLBOrderDownFileResponse;

/**
 * 对账文件相关的业务接口
 * @author qiangjiyi
 * @date 2018年1月12日 下午5:04:38
 */
public interface YlbOrderDownFileService {

	/**
	 * 对账文件下载
	 */
	YLBOrderDownFileResponse order_downfile(YLBOrderDownFileRequest request);
}
