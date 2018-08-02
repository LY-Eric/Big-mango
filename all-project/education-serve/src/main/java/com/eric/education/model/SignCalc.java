package com.eric.education.model;

import java.io.Serializable;

public class SignCalc implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 用户Id
     */
    private Integer userId;

    /**
     * 签到次数
     */
    private Integer continueDays;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getContinueDays() {
        return continueDays;
    }

    public void setContinueDays(Integer continueDays) {
        this.continueDays = continueDays;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", continueDays=").append(continueDays);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}