package com.yxhl.platform.common.service.datasource;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import java.util.Date;

/**
 * @author wangxz
 * @class_name MyMetaObjectHandler
 * @description 自动填充字段
 * @date 2017/8/4
 */
public class MyMetaObjectHandler extends MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        //新增填充
        // 更多查看源码测试用例
        System.out.println("*************************");
        System.out.println("insert fill");
        System.out.println("*************************");

        //createTime
        if (hasFieldName(metaObject, "createTime")) {
            Object createTime = getFieldValByName("createTime", metaObject);
            System.out.println("createTime=" + createTime);
            if (createTime == null) {
                setFieldValByName("createTime", new Date(), metaObject);
            }
        }

        //updateTime
        if (hasFieldName(metaObject, "updateTime")) {
            Object updateTime = getFieldValByName("updateTime", metaObject);
            System.out.println("updateTime=" + updateTime);
            if (updateTime == null) {
                setFieldValByName("updateTime", new Date(), metaObject);
            }
        }
        //delFlag
        if (hasFieldName(metaObject, "delFlag")) {
            Object delFlag = getFieldValByName("delFlag", metaObject);
            System.out.println("delFlag=" + delFlag);
            if (delFlag == null) {
                setFieldValByName("delFlag", "0", metaObject);
            }
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        //更新填充
        System.out.println("*************************");
        System.out.println("update fill");
        System.out.println("*************************");
        //updateTime
        if (hasFieldName(metaObject, "updateTime")) {
            Object updateTime = getFieldValByName("updateTime", metaObject);
            System.out.println("updateTime=" + updateTime);
            if (updateTime == null) {
                setFieldValByName("updateTime", new Date(), metaObject);
            }
        }
    }

    private boolean hasFieldName(MetaObject metaObject, String fieldName) {
        if (metaObject.hasGetter(fieldName) || metaObject.hasGetter("et." + fieldName)) {
            return true;
        }
        return false;
    }
}
