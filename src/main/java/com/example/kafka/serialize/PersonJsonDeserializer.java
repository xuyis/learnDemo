package com.example.kafka.serialize;

import com.alibaba.fastjson.JSON;
import com.example.entity.Person;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

/**
 * @Author: xuyisheng
 * @Description
 * @Date: 2020/3/5 9:35
 * @Param
 * @return
 **/
public class PersonJsonDeserializer implements Deserializer<Person>
{
    @Override
    public void configure(Map<String, ?> configs, boolean isKey)
    {

    }

    @Override
    public Person deserialize(String topic, byte[] data)
    {
        return JSON.parseObject(data, Person.class);
    }

    @Override
    public void close()
    {

    }
}
