package com.ynet.finmall.gateway.yulebao.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;
import com.ynet.finmall.gateway.jxbank.request.JxOrderDownFileRequest;
import com.ynet.finmall.gateway.jxbank.response.JxOrderDownFileResponse;
import com.ynet.finmall.gateway.jxbank.service.JxbankGateway;
import com.ynet.finmall.gateway.yulebao.request.YLBOrderDownFileRequest;
import com.ynet.finmall.gateway.yulebao.response.OrderDownFileInfo;
import com.ynet.finmall.gateway.yulebao.response.YLBOrderDownFileResponse;
import com.ynet.finmall.gateway.yulebao.service.YlbOrderDownFileService;
import com.ynet.finmall.gateway.yulebao.utils.CopyUtils;

/**
 * 对账文件相关的业务接口实现
 * @author qiangjiyi
 * @date 2018年1月12日 下午5:05:47
 */
@Service
public class YlbOrderDownFileServiceImpl implements YlbOrderDownFileService {

	private static Logger logger = LoggerFactory.getLogger(YlbOrderDownFileServiceImpl.class);
	
	@Autowired
	private JxbankGateway jxbankGateway;
	
	@Override
	public YLBOrderDownFileResponse order_downfile(YLBOrderDownFileRequest request) {

		JxOrderDownFileRequest jx_request = new JxOrderDownFileRequest();
		CopyUtils.Copy(request, jx_request);

		JxOrderDownFileResponse jx_response = jxbankGateway.order_downfile(jx_request);
		logger.info("调用嘉兴银行对账单下载接口结果为：" + JSON.toJSONString(jx_response));

		YLBOrderDownFileResponse response = new YLBOrderDownFileResponse();
		//CopyUtils.Copy(jx_response, response);
		OrderDownFileInfo downFileInfo = JSON.parseObject(JSON.toJSONString(jx_response), OrderDownFileInfo.class);
		
		if(response.getReturnCode().equals("000000")){
			response.setData(downFileInfo);
		}
		
		response.setReturnCode(jx_response.getRecode());
		response.setReturnMsg(jx_response.getRecode_info());
		return response;
	}

}
