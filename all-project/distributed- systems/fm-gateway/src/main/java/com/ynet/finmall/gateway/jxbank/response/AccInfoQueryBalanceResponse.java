package com.ynet.finmall.gateway.jxbank.response;

import java.util.List;

import com.ynet.finmall.gateway.jxbank.event.BalanceDetail;

/**
 * 查询余额响应参数
 * 
 * @author qiangjiyi
 * @date 2018年1月5日 上午10:46:04
 */
public class AccInfoQueryBalanceResponse extends AbstractJxBankResponse {

	private String account_name; // 户名

	private String id_type; // 证件类型

	private String id_no; // 证件号码

	private String mobile; // 手机号

	private String sys_date; // 账户系统日期
	private String sys_time; // 账户系统时间
	private List<BalanceDetail> detail_list; // 明细列表，出现1…n次

	public String getAccount_name() {
		return account_name;
	}

	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}

	public String getId_type() {
		return id_type;
	}

	public void setId_type(String id_type) {
		this.id_type = id_type;
	}

	public String getId_no() {
		return id_no;
	}

	public void setId_no(String id_no) {
		this.id_no = id_no;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public List<BalanceDetail> getDetail_list() {
		return detail_list;
	}

	public void setDetail_list(List<BalanceDetail> detail_list) {
		this.detail_list = detail_list;
	}

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
