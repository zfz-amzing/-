package com.zfz.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

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
