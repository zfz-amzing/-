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
}
