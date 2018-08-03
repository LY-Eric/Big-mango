package com.ynet.finmall.goods.response;

import com.ynet.finmall.common.response.AbstractResponse;

/**
 * 查询审核流模板接口
 * @author liuxin
 *
 */
public class QueryWorkflowOrderStatusResponse extends AbstractResponse {

    /**
     * 审核后的业务状态  审核记录步骤表 的审核后的状态
     */
    private String orderStatus;
    /**
     * 下一步审核方
     */
    private String nextAuditor;
//
//    /**
//     * 审核记录表ID
//     */
//    private String checkId;
//
//    /**
//     * 审批流ID
//     */
//    private String workflowId;
//
//    /**
//     * 父项目ID
//     */
//    private String parentProjectId;
//
//    /**
//     * 子项目ID
//     */
//    private String sonProjectId;
//
//    /**
//     * 企业ID
//     */
//    private String companyId;
//
//    /**
//     * 业务ID
//     */
//    private String serviceId;
//
//    /**
//     * 业务类型 1-融资单表 2-资产单 3-核心企业入网 4-供应商入网
//     */
//    private String serviceType;
//
//    /**
//     * 当前步骤的操作状态,1预审中(无人领取),2审核中(已被领取别人此时不能操作),3(审核完成)通过,4(审核完成)失败
//     */
//    private String status;
//
//    /**
//     * 当前所属步骤类型(1开始步骤，2一般步骤，3结束步骤)
//     */
//    private String stepType;
//
//    /**
//     * 当前所属步骤
//     */
//    private String stepCode;
//
//    /**
//     * 备注
//     */
//    private String remark;
//
//    /**
//     * 下一步所属步骤
//     */
//    private String nextStepCode;
//
//    /**
//     * 审核方（1finmall运营，2核心企业，3供应商，4业务方，5资金方）
//     */
//    private String auditor;
//

//
//    /**
//     * 创建时间
//     */
//    private Date createTime;
//
//    /**
//     * 更新时间
//     */
//    private Date updateTime;

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

	public String getNextAuditor() {
		return nextAuditor;
	}

	public void setNextAuditor(String nextAuditor) {
		this.nextAuditor = nextAuditor;
	}


}
