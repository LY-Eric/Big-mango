package com.eric.education.request;

/**
 * @author liuyang
 * @create 2018-06-06 13:35
 * @desc
 */
public class WXRequest {

    /**
     *  临时登录凭证code
     */
    private String code;

    /**
     *  session3rd
     * @return
     */
    private String session3rd;

    private String idcard;
    private String identity;
    private String tel;
    private String nickName;
    private String gender;


    //--------------------------------------------------分割线--------------------

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSession3rd() {
        return session3rd;
    }

    public void setSession3rd(String session3rd) {
        this.session3rd = session3rd;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
