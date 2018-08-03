package com.ynet.finmall.common.server.impl;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ynet.finmall.common.constant.ParamConstants;
import com.ynet.finmall.common.server.SerialNumber;
import com.ynet.finmall.redis.server.SharedJedisUtils;


/**
 * 序列号/流水号/ID号
 * 
 * @author liuxin
 */
@Component("serialNumber")
public class SerialNumberImpl implements SerialNumber{

	@Autowired(required=false)
	@Qualifier("sharedJedisUtils")
	private SharedJedisUtils sharedJedisUtils;

	@Override
	public String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	/**
	 * 生成21位流水号 格式： 前缀 + 时间 + 有序序列。
	 * 前缀长度不能超过3位 不足3位补零“0”
	 */
	@Override
	public String getFlow(String prefix) {

		Date currentDate = new Date();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHMMSSSSS");
		if (StringUtils.isBlank(prefix)) {
			for (; prefix.length() < 3;) {
				prefix = prefix + "0";
			}
		}
		String flow = prefix + fmt.format(currentDate);

		Long count = sharedJedisUtils.incr(flow, 1);
		if(count == null){//count null 缓存出现问题,时间精确到毫秒，此处有一漏洞，当集群模式同一时间不同服务器可能会生成同一个流水号。
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHMMSS0SSS");
			flow = prefix + format.format(currentDate);
		}
		String countStr = count + "";
		for(;countStr.length() < 4;){
			countStr = "0" + countStr;
		}
		
		flow = flow + countStr;

		return flow;
	}
	
	/**
	 * 指定长度和前缀的有序流水号
	 */
	@Override
	public String getGlobalOnlyFlow(String prefix, int count) {
		//默认生成长度为21位
		if(count == 0){	count = 21;	}
		
		String flow = null;
		if (StringUtils.isBlank(prefix)) {
			flow = sharedJedisUtils.incr(ParamConstants.GLOBALONLYFLOW_KEY, 0) + "";
		}else{
			flow = prefix + sharedJedisUtils.incr(prefix + ParamConstants.GLOBALONLYFLOW_KEY, 0);
		}
		
		for (;  count < flow.length(); ) {
			if (count - flow.length() > 10) {
				flow = "0000000000" + flow;
			}
			if (count - flow.length() > 5) {
				flow = "00000" + flow;
			}
			if (count - flow.length() > 3) {
				flow = "000" + flow;
			}
			if (count - flow.length() > 1) {
				flow = "0" + flow;
			}
		}
		return flow;
	}
	
	/**
	 * 有前缀序列号默认长度21位 有序流水号
	 */
	@Override
	public String getGlobalOnlyFlow(String prefix) {
		return this.getGlobalOnlyFlow(prefix, 0);
	}
	/**
	 * 无前缀默认长度21为 有序流水号
	 */
	@Override
	public String getGlobalOnlyFlow() {
		return this.getGlobalOnlyFlow("", 0);
	}
	
	/**
	 * 无前缀自定义长度 有序流水号
	 */
	@Override
	public String getGlobalOnlyFlow(int count) {
		return this.getGlobalOnlyFlow("", count);
	}

	public static void main(String[] args) {
		Date currentDate = new Date();
		
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHMMSS0SSS");
		String flow =  fmt.format(currentDate);
		System.out.println(flow);
		
		SimpleDateFormat fmt1 = new SimpleDateFormat("yyyyMMddHHMMSS");
		String flow1 =  fmt1.format(currentDate);
		System.out.println(flow1);
	}
}
