package com.example.demo;

import com.example.demo.properties.AppConfigProperties;
import com.example.demo.properties.TestConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * spring boot 项目的核心注解，开启项目自动配置
 */
@SpringBootApplication
@EnableConfigurationProperties({AppConfigProperties.class, TestConfigProperties.class})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
