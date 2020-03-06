package com.example.kafka.serialize;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * @Author: xuyisheng
 * @Description
 * @Date: 2020/3/5 9:15
 * @Param
 * @return
 **/
public class StringDeserializer implements Deserializer<String>
{
    private String encoding = "UTF8";
    @Override
    public void configure(Map<String, ?> configs, boolean isKey)
    {
        String propertyName = isKey ? "key.deserializer.encoding" : "value.deserializer.encoding";
        Object encodingValue = configs.get(propertyName);
        if (encodingValue == null){
            encodingValue = configs.get("deserializer.encoding");
        }
        if (encodingValue instanceof String){
            encoding = (String) encodingValue;
        }
    }

    @Override
    public String deserialize(String topic, byte[] data)
    {
        try
        {
            if (data == null){
                return null;
            }
            else{
                return new String(data, encoding);
            }
        }catch (UnsupportedEncodingException ex){
            throw new SerializationException("Error when deserializing byte[] to string due to unsupported encoding " + encoding);
        }
    }

    @Override
    public void close()
    {
        //nothing to do
    }
}
