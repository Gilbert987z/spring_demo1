package com.zz.spring_demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class SpringDemo1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringDemo1Application.class, args);
    }

}
