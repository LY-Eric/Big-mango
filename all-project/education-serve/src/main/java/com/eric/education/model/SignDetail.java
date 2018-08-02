package com.eric.education.model;

import java.io.Serializable;
import java.util.Date;

public class SignDetail implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 用户Id
     */
    private Integer userId;

    /**
     * 签到时间
     */
    private Date signdate;

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

    public Date getSigndate() {
        return signdate;
    }

    public void setSigndate(Date signdate) {
        this.signdate = signdate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", signdate=").append(signdate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}