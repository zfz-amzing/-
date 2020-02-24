package com.zfz.xiaomi.controller;


import com.zfz.xiaomi.entry.Consumer;
import com.zfz.xiaomi.service.ConsumerService;
import com.zfz.xiaomi.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @PostMapping(value = "/login/auth",produces = {"application/json;charset=UTF-8"})
    @ResponseBody //@responseBody注解的作用是将controller的方法返回的对象通过适当的转换器转换为指定的格式之后，写入到response对象的body区，通常用来返回JSON数据或者是XML数据。
    public ResponseMessage login(@RequestParam String username, @RequestParam String password){
        System.out.println("接收到请求：/consumer/login/auth");
        System.out.println("账号："+username+"密码："+password);
        Consumer consumer = new Consumer(username,password);
        boolean result = consumerService.findConsumerWithUsernameAndPassword(consumer);
        System.out.println("登录结果: "+ result);
        return result ? ResponseMessage.success() : ResponseMessage.error();
    }
}
