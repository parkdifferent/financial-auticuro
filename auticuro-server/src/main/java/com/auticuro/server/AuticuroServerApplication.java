package com.auticuro.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.auticuro.server", "com.auticuro.core"})
@MapperScan({"com.auticuro.**.mapper*", "com.auticuro.**.repository*"})
public class AuticuroServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuticuroServerApplication.class, args);
    }
}
