package com.hashirama.demo.controller;

import com.hashirama.demo.properties.AppConfigProperties;
import com.hashirama.demo.properties.TestConfigProperties;
import com.hashirama.demo.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController = @Controller+@ResponseBody的结合，
 * 使用这个注解的类里面的方法都以json格式输出
 */
@RequestMapping("/")
@RestController
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Value("${project.author.name}")
    private String name;

    @Autowired
    private AppConfigProperties appConfigProperties;

    @Autowired
    private TestConfigProperties testConfigProperties;

    @Autowired
    private User user;

    @RequestMapping("/")
    private String index(){
        return "Hello World!";
    }

    @RequestMapping("/test")
    private String test() {
        logger.info("author name: {}.", name);
        return "this is spring boot demo.";
    }

    @RequestMapping("/author/info")
    private String getAuthorInfo(){
        return String.format("author name: %s, age: %d.", appConfigProperties.getName(), appConfigProperties.getAge());
    }

    @RequestMapping(value = "/test/info")
    private String getTestInfo(){
        return String.format("test info: %s, random value: %s.", testConfigProperties.getDesc(), testConfigProperties.getRandomValue());
    }

    @RequestMapping("/user")
    private User getUser(){
        User user = new User();
        user.setName("lenn");
        user.setAge(12);
        user.setFamale(false);

        return user;
    }

    @RequestMapping("/config/user")
    private User User(){
        return this.user;
    }

}
