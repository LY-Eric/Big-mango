package com.ynet.finmall.common.enums;

/**
 * 企业角色信息 状态表
 * @author zhangjijian
 *
 */
public enum CmCompanyRoleStatus {
	/**
	 * 待关联项目
	 */
	ToBeMatched("1","待关联项目"),
	/**
	 * 待开户
	 */
	STAYOPENACCOUNT("2","待开户"),
	/**
	 * 正常(已开户)
	 */
	NORMAL("3","正常"),
	/**
	 * 冻结
	 */
	FROZEN("4","冻结"),
	/**
	 * 删除
	 */
	DELETE("5","删除");
	
	private String code;
	private String cnName;
	
	
	private CmCompanyRoleStatus(String code, String cnName) {
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
