package com.example.geek;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.geek.mapper")
public class GeekApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeekApplication.class, args);
    }

}
