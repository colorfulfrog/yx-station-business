package com.elead.platform.common.constants;


/**
 * Domain常量类
 * @author lisk
 *
 */
public class DomainConstants {
	/**
	 * 删除标记（0：正常；1：删除；2：审核；）
	 */
	public static final String DEL_FLAG_NORMAL = "0";
	public static final String DEL_FLAG_DELETE = "1";
	public static final String DEL_FLAG_AUDIT = "2";

	/**
	 * 激活状态，1：激活，0：失效
	 */
	public static final String ACTIVE_VALID = "1";
	public static final String ACTIVE_INVALID = "0";

	/**
	 * 是否默认
	 */
	public static final String DATA_DEFAULT_YES = "1";
	public static final String DATA_DEFAULT_NO = "0";

	/**
	 * 树结构根节点 parentId默认值
	 */
	public static final String TREE_PARENT_ID_DEFAULT = "-1";

	/**
	 * 树结构递归深度
	 */
	public static final int TREE_DEEP_LEVEL = 20;

	/**
	 * consumer端的数据节点名称
	 */
	public static final String JSONRESULT_RES_DATA = "data";
	public static final String JSONRESULT_RES_CHECKLIST = "checks";
	public static final String JSONRESULT_RES_LABELS = "labels";
	public static final String JSONRESULT_RES_TASKS = "tasks";
	public static final String JSONRESULT_RES_USERS = "users";
	public static final String JSONRESULT_RES_ORG = "org";
	public static final String JSONRESULT_RES_PROJECT = "project";
	//附件集合
	public static final String JSONRESULT_RES_ATTR="attachs";

	/**
	 * 通用查询关联查询字段名称
	 */
	public static final String QUERY_EXT_MEMBER_ID = "ELMember";
	public static final String QUERY_EXT_CHECKLIST_ID = "ELCheckList";
	public static final String QUERY_EXT_LABEL_ID = "ELLink";

	// 数据范围（1：所有数据；2：所在公司及以下数据；3：所在公司数据；4：所在部门及以下数据；5：所在部门数据；8：仅本人数据；9：按明细设置）
	public static final String DATA_SCOPE_ALL = "1";
	public static final String DATA_SCOPE_COMPANY_AND_CHILD = "2";
	public static final String DATA_SCOPE_COMPANY = "3";
	public static final String DATA_SCOPE_OFFICE_AND_CHILD = "4";
	public static final String DATA_SCOPE_OFFICE = "5";
	public static final String DATA_SCOPE_SELF = "8";
	public static final String DATA_SCOPE_CUSTOM = "9";

	//状态流成员处理流程的标识
	/**
	 * 初始化
	 */
	public static final String MEMBER_ACTIVE_INIT = "0";
	/**
	 * 待处理
	 */
	public static final String MEMBER_ACTIVE_PENDING = "1";
	/**
	 * 已处理
	 */
	public static final String MEMBER_ACTIVE_PROCESSED = "2";


	//业务对象关联类型（需求、任务、问题、风险）
	/**
	 * 类型：ELRequirement
	 */
	public static final String BUSINESS_LINK_ELREQUIREMENT = "ELRequirement";
	/**
	 * 类型：ELTask
	 */
	public static final String BUSINESS_LINK_ELTASK = "ELTask";
	/**
	 * 类型：ELIssue
	 */
	public static final String BUSINESS_LINK_ELISSUE = "ELIssue";
	/**
	 * 类型：ELRisk
	 */
	public static final String BUSINESS_LINK_ELRISK = "ELRisk";
	
	public static final String BUSINESS_LINK_ELPROJECT = "ELProject";
	
	public static final String BUSINESS_LINK_ELFolder = "ELFolder";
	
	public static final String BUSINESS_LINK_ELDocument = "ELDocument";
	
	/**
	 * 项目群 类型：ELProgram
	 */
	public static final String BUSINESS_LINK_ELProgram = "ELProgram";
	
	/**
	 * 项目组合类型:ELPortfolio
	 */
	public static final String BUSINESS_LINK_ELPortfolio = "ELPortfolio";
	
	/**
	 * 战略：ELStrategy
	 */
	public static final String BUSINESS_LINK_ELStrategy = "ELStrategy";

	/**
	 * 指标：ELIndicatorElementDef
	 */
	public static final String BUSINESS_LINK_ELIndicatorElementDef = "ELIndicatorElementDef";
	
	/**
	 * 收藏
	 */
	public static final String SYS_FAVORITES_COLLECTION = "1";
	/**
	 * 关注
	 */
	public static final String SYS_FAVORITES_CARE = "2";
	/**
	 * 打开
	 */
	public static final String SYS_FAVORITES_OPEN = "3";


}
