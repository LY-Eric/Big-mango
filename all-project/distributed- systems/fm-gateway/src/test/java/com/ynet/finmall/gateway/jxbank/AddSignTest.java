package com.ynet.finmall.gateway.jxbank;

import java.util.HashMap;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.ynet.finmall.gateway.yulebao.aop.YLBSignUtil;

/**
 * 加签 验签
 * @author liuxin
 *
 */
public class AddSignTest {

	@Test
	public void addSign(){
		YLBSignUtil sign = new YLBSignUtil();
		
		String json = "{\"channel_no\":\"0001\",\"serial_no\":\"2015033100001001240049250704\",\"trans_date\":\"2018-01-02\",\"trans_tradetime\":\"2018-01-0202:12:12\",\"file_list\":[{\"file_index\":1,\"file_data\":\"UEsDBBQACAgIAAVRKkwAAAAAAAAAQSwUGAAAAAAEAAQAzAAAAvA8AAAAA\"},{\"file_index\":2,\"file_data\":\"UEsDBBQACAgIAAVRKkwAAAAAAAAAAAAAAAAFAAAAEAAQAzAAAAvA8AAAAA\"}]}";
		
		
//		Map reqObj = JSON.parseObject(json,LinkedHashMap.class,Feature.OrderedField);
		String sign_data = sign.addSign(json);
		
		System.err.println("签名数据："  + sign_data);
		
		
	      HashMap<String, String> hashMap = new HashMap<String,String>();
		
	      hashMap.put("code", "999999");
	      hashMap.put("msg", "com.alibaba.fastjson.JSONException: For input string: \"1.5\"");
	      
	      String addSign = sign.addSign(JSON.toJSONString(hashMap));
	      System.out.println("---->>>"+addSign);
		
	}
}
