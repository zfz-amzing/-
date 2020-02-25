## 2、mybatis逆向工程

逆向工程是通过数据库中已经存在的数据表，反向生成Java中的实体类`Java`中的实体类`(生成对应的持久层代码)`                                   

### 1、创建商城项目

代码生成器作为商城项目的一个工具组件存在。

`maven`项目

引入逆向工程依赖

+ mybatis-generator-core
+ mybatis-connector-java

```
<dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.19</version>
        </dependency>
        <dependency>
            <groupId>org.mybatis.generator</groupId>
            <artifactId>mybatis-generator-core</artifactId>
            <version>1.4.0</version>
        </dependency>
```



### 2、配置生成规则

逆向工程的生成规则，就是描述数据库中的那些表，生成对应的Java中的实体类，同时生成映射配置文件。这个生成规则就是一个普通的配置文件。

在项目的主目录中创建一个配置文件：`generator.xml`

```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration
        PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
        "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">

<generatorConfiguration>
<!--    <classPathEntry location="/Program Files/IBM/SQLLIB/java/db2java.zip" />-->

    <context id="DB2Tables" targetRuntime="MyBatis3">
        <jdbcConnection driverClass="com.mysql.jdbc.Driver"
                        connectionURL="jdbc:mysql:localhost:3306/xiaomi"
                        userId="root"
                        password="123456">
        </jdbcConnection>

        <javaTypeResolver >
            <property name="forceBigDecimals" value="false" />
        </javaTypeResolver>

        <javaModelGenerator targetPackage="com.zfz.xiaomi.entry" targetProject=".\src\main\java">
            <property name="enableSubPackages" value="true" />
            <property name="trimStrings" value="true" />
        </javaModelGenerator>

        <sqlMapGenerator targetPackage="mapper"  targetProject=".\src\main\resources">
            <property name="enableSubPackages" value="true" />
        </sqlMapGenerator>

        <javaClientGenerator type="XMLMAPPER" targetPackage="com.zfz.xiaomi.dao"  targetProject=".\src\main\java">
            <property name="enableSubPackages" value="true" />
        </javaClientGenerator>

<!--        映射关系-->
        <table tableName="consumer" domainObjectName="Consumer"></table>
        <table tableName="goods" domainObjectName="Goods"></table>
        <table tableName="goods_images" domainObjectName="GoodsImages"></table>
        <table tableName="goods_type" domainObjectName="GoodsType"></table>
        <table tableName="goods_service" domainObjectName="GoodsService"></table>
        <table tableName="goods_package" domainObjectName="GoodsPackage"></table>
        <table tableName="goods_configure" domainObjectName="GoodsConfigure"></table>
        <table tableName="goods_cart" domainObjectName="GoodsCart"></table>
        <table tableName="goods_order" domainObjectName="GoodsOrder"></table>
        <table tableName="goods_order_item" domainObjectName="GoodsOrderItem"></table>
        <table tableName="goods_shipping_address" domainObjectName="GoodsShippingAddress"></table>
        

    </context>
</generatorConfiguration>
```



### 3、逆向工程

通过配置文件指定的生成规则，自动构建实体类和数据访问类，参考官方文档

```
public class CodeGenerator {
    public static void main(String[] args) throws  Exception{
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File("generator.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }
}

```



## 3、SSM项目整合

### （1）配置文件整合

spring配置文件：`src/main/resources/applicationContext.xml`

springMVC配置文件：`src/main/resources/springMVC.xml`

mybatis配置文件：`src/main/rescources/mybatis-config.xml`

数据源配置文件：`scr/main/resoucres/db.properties`

在启动时，框架初始化需要在`web.xml`中添加启动配置

在项目中创建对应的配置文件，同时添加web支持

### （2）依赖添加

- spring-core
- spring-context
- spring-beans
- spring-expression
- spring-insuiession
- spring-jdbc
- spring-orm
- spring-web
- spring-webmvc
- mybatis
- mybatis-spring
- c3p0
- mysql-connector-java

##### pom.xml

```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>Xiaomi</artifactId>
    <version>1.0-SNAPSHOT</version>

    <dependencies>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.19</version>
        </dependency>
        <dependency>
            <groupId>org.mybatis.generator</groupId>
            <artifactId>mybatis-generator-core</artifactId>
            <version>1.4.0</version>
        </dependency>
    </dependencies>
    <!-- https://mvnrepository.com/artifact/org.springframework/spring-core -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-core</artifactId>
        <version>5.2.1.RELEASE</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/org.springframework/spring-core -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-beans</artifactId>
        <version>5.2.1.RELEASE</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/org.springframework/spring-core -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>5.2.1.RELEASE</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/org.springframework/spring-core -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-expression</artifactId>
        <version>5.2.1.RELEASE</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/org.springframework/spring-core -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-jdbc</artifactId>
        <version>5.2.1.RELEASE</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/org.springframework/spring-core -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-orm</artifactId>
        <version>5.2.1.RELEASE</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/org.springframework/spring-core -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-web</artifactId>
        <version>5.2.1.RELEASE</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/org.springframework/spring-core -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-webmvc</artifactId>
        <version>5.2.1.RELEASE</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
    <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis</artifactId>
        <version>3.5.3</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/org.mybatis/mybatis-spring -->
    <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis-spring</artifactId>
        <version>2.0.3</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/com.mchange/c3p0 -->
    <dependency>
        <groupId>com.mchange</groupId>
        <artifactId>c3p0</artifactId>
        <version>0.9.5.4</version>
    </dependency>


</project>
```



### （3）细化配置信息



## 4、单元测试

### (1)引入依赖

基于`spring`的单元测试，需要以下依赖

+ `spring-test`
+ `junit`
+ `spring-aop`
+ `aspectj`

```
 <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-test</artifactId>
            <version>5.2.1.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-aop</artifactId>
            <version>5.2.1.RELEASE</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.aspectj/aspectjrt -->
        <!-- https://mvnrepository.com/artifact/org.aspectj/aspectjweaver -->
        <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjweaver</artifactId>
            <version>1.9.5</version>
        </dependency>

```



### (2)单元测试代码

```
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class DaoTest {
    @Autowired
    private ConsumerMapper consumerMapper;

    @Test
    public void testConsumerInsert(){
        Consumer consumer = new Consumer("zfz","123");
        //讲consumer添加到数据库 insertSelective在只有部分属性有值时使用
        consumerMapper.insertSelective(consumer);
        System.out.println("insertSelective执行完成");
    }
 }
    
```



## 5、业务模型开发&封装响应

从业务模型处理>>复杂业务模型操作

登录、注册>>首页数据加载-->搜索>>购物车>>订单

### (1)登录业务

首先创建用户相关业务处理类：`com.zfz.xiaomi.service.ConsumerService.java`

```java
@Service
public class ConsumerService {

    @Autowired
    private ConsumerMapper consumerMapper;

    public boolean findConsumerWithUsernameAndPassword(Consumer consumer ){
        ConsumerExample ce = new ConsumerExample();
        ce.createCriteria().andUsernameEqualTo(consumer.getUsername()).andPasswordEqualTo(consumer.getPassword());
        List<Consumer> consumerList = consumerMapper.selectByExample(ce);

        return consumerList != null && consumerList.size() == 1;
    }
}

```



创建用户相关业务的访问接口/控制器：`com.zfz.xiaomi.controller.ConsumerController.java`

```java
@Controller
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @PostMapping("/login/auth")
    public String login(@RequestParam String username,@RequestParam String password){
        System.out.println("接收到请求：/consumer/login/auth");
        System.out.println("账号："+username+"密码："+password);
        Consumer consumer = new Consumer(username,password);
        boolean result = consumerService.findConsumerWithUsernameAndPassword(consumer);
        System.out.println("登录结果: "+ result);
        return result ? "success" : "error";
    }
}

```



针对登录业务进行响应数据封装

基于web业务的单元测试

```
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:springMVC.xml"})
@WebAppConfiguration
public class WebTest {

    //声明一个模拟请求的对象
    private MockMvc mockMvc;
    //需要一个web容器
    @Autowired
    private WebApplicationContext context;

    @Before
    public  void SetUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testLogin() throws Exception {
        //发送post请求
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/consumer/login/auth")
                .param("username", "zfz")
                .param("password", "123")).andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
    }
}

```

### (2)相应数据封装

关于数据接口，提供给客户端调用，并且返回符合预期标准的数据访问接口，通常会有如下的要求

+ 固定格式的参数，根据需求提供调用接口即可
+ 返回数据-错误码：快捷判断响应结果是否正确的错误标志，HTTP：200 正确；404 未找到资源； 500 服务器内部错误
+ 返回数据-错误描述：针对错误码具体错误信息的描述
+ 返回数据-数据封装：具体包含的一个或者多个数据

在项目中定义工具类型，封装响应数据：`com.zfz.xiaomi.utils.ResponsMessage.java`

```java
public class ResponseMessage {
    private  String errorCode;
    private  String errMsg;
    private Map<String,Object> objectMap = new HashMap<>();

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Map<String, Object> getObjectMap() {
        return objectMap;
    }

    public void setObjectMap(Map<String, Object> objectMap) {
        this.objectMap = objectMap;
    }
    
    public ResponseMessage addObject(String key, Object value){
        this.objectMap.put(key, value);
        return this;
    }
    
    //处理成功相应的方法
    public static ResponseMessage success(){
        ResponseMessage rm = new ResponseMessage();
        rm.setErrorCode("100");
        rm.setErrMsg("处理成功");
        return rm;
    }
    public static ResponseMessage error(){
        ResponseMessage rm = new ResponseMessage();
        rm.setErrorCode("200");
        rm.setErrMsg("处理失败");
        return rm;
    }
    
}
```

重构登陆业务

```

    @PostMapping("/login/auth")
    @ResponseBody //@responseBody注解的作用是将controller的方法返回的对象通过适当的转换器转换为指定的格式之后，写入到response对象的body区，通常用来返回JSON数据或者是XML数据。
    public ResponseMessage login(@RequestParam String username, @RequestParam String password){
        System.out.println("接收到请求：/consumer/login/auth");
        System.out.println("账号："+username+"密码："+password);
        Consumer consumer = new Consumer(username,password);
        boolean result = consumerService.findConsumerWithUsernameAndPassword(consumer);
        System.out.println("登录结果: "+ result);
        return result ? ResponseMessage.success() : ResponseMessage.error();
    }
```

## 6、登录

```
    <script>
        $(function() {
           // 点击登录按钮时，发送ajax请求
           $("#login-btn").click(function() {
               // 发送ajax请求
               $.ajax({
                   url: "/xiaomi/consumer/login/auth",
                   method: "post",
                   data: {
                       "username": $("#username").val(),
                       "password": $("#password").val()
                   },
                   success:function(response) {
                       console.log("请求发送成功");
                       console.log(response);
                       if(response.errorCode === "100") {
                           // 登录成功
                           alert("用户登录成功！");
                           window.location = "/xiaomi/index.jsp";
                       } else {
                           // 登录失败
                           $("#error-username").text("账号或者密码有误，请重新登录").css({"color": "red"});
                       }
                   },
                   error: function() {
                       console.log("请求发送失败..");

                   }
               });
           });
        });
    </script>
```

## 7、用户注册

业务层：`com.zfz.xiaomi.service.ConsumerService.java`

​	添加注册方法：`register()`

```
public String register(Consumer consumer){
        //验证用户名是否存在
        ConsumerExample ce = new ConsumerExample();
        ce.createCriteria().andUsernameEqualTo(consumer.getUsername());

        List<Consumer> consumerList = consumerMapper.selectByExample(ce);
        if(consumerList.size() > 0){
            return "注册失败，用户名已存在";
        }
        return "注册成功";
    }
```



业务层：`com.zfz.xiaomi.service.ConsumerController.java`

​	添加注册方法：`register()`

```
  @PostMapping(value = "/register",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ResponseMessage register(@RequestParam String username, @RequestParam String password){
        Consumer consumer = new Consumer(username,password);
        String result = consumerService.register(consumer);
        //判断结果
        if (result.contains("注册成功")){
            return  ResponseMessage.success();
        }
        return ResponseMessage.error().addObject("msg",result);

    }
```



网页视图及功能完善

`web/register.jsp`+'jquery'脚本

```
<script src="js/jquery/jquery-3.4.1.js"></script>
    <script>
        $(function() {
            // 点击注册按钮时，发送请求
            $("#register-btn").click(function() {
                // 发送Ajax请求
                $.ajax({
                    url: "/xiaomi/consumer/register",
                    method: "POST",
                    data: {
                        "username": $("#username").val(),
                        "password": $("#password").val()
                    },
                    success: function(response) {
                        if(response.errorCode === "100") {
                            alert("Congratulations，账号注册成功，请登录吧");
                            window.location = "/xiaomi/login.jsp";
                        }else{
                            $("#errorMsg").text(response.objectMap.msg).css({"color": "red"});
                        }
                    },
                    error: function() {
                        $("#errorMsg").text("请求迷路了，小二正在赶来的路上，请稍后再试..").css({"color": "red"});
                    }
                });
            });
        });
    </script>
```



## 8、首页数据加载

首页中需要的数据从后台获取并添加

+ 商品类型
+ 每种类型下的商品

开发业务处理层

+ 商品类型： `com.zfz.xiaomi.service.GoodsTypeService.java`

+ 商品：`com.zfz.xiaomi.service.GoodsShippingService.java`

  反例：项目设计时充分考虑不同的代码层、组件模块之间的命名规则和规范。避免出现不同模块、不同代码层出现相同/相似名称的类型，降低代码质量和可读性

![image-20200224185908599](D:\Xiaomi\notes\pic\image-20200224185908599.png)

`GoodsTypeService.java`

```
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
        gte.createCriteria().andPidIsNotNull();
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

```

`GoodsShippingService.java`

```
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
```

首页数据加载完善

生成的Goods类中不包含图片的地址，在类中添加图片地址的属性

+ `com.zfz.xiaomi.entry.Goods.java`

```
private List<GoodsImages> goodsImages;

    public List<GoodsImages> getGoodsImages() {
        return goodsImages;
    }

    public void setGoodsImages(List<GoodsImages> goodsImages) {
        this.goodsImages = goodsImages;
    }
```

+ `mapper/GoodsMapper.xml`

```
<!--修改了selectByExample，使其能在goodsImages表中查询到图片地址 -->
<select id="selectByExample" parameterType="com.zfz.xiaomi.entry.GoodsExample" resultMap="ResultMapWithGoodsImages">
    <!--
      WARNING - @mbg.generated
      This element is automatically generated by MyBatis Generator, do not modify.
      This element was generated on Sun Feb 23 17:50:08 CST 2020.
    -->
    select g.id, g.name,g.price,g.stock,g.goods_type_id,g.remark,
           gi.id giid,gi.path, gi.title, gi.alt
    from goods g
    left join goods_images gi
    on g.id = gi.goods_id
    <if test="_parameter != null">
      <include refid="Example_Where_Clause" />
    </if>
    <if test="orderByClause != null">
      order by ${orderByClause}
    </if>
  </select>
```

+ `mapper/GoodsMapper.xml`

```
  <!-- 改造resultMap -->
  <resultMap extends="BaseResultMap" id="ResultMapWithGoodsImages" type="com.zfz.xiaomi.entry.Goods">

    <result column="remark" jdbcType="LONGVARCHAR" property="remark" />
    <collection property="goodsImages" ofType="com.zfz.xiaomi.entry.GoodsImages">
      <id column="giid" property="id"/>
      <result column="path" property="path"/>
      <result column="title" property="title"/>
      <result column="alt" property="alt"/>
    </collection>
  </resultMap>
```





开发首页控制器`com.zfz.xiaomi.controller.IndexController.java`

+ initIndex(..):加载首页数据的控制器方法，前端网页中通过JQuery Ajax请求获取数据

开发首页视图：`/web/index.jsp`渲染展示商品

## 9、商品搜索

基本搜索功能，直接和数据库交互，通过sql语句完成商品数据的检索
企业项目需要的搜索功能，很少会直接和数据库进行交互，一般情况下会使用数据中间件框架`elasticesearch`

### （1）、商品按名称模糊搜索

业务层方法开发：`com.zfz.xiaomi.service.GoodsShipService.java`

```
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
```

控制层方法`com.zfz.xiaomi.controller.UtilsController.java`

```
    @GetMapping("/search/{name}")
    @ResponseBody
    private ResponseMessage searchGoodsWithName(@PathVariable String name){
        List<Goods> goodsList = goodsShippingService.searchGoodsWithName(name);
        return goodsList.size() > 0 ? ResponseMessage.success().addObject("goodsList", goodsList)
                                    : ResponseMessage.error();
    }
```

单元测试

```
 @Test
    public void testSearchGoods(){
        List<Goods> goodsList = goodsShippingService.searchGoodsWithName("小米");
        goodsList.forEach(goods -> System.out.println(goods));
    }
```

网页视图开发

```
    <!-- 搜索框 index.jsp-->
    <form action="#" id="search">
        <input type="text">
        <button></button>
    </form>
```



### （2）、商品按类型检索

