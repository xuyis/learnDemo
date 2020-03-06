package com.example.entity;

/**
 * @Author: xuyisheng
 * @Description 参数实体
 * @Date: 2020/3/5 16:58
 * @Param
 * @return
 **/
public class Parameter
{
    private String key;

    private Object value;

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public Object getValue()
    {
        return value;
    }

    public void setValue(Object value)
    {
        this.value = value;
    }

    public Parameter()
    {
    }

    public Parameter(String key, Object value)
    {
        this.key = key;
        this.value = value;
    }
}
