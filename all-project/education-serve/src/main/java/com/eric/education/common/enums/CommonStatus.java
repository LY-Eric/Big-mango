package com.eric.education.common.enums;

/**
 *	状态 0:正常 1:冻结 2:删除
 */
public enum CommonStatus {

    /**
     * 正常(已开户)
     */
    NORMAL("0","正常"),

    /**
     * 冻结
     */
    FROZEN("1","冻结"),

    /**
     * 删除
     */
    DELETE("2","删除");

    private String code;
    private String cnName;
    private CommonStatus(String code, String cnName) {
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
