package com.xlk.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value=3)
public class MyStartupRunner3 implements CommandLineRunner{

	@Autowired
	private  ApplicationContext applicationContext;
	 
	@Override
	public void run(String... args) throws Exception {
		String [] beanNames = applicationContext.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
	}

}
