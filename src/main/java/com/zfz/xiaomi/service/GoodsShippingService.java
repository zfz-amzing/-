package com.zfz.xiaomi.service;

import com.zfz.xiaomi.dao.GoodsMapper;
import com.zfz.xiaomi.entry.Goods;
import com.zfz.xiaomi.entry.GoodsExample;
import com.zfz.xiaomi.entry.GoodsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsShippingService {

    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * 根据商品类型查询商品
     * @param goodsType 商品类型
     * @return 属于指定商品类型的所有商品
     */
    public List<Goods> findGoodsWithType(GoodsType goodsType){
        GoodsExample ge = new GoodsExample();
        ge.createCriteria().andGoodsTypeIdEqualTo(goodsType.getId());
        return goodsMapper.selectByExample(ge);
    }

    /**
     * 根据名称模糊搜索商品数据
     * @param name 商品名称
     * @return 返回符合条件的商品
     */
    public List<Goods> searchGoodsWithName(String name ){
        GoodsExample ge = new GoodsExample();
        ge.createCriteria().andNameLike("%" + name + "%");
        return goodsMapper.selectByExample(ge);
    }
}
