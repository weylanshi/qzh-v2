package com.huidong.qzh.util.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author weylan
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface LoginRequired {

    /**
     * 是否需要登录，缺省为需要
     * @return
     */
    boolean loginRequired() default true;
}
