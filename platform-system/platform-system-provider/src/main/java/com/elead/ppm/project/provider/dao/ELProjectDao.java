package com.elead.ppm.project.provider.dao;

import org.apache.ibatis.annotations.Mapper;
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

}