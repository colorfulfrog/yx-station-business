package com.elead.ppm.project.provider.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.elead.platform.common.service.dao.CrudDao;
import com.elead.ppm.project.domain.entity.ELProject;

/**
 * 项目表DAO接口
 * @author wangxz
 */

@Mapper
@Repository
public interface ELProjectDao extends CrudDao<ELProject> {
	/**
	 * 通过项目id关闭项目
	 * @author 蒙茂良
	 * 创建时间：2017年5月17日  下午4:41:09
	 * version 1.0
	 * @param projectId
	 * @return
	 */
	//int updateProjectState(String projectId);
	
	/**
	 * 通过项目id归档项目
	 * @author 蒙茂良
	 * 创建时间：2017年5月17日  下午4:41:19
	 * version 1.0
	 * @param projectId
	 * @return
	 */
	//int updateProjectFile(String projectId);
	
	/**
	 * 根据项目id查找项目名字
	 * @author 蒙茂良
	 * 创建时间：2017年5月25日  下午2:12:43
	 * version 1.0
	 * @param projectId
	 * @return
	 */
	//String getNameByProjectId(String projectId);
	
	
	//List<ProjectDto> getProjectListByName(@Param("projectDto")ProjectDto projectDto,@Param("pageIndex")int pageIndex,@Param("pageSize")int pageSize);
	
	/**
	 * 根据项目成员ID查询项目列表
	 * @param projectDto {name项目名称, userId项目成员ID}
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	List<ELProject> getProjectList(Map<String, Object> params);
	
	/**
	 * @描述（导航栏查看项目）
	 * @author yanghuayong
	 * @version 1.0
	 * @date 2017年5月11日 下午12:19:00
	 * @parameter （参数及其意义）
	 * @throws 异常类及抛出条件
	 * @return 返回值
	 */
	List<Map<String, String>> getMyAdministrationProject(Map<String, Object> parameter);
	
	/**
	 * @描述（导航栏查看项目-收藏项目）
	 * @author yanghuayong
	 * @version 1.0
	 * @date 2017年5月11日 下午12:19:00
	 * @parameter （参数及其意义）
	 * @throws 异常类及抛出条件
	 * @return 返回值
	 */
     //List<Map<String, String>> getMyCareProject(Map<String, Object> parameter);
     
 	/**
 	 * @描述（导航栏查看项目-收藏项目）
 	 * @author yanghuayong
 	 * @version 1.0
 	 * @date 2017年5月11日 下午12:19:00
 	 * @parameter （参数及其意义）
 	 * @throws 异常类及抛出条件
 	 * @return 返回值
 	 */
 	List<Map<String, String>> getArchivedProject(Map<String, Object> parameter);
 	
	/**
	 * @描述（添加最近打开的项目数据）
	 * @author yanghuayong
	 * @version 1.0
	 * @date 2017年5月16日 下午12:19:00
	 * @parameter （参数及其意义）
	 * @throws 异常类及抛出条件
	 * @return 返回值
	 */
	//void addProjectMyOpen(Map<String, Object> parameter);
	
	
	//int getProjectMyOpenCount(Map<String, Object> parameter);
	
	//void updateProjectMyOpen(Map<String, Object> parameter);
	
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
	//List<ELProject> getProjectByNameOrCode(@Param("keyword")String keyword,@Param("hasParent")int hasParent);
	
	/**
	 * 根据子项目id删除/解除父子项目关联
	 * @param childId	子项目id
	 * @return
	 */
	//int deleteParentChildLinkByChildId(@Param("childId")String childId);
	
	/**
	 * 根据项目id获取第一层子项目的个数
	 * @param projectId	项目id
	 * @return
	 */
	//int getFirstLevelChildrenProjectsCount(@Param("projectId")String projectId);
	
	
	/**
	 * 根据项目id获取第一层子项目列表
	 * @param projectId	项目id
	 * @return
	 */
	List<ELProject> getChildrenById(@Param("projectId")String projectId);
	
/*	*//**
	 * 获取所有项目列表
	 * @return
	 *//*
	List<ELProject> getAllProjectList();
	*/
	
	/**
	 * 根据项目id获取项目详细信息
	 * @param projectId	项目id
	 * @return	项目详细信息（包含父项目id/parent_id字段信息）
	 */
	ELProject getProjectInfoByProjectId(@Param("projectId")String projectId);
	
	
	/**
	 * 根据项目id和子项目id列表，批量添加父子项目关联
	 * @param projectId	项目id
	 * @param childrenProjectIds	子项目id列表
	 * @return	已添加父子项目关联的个数
	 */
	//int addChildrenProjectsByProjectIdAndChildrenProjectIds(@Param("projectId")String projectId,@Param("childrenProjectIds")List<String> childrenProjectIds);
	
	/**
	 * 根据项目id列表，批量置空父子项目关联
	 * @param projectIds	项目id列表
	 * @return	已置空父子项目关联的个数
	 */
	int batchToNullParentIdByProjectIds(@Param("projectIds")List<String> projectIds);
	
	/**
	 * 根据项目id列表批量查询项目
	 * @param projectIds 项目id列表
	 * @return
	 */
	List<ELProject> getProjectListByIds(@Param("projectIds")List<String> projectIds);
	
	/**
	 * 根据项目id查询该项目所在的项目树的根项目信息
	 * @param projectId
	 * @return
	 */
	ELProject getProjectTreeRoot(@Param("projectId")String projectId);
	
	/**
	 * 根据项目id列查询项目树（以当前项目节点为树根节点）中的项目列表
	 * @param projectId 项目id
	 * @return
	 */
	List<ELProject> getProjectTreeListById(@Param("projectId")String projectId);
	
	/**
	 * 根据项目id获取第一层子项目id列表
	 * @param projectId	项目id
	 * @return
	 */
	List<String> getFirstLevelChildrenProjectIdsByProjectId(@Param("projectId")String projectId);
	
	/**
	 * 查询用户有权限的一级项目列表
	 * </p>权限：用户创建的、用户是项目经理、用户是项目成员
	 * @param userId 用户ID
	 * @param code 项目编码
     * @param name 项目名称
	 * @return List<ELProject>
	 */
	List<ELProject> getPermissionProjectsByUserId(@Param("userId")String userId,@Param("code")String code,@Param("name")String name);
	/**
	 * 获取项目模板列表
	 * @param projectDto {name项目名称, userId项目成员ID}
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	List<ELProject> getProjectTemplateList(Map<String, Object> params);

}