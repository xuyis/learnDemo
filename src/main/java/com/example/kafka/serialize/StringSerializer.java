package com.example.kafka.serialize;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * @Author: xuyisheng
 * @Description
 * @Date: 2020/3/5 9:09
 * @Param
 * @return
 **/
public class StringSerializer implements Serializer<String>
{
    private String encoding = "UTF8";

    @Override
    public void configure(Map<String, ?> configs, boolean isKey)
    {
        String propertyName = isKey ? "key.serializer.encoding" : "value.serializer.encoding";
        Object encodingValue = configs.get(propertyName);
        if (encodingValue == null){
            encodingValue = configs.get("serializer.encoding");
        }
        if (encodingValue instanceof String){
            encoding = (String) encodingValue;
        }
    }

    @Override
    public byte[] serialize(String topic, String data)
    {
        try
        {
            if (data == null){
                return null;
            }else {
                return data.getBytes(encoding);
            }
        }catch (UnsupportedEncodingException ex){
            throw new SerializationException("Error when serializing string to byte[] due to unsupported encoding " + encoding);
        }
    }

    @Override
    public void close()
    {
        //nothing to do
    }
}
