package com.zfz.xiaomi.service;


import com.zfz.xiaomi.dao.GoodsCartMapper;
import com.zfz.xiaomi.entry.Consumer;
import com.zfz.xiaomi.entry.Goods;
import com.zfz.xiaomi.entry.GoodsCart;
import com.zfz.xiaomi.entry.GoodsCartExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ShopCartService {

    @Autowired
    private GoodsCartMapper goodsCartMapper;

    /**
     * 判断某个商品在购物车中是否存在
     * @param consumer 指定用户
     * @param goods 指定商品
     * @return
     */
    private List<GoodsCart> checkGoods(Consumer consumer, Goods goods){
        //查询指定的商品在当前用户的购物车中是否存在
        GoodsCartExample gce = new GoodsCartExample();
        gce.createCriteria().andConsumerIdEqualTo(consumer.getId()).andGoodsIdEqualTo(goods.getId());
        //查询操作
        List<GoodsCart> cartList = goodsCartMapper.selectByExampleNoImages(gce);
        return  cartList;
    }

    /**
     * 指定商品加入购物车
     * @param goods 要加入购物车的商品
     * @return 返回加入结果
     */
    public boolean addGoodsToShopCart(Consumer consumer,Goods goods){
        List <GoodsCart> cartList = this.checkGoods(consumer, goods);
        if (cartList.size() > 0){
            //更新购买数量
            int count = cartList.get(0).getBuyCount();
            cartList.get(0).setBuyCount(count + 1);
            //更新小计金额
            double totalPrice = cartList.get(0).getSubtotal()/count * cartList.get(0).getBuyCount();
            cartList.get(0).setSubtotal(totalPrice);
        }else {
            //新增商品
            GoodsCart goodsCart = new GoodsCart(goods.getId(),1,new Date(), goods.getPrice(), consumer.getId());
            goodsCartMapper.insertSelective(goodsCart);
        }
        return true;
    }

    /**
     * 从购物车中删除商品
     * @param goods 要删除的商品
     * @return 返回删除结果
     */
    public boolean removeGoodsFromShopCart(Consumer consumer,Goods goods){
        List<GoodsCart> cartList = this.checkGoods(consumer, goods);
        if (cartList.size() > 0){
            goodsCartMapper.deleteByPrimaryKey(cartList.get(0).getId());
            return true;
        }
        System.out.println("商品不存在");
        return false;
    }

    /**
     * 查询指定用户购物车中的所有商品
     * @param consumer 指定用户
     * @return 返回该用户购物车的所有商品
     */
    public List<GoodsCart> findAllGoodsCartWithConsumer(Consumer consumer){
        GoodsCartExample gce = new GoodsCartExample();
        gce.createCriteria().andConsumerIdEqualTo(consumer.getId());
        return goodsCartMapper.selectByExample(gce);
    }


}
