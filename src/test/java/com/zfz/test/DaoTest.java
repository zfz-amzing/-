package com.zfz.test;

import com.zfz.xiaomi.dao.ConsumerMapper;
import com.zfz.xiaomi.entry.Consumer;
import com.zfz.xiaomi.entry.ConsumerExample;
import com.zfz.xiaomi.entry.Goods;
import com.zfz.xiaomi.service.GoodsShippingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class DaoTest {
    @Autowired
    private ConsumerMapper consumerMapper;

    @Autowired
    private GoodsShippingService goodsShippingService;

    @Test
    public void testConsumerInsert(){
        Consumer consumer = new Consumer("zfz","123");
        //讲consumer添加到数据库 insertSelective在只有部分属性有值时使用
        consumerMapper.insertSelective(consumer);
        System.out.println("insertSelective执行完成");
    }
    @Test
    public void testConsumerById(){
        Consumer consumer = consumerMapper.selectByPrimaryKey(1);
        System.out.println(consumer);
    }
    @Test
    public void  testConsumerSelectExample(){
        ConsumerExample ce = new ConsumerExample();
        ce.createCriteria().andUsernameEqualTo("zfz")
                .andPasswordEqualTo("123");

        List<Consumer> consumers = consumerMapper.selectByExample(ce);
        for (Consumer consumer : consumers){
            System.out.println(consumer);
        }
    }

    @Test
    public void testSearchGoods(){
        List<Goods> goodsList = goodsShippingService.searchGoodsWithName("小米");
        goodsList.forEach(goods -> System.out.println(goods));
    }
}
