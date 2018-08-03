package com.eric.education.service.impl;

import com.eric.education.service.ISerialNumber;
import org.springframework.stereotype.Component;

import java.util.UUID;


/**
 * 序列号/流水号/ID号
 * 
 * @author liuxin
 */
@Component("serialNumber")
public class SerialNumberImpl implements ISerialNumber {

	/*@Autowired(required=false)
	@Qualifier("sharedJedisUtils")
	private SharedJedisUtils sharedJedisUtils;*/

	@Override
	public String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	/**
	 * 生成21位流水号 格式： 前缀 + 时间 + 有序序列。
	 * 前缀长度不能超过3位 不足3位补零“0”
	 */
	/*@Override
	public String getFlow(String prefix) {

		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHMMSS");
		if (StringUtils.isBlank(prefix)) {
			for (; prefix.length() < 3;) {
				prefix = prefix + "0";
			}
		}
		String flow = prefix + fmt.format(new Date());

		Long count = sharedJedisUtils.incr(flow, 1);
		if(count == null){//count null 缓存出现问题，此时程序判断本机IP + 本机生成序号。
			try {
				String localhostIp = InetAddress.getLocalHost().getHostAddress();
				Map<String, Long> dataMap = new HashMap<String, Long>();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
		}
		String countStr = count + "";
		for(;countStr.length() < 4;){
			countStr = "0" + countStr;
		}
		
		flow = flow + countStr;

		return flow;
	}
	
	*//**
	 * 指定长度和前缀的有序流水号
	 *//*
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
	
	*//**
	 * 有前缀序列号默认长度21位 有序流水号
	 *//*
	@Override
	public String getGlobalOnlyFlow(String prefix) {
		return this.getGlobalOnlyFlow(prefix, 0);
	}
	*//**
	 * 无前缀默认长度21为 有序流水号
	 *//*
	@Override
	public String getGlobalOnlyFlow() {
		return this.getGlobalOnlyFlow("", 0);
	}
	
	*//**
	 * 无前缀自定义长度 有序流水号
	 *//*
	@Override
	public String getGlobalOnlyFlow(int count) {
		return this.getGlobalOnlyFlow("", count);
	}*/

}
