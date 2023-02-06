package com.shaw.service_activity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class serviceactivityApplication {
	public static void main(String[] args) {
		SpringApplication.run(serviceactivityApplication.class);
	}
}
