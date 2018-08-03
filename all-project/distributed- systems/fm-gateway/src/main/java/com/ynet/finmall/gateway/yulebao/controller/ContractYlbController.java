package com.ynet.finmall.gateway.yulebao.controller;

import com.alibaba.fastjson.JSONObject;
import com.ynet.finmall.gateway.exception.GatewayErrorConstants;
import com.ynet.finmall.gateway.yulebao.request.YLBContractSignYlbRequest;
import com.ynet.finmall.gateway.yulebao.request.YLBContractVoucherYlbRequest;
import com.ynet.finmall.gateway.yulebao.response.YLBContractSignYlbResponse;
import com.ynet.finmall.gateway.yulebao.response.YLBContractVoucherYlbResponse;
import com.ynet.finmall.gateway.yulebao.service.YlbApplyAndContractService;
import com.ynet.finmall.gateway.yulebao.utils.AssertUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 合同 相关
 * @Author 刘俊重
 * @Date 2018/1/5
 */
@RestController
public class ContractYlbController {
	@Autowired
	private YlbApplyAndContractService ylbApplyAndContractService;

	/**
	 * @Description 合同盖章
	 * @Author 刘俊重
	 * @Date 2018/1/5
	 */
	@PostMapping(name="调用娱乐宝贷合同盖章接口",value="/api/ylb/loan/contractSignYlb.do")
	public YLBContractSignYlbResponse contractSignYlb(@RequestBody YLBContractSignYlbRequest request) {
		AssertUtils.notNull(request.getFinmall_id(), GatewayErrorConstants.YLB_FINMALLID_NOT_NULL);
		YLBContractSignYlbResponse ylbContractSignYlbResponse = ylbApplyAndContractService.contractSignYlb(request);
		return ylbContractSignYlbResponse;
	}

	/**
	 * @Description 合同存证
	 * @Author 刘俊重
	 * @Date 2018/1/5
	 */
	@PostMapping(name="调用娱乐宝贷合合同存证接口",value="/api/ylb/loan/contractVoucherYlb.do")
	public YLBContractVoucherYlbResponse contractVoucherYlb(@RequestBody JSONObject jsonObj) {
		YLBContractVoucherYlbRequest request = JSONObject.parseObject(jsonObj.toJSONString(),
				YLBContractVoucherYlbRequest.class);
		AssertUtils.notNull(request.getFinmall_id(), GatewayErrorConstants.YLB_FINMALLID_NOT_NULL);
		YLBContractVoucherYlbResponse ylbContractVoucherYlbResponse = ylbApplyAndContractService
				.contractVoucherYlb(request);
		return ylbContractVoucherYlbResponse;
	}
}
