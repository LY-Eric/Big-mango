package com.ynet.finmall.gateway.jxbank.response;

/**
 * @Description 贷款文件返回的集合
 * @Author 刘俊重
 * @Date 2018/1/5
 */
public class ContractFileList {
    private String contract_file;//合同文件
    private String apply_id;//贷款编号
    private String bank_service_id;  //银行签章id

    public String getContract_file() {
        return contract_file;
    }

    public void setContract_file(String contract_file) {
        this.contract_file = contract_file;
    }

    public String getApply_id() {
        return apply_id;
    }

    public void setApply_id(String apply_id) {
        this.apply_id = apply_id;
    }

    public String getBank_service_id() {
        return bank_service_id;
    }

    public void setBank_service_id(String bank_service_id) {
        this.bank_service_id = bank_service_id;
    }
}
