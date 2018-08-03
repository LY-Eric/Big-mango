package com.ynet.finmall.gateway.jxbank.response;

/**
 * @Description 贷款审批查询返回参数
 * @Author 刘俊重
 * @Date 2018/3/15
 */
public class IngApprovalYlbListRes {

    private String apply_id;//贷款编号
    private String approval_status;//审批结果
    private String approval_note;//拒绝原因
    private String voucher_no;//存证编号

    public String getApply_id() {
        return apply_id;
    }

    public void setApply_id(String apply_id) {
        this.apply_id = apply_id;
    }

    public String getApproval_status() {
        return approval_status;
    }

    public void setApproval_status(String approval_status) {
        this.approval_status = approval_status;
    }

    public String getApproval_note() {
        return approval_note;
    }

    public void setApproval_note(String approval_note) {
        this.approval_note = approval_note;
    }

    public String getVoucher_no() {
        return voucher_no;
    }

    public void setVoucher_no(String voucher_no) {
        this.voucher_no = voucher_no;
    }
}
