package com.elead.ppm.project.domain.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;
import com.elead.platform.common.CommonResponse;
import com.elead.platform.common.dto.QueryDto;
import com.elead.platform.common.service.IELItemService;
import com.elead.platform.common.service.IELStateFlowService;
import com.elead.platform.common.type.ELTypeAttrDefinition;
import com.elead.ppm.project.domain.dto.ELProjectDto;
import com.elead.ppm.project.domain.entity.ELProject;
import com.elead.ppm.project.domain.entity.ELProjectStateFlowRecord;

/**
 * @author zhangwei
 * @title: 项目服务接口
 * @date 2017/03/23
 */
public interface ELProjectService extends IELItemService<ELProject>, IELStateFlowService<ELProjectStateFlowRecord>{
	
	/**
	 * 新建项目信息
	 * @param elMemberIds		项目成员ID数组
	 * @param invitedMemberIds	邀请成员ID（多个成员ID用盗号分隔）
	 * @param elProject			项目信息
	 * @return	ELProject
	 */
	ELProject addProject(ELProject elProject, List<ELTypeAttrDefinition> attrDefList);
	
	
	/**
	 * 根据项目ID获取项目信息
	 * @param projectId		项目ID
	 * @return ELProject
	 */
	//ELProject getProjectById(String projectId);
	
	
	/**
	 * 更新项目信息
	 * @param elMemberId		项目成员ID数组
	 * @param invitedMemberIds	邀请成员ID（多个成员ID用盗号分隔）
	 * @param elProject			项目信息
	 */
	void updateProject(ELProject elProject, List<ELTypeAttrDefinition> attrDefList);
	
	/**
	 * 项目归档
	 * @param projectId		项目ID
	 */
	void projectArchived(String projectId);
	
	
	
	
	
	/**
	 * 收藏项目
	 * @param myCare
	 * @return	
	 */
	//CommonResponse careProject(ELProjectMyCare myCare);
	
	
	/**
	 * 邀请成员
	 * @param userId		用户ID
	 * @param elProjectId	项目ID
	 * @return
	 */
	CommonResponse invitedMember(String userId, String elProjectId);
	
	/**
	 * 
	 * @描述（通过项目名称获取所有项目，项目列表）
	 * @author wencz
	 * @version 1.0
	 * @date 2017年5月4日 下午12:19:14
	 * @parameter （参数及其意义）
	 * @throws 异常类及抛出条件
	 * @return 返回值
	 */
	Page<ELProject> getProjectList(QueryDto queryDto);
	
	/**
	 * @描述（项目切换搜索）
	 * @author wencz
	 * @version 1.0
	 * @date 2017年5月4日 下午12:19:00
	 * @parameter （参数及其意义）
	 * @throws 异常类及抛出条件
	 * @return 返回值
	 */
	//JSONArray getProjectListByName(ProjectDto projectDto,int pageIndex,int pageSize);
	
	
	/**
	 * 导航栏查看我打开过的项目
	 * @param parameter	{userId,	可选参数:keywords(模糊匹配)}
	 * @return
	 */
	//List<Map<String, String>> getMyAdministrationProject(Map<String, Object> parameter);
	
	
	/**
	 * 导航栏查看我收藏项目
	 * @param parameter	{userId,	可选参数:keywords(模糊匹配)}
	 * @return
	 */
	//List<Map<String, String>> getMyCareProject(Map<String, Object> parameter);
	
	
	/**
	 * 查询归档的项目
	 * @param parameter
	 * @return	{userId,	可选参数:keywords(模糊匹配)}
	 */
	List<Map<String, String>> getArchivedProject(Map<String, Object> parameter);
	
	
	/**
	 * 记录当前用户打开的项目
	 * @param parameter	{projectId, userId}
	 */
	//void addProjectMyOpen(Map<String, Object> parameter);
	
	
	/**
	 * 查询打开过的项目数据
	 * @param parameter	{projectId, userId}
	 * @return
	 */
	//int getProjectMyOpenCount(Map<String, Object> parameter);
	
	
	/**
	 * 删除最近打开的项目数据，保留时间最近的3个项目
	 * @param userId
	 */
	//void delProjectMyOpen(String userId);
	
	
	/**
	 * 根据条件查询项目详情列表
	 * @param keyword	查询关键字
	 * @param hasParent	有无父项目（0：无父项目，1：有父项目，2：不限，其它：非法）
	 * @return
	 */
	List<ELProject> getProjectsByConditions(Map<String, Object> parmer);
	
	/**
	 * 根据项目名称或编码查询项目详情列表
	 * @param keyword	查询关键字
	 * @param hasParent	有无父项目（0：无父项目，1：有父项目，2：不限，其它：非法）
	 * @return
	 */
	//List<ELProject> getProjectByNameOrCode(String keyword,int hasParent);
	
	
	/**
	 * 根据子项目id删除/解除父子项目关联
	 * @param projectIdList 子项目ID列表
	 * @return
	 */
	int deleteParentLink(List<String> projectIdList);
	
	/**
	 * 根据父项目ID删从说有的子项目关联
	 * @param projectId 子项目ID列表
	 * @return
	 */
	int deleteChindrenLink(String projectId);
	
	/**
	 * 根据项目id获取第一层子项目的个数
	 * @param projectId	项目id
	 * @return
	 */
	//int getFirstLevelChildrenProjectsCount(String projectId);
	
	
	/**
	 * 获取下一层的项目数量
	 * @param projectId	项目id
	 * @return
	 */
	int getChildrenCountById(String projectId);
	
	/**
	 * 获取下一层的项目
	 * @param projectId	项目id
	 * @return
	 */
	List<ELProject> getChildrenById(String projectId);
	
	/**
	 * 获取所有项目列表
	 * @return
	 *//*
	List<ELProject> getAllProjectList();*/
	
	/**
	 * 根据项目id获取项目详细信息
	 * @param projectId	项目id
	 * @return	项目详细信息（包含父项目id/parent_id字段信息）
	 */
	//合并到 getProjectById
	//ELProject getProjectInfoByProjectId(String projectId);
	
	
	/**
	 * 根据项目id和子项目id列表，批量添加父子项目关联
	 * @param projectId	项目id
	 * @param childrenProjectIds	子项目id列表
	 * @return	已添加父子项目关联的个数
	 */
	int addChildren(String projectId,List<String> childrenProjectIds);
	
	
	/**
	 * 根据项目id列表批量查询项目
	 * @param projectIds 项目id列表
	 * @return
	 */
	List<ELProject> getProjectListByIds(List<String> projectIds, List<ELTypeAttrDefinition> attrDefList);
	
	/**
	 * 根据项目id查询该项目所在的项目树的根项目信息
	 * @param projectId
	 * @return
	 */
	ELProject getProjectTreeRoot(String projectId);
	
	/**
	 * 根据项目id列查询项目树（以当前项目节点为树根节点）中的项目列表
	 * @param projectId 项目id
	 * @return
	 */
	List<ELProject> getProjectTreeListById(String projectId);


	/**
	 * 根据模板类型获取模板列表
	 * @param type
	 * @return
	 */
	List<ELProject> getAllProjectTemplateList(String type);

	 /**
	  * 新建项目模板信息
	  * @param elProject      项目信息
	  * @return  ELProject
	  */
	ELProject addProjectTemplate(ELProject elProject);
	
	
	/**
     * 查询用户有权限的一级项目列表
     * </p>权限：用户创建的、用户是项目经理、用户是项目成员
     * @param userId 用户ID
     * @param code 项目编码
     * @param name 项目名称
     * @return List<ELProject>
     */
    List<ELProject> getPermissionProjectsByUserId(String userId,String code,String name);
    
    
    /**
     * 
     * @描述（通过项目名称获取所有项目模板，项目模板列表）
     * @version 1.0
     * @date 2017年10月25日 下午12:11:14
     * @parameter （参数及其意义）
     * @throws 异常类及抛出条件
     * @return 返回值
     */
     Page<ELProject> getProjectTemplateList(QueryDto queryDto);
     /**
	  * 删除项目
	  * @param projectId      项目id
	  * @return 已删除的项目id
	  */
     List<String> deleteProjectById(ELProject elproject);
}
