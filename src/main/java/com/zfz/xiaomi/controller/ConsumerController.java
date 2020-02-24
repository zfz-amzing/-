package com.zfz.xiaomi.controller;


import com.zfz.xiaomi.entry.Consumer;
import com.zfz.xiaomi.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @PostMapping("/login/auth")
    public String login(@RequestParam String username,@RequestParam String password){
        System.out.println("接收到请求：/consumer/login/auth");
        System.out.println("账号："+username+"密码："+password);
        Consumer consumer = new Consumer(username,password);
        boolean result = consumerService.findConsumerWithUsernameAndPassword(consumer);
        System.out.println("登录结果: "+ result);
        return result ? "success" : "error";
    }
}
