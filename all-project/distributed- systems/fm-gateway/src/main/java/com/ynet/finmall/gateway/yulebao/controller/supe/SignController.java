package com.ynet.finmall.gateway.yulebao.controller.supe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.ynet.finmall.gateway.jxbank.JxBankLoanSignUtil;
import com.ynet.finmall.gateway.jxbank.JxBankSignUtil;
import com.ynet.finmall.gateway.yulebao.aop.YLBSignUtil;

@Controller
@ResponseBody
public class SignController {

	@Value("${spring.profiles.active}")
	private String env;
	
	@RequestMapping("/addSign.do")
	public Map<String, Object> addSign(HttpServletRequest request) {
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		if(!("dev".equals(env))){
			dataMap.put("msg", "只允许开发环境访问此接口！！！");
			return dataMap;
		}
		
		BufferedReader streamReader = null;
		JSONObject jsonObject = null;
		try {
			streamReader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
			StringBuilder responseStrBuilder = new StringBuilder();
			String inputStr;
			while ((inputStr = streamReader.readLine()) != null)
				responseStrBuilder.append(inputStr);
			jsonObject = JSONObject.parseObject(responseStrBuilder.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(jsonObject == null){
			dataMap.put("msg", "请求录入json报文");
			return dataMap;
		}
		String json = jsonObject.toJSONString();
		String sign_data = YLBSignUtil.addSign(json);
		
		System.err.println("签名数据："  + sign_data);

		jsonObject.put("sign_data", sign_data);
		jsonObject.put("sign_type", "MD5");
		
		json = jsonObject.toJSONString();
		System.err.println("加签json串："  + json);
		dataMap = jsonObject;
		return dataMap;

	}


	@RequestMapping("/checkSign.do")
	public Map<String, Object> checkSign(HttpServletRequest request) {
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		if(!("dev".equals(env))){
			dataMap.put("msg", "只允许开发环境访问此接口！！！");
			return dataMap;
		}
		
		BufferedReader streamReader;
		JSONObject jsonObject = null;
		try {
			streamReader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
			StringBuilder responseStrBuilder = new StringBuilder();
			String inputStr;
			while ((inputStr = streamReader.readLine()) != null)
				responseStrBuilder.append(inputStr);
			jsonObject = JSONObject.parseObject(responseStrBuilder.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(jsonObject == null){
			dataMap.put("msg", "请求录入json报文");
			return dataMap;
		}
		String json = jsonObject.toJSONString();
		boolean flag = YLBSignUtil.checkSign(json);
		
		System.err.println("验签状态："  + flag);

		if(flag){
			dataMap.put("msg", "验签成功！");
			return dataMap;
		}
		dataMap.put("msg", "验签失败！");
		return dataMap;
	}


	/**
	 * 银行网贷系统回调接口加密
	 */
	@RequestMapping("/bankAddSign.do")
	public Map<String, Object> bankAddSign(HttpServletRequest request) {
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		if(!("dev".equals(env))){
			dataMap.put("msg", "只允许开发环境访问此接口！！！");
			return dataMap;
		}
		
		BufferedReader streamReader = null;
		JSONObject jsonObject = null;
		try {
			streamReader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
			StringBuilder responseStrBuilder = new StringBuilder();
			String inputStr;
			while ((inputStr = streamReader.readLine()) != null)
				responseStrBuilder.append(inputStr);
			jsonObject = JSONObject.parseObject(responseStrBuilder.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(jsonObject == null){
			dataMap.put("msg", "请求录入json报文");
			return dataMap;
		}

		String json = jsonObject.toJSONString();//排序
		JSONObject jsonMap = JSONObject.parseObject(json);
		
		//加签 json
		String sign_data = JxBankLoanSignUtil.addSign(jsonMap, JxBankLoanSignUtil.MD5_KEY);
		
		System.err.println("签名数据："  + sign_data);

		jsonObject.put("sign", sign_data);
		jsonObject.put("sign_type", "MD5");
		
		json = jsonObject.toJSONString();
		System.err.println("加签json串："  + json);
		dataMap = jsonObject;
		return dataMap;

	}


	/**
	 * 网贷系统
	 * @param request
	 * @return
	 */
	@RequestMapping("/bankCheckSign.do")
	public Map<String, Object> bankCheckSign(HttpServletRequest request) {
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		if(!("dev".equals(env))){
			dataMap.put("msg", "只允许开发环境访问此接口！！！");
			return dataMap;
		}
		
		BufferedReader streamReader;
		JSONObject jsonObject = null;
		try {
			streamReader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
			StringBuilder responseStrBuilder = new StringBuilder();
			String inputStr;
			while ((inputStr = streamReader.readLine()) != null)
				responseStrBuilder.append(inputStr);
			jsonObject = JSONObject.parseObject(responseStrBuilder.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(jsonObject == null){
			dataMap.put("msg", "请求录入json报文");
			return dataMap;
		}
		String json = jsonObject.toJSONString();
		boolean flag = JxBankLoanSignUtil.checkSign(json,JxBankLoanSignUtil.MD5_KEY);
		
		System.err.println("验签状态："  + flag);

		if(flag){
			dataMap.put("msg", "验签成功！");
			return dataMap;
		}
		dataMap.put("msg", "验签失败！");
		return dataMap;
	}
	

	/**
	 * 银行二类户系统接口加密
	 */
	@RequestMapping("/bankEamsAddSign.do")
	public Map<String, Object> bankEamsAddSign(HttpServletRequest request) {
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		if(!("dev".equals(env))){
			dataMap.put("msg", "只允许开发环境访问此接口！！！");
			return dataMap;
		}
		
		BufferedReader streamReader = null;
		JSONObject jsonObject = null;
		try {
			streamReader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
			StringBuilder responseStrBuilder = new StringBuilder();
			String inputStr;
			while ((inputStr = streamReader.readLine()) != null)
				responseStrBuilder.append(inputStr);
			jsonObject = JSONObject.parseObject(responseStrBuilder.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(jsonObject == null){
			dataMap.put("msg", "请求录入json报文");
			return dataMap;
		}

		String json = jsonObject.toJSONString();//排序
		JSONObject jsonMap = JSONObject.parseObject(json);
		
		//加签 json
		String sign_data = JxBankSignUtil.addSign(jsonMap, JxBankSignUtil.MD5_KEY);
		
		System.err.println("签名数据："  + sign_data);

		jsonObject.put("sign_data", sign_data);
		jsonObject.put("signType", "MD5");
		
		json = jsonObject.toJSONString();
		System.err.println("加签json串："  + json);
		dataMap = jsonObject;
		return dataMap;

	}

}
