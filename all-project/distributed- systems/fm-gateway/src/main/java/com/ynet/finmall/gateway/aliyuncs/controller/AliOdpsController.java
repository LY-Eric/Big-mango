package com.ynet.finmall.gateway.aliyuncs.controller;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.finmall.model.v20180118.AddCollectionInfoOfProviderRequest;
import com.aliyuncs.finmall.model.v20180118.AddCollectionInfoOfProviderResponse;
import com.aliyuncs.finmall.model.v20180118.CreateProviderRequest;
import com.aliyuncs.finmall.model.v20180118.CreateProviderResponse;
import com.aliyuncs.http.FormatType;
import com.aliyuncs.http.ProtocolType;
import com.aliyuncs.profile.DefaultProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description 阿里云ODPS相关接口
 * @Author 刘俊重
 * @Date 2018/1/18
 */
@Controller
@ResponseBody
@RequestMapping("odps")
public class AliOdpsController {
	private static final Logger logger = LoggerFactory.getLogger(AliOdpsController.class);

	@Value("${aliyun.region.id}")
	private String regionId;

	@Value("${aliyun.access.key.id}")
	private String accessKeyId;

	@Value("${aliyun.access.key.secret}")
	private String accessKeySecret;

	@Value("${aliyun.product}")
	private String product;

	@Value("${aliyun.domain}")
	private String domain;

	/**
	 * @Description 供应商账户修改信息
	 * @Author 刘俊重
	 * @Date 2018/1/18
	 */
	@PostMapping("createProvider.do")
	public CreateProviderResponse createProvider(@RequestBody CreateProviderRequest request) throws ClientException {
		logger.info("请求参数>>>>>>>>>>>>>" + request.toString());
		// 创建DefaultAcsClient实例并初始化

		DefaultProfile profile = DefaultProfile.getProfile(regionId,accessKeyId,accessKeySecret);
		DefaultProfile.addEndpoint(regionId,regionId,product,domain);
		IAcsClient client = new DefaultAcsClient(profile);

		request.setAcceptFormat(FormatType.JSON);
		request.setProtocol(ProtocolType.HTTPS);
		// 发起请求并处理应答或异常
		CreateProviderResponse response = null;
		try {
			response = client.getAcsResponse(request);
			System.out.println(response);
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (ClientException e) {
			e.printStackTrace();
		}
		return response;
	}

	/**
	 * @Description 供应商应收账单
	 * @Author 刘俊重
	 * @Date 2018/1/18
	 */
	@PostMapping("addCollectionInfoOfProvider.do")
	public AddCollectionInfoOfProviderResponse addCollectionInfoOfProvider(@RequestBody AddCollectionInfoOfProviderRequest request)
			throws ClientException {
		logger.info("请求参数>>>>>>>>>>>>>" + request.toString());
		// 创建DefaultAcsClient实例并初始化
		DefaultProfile profile = DefaultProfile.getProfile(regionId,accessKeyId,accessKeySecret);
		DefaultProfile.addEndpoint(regionId,regionId,product,domain);
		IAcsClient client = new DefaultAcsClient(profile);

		request.setAcceptFormat(FormatType.JSON);
		request.setProtocol(ProtocolType.HTTPS);
		// 发起请求并处理应答或异常
		AddCollectionInfoOfProviderResponse response = null;
		try {
			response = client.getAcsResponse(request);
			System.out.println(response);
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (ClientException e) {
			e.printStackTrace();
		}
		return response;
	}
}
