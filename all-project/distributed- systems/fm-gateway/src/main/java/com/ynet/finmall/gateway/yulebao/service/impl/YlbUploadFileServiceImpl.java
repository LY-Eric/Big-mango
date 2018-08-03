package com.ynet.finmall.gateway.yulebao.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ynet.finmall.gateway.jxbank.request.JxFileUploadRequest;
import com.ynet.finmall.gateway.jxbank.response.JxFileUploadResponse;
import com.ynet.finmall.gateway.jxbank.service.JxbankGateway;
import com.ynet.finmall.gateway.utils.Base64Util;
import com.ynet.finmall.gateway.utils.OSSClientUtil;
import com.ynet.finmall.gateway.yulebao.request.FileInfo;
import com.ynet.finmall.gateway.yulebao.request.YLBFileUploadRequest;
import com.ynet.finmall.gateway.yulebao.response.FileUploadInfo;
import com.ynet.finmall.gateway.yulebao.response.YLBFileUploadResponse;
import com.ynet.finmall.gateway.yulebao.service.YlbUploadFileService;
import com.ynet.finmall.gateway.yulebao.utils.CopyUtils;
import com.ynet.scm.api.gateway.yulebao.ScmLoanAndUploadService;

/**
 * 文件上传接口
 * 
 * @author xuhui
 *
 */

@Service
public class YlbUploadFileServiceImpl implements YlbUploadFileService {

	private static Logger logger = LoggerFactory.getLogger(YlbUploadFileServiceImpl.class);

	@Autowired(required = false)
	private ScmLoanAndUploadService scmLoanAndUploadService;

	@Autowired
	private JxbankGateway jxbankGateway;

	// 文件临时存放地址
	@Value("${locationTemp.url}")
	private String locationTempUrl;

	@Override
	public YLBFileUploadResponse uploadFile(YLBFileUploadRequest fileUploadRequest) {
		JxFileUploadRequest jxFileUploadRequest = new JxFileUploadRequest();
		YLBFileUploadResponse fileUploadResponse = new YLBFileUploadResponse();
		JSONArray jsonArray = null;
		CopyUtils.Copy(fileUploadRequest, jxFileUploadRequest);
		JxFileUploadResponse jxfileUploadResponse = jxbankGateway.upload(jxFileUploadRequest);
		FileUploadInfo fileUploadInfo = JSON.parseObject(JSON.toJSONString(jxfileUploadResponse), FileUploadInfo.class);
		if ("000000".equals(jxfileUploadResponse.getRecode())) {
			fileUploadResponse.setData(fileUploadInfo);
			List<FileInfo> listInfo = fileUploadRequest.getFile_list();
			jsonArray = new JSONArray();
			for (int i = 0; i < listInfo.size(); i++) {
				String fileName = UUID.randomUUID().toString() + ".jpg";
				String file_data = listInfo.get(i).getFile_data();
				Base64Util.decode(file_data, fileName, locationTempUrl);
				File file = new File(locationTempUrl + fileName);
				String url = null;
				try {
					url = OSSClientUtil.getUrl(file);
				} catch (IOException e) {
					 logger.error("--->>>"+e);
					// throw new YLBGatewayException(GatewayErrorConstants.YLB_FILE_ERROR);
				}
				logger.info("返回的Url" + url);
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("fileIndex", jxfileUploadResponse.getFile_list().get(i).getFile_index());
				jsonObject.put("fileNo", jxfileUploadResponse.getFile_list().get(i).getFile_no());
				jsonObject.put("fileUrl", url);
				jsonArray.add(jsonObject);
			}
             if(null != jsonArray){
            	 try {
					scmLoanAndUploadService.scmFileUploadSave(jsonArray.toJSONString());
				} catch (Exception e) {
					logger.error("--->>>"+e);
				}
             }
		}
		
		//CopyUtils.Copy(jxfileUploadResponse, fileUploadResponse);
		fileUploadResponse.setReturnCode(jxfileUploadResponse.getRecode());
		fileUploadResponse.setReturnMsg(jxfileUploadResponse.getRecode_info());
		return fileUploadResponse;
	}

}
