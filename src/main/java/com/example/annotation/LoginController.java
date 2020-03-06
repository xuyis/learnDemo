package com.example.annotation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xuyisheng
 * @Description
 * @Date: 2020/3/5 16:10
 * @Param
 * @return
 **/
@RestController
public class LoginController
{
    @RequestMapping("/login")
    @LoginAnno(value = "tt")
    public String login(@RequestParam String userName){
        return "welcome " + userName;
    }
}
