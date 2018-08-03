package com.ynet.finmall.gateway.yulebao.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.ynet.finmall.gateway.yulebao.request.YLBFileUploadRequest;
import com.ynet.finmall.gateway.yulebao.response.YLBFileUploadResponse;
import com.ynet.finmall.gateway.yulebao.service.YlbUploadFileService;
@Controller
@ResponseBody
public class UploadController {
	@Autowired(required=false)
	private YlbUploadFileService ylbUploadFileService;
	
	@PostMapping(name="调用娱乐宝文件上传接口",value="api/ylb/upload/uploadFile.do")
	public YLBFileUploadResponse upload(@RequestBody JSONObject jsonObj){		
		YLBFileUploadRequest fileUploadRequest = JSONObject.parseObject(jsonObj.toJSONString(), YLBFileUploadRequest.class);
		return ylbUploadFileService.uploadFile(fileUploadRequest);
		
	}

}