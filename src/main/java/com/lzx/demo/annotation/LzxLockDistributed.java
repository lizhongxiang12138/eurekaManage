package com.lzx.demo.annotation;

import java.lang.annotation.*;

/**
 * 描述: 分布式锁注解
 *
 * @Auther: lzx
 * @Date: 2019/6/17 16:24
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LzxLockDistributed {

    String value() default "";

    int time() default 30;
}
