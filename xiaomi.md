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



## 5\业务模型开发&封装响应

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

针对登录业务进行响应数据封装

基于web业务的单元测试

