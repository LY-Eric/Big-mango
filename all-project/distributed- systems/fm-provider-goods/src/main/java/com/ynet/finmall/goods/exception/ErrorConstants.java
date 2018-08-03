package com.ynet.finmall.goods.exception;

/**
 * 错误代码常量
 * @author liuxin
 *
 */
public interface ErrorConstants {
	
	/**
	 * 参数不能为空
	 */
	public static final String PARAM_NULL ="000001";
	
	/**
	 * 参数不正确
	 */
	public static final String PARAM_ERROR = "000002";

	/**
	 * 审批流模板ID不能为空
	 */
	public static final String WORKFLOWID_NOT_NULL = "WF0001";
	/**
	 * 需要修改的审批流模板信息不能都为空
	 */
	public static final String ALL_NOT_NULL = "WF0002";
	
	/**
	 * 审核模板步骤未查询到请检查输入参数
	 */
	public static final String WORKFLOWID_IS_NULL = "WF0003";
	
	/**
	 * 审批流模板步骤查询为空，请联系管理员查询审批流模板步骤表
	 */
	public static final String WORKFLOWIDID_IS_NULL = "WF0004";
	
	/**
	 * 步骤信息不正确，请检查审批步骤模板和审批步骤记录信息
	 */
	public static final String STEP_CODE_INFO_ERROR = "WF0005";
	
	/**
	 * 审批流程已经结束，无法插入下一步
	 */
	public static final String WORKFLOWEND_ERROR = "WF0006";
	
	/**
	 * 请检查审批记录存在多条数据
	 */
	public static final String WORKFLOWE_ERROR = "WF0007";
	
	/**
	 * 请输入查询参数
	 */
	public static final String PARAM_IS_NULL = "WF0008";
	
	/**
	 * 审批流模板ID,不能为空
	 */
	public static final String WORKFLOWEID_NOT_NULL = "WF0009";
	
	/**
	 * 父项目ID,不能为空
	 */
	public static final String PARENT_PROJECT_ID_NOT_NULL = "WF0010";
	
	/**
	 * 业务ID,不能为空
	 */
	public static final String SERVICE_ID_NOT_NULL = "WF0011";
	
	/**
	 * 业务类型,不能为空
	 */
	public static final String SERVICE_TYPE_NOT_NULL = "WF0012";
	
	/**
	 * 审核记录被驳回时，驳回步骤不能为空
	 */
	public static final String ROLLBACK_STEP_CODE_NOT_NULL = "WF0013";
	
	/**
	 * 有审核结果时候，审核人ID不能为空
	 */
	public static final String ADMIN_ID_NOT_NULL = "WF0014";
	
	/**
	 * 有审核结果时候，审核方不能为空
	 */
	public static final String AUDITOR_NOT_NULL = "WF0015";
	
	/**
	 * 有审核结果时候，审核渠道编号不能为空
	 */
	public static final String CHANNEL_NO_NOT_NULL = "WF0016";
	
	/**
	 * 审批记录已经存在，请输入审批结果
	 */
	public static final String CHECKRESULT_NOT_NULL = "WF0017";
	
	/**
	 * 审批流名称不能为空
	 */
	public static final String WF_ID_NOT_NULL = "WF0018";
	
	/**
	 * 审批流名称已经存在请更换审批流名称
	 */
	public static final String WF_NAME_NOT_DOUBLE = "WF0019";
	
	/**
	 * 审批流可以驳回时，驳回步骤不能为空
	 */
	public static final String ROLLBACKSTEPCODE_NOT_NULL = "WF0020";
	
}
