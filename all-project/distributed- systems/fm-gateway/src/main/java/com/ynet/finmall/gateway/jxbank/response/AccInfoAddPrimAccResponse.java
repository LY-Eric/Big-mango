package com.ynet.finmall.gateway.jxbank.response;

/**
 * 绑定账号新增
 * 
 * @author hubk
 *
 */
public class AccInfoAddPrimAccResponse extends AbstractJxBankResponse {
	private String sys_date;// 系统日期
	private String sys_time;// 系统时间

	public String getSys_date() {
		return sys_date;
	}

	public String getSys_time() {
		return sys_time;
	}

	public void setSys_date(String sys_date) {
		this.sys_date = sys_date;
	}

	public void setSys_time(String sys_time) {
		this.sys_time = sys_time;
	}

}
