package com.zfz.xiaomi.controller;

import com.zfz.xiaomi.entry.Goods;
import com.zfz.xiaomi.entry.GoodsType;
import com.zfz.xiaomi.service.GoodsShippingService;
import com.zfz.xiaomi.service.GoodsTypeService;
import com.zfz.xiaomi.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/u")
public class UtilsController {

    @Autowired
    private GoodsShippingService goodsShippingService;

    @Autowired
    private GoodsTypeService goodsTypeService;

    @GetMapping("/search/{name}")
    @ResponseBody
    private ResponseMessage searchGoodsWithName(@PathVariable String name){
        List<Goods> goodsList = goodsShippingService.searchGoodsWithName(name);
        return goodsList.size() > 0 ? ResponseMessage.success().addObject("goodsList", goodsList)
                                    : ResponseMessage.error();
    }

    /**
     * 根据类型查看商品
     * @param level level 类型级别 1一级类型 2 二级类型
     * @param goodTypeId 类型编号
     * @return 返回响应数据
     */
    @GetMapping("search/{level}/{goodTypeId}")
    @ResponseBody
    public ResponseMessage searchGoodsWithType(@PathVariable String level, @PathVariable String goodTypeId){

        GoodsType goodsType = goodsTypeService.findById(Integer.parseInt(goodTypeId));
        List<Goods> goodsList = null;

        if ("1".equals(level)){
            goodsList = goodsShippingService.findGoodsWithTopType(goodsType);
        } else if ("2".equals(level)){
            goodsList = goodsShippingService.findGoodsWithType(goodsType);
        }
        return goodsList != null && goodsList.size() > 0
                ? ResponseMessage.success().addObject("goodsList", goodsList)
                : ResponseMessage.error();
    }
}
