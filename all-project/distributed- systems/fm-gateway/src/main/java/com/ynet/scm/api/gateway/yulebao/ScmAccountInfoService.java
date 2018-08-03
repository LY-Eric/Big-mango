package com.ynet.scm.api.gateway.yulebao;

public interface ScmAccountInfoService {

	/**
	 * 开二类户
	 */
	String openSecondAccount(String jsonString);
	
	/**
	 * 绑定账号设定
	 */
	String accInfoSetPrimAcc(String jsonString);
	
	/**
	 * 保存商户取现信息
	 */
	String saveMerWithdrawInfo(String jsonString);
	
	/**
	 * 查询娱乐宝回调地址url
	 */
	String queryYlbReceiveUrl(String jsonString);
	
	/**
	 * 备注：通过finmallid 和证件号码/营业执照 验证finmallId
	 * @author liaoyy@belink.com
	 * @param accountInfo
	 * @return
	 */
	int checkFinmallIdByIdNo(String accountInfo);
}
