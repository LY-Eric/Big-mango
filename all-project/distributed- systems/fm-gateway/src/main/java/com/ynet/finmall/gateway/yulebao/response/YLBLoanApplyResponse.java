package com.ynet.finmall.gateway.yulebao.response;
/**
 * 贷款申请返回
 * 
 * @author xuhui
 *
 */
public class YLBLoanApplyResponse extends AbstractYLBResponse{

	private String apply_id ; //贷款编号
	
	public String getApply_id() {
		return apply_id;
	}
	public void setApply_id(String apply_id) {
		this.apply_id = apply_id;
	}
	
}
