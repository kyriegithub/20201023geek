package com.example.geek.controller;

import com.alibaba.fastjson.JSON;
import com.example.geek.GeekApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * 用户单元测试类
 */
@Slf4j
public class GeekTestControllerTest extends GeekApplicationTests {


    /**
     * 测试get方法(参数在url中)
     *
     * @throws Exception
     */
    @Test
    public void getUser() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/geek/user/{id}", "1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        log.info(mvcResult.getResponse().getContentAsString());
    }


    /**
     * get方法  ?之后的参数
     */
    @Test
    public void getUserList() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/geek/user/list")
                .param("name", "cjy").param("phone", "1").
                        param("pageNo","2").param("pageSize","3").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        log.info(mvcResult.getResponse().getContentAsString());
    }

    /**
     * 新增数据
     * @throws Exception
     */
    @Test
    public void addUser() throws Exception {
        Map<String,Object> map = new HashMap<>(4);
        map.put("name","nana");
        map.put("phone","188832");
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/geek/user")
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(JSON.toJSONString(map)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        log.info(mvcResult.getResponse().getContentAsString());
    }


    /**
     * 删
     * @throws Exception
     */
    @Test
    public void delUser() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete("/geek/user/{id}",5)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        log.info(mvcResult.getResponse().getContentAsString());
    }

    /**
     * 改
     */
    @Test
    public void updatUser() throws Exception {
        Map<String,Object> map = new HashMap<>(4);
        map.put("id","5");
        map.put("name","xxx");
        map.put("phone","1257318399");
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put("/geek/user")
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(JSON.toJSONString(map)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        log.info(mvcResult.getResponse().getContentAsString());
    }
}