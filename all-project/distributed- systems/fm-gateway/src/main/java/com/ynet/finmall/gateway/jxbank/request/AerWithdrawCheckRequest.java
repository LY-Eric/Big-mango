package com.ynet.finmall.gateway.jxbank.request;

/**
 * 商户取现查证接口
 * 
 * 对商户取现的处理结果进行查证
 * 
 * @author liuxin
 *
 */
public class AerWithdrawCheckRequest extends AbstractJxBankRequest {

	private String serial_no			;//C32	Y	流水号
	private String original_serialno	;//C32	Y	原交易流水号
	private String trans_date			;//C10	Y	操作日期	YYYY-MM-DD
	private String trans_tradetime		;//C19	Y	操作时间
	private String trans_teller			;//C8	C	虚拟柜员为“00000000”
	
	public String getSerial_no() {
		return serial_no;
	}

	public void setSerial_no(String serial_no) {
		this.serial_no = serial_no;
	}

	public String getOriginal_serialno() {
		return original_serialno;
	}

	public void setOriginal_serialno(String original_serialno) {
		this.original_serialno = original_serialno;
	}

	public String getTrans_date() {
		return trans_date;
	}

	public void setTrans_date(String trans_date) {
		this.trans_date = trans_date;
	}

	public String getTrans_tradetime() {
		return trans_tradetime;
	}

	public void setTrans_tradetime(String trans_tradetime) {
		this.trans_tradetime = trans_tradetime;
	}

	public String getTrans_teller() {
		return trans_teller;
	}

	public void setTrans_teller(String trans_teller) {
		this.trans_teller = trans_teller;
	}

	@Override
	public String getServerCode() {
		return "merTrade/mer_withdraw_check";
	}
	
}
