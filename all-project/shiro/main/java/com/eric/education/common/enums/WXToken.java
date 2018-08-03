package com.eric.education.common.enums;

/**
 *	微信敏感信息
 */
public enum WXToken {

    /**
     * openid
     */
    openid("1","openid"),

    /**
     * sessin_key
     */
    sessinkey("2","sessin_key");

    private String code;
    private String cnName;
    private WXToken(String code, String cnName) {
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
