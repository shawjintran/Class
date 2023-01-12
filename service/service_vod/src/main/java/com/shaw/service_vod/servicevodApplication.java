package com.shaw.service_vod;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@MapperScan("com.shaw.service_vod.mapper")
@ComponentScan(basePackages = "com.shaw")
public class servicevodApplication {
	public static void main(String[] args) {
		SpringApplication.run(servicevodApplication.class,args);
	}
}
