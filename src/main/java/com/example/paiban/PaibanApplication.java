package com.example.paiban;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.paiban.dao")
public class PaibanApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaibanApplication.class, args);
    }

}
