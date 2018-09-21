package com.hashirama.demo;

import com.hashirama.demo.properties.AppConfigProperties;
import com.hashirama.demo.properties.TestConfigProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * spring boot 项目的核心注解，开启项目自动配置
 */
@SpringBootApplication
@MapperScan("com.hashirama.demo")
@EnableScheduling
@EnableConfigurationProperties({AppConfigProperties.class, TestConfigProperties.class})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
