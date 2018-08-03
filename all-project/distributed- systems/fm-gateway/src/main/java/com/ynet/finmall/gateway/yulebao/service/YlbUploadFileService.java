package com.ynet.finmall.gateway.yulebao.service;

import com.ynet.finmall.gateway.yulebao.request.YLBFileUploadRequest;
import com.ynet.finmall.gateway.yulebao.response.YLBFileUploadResponse;

/**
 * 文件上传接口
 * @author xuhui
 *
 */
public interface YlbUploadFileService {

	YLBFileUploadResponse uploadFile(YLBFileUploadRequest fileUploadRequest);
}
