package com.eric.education.common.enums;

/**
 *	用户状态 0:正常 1:冻结 2:删除
 */
public enum UserStatus {

    /**
     * 正常(已开户)
     */
    NORMAL("1","正常"),

    /**
     * 冻结
     */
    FROZEN("2","冻结"),

    /**
     * 删除
     */
    DELETE("4","删除");

    private String code;
    private String cnName;
    private UserStatus(String code, String cnName) {
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
