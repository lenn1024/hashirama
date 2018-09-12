package com.example.demo.bean;

import com.example.demo.domain.User;
import com.example.demo.filter.TestFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {
    @Bean
    public User user(){
        User user = new User();
        user.setName("waw");

        return user;
    }

    @Bean
    public TestFilter testFilter(){
        return new TestFilter();
    }

    @Bean
    public FilterRegistrationBean filterRegistration(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();

//        filterRegistrationBean.setFilter(testFilter());
        filterRegistrationBean.setFilter(new TestFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("password", "123");
        filterRegistrationBean.setName("testFilter");
        filterRegistrationBean.setOrder(1);

        return filterRegistrationBean;
    }
}
