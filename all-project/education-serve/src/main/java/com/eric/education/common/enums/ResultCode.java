package com.eric.education.common.enums;

/**
 *	响应码
 */
public enum ResultCode {

    /**
     * 成功
     */
    SUCCESS(200,"成功"),

    /**
     * 失败
     */
    FAIL(999,"失败");

    private Integer code;
    private String cnName;
    ResultCode(Integer code, String cnName) {
        this.code = code;
        this.cnName = cnName;
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public String getCnName() {
        return cnName;
    }
    public void setCnName(String cnName) {
        this.cnName = cnName;
    }


}
