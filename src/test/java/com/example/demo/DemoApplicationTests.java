package com.example.demo;

import com.example.demo.controller.TestController;
import com.example.demo.entity.UserInfo;
import com.example.demo.mapper.UserMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    private Logger logger = LoggerFactory.getLogger(DemoApplicationTests.class);

    private MockMvc mockMvc;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private UserMapper userMapper;

    @Before
    public void init(){
    }

    @Test
    public void contextLoads() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(new TestController()).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello World!")));
    }


    @Test
    public void testRedis(){
        // key-value
        stringRedisTemplate.opsForValue().set("name", "waw");
        String value = stringRedisTemplate.opsForValue().get("name");
        logger.info("key-value: {}", value);

        // list
        stringRedisTemplate.opsForList().leftPushAll("list", "1", "2", "3");

        // set
        stringRedisTemplate.opsForSet().add("set", "apple", "apple", "banana");

        // zset
        stringRedisTemplate.opsForZSet().add("zset", "apple", 1);
        stringRedisTemplate.opsForZSet().add("zset", "orange", 2);

        // hash
        stringRedisTemplate.opsForHash().put("hash", "name", "lenn");
        stringRedisTemplate.opsForHash().put("hash", "age", "18");
        Map<Object, Object> map = stringRedisTemplate.opsForHash().entries("hash");
        logger.info("map: {}", map);
    }

    @Test
    public void testMybatis(){
        List<UserInfo> users = userMapper.getAllUser();
        System.out.println(users);
    }

    @Test
    public void mybatisInsert(){
        UserInfo user = new UserInfo();
        user.setName("maer");
        user.setAge(10);
        user.setCreateTime(new Date());
        userMapper.insertUser(user);

        System.out.println("bang");
    }
}
