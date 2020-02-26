package com.zfz.xiaomi.service;

import com.zfz.xiaomi.dao.GoodsMapper;
import com.zfz.xiaomi.entry.Goods;
import com.zfz.xiaomi.entry.GoodsExample;
import com.zfz.xiaomi.entry.GoodsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsShippingService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private GoodsTypeService goodsTypeService;

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
     * 根据二级类型查询商品数据
     * @param goodsType 一级类型
     * @return 返回所有商品
     */
    public List<Goods> findGoodsWithTopType(GoodsType goodsType){
        //查询一级类型下的所有二级类型
        List<GoodsType> gt = goodsTypeService.findSecondLevel(goodsType);
        //查询所有二级类型下所有商品
        List<Goods> goodsList = new ArrayList<>();
        for (GoodsType goodsType1 : gt){
            List<Goods> goodses = this.findGoodsWithType(goodsType1);
            goodsList.addAll(goodses);
        }
        return goodsList;
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

    /**
     * 根据id查询商品
     * @param id 商品的id
     * @return 查询到的商品
     */
    public Goods findGoodWithId(Integer id){
        return goodsMapper.selectByPrimaryKey(id);
    }
}
