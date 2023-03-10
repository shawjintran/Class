package com.shaw.service_activity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.shaw")
public class serviceactivityApplication {
	public static void main(String[] args) {
		SpringApplication.run(serviceactivityApplication.class);
	}
}
