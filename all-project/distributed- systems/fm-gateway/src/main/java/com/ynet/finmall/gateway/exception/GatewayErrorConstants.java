package com.ynet.finmall.gateway.exception;

/**
 * 错误代码常量
 * @author liuxin
 *
 */
public interface GatewayErrorConstants {
	
	/**
	 * 系统统一成功代码
	 * {@link ParamConstants} 已存在
	 */
//	public static final String RETURNCODE_SUCCESS = "000000";
//	public static final String RETURNMSG_SUCCESS  = "成功";
	
	/**
	 * 嘉信银行MD5签名验证失败JX0001
	 */
	public static final String JXBANK_CHECK_SIGN ="JX0001";
	/**
	 * 嘉兴银行回调接口MD5签名验证失败 JX0002
	 */
	public static final String JX_CHECK_SIGN ="JX0002";
	/**
	 * 嘉兴银行回调接口请求非法 ！ JX0003
	 */
	public static final String JX_REQ_ERROR = "JX0003";
	
	/**
	 * 嘉兴银行请求回调URL异常
	 */
	public static final String JX_REQ_RECEIVE_URL_ERROR = "JX0004";
	
	/**
	 * 嘉兴银行系统异常 JX9998
	 */
	public static final String JXBANK_SYS_ERROR = "JX9998";
	
	/**
	 * 娱乐宝MD5签名验证失败JX0001
	 */
	public static final String YLB_CHECK_SIGN ="YLB0001";

	/**
	 * 娱乐宝请求非法 YLB997
	 */
	public static final String YLB_REQ_ERROR = "YLB9997";
	
	/**
	 * 娱乐宝系统异常 JX9998
	 */
	public static final String YLB_SYS_ERROR = "YLB9998";
	
	/**
	 * 属性复制失败
	 */
	public static final String YLB_FIELD_ERROR = "YLB0002";

	/**
	 * 参数不能为空
	 */
	public static final String PARAM_IS_NULL = "000001";

	/**
	 * 娱乐宝上送渠道号不能为空
	 */
	public static final String YLB_CHANNEL_NO_NULL = "YLB0003";

	/**
	 * 用户中心访问失败
	 */
	public static final String YLB_REQ_USER_ERROR = "YLB0004";
	/**
	 * 用户中心保存失败
	 */
	public static final String YLB_USER_SAVE_ERROR = "YLB0005";
	
	/**
	 * 文件上传失败
	 */
	public static final String YLB_FILE_ERROR = "YLB0006";
	
	/**
	 * 娱乐宝发起商户取现请求出错
	 */
	public static final String YLB_REQ_MER_WITHDRAW_ERROR = "YLB0007";
	
	/**
	 * 娱乐宝回调URL为空
	 */
	public static final String YLB_RECEIVE_URL_NULL = "YLB0008";
	
	/**
	 * 上传文件为空
	 */
	public static final String YLB_FILE_IS_NULL = "YLB0009";
	/**
	 * 娱乐宝上送应用编号不能为空
	 */
	public static final String YLB_APP_NO_NULL = "YLB0010";

	/**
	 * 娱乐宝渠道编号有误请检查
	 */
	public static final String YLB_CHANNEL_NO_ERROR = "YLB0011";
	/**
	 * 娱乐宝应用编号有误请检查
	 */
	public static final String YLB_APP_NO_ERROR = "YLB0012";
	
	/**
	 * 娱乐宝上送finmall_id不能为空
	 */
	public static final String YLB_FINMALLID_NOT_NULL = "YLB0013";
	
	
	/**
	 * 证件号码/营业执照 与finmall_id不匹配
	 */
	public static final String YLB_FINMALLID_NOT_MATCH_ID_NO = "YLB0014";
	
	/**
	 * 贷款申请编号与finmall_id不匹配
	 */
	public static final String YLB_FINMALLID_NOT_MACTCH_APPLY_ID = "YLB0015";
	
	
	/**
	 * 保存商户取现信息错误
	 */
	public static final String FM_SAVE_MER_WITHDRAW_INFO_ERROR = "FM0001";
	
}

