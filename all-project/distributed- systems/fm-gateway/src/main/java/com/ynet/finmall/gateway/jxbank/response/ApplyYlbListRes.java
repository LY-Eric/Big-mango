package com.ynet.finmall.gateway.jxbank.response;

/**
 * @Description 贷款申请响应数据列表
 * @Author 刘俊重
 * @Date 2018/1/5
 */
public class ApplyYlbListRes{

    private String apply_id;//编号
    private Integer approval_status;  //审批结果
    private String approval_note;  //拒绝原因

    public String getApply_id() {
        return apply_id;
    }

    public void setApply_id(String apply_id) {
        this.apply_id = apply_id;
    }

    public Integer getApproval_status() {
        return approval_status;
    }

    public void setApproval_status(Integer approval_status) {
        this.approval_status = approval_status;
    }

    public String getApproval_note() {
        return approval_note;
    }

    public void setApproval_note(String approval_note) {
        this.approval_note = approval_note;
    }
}
