package com.student.union;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("com.student.union.dao")
@ServletComponentScan(basePackages = "com.student.union.filter")
public class UnionApplication {

    public static void main(String[] args) {
        SpringApplication.run(UnionApplication.class, args);
    }

}
