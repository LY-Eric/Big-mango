package com.ynet.scm.api.gateway.yulebao;


/**
 * 贷款发放、贷款归还、文档上传等接口
 * @author xuhui
 *
 */
public interface ScmLoanAndUploadService {
	/**
	 * 文档上传插入操作
	 * @param map
	 */
	void  scmFileUploadSave(String json);
	
	/**
	 * 贷款发放
	 */
	void  scmLoanGrant(String json);
	
	/**
	 * 贷款发放异步通知
	 */
	void  scmLoanGrantNotice(String json);
	
	/**
	 * 根据贷款编号查询回掉地址
	 * 
	 */
	String queryReceiveUrl(String applyId);
	
	/**
	 * 贷款归还
	 */
	void scmLoanReturn(String json);
	
	/**
	 * 查询贷款归还异步通知回调地址url
	 */
	String queryRepayCallbackUrl(String proId, String batchSerialNo); 
}
