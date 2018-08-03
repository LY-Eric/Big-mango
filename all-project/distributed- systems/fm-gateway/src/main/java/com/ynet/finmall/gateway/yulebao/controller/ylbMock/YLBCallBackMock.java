package com.ynet.finmall.gateway.yulebao.controller.ylbMock;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

/**
 * 备注：模拟娱乐宝回调接口
 * 
 * @author liaoyy@belink.com
 */
@RestController
public class YLBCallBackMock {

	@RequestMapping("/ylb/yx")
	public JSONObject qx(@RequestBody JSONObject json) {
		JSONObject jsonObject = new JSONObject();
		
		System.out.println("娱乐宝回调接收参数--->>>"+json.toJSONString());
		
		jsonObject.put("account_no", json.get("account_no"));
		
		return jsonObject;
	}
}
