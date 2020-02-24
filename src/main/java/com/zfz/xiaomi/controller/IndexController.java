package com.zfz.xiaomi.controller;

import com.zfz.xiaomi.entry.Goods;
import com.zfz.xiaomi.entry.GoodsType;
import com.zfz.xiaomi.service.GoodsShippingService;
import com.zfz.xiaomi.service.GoodsTypeService;
import com.zfz.xiaomi.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 首页处理相关结构接口
 */

@Controller
public class IndexController {

    @Autowired
    private GoodsTypeService goodsTypeService;
    @Autowired
    private GoodsShippingService goodsShippingService;

    @GetMapping("/initIndex")
    @ResponseBody
    public ResponseMessage initIndex(){
        //查询一级商品类型
        List<GoodsType> topLevel = goodsTypeService.findTopLevel();
        Map<Integer,List<Goods>> goodsMap = new HashMap<>();
        //遍历查询每个一级类型下的二级类型，按照二级类型 ：商品类型
        for(GoodsType goodsType : topLevel){
           // System.out.println(goodsType);
            //查询一级类型下的所有二级类型
            List<GoodsType> secondLevel = goodsTypeService.findSecondLevel(goodsType);
            //查询每个二级商品类型下的商品
            for(GoodsType secondGoodsType : secondLevel){
                List<Goods> goodsList = goodsShippingService.findGoodsWithType(secondGoodsType);

                //存储在map中
                goodsMap.put(secondGoodsType.getId(), goodsList);
            }
        }

        //返回首页需要的数据
        return ResponseMessage.success().addObject("goodsTypeList",topLevel).addObject("goodsMap",goodsMap);
    }
}
