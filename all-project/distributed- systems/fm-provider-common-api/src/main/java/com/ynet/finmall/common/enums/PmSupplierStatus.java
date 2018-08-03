package com.ynet.finmall.common.enums;

/**
 * 供应商入网  审核状态
 * 1待核心企业确认 2待供应商添加账户 3待资金方审核 4核心企业审核拒绝 5资金方审核拒绝 6资金方审核待修改 7审核通过
 * @author zhangjijian
 *
 */
public enum PmSupplierStatus {

	/**
	 * 待核心企业确认
	 */
	TOBECONFIRMEDBYTHECOREENTERPRISE("1","待核心企业确认"),
	/**
	 * 待供应商添加账户
	 */
	ADDANACCOUNTTOASUPPLIER("2","待供应商添加账户"),
	/**
	 * 待资金方审核
	 */
	AUDITSOFPENDINGCAPITAL("3","待资金方审核"),
	/**
	 * 核心企业审核拒绝
	 */
	Coreenterprisereviewrefusal("4","核心企业审核拒绝"),
	/**
	 * 资金方审核拒绝
	 */
	REFUSALOFFINANCIALAUDITS("5","资金方审核拒绝"),
	/**
	 * 资金方审核待修改
	 */
	FUNDREVIEWTOBEREVISED("6","资金方审核待修改"),
	/**
	 * 审核通过
	 */
	REVIEWANDPASSTHROUGH("7","审核通过");
	
	private String code;
	private String cnName;
	private PmSupplierStatus(String code, String cnName) {
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
