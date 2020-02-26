package com.zfz.xiaomi.controller;

import com.zfz.xiaomi.entry.Consumer;
import com.zfz.xiaomi.entry.Goods;
import com.zfz.xiaomi.entry.GoodsCart;
import com.zfz.xiaomi.service.GoodsShippingService;
import com.zfz.xiaomi.service.ShopCartService;
import com.zfz.xiaomi.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/shopcart")
public class ShopCartController {

    @Autowired
    private ShopCartService shopCartService;
    @Autowired
    private GoodsShippingService goodsShippingService;


    /**
     * 商品加入购物车
      * @param goodsId 商品id
     * @param session session中携带consumer信息
     * @return 成功或失败
     */
    @GetMapping("/add/{goodsId}")
    @ResponseBody
    public ResponseMessage addGoodsToCart(@PathVariable Integer goodsId, HttpSession session){
        //获取当前用户
        Consumer consumer = (Consumer) session.getAttribute("loginConsumer");
        if (consumer == null)
            return ResponseMessage.error();

        //加入商品到购物车
        Goods goods = goodsShippingService.findGoodWithId(goodsId);
        shopCartService.addGoodsToShopCart(consumer,goods);
        return ResponseMessage.success();
    }

    /**
     * 从购物车中删除指定商品
     * @param goodsId 商品id
     * @param session session中携带consumer信息
     * @return 成功或失败
     */
    @GetMapping("/remove/{goodsId}")
    public ResponseMessage removeGoodsToCart(@PathVariable Integer goodsId, HttpSession session){
        //获取当前用户
        Consumer consumer = (Consumer) session.getAttribute("loginConsumer");
        if (consumer == null)
            return ResponseMessage.error();
        Goods goods = goodsShippingService.findGoodWithId(goodsId);
        shopCartService.removeGoodsFromShopCart(consumer,goods);
        return ResponseMessage.success();

    }
    @GetMapping("/chk")
    public ResponseMessage findAllWithConsumer(HttpSession session){
        //获取当前用户
        Consumer consumer = (Consumer) session.getAttribute("loginConsumer");
        if (consumer == null)
            return ResponseMessage.error();
        List<GoodsCart> cartList = shopCartService.findAllGoodsCartWithConsumer(consumer);
        return ResponseMessage.success().addObject("cartList",cartList);
    }
}
