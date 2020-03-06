package com.example.kafka.serialize;

import com.alibaba.fastjson.JSON;
import com.example.entity.Person;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

/**
 * @Author: xuyisheng
 * @Description
 * @Date: 2020/3/5 9:32
 * @Param
 * @return
 **/
public class PersonJsonSerializer implements Serializer<Person>
{
    @Override
    public void configure(Map<String, ?> configs, boolean isKey)
    {

    }

    @Override
    public byte[] serialize(String topic, Person data)
    {
        return JSON.toJSONBytes(data);
    }

    @Override
    public void close()
    {

    }
}
