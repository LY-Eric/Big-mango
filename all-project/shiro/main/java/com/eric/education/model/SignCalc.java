package com.eric.education.model;

import java.io.Serializable;

public class SignCalc implements Serializable {
    /**
     * 签到ID
     */
    private String signId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 签到次数
     */
    private Long continueDays;

    private static final long serialVersionUID = 1L;

    public String getSignId() {
        return signId;
    }

    public void setSignId(String signId) {
        this.signId = signId == null ? null : signId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Long getContinueDays() {
        return continueDays;
    }

    public void setContinueDays(Long continueDays) {
        this.continueDays = continueDays;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", signId=").append(signId);
        sb.append(", userId=").append(userId);
        sb.append(", continueDays=").append(continueDays);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}