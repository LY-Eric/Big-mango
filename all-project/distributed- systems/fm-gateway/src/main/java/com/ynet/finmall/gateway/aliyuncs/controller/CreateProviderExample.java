package com.ynet.finmall.gateway.aliyuncs.controller;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.finmall.model.v20180118.CreateProviderRequest;
import com.aliyuncs.finmall.model.v20180118.CreateProviderResponse;
import com.aliyuncs.http.FormatType;
import com.aliyuncs.http.ProtocolType;
import com.aliyuncs.profile.DefaultProfile;

import java.util.Date;

/**
 * @author 刘俊重
 * @Description
 * @date 18:50
 */
public class CreateProviderExample {
    public static void main(String[] args) throws ClientException {
        // 创建DefaultAcsClient实例并初始化
        DefaultProfile profile = DefaultProfile.getProfile(
                "cn-hangzhou", // 地域ID
                "LTAI3nl51iph58YY", // RAM账号的AccessKey ID
                "fjpsURzE4yQObi1FdimBQG1NsATzCW"); // RAM账号Access Key Secret
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "Finmall", "finmall.aliyuncs.com");
        IAcsClient client = new DefaultAcsClient(profile);
        // 创建API请求并设置参数
        CreateProviderRequest request = new CreateProviderRequest();

        request.setAlipayNo("99dx@9dian9.cn");
        request.setPlatformName("1");
        request.setProviderName("1");
        request.setCompanyName("杭州久点久电子商务有限公司");
        request.setBusinessRegistrationNo("91330106092043066C");
        request.setSiteMemId("1");
        request.setContractBeginDate(new Date().getTime() - 1000);
        request.setContractExpirationDate(new Date().getTime());
        request.setContractStatus(1);
        request.setAccountSubject("1");
        request.setAliuid("1845565787725775");

        request.setAcceptFormat(FormatType.JSON);
        request.setProtocol(ProtocolType.HTTPS);
        // 发起请求并处理应答或异常
        CreateProviderResponse response;
        try {
            response = client.getAcsResponse(request);
            System.out.println(response.toString());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
