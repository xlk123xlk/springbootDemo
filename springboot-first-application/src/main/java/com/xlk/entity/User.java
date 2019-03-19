package com.xlk.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

//加载外部（不在application.yml中）配置文件  @PropertySource不支持加载yml文件（注意）
@PropertySource(value="classpath:test.properties")
@ConfigurationProperties(prefix = "com.xlk")
@Component
public class User {

	private String aa;
	
	private String bb;

	public String getAa() {
		return aa;
	}

	public void setAa(String aa) {
		this.aa = aa;
	}

	public String getBb() {
		return bb;
	}

	public void setBb(String bb) {
		this.bb = bb;
	}
	
}
