package com.example.redis;

import com.alibaba.fastjson.JSON;
import com.example.entity.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

/**
 * @Author: xuyisheng
 * @Description
 * @Date: 2020/3/5 15:56
 * @Param
 * @return
 **/
@RestController
public class RedisDemo
{
    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @RequestMapping("/redis")
    public String sendRedis(){
        Jedis jedis = new Jedis(host,port);
        Person person = new Person(1,"zhangsan",18);
        jedis.set("json:info:person", JSON.toJSONString(person));
        System.out.println("jedis:"+ jedis.get("json:info:person"));
        return "SUCCESS";
    }
}
