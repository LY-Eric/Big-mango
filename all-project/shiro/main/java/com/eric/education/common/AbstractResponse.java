package com.eric.education.common;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author liuyang
 * @create 2018-05-31 15:08
 * @desc    公共响应参数
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AbstractResponse {

    public static final String SUCCESS = "000000";
    public static final String SUCCESSMSG = "成功";

    /**
     * 返回码
     */
    private String returnCode = SUCCESS;
    /**
     * 含义
     */
    private String returnMsg = SUCCESSMSG;
    /**
     * 签名串
     */
    private String sign_data;
    /**
     * 签名方式
     */
    private String sign_type;

    public AbstractResponse() {
        super();
    }

    public AbstractResponse(String returnCode, String returnMsg) {
        super();
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public String getSign_type() {
        return sign_type;
    }

    public void setSign_type(String sign_type) {
        this.sign_type = sign_type;
    }

    public String getSign_data() {
        return sign_data;
    }

    public void setSign_data(String sign_data) {
        this.sign_data = sign_data;
    }
}
