package com.ynet.finmall.common.enums;

/**
 * 文件状态
 * @desc
 * @author zhangjijian
 * @date: 2018年5月24日 下午2:28:23 
 * @since JDK 1.8  
 * 
 *
 */
public enum FileStatus {

	/**
	 * 正常
	 */
	NORMAL("1","正常"),
	/**
	 * 冻结
	 */
	FROZEN("2","冻结"),
	/**
	 * 删除
	 */
	DELETE("3","删除");
	private String code;
	private String cnName;
	
	
	private FileStatus(String code, String cnName) {
		this.code = code;
		this.cnName = cnName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCnName() {
		return cnName;
	}
	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
}
