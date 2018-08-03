package com.ynet.finmall.gateway.yulebao;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.ynet.finmall.gateway.exception.GatewayErrorConstants;
import com.ynet.finmall.gateway.exception.YLBGatewayException;
import com.ynet.finmall.gateway.yulebao.aop.YLBSignUtil;
import com.ynet.finmall.gateway.yulebao.response.AbstractYLBResponse;

/**
 * HttpClient请求工具类（支持GET/POST方式）
 * @author qiangjiyi
 * @date 2017年11月7日 下午3:12:10
 */
public class YLBHttpGateway {
	private static final Logger logger = LoggerFactory.getLogger(YLBHttpGateway.class);

	private static final String recode8 = "999998";
	private static final String recode_info8 = "娱乐宝系统异常";
	
	private static final String recode9 = "999999";//通讯异常
	
	/**
	 * 娱乐宝贷款网关通讯
	 */
	public static String doPostObj(String url, Object obj){
		
		//删除serverCode 加签sign_data
		String json = JSONObject.toJSONString(obj);
		JSONObject jsonObj = JSONObject.parseObject(json);
		jsonObj.remove("serverCode");
		json = jsonObj.toJSONString();//加签前json

		//加签
		String sign = YLBSignUtil.addSign(json, YLBSignUtil.MD5_KEY);

		jsonObj.put("sign_data", sign);
		jsonObj.put("sign_Type", "MD5");
		
		//加签后json
		json = jsonObj.toJSONString();
		
		logger.debug("----请求URL-----:" + url);
		logger.debug("----请求报文-----:" + json);
		
		return YLBHttpGateway.doPostJson(url, json);
	}
	
	public static String doPostJson(String url, String json) {
		
		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String resultString = "";
		AbstractYLBResponse res = null;
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
				checkSign(resultString);
			}else{
				res = new AbstractYLBResponse();
				res.setReturnCode(recode8);
				res.setReturnMsg(recode_info8 + ", 系统响应代码: " + status);
				logger.debug("----错误代码：" + recode8 + " , 错误信息：" + recode_info8 + ", 系统响应代码: " + status);
			}
			
		} catch (Exception e) {
			res = new AbstractYLBResponse();
			if(e instanceof YLBGatewayException){
				res.setReturnCode(((YLBGatewayException)e).getReturnCode());
				res.setReturnMsg(((YLBGatewayException)e).getReturnMsg());
			}else{
				logger.debug("与娱乐宝通讯异常:" + e.getMessage());
				res.setReturnCode(recode9);
				res.setReturnMsg("与娱乐宝通讯异常");				
			}
			
			resultString = JSONObject.toJSONString(res);
			logger.debug("----响应报文-----:" + resultString);
			return resultString;
			
		} finally {
			try {
				response.close();
				httpClient.close();
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
	public static boolean checkSign(String resultString){

		boolean checkSign = YLBSignUtil.checkSign(resultString, YLBSignUtil.MD5_KEY);
		
		if(!checkSign){
			throw new YLBGatewayException(GatewayErrorConstants.YLB_CHECK_SIGN);
		}
		
		return checkSign;
	}
	
}
