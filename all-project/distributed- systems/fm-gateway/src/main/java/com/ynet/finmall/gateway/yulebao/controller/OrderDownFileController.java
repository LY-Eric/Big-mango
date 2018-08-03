package com.ynet.finmall.gateway.yulebao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.ynet.finmall.gateway.yulebao.request.YLBOrderDownFileRequest;
import com.ynet.finmall.gateway.yulebao.response.YLBOrderDownFileResponse;
import com.ynet.finmall.gateway.yulebao.service.YlbOrderDownFileService;

/**
 * 对账文件相关的请求控制类
 * @author qiangjiyi
 * @date 2018年1月12日 下午5:01:46
 */
@Controller
@ResponseBody
public class OrderDownFileController {
	@Autowired
	private YlbOrderDownFileService ylbOrderDownFileService;
	
	/**
	 * 对账文件下载
	 */
	@PostMapping(name="调用娱乐宝对账文件下载接口",value="/api/ylb/v1/order/downfile.do")
	public YLBOrderDownFileResponse orderDownFile(@RequestBody JSONObject jsonObj) {
		YLBOrderDownFileRequest request = JSONObject.parseObject(jsonObj.toJSONString(), YLBOrderDownFileRequest.class);
		YLBOrderDownFileResponse response = ylbOrderDownFileService.order_downfile(request);
		return response;
	}
}
