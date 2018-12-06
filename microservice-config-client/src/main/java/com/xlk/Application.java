package com.xlk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient  //服务消费者
public class Application {
     public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
