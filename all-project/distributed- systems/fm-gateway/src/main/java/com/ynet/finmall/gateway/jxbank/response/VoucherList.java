package com.ynet.finmall.gateway.jxbank.response;

/**
 * @Description 合同存证
 * @Author 刘俊重
 * @Date 2018/1/5
 */
public class VoucherList {
    private String apply_id;//贷款编号
    private String voucher_no;//存证编号
    private String voucher_url;//存证地址

    public String getApply_id() {
        return apply_id;
    }

    public void setApply_id(String apply_id) {
        this.apply_id = apply_id;
    }

    public String getVoucher_no() {
        return voucher_no;
    }

    public void setVoucher_no(String voucher_no) {
        this.voucher_no = voucher_no;
    }

    public String getVoucher_url() {
        return voucher_url;
    }

    public void setVoucher_url(String voucher_url) {
        this.voucher_url = voucher_url;
    }
}
