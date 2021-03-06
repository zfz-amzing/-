package com.zfz.xiaomi.service;

import com.zfz.xiaomi.dao.ConsumerMapper;
import com.zfz.xiaomi.entry.Consumer;
import com.zfz.xiaomi.entry.ConsumerExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumerService {

    @Autowired
    private ConsumerMapper consumerMapper;

    public Consumer findConsumerWithUsernameAndPassword(Consumer consumer ){
        ConsumerExample ce = new ConsumerExample();
        ce.createCriteria().andUsernameEqualTo(consumer.getUsername()).andPasswordEqualTo(consumer.getPassword());
        List<Consumer> consumerList = consumerMapper.selectByExample(ce);

        return consumerList != null && consumerList.size() == 1 ? consumerList.get(0) : null;
    }
    public String register(Consumer consumer){
        //验证用户名是否存在
        ConsumerExample ce = new ConsumerExample();
        ce.createCriteria().andUsernameEqualTo(consumer.getUsername());
        System.out.println(consumer+"add to database");
        List<Consumer> consumerList = consumerMapper.selectByExample(ce);
        if(consumerList.size() > 0){
            return "注册失败，用户名已存在";
        }
        consumerMapper.insertSelective(consumer);
        return "注册成功";
    }
}
