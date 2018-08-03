package com.eric.education.response;

import com.eric.education.common.AbstractResponse;
import com.eric.education.model.SignCalc;
import com.eric.education.model.SignDetail;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author liuyang
 * @create 2018-05-31 14:58
 * @desc
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SignResponse extends AbstractResponse {

    /**
     * 签到详情对象
     */
    private SignDetail signDetail;

    /**
     * 签到次数对象
     */
    private SignCalc signCalc;

    public SignDetail getSignDetail() {
        return signDetail;
    }

    public void setSignDetail(SignDetail signDetail) {
        this.signDetail = signDetail;
    }

    public SignCalc getSignCalc() {
        return signCalc;
    }

    public void setSignCalc(SignCalc signCalc) {
        this.signCalc = signCalc;
    }
}
