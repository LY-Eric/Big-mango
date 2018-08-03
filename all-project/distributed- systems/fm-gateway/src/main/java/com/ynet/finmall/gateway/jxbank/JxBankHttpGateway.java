package com.ynet.finmall.gateway.jxbank;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.ynet.exception.FinMallException;
import com.ynet.finmall.gateway.exception.GatewayErrorConstants;
import com.ynet.finmall.gateway.jxbank.response.AbstractJxBankLoanResponse;
import com.ynet.finmall.gateway.jxbank.response.AbstractJxBankResponse;

/**
 * HttpClient请求工具类（支持GET/POST方式）
 * @author qiangjiyi
 * @date 2017年11月7日 下午3:12:10
 */
public class JxBankHttpGateway {
	private static final Logger logger = LoggerFactory.getLogger(JxBankHttpGateway.class);

	private static final String recode8 = "JX99998";
	private static final String recode_info8 = "嘉兴银行系统异常";
	
	private static final String recode9 = "JX99997";//通讯异常
	
	
	public static String doGet(String url, Map<String, String> param) {

		// 创建Httpclient对象
		CloseableHttpClient httpclient = HttpClients.createDefault();

		String resultString = "";
		CloseableHttpResponse response = null;
		try {
			// 创建uri
			URIBuilder builder = new URIBuilder(url);
			if (param != null) {
				for (String key : param.keySet()) {
					builder.addParameter(key, param.get(key));
				}
			}
			URI uri = builder.build();

			// 创建http GET请求
			HttpGet httpGet = new HttpGet(uri);

			// 执行请求
			response = httpclient.execute(httpGet);
			// 判断返回状态是否为200
			if (response.getStatusLine().getStatusCode() == 200) {
				resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (response != null) {
					response.close();
				}
				if(httpclient != null){
					httpclient.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultString;
	}

	public static String doGet(String url) {
		return doGet(url, null);
	}

	public static String doPost(String url, Map<String, String> param) {
		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String resultString = "";
		try {
			// 创建Http Post请求
			HttpPost httpPost = new HttpPost(url);
			// 创建参数列表
			if (param != null) {
				List<NameValuePair> paramList = new ArrayList<NameValuePair>();
				for (String key : param.keySet()) {
					paramList.add(new BasicNameValuePair(key, param.get(key)));
				}
				// 模拟表单
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList, "UTF-8");
				httpPost.setEntity(entity);
			}
			// 执行http请求
			response = httpClient.execute(httpPost);
			resultString = EntityUtils.toString(response.getEntity(), "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(response != null){
					response.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return resultString;
	}

	public static String doPost(String url) {
		return doPost(url, null);
	}
	
	/**
	 * 嘉兴银行贷款系统网关通讯
	 */
	public static String doLoanPostObj(String url, Object obj){
		
		Map dataMap = JSONObject.parseObject(JSON.toJSONString(obj), LinkedHashMap.class, Feature.OrderedField);
		dataMap.remove("serverCode");
	    
		String sign = JxBankLoanSignUtil.addSign(dataMap, JxBankSignUtil.MD5_KEY);
		
		dataMap.put("sign_type", "MD5");
		dataMap.put("sign", sign);
		//加签后json
		String json = JSON.toJSONString(dataMap);
		
		logger.debug("----请求URL-----:" + url);
		logger.debug("----请求报文-----:" + json);
		
		return JxBankHttpGateway.doLoanPostJson(url, json);
	}
	
	/**
	 * 嘉兴银行 网贷系统 
	 */
	public static String doLoanPostJson(String url, String json) {
		
		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String resultString = "";
		AbstractJxBankLoanResponse res = null;
		try {
			// 创建Http Post请求
			HttpPost httpPost = new HttpPost(url);
			// 创建请求内容
			StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
			httpPost.setEntity(entity);
			// 执行http请求
			response = httpClient.execute(httpPost);
			// 响应状态
			int status = response.getStatusLine().getStatusCode();
			if(status == 200){
				resultString = EntityUtils.toString(response.getEntity(), "utf-8");
				System.out.println("----响应报文：----" + resultString);
 				checkLoanSign(resultString);  
			}else{
				res = new AbstractJxBankLoanResponse();
				res.setCode(recode8);
				res.setMsg(recode_info8 + ", 系统响应代码: " + status);
				logger.debug("----错误代码：" + recode8 + " , 错误信息：" + recode_info8 + ", 系统响应代码: " + status);
			}
			
		} catch (Exception e) {
			logger.debug("与嘉兴银行通讯异常:" + e.getMessage());
			
			res = new AbstractJxBankLoanResponse();
			
			if(e instanceof FinMallException){
				res.setCode(((FinMallException)e).getReturnCode());
				res.setMsg(((FinMallException)e).getReturnMsg());
			}else{
				res.setCode(recode9);
				res.setMsg("与嘉兴银行通讯异常");
			}
			
			resultString = JSONObject.toJSONString(res);
			logger.debug("----响应报文-----:" + resultString);
			return resultString;
			
		} finally {
			try {
				if(response != null){
					response.close();
				}
				if(httpClient != null){
					httpClient.close();					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(res != null){
			resultString = JSONObject.toJSONString(res);
		}
		
		logger.debug("----响应报文-----:" + resultString);

		return resultString;
	}
	

	/**
	 * 响应参数签名验证
	 */
	public static boolean checkLoanSign(String resultString){

		//由于二类户系统 和 网贷系统  加密方式相同，但所用字段不同次处统一处理
		
		boolean checkSign = JxBankLoanSignUtil.checkSign(resultString, JxBankLoanSignUtil.MD5_KEY);
		
		if(!checkSign){
			throw new FinMallException(GatewayErrorConstants.JXBANK_CHECK_SIGN);
		}
		
		return checkSign;
	}
	
	
	/**
	 * 嘉兴银行二类户系统网关通讯
	 */
	public static String doEamsPostObj(String url, Object obj){

		Map dataMap = JSONObject.parseObject(JSON.toJSONString(obj), LinkedHashMap.class, Feature.OrderedField);
		dataMap.remove("serverCode");
	      
		logger.debug("----签名前报文-----:" + dataMap.toString());
		String sign = JxBankLoanSignUtil.addSign(dataMap, JxBankSignUtil.MD5_KEY);

		dataMap.put("sign_data", sign);
		//加签后json
		String json = JSON.toJSONString(dataMap);
		
		logger.debug("----请求URL-----:" + url);
		logger.debug("----请求报文-----:" + json);
		
		return JxBankHttpGateway.doEamsPostJson(url, json);
	}
	
	public static String doEamsPostJson(String url, String json) {
		
		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String resultString = "";
		AbstractJxBankResponse res = null;
		try {
			// 创建Http Post请求
			HttpPost httpPost = new HttpPost(url);
			// 创建请求内容
			StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
			httpPost.setEntity(entity);
			// 执行http请求
			response = httpClient.execute(httpPost);
			// 响应状态
			int status = response.getStatusLine().getStatusCode();
			if(status == 200){
				resultString = EntityUtils.toString(response.getEntity(), "utf-8");
				System.out.println("----响应报文：----" + resultString);
				checkEamsSign(resultString); 
			}else{
				res = new AbstractJxBankResponse();
				res.setRecode(recode8);
				res.setRecode_info(recode_info8 + ", 系统响应代码: " + status);
				logger.debug("----错误代码：" + recode8 + " , 错误信息：" + recode_info8 + ", 系统响应代码: " + status);
			}
			
		} catch (Exception e) {
			logger.debug("与嘉兴银行通讯异常:" + e.getMessage());
			res = new AbstractJxBankResponse();
			res.setRecode(recode9);
			res.setRecode_info("与嘉兴银行通讯异常");
			
			resultString = JSONObject.toJSONString(res);
			logger.debug("----响应报文-----:" + resultString);
			return resultString;
			
		} finally {
			try {
				if(response != null){
					response.close();
				}
				if(httpClient != null){
					httpClient.close();					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(res != null){
			resultString = JSONObject.toJSONString(res);
		}
		
		logger.debug("----响应报文-----:" + resultString);

		return resultString;
	}
	
	/**
	 * 响应参数签名验证
	 */
	public static boolean checkEamsSign(String resultString){

		//由于二类户系统 和 网贷系统  加密方式相同，但所用字段不同次处统一处理
		
		boolean checkSign = JxBankSignUtil.checkSign(resultString, JxBankSignUtil.MD5_KEY);
		
		if(!checkSign){
			throw new FinMallException(GatewayErrorConstants.JXBANK_CHECK_SIGN);
		}
		
		return checkSign;
	}
	
}
