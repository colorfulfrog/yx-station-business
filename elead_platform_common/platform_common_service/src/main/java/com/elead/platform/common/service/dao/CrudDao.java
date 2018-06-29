package com.elead.platform.common.service.dao;

import com.elead.platform.common.entity.BaseObject;
/**
 * dao基类继承BaseMapper
 *
 * @param <T> the type parameter
 * @author wangxz
 */
public interface CrudDao<T extends BaseObject> extends com.baomidou.mybatisplus.mapper.BaseMapper<T> {
    // 这里可以放一些公共的方法
}