package com.liujunbo.springbootdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.liujunbo.springbootdemo.controller","com.liujunbo.springbootdemo.config","com.liujunbo.springbootdemo.service"})
@MapperScan(basePackages = "com.liujunbo.springbootdemo.dao")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
