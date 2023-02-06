package com.shaw.service_order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.shaw.service_order.mapper")
@ComponentScan(basePackages = "com.shaw")
public class serviceorderApplication {
	public static void main(String[] args) {
		SpringApplication.run(serviceorderApplication.class,args);
	}
}
