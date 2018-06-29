package com.elead.platform.common.redis.Interceptor;

import org.springframework.cache.annotation.CacheAnnotationParser;
import org.springframework.cache.interceptor.CacheOperation;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Collection;

/**
 * @author wangxz
 * @class_name ELCacheAnnotationParser
 * @description 解析自定义注解
 * @date 2017/9/6
 */
public class ELCacheAnnotationParser implements CacheAnnotationParser,Serializable {

    @Override
    public Collection<CacheOperation> parseCacheAnnotations(Method method) {
        return null;
    }

    @Override
    public Collection<CacheOperation> parseCacheAnnotations(Class<?> type) {
        return null;
    }
}
