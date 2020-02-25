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