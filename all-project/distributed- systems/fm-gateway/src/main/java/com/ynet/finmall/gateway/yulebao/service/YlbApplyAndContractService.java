package com.ynet.finmall.gateway.yulebao.service;

import com.ynet.finmall.gateway.yulebao.request.YLBApplyYlbRequest;
import com.ynet.finmall.gateway.yulebao.request.YLBContractSignYlbRequest;
import com.ynet.finmall.gateway.yulebao.request.YLBContractVoucherYlbRequest;
import com.ynet.finmall.gateway.yulebao.request.YLBIngApprovalYlbRequest;
import com.ynet.finmall.gateway.yulebao.response.YLBApplyYlbResponse;
import com.ynet.finmall.gateway.yulebao.response.YLBContractSignYlbResponse;
import com.ynet.finmall.gateway.yulebao.response.YLBContractVoucherYlbResponse;
import com.ynet.finmall.gateway.yulebao.response.YLBIngApprovalYlbResponse;

/**
 * @Description 娱乐宝贷款申请和盖章相关接口
 * @Author 刘俊重
 * @Date 2018/1/16
 */
public interface YlbApplyAndContractService {

    /**
     * @Description 贷款申请
     * @Author 刘俊重
     * @Date 2018/1/16
     */
    YLBApplyYlbResponse applyYlb(YLBApplyYlbRequest request);

    /**
     * @Description 合同盖章
     * @Author 刘俊重
     * @Date 2018/1/16
     */
    YLBContractSignYlbResponse contractSignYlb(YLBContractSignYlbRequest request);

    /**
     * @Description 合同存证
     * @Author 刘俊重
     * @Date 2018/1/16
     */
    YLBContractVoucherYlbResponse contractVoucherYlb(YLBContractVoucherYlbRequest request);

    /**
     * @Description 贷款审批查询
     * @Author 刘俊重
     * @Date 2018/3/15
     */
    YLBIngApprovalYlbResponse ingApprovalYlb(YLBIngApprovalYlbRequest request);
}
