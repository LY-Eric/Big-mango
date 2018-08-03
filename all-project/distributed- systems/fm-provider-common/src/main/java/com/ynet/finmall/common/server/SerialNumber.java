package com.ynet.finmall.common.server;

/**
 * 序列号/流水号/ID号，生产器
 * @author liuxin
 */
public interface SerialNumber {

	
	/**
	 * 生成UUID序列号删除横线"-"
	 */
	public String getUUID();
	
	/**
	 * 生成21位流水号其中前缀三位不足三位的补0，4到17位是日期+时间，后四位是有序数列
	 * ???YYYYMMDDHHMMSS????
	 */
	public String getFlow(String prefix);
	
	/**
	 * 生成18位全局唯一有序流水号
	 */
	public String getGlobalOnlyFlow(String prefix, int count);

	String getGlobalOnlyFlow(String prefix);

	String getGlobalOnlyFlow();

	String getGlobalOnlyFlow(int count);
	
	
	

}
