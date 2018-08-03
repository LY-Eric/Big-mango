package com.ynet.finmall.gateway.yulebao.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.ynet.exception.ParamConstants;
import com.ynet.finmall.gateway.exception.YLBGatewayException;
import com.ynet.finmall.gateway.validator.ValidatorUtils;
import com.ynet.finmall.gateway.yulebao.model.CoreCorpInfo;
import com.ynet.finmall.gateway.yulebao.request.YLBCreateCoreRequest;
import com.ynet.finmall.gateway.yulebao.response.BaseResponse;
import com.ynet.finmall.gateway.yulebao.response.CoreCorpInfoResponse;
import com.ynet.finmall.gateway.yulebao.response.CreateCoreInfo;
import com.ynet.finmall.gateway.yulebao.response.YLBCreateCoreResponse;
import com.ynet.finmall.gateway.yulebao.service.YlbCoreCorpService;
import com.ynet.scm.api.gateway.yulebao.CoreCorpService;

@Service
public class YlbCoreCorpServiceImpl implements YlbCoreCorpService {
	private static final Logger logger = LoggerFactory.getLogger(YlbCoreCorpService.class);
	
	@Autowired(required = false)
	private CoreCorpService coreCorpService;

	@Override
	public YLBCreateCoreResponse gSave(String req) {
		YLBCreateCoreRequest coreRequest = JSON.parseObject(req, YLBCreateCoreRequest.class);
		ValidatorUtils.validateEntity(coreRequest);
		CoreCorpInfo coreCorpInfo = convert(coreRequest);
		// 1.调用(外部接口)供应链接口
		String save = null;
		try {
			save = coreCorpService.save(JSON.toJSONString(coreCorpInfo));
		} catch (Exception e) {
			logger.error("--->>" + e);
			logger.error("--->>用户中心访问失败");
			// 2.外部接口调用失败，抛出具体 外部系统调用失败异常如：YLB0004 用户中心访问失败
			// throw new
			// YLBGatewayException(GatewayErrorConstants.YLB_REQ_USER_ERROR);
			throw new YLBGatewayException(ParamConstants.SYSTEM_ERROR_CODE, ParamConstants.SYSTEM_ERROR_MSG);
		}
		CoreCorpInfoResponse parseObject = JSON.parseObject(save, CoreCorpInfoResponse.class);
		// 3.判断外部系统业务处理是否成功
		if (BaseResponse.SUCCESS.equals(parseObject.getCode())) {
			YLBCreateCoreResponse ylbCreateCoreResponse = new YLBCreateCoreResponse();
			CreateCoreInfo createCoreInfo = new CreateCoreInfo();
			createCoreInfo.setFinmall_id(parseObject.getFinmallId() + "");
			ylbCreateCoreResponse.setData(createCoreInfo);
			return ylbCreateCoreResponse;
		} else {
			// 4.不成功则抛出具体业务处理失败异常，如：YLB0005 用户中心保存失败
			logger.error("--->>用户中心保存失败");
			// throw new
			// YLBGatewayException(GatewayErrorConstants.YLB_USER_SAVE_ERROR,
			// parseObject);
			throw new YLBGatewayException(ParamConstants.SYSTEM_ERROR_CODE, ParamConstants.SYSTEM_ERROR_MSG);
		}
	}

	private CoreCorpInfo convert(YLBCreateCoreRequest coreRequest) {
		CoreCorpInfo coreCorpInfo = new CoreCorpInfo();
		coreCorpInfo.setEmail(coreRequest.getEmail());
		coreCorpInfo.setPhone(coreRequest.getPhone());
		coreCorpInfo.setContactPerson(coreRequest.getContact_person());
		coreCorpInfo.setUserName(coreRequest.getUserName());
		coreCorpInfo.setCompanyName(coreRequest.getCompanyName());

		coreCorpInfo.setBusinessRegistrationNo(coreRequest.getBusiness_licence());
		coreCorpInfo.setBusinessRegisterDate(coreRequest.getBusiness_register_date());
		coreCorpInfo.setBusinessType(coreRequest.getBusiness_type());
		coreCorpInfo.setOrganizationCode(coreRequest.getOrganization_code());
		coreCorpInfo.setBusinessRegisterCapital(coreRequest.getBusiness_register_capital());
		coreCorpInfo.setCompanyAddress(coreRequest.getCompany_address());
		coreCorpInfo.setLegalCertType(coreRequest.getLegal_cert_type());
		coreCorpInfo.setLegalPerson(coreRequest.getLegal_person());
		coreCorpInfo.setLegalErtificateNo(coreRequest.getLegal_ertificate_no());
		return coreCorpInfo;
	}
}
