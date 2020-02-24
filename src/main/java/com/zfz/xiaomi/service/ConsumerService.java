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

    public boolean findConsumerWithUsernameAndPassword(Consumer consumer ){
        ConsumerExample ce = new ConsumerExample();
        ce.createCriteria().andUsernameEqualTo(consumer.getUsername()).andPasswordEqualTo(consumer.getPassword());
        List<Consumer> consumerList = consumerMapper.selectByExample(ce);

        return consumerList != null && consumerList.size() == 1;
    }
}
