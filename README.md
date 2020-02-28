环境：IDEA  MySQL 8.0 tomcat8.5

## 整合SSM框架

整合了ssm框架，逆向生成了dao层，实现了dao层的测试

## 登录业务

1. 登陆业务完成  web测试成功
2. 封装响应数据：`com.zfz.xiaomi.utils.ResponsMessage.java`  重构了登陆业务以json返回

## 注册业务

注册业务完成

## 首页数据加载

在后端查询出一级类型 二级类型 和对应的商品。渲染前端完成

完善了首页数据，改造Goods类以及goodsMap.xml使其能够查询到图片位置

修改了图片资源，使首页能够正常显示商品图片

## 首页搜索功能

后端 增加service层和controller层

前端增加goodslist.jsp

根据商品类型检索完成，前端增加goodslist2.jsp

## 商品细节展示

后端查询商品详细信息

前端增加detail.jsp 可再index.jsp和goodslist.jsp跳转到商品详情页

## 购物车

添加到购物车 购物车页面



## 完成视频内容修复瑕疵

已解决首页登录注册超链接

新问题：添加购物车时显示服务器繁忙。           已解决