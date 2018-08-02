package com.eric.education.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    /**
     * Id
     */
    private Integer id;

    /**
     * 登陆账号
     */
    private String loginName;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * MD5密码
     */
    private String password;

    /**
     * 创建日期
     */
    private Date createTime;

    /**
     * 头像
     */
    private String icon;

    /**
     * 手机
     */
    private String telphone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 性别：0-保密 1-男 2-女
     */
    private String sex;

    /**
     * 状态
     */
    private String status;

    /**
     * 授权ID
     */
    private String openid;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 0-老师，1-学生
     */
    private String identity;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone == null ? null : telphone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity == null ? null : identity.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", loginName=").append(loginName);
        sb.append(", nickName=").append(nickName);
        sb.append(", password=").append(password);
        sb.append(", createTime=").append(createTime);
        sb.append(", icon=").append(icon);
        sb.append(", telphone=").append(telphone);
        sb.append(", email=").append(email);
        sb.append(", sex=").append(sex);
        sb.append(", status=").append(status);
        sb.append(", openid=").append(openid);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", identity=").append(identity);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}