package com.zfz.xiaomi.controller;

import com.zfz.xiaomi.entry.Goods;
import com.zfz.xiaomi.service.GoodsShippingService;
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

    @GetMapping("/search/{name}")
    @ResponseBody
    private ResponseMessage searchGoodsWithName(@PathVariable String name){
        List<Goods> goodsList = goodsShippingService.searchGoodsWithName(name);
        return goodsList.size() > 0 ? ResponseMessage.success().addObject("goodsList", goodsList)
                                    : ResponseMessage.error();
    }
}
