package com.eric.education.model;

import java.io.Serializable;
import java.util.Date;

public class SignDetail implements Serializable {
    /**
     * 签到ID
     */
    private String signDetailId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 签到时间
     */
    private Date signDate;

    private static final long serialVersionUID = 1L;

    public String getSignDetailId() {
        return signDetailId;
    }

    public void setSignDetailId(String signDetailId) {
        this.signDetailId = signDetailId == null ? null : signDetailId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", signDetailId=").append(signDetailId);
        sb.append(", userId=").append(userId);
        sb.append(", signDate=").append(signDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}