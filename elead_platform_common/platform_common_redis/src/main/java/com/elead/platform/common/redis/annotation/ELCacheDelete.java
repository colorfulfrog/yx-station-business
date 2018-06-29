package com.elead.platform.common.redis.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by wangxz on 2017/9/6.
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RUNTIME)
public @interface ELCacheDelete {
}
