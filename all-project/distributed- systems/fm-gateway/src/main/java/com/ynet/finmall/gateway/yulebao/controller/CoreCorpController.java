package com.ynet.finmall.gateway.yulebao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.ynet.finmall.gateway.yulebao.response.YLBCreateCoreResponse;
import com.ynet.finmall.gateway.yulebao.service.YlbCoreCorpService;

/**
 * 备注：核心企业相关
 * @author liaoyy@belink.com
 */
@RestController
public class CoreCorpController {
	@Autowired
	private YlbCoreCorpService ylbCoreCorpService;

	/**
	 * 备注：核心企业入驻
	 * 
	 * @author liaoyy@belink.com
	 * @param coreCorpInfo
	 * @return
	 * @throws Exception
	 */
	@PostMapping(name="调用娱乐宝贷核心企业入驻接口",value="/api/ylb/corecorpinfo/createCore.do")
	public YLBCreateCoreResponse createCore(@RequestBody JSONObject jsonObject) {
		return ylbCoreCorpService.gSave(jsonObject.toJSONString());
	}

}
