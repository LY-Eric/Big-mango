package com.eric.education.model;

import java.io.Serializable;
import java.util.Date;

public class File implements Serializable {
    /**
     * 文件Id
     */
    private Integer id;

    /**
     * 文件组Id
     */
    private String fileGroupId;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 文件地址
     */
    private String fileAddress;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 文件类型
     */
    private String fileType;

    /**
     * 文件状态
     */
    private String fileStatus;

    /**
     * 文件描述
     */
    private String remark;

    /**
     * 上传者
     */
    private Integer userId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileGroupId() {
        return fileGroupId;
    }

    public void setFileGroupId(String fileGroupId) {
        this.fileGroupId = fileGroupId == null ? null : fileGroupId.trim();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getFileAddress() {
        return fileAddress;
    }

    public void setFileAddress(String fileAddress) {
        this.fileAddress = fileAddress == null ? null : fileAddress.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    public String getFileStatus() {
        return fileStatus;
    }

    public void setFileStatus(String fileStatus) {
        this.fileStatus = fileStatus == null ? null : fileStatus.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", fileGroupId=").append(fileGroupId);
        sb.append(", fileName=").append(fileName);
        sb.append(", fileAddress=").append(fileAddress);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", fileType=").append(fileType);
        sb.append(", fileStatus=").append(fileStatus);
        sb.append(", remark=").append(remark);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}