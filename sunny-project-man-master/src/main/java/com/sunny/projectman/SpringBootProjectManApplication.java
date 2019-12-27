package com.sunny.projectman;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lgwang
 */
@SpringBootApplication
@MapperScan(value = "classpath:com.sunny.projectman.business.mapper")
public class SpringBootProjectManApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootProjectManApplication.class, args);
    }
}
