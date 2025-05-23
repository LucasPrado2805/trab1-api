package com.api.trab1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.api.trab1.modelos"})
public class ApiMainTrab1 {

    public static void main(String[] args) {
        SpringApplication.run(ApiMainTrab1.class, args);
    }
}
