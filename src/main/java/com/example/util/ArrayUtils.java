package com.example.util;

/**
 * @Author: xuyisheng
 * @Description
 * @Date: 2020/3/5 16:36
 * @Param
 * @return
 **/
public class ArrayUtils
{
    public static boolean isEmpty(Object[] array){
        if (array == null || array.length ==0){
            return false;
        }
        return true;
    }
}
