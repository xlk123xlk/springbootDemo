package com.xlk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 获取git上的资源信息遵循如下规则：
 * /{application}/{profile}[/{label}]
 * /{application}-{profile}.yml
 * /{label}/{application}-{profile}.yml
 * /{application}-{profile}.properties
 * /{label}/{application}-{profile}.properties
 * 
 * bootstrap.yml:付从外部资源获取配置文件
 */

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient  //服务提供者
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
