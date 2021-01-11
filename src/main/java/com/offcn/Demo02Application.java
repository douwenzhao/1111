package com.offcn;

import com.offcn.properties.CompanyProperties;
import com.offcn.properties.CourseProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
//开启配置参数类
@EnableConfigurationProperties({CompanyProperties.class, CourseProperties.class})
public class Demo02Application {
    public static void main(String[] args) {
        SpringApplication.run(Demo02Application.class,args);
    }
}