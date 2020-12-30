package com.baizhi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Classname Application
 * @Author GuOHuI
 * @Date 2020/11/19
 * @Time 21:08
 */
@SpringBootApplication
@MapperScan("com.baizhi.dao")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);

    }
}
