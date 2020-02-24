package com.zfz.xiaomi.service;

import com.zfz.xiaomi.dao.GoodsTypeMapper;
import com.zfz.xiaomi.entry.GoodsType;
import com.zfz.xiaomi.entry.GoodsTypeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用于加载首页数据
 */
@Service
public class GoodsTypeService {

    @Autowired
    private GoodsTypeMapper goodsTypeMapper;
    /**
     * 查询一级商品类型
     * @return 返回所有的一级商品类型
     */
    public List<GoodsType> findTopLevel(){
        GoodsTypeExample gte = new GoodsTypeExample();
        gte.createCriteria().andPidIsNull();
        return goodsTypeMapper.selectByExample(gte);
    }

    /**
     * 查询二级商品类型
     * @param top 一级商品类型
     * @return 返回对应的二级商品类型
     */
    public List<GoodsType> findSecondLevel(GoodsType top){
        GoodsTypeExample gte = new GoodsTypeExample();
        gte.createCriteria().andPidEqualTo(top.getId());
        return goodsTypeMapper.selectByExample(gte);
    }
}
