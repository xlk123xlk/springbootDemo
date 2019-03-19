package com.xlk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@MapperScan("com.xlk.dao")
public class Application {

	/**
	 * springboot执行原理：SpringApplication.run()方法执行，会new SpringApplication();执行SpringApplication的初始化方法，
	 * 然后调用SpringFactoriesLoader.loadFactoryNames()方法去加载 META-INF/spring.factories 中的bean
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}
