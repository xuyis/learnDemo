package com.example.annotation;

import java.lang.annotation.*;

/**
 * @Author: xuyisheng
 * @Description  自定义登录注解
 * @Date: 2020/3/5 16:07
 * @Param
 * @return
 **/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LoginAnno
{
    String value() default "";
}
