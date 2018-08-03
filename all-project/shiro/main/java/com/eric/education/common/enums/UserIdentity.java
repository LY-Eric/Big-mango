package com.eric.education.common.enums;

/**
 *	用户状态 1:老师 2:学生
 */
public enum UserIdentity {

    /**
     * 老师
     */
    NORMAL("1","老师"),

    /**
     * 学生
     */
    DELETE("2","学生");

    private String code;
    private String cnName;
    private UserIdentity(String code, String cnName) {
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
