package com.ynet.finmall.common.enums;

/**
 * 平台企业状态
 * 0：待关联项目 1：正常: 2：冻结: 3：删除
 * @author zhangjijian
 *
 */
public enum PmPlatformStatus {
	
	/**
	 * 正常(已开户)
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
	
	
	private PmPlatformStatus(String code, String cnName) {
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
