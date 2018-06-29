package com.elead.platform.common.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author wangxz
 * @class_name GenericeClassUtils
 * @description 获取类class定义
 * @date 2017/8/31
 */
public class GenericeClassUtils {
    @SuppressWarnings("rawtypes")
    public static Class getSuperClassGenricType(Class clazz, int index) {

        Type genType = clazz.getGenericSuperclass();
        if (!(genType instanceof ParameterizedType)) {
            return null;
        }

        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        if (index >= params.length || index < 0) {
            return null;
        }

        if (!(params[index] instanceof Class)) {
            return null;
        }
        return (Class) params[index];
    }
}
