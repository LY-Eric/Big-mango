package com.eric.education.model;

import java.io.Serializable;

public class Permission implements Serializable {
    private Long perId;

    /**
     * url地址
     */
    private String urlAddress;

    /**
     * url描述
     */
    private String urlDesc;

    private static final long serialVersionUID = 1L;

    public Long getPerId() {
        return perId;
    }

    public void setPerId(Long perId) {
        this.perId = perId;
    }

    public String getUrlAddress() {
        return urlAddress;
    }

    public void setUrlAddress(String urlAddress) {
        this.urlAddress = urlAddress == null ? null : urlAddress.trim();
    }

    public String getUrlDesc() {
        return urlDesc;
    }

    public void setUrlDesc(String urlDesc) {
        this.urlDesc = urlDesc == null ? null : urlDesc.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", perId=").append(perId);
        sb.append(", urlAddress=").append(urlAddress);
        sb.append(", urlDesc=").append(urlDesc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}