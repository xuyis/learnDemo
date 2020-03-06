package com.example.annotation;

import com.alibaba.fastjson.JSON;
import com.example.entity.Parameter;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xuyisheng
 * @Description 登录注解实现类
 * @Date: 2020/3/5 16:08
 * @Param
 * @return
 **/
@Aspect
@Component
public class LoaginAnnoImpl
{
    @Pointcut("@annotation(com.example.annotation.LoginAnno)")
    private void cut(){

    }

    @Before("cut()")
    public void before(JoinPoint joinPoint){
        MethodSignature sign = (MethodSignature)joinPoint.getSignature();
        Method method = sign.getMethod();
        LoginAnno loginAnno = method.getAnnotation(LoginAnno.class);
        System.out.println("value: " + loginAnno.value());
        // 获取参数
        String[] parameterNames = sign.getParameterNames();
        for (String parameter:parameterNames){
            System.out.println("parameter" + parameter);
        }
        // 构造参数组集合
        List<Object> argList = new ArrayList<>();
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            // request/response无法使用toJSON
            if (arg instanceof HttpServletRequest) {
                argList.add("request");
            } else if (arg instanceof HttpServletResponse) {
                argList.add("response");
            } else {
                argList.add(JSON.toJSON(arg));
            }
        }
        System.out.println("argList:" + JSON.toJSON(argList));
        // 构造参数及参数值列表
        List<Parameter> parameters = new ArrayList<>();
        for (int i = 0; i <parameterNames.length; i++){
            parameters.add(new Parameter(parameterNames[i],args[i]));
        }
        System.out.println("parameters:" + JSON.toJSON(parameters));
        System.out.println("自定义注解生效了");
    }
}
