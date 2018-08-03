package com.ynet.scm.api.gateway.yulebao;

/**
 * @Description 供应链项目提供的贷款申请和盖章相关接口
 * @Author 刘俊重
 * @Date 2018/1/5
 */
public interface ScmApplyAndContractService {
	/**
	 * @Description 保存贷款申请信息
	 * @Author 刘俊重
	 * @Date 2018/1/5
	 */
	String saveApplyYlb(String json);

	/**
	 * @Description 更新贷款申请信息（回调时调用）
	 * @Author 刘俊重
	 * @Date 2018/1/7
	 */
	String updateApplyYlb(String json);

	/**
	 * @Description 合同盖章
	 * @Author 刘俊重
	 * @Date 2018/1/5
	 */
	String contractSignYlb(String json);

	/**
	 * @Description 合同存证
	 * @Author 刘俊重
	 * @Date 2018/1/5
	 */
	String contractVoucherYlb(String json);

	/**
	 * @Description 查询回调地址
	 * @Author 刘俊重
	 * @Date 2018/1/11
	 */
	String getCallBackUrl(String json);
	
	/**
	 * 备注：通过finmallid 和 贷款申请id验证finmallid 的正确性
	 * 
	 * @author liaoyy@belink.com
	 * @param finmallId
	 * @param applyId
	 * @return
	 */
	int checkFinmallId(String loanInfo);
	
}
