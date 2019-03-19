package com.xlk;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.xlk.entity.Message;
import com.xlk.utils.RedisUtils;

@SpringBootApplication
@RestController
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	//字符串
	@RequestMapping("/hello")
    public String index() {
		String obj = "";
		if( RedisUtils.hasKey("xlk1")) {
			obj = (String)RedisUtils.get("xlk1");
		}
		return obj;
    }
	
	@RequestMapping("/hello1")
	public boolean index1() {
		return RedisUtils.set("xlk1", "xlk1");
	}
	
	//hash
	@RequestMapping("/hello2")
	public boolean index2() {
		return RedisUtils.hset("xlk2", "xlk2","haha");
	}
	
	@RequestMapping("/hello3")
	public Object index3() {
		return RedisUtils.hget("xlk2", "xlk2");
	}
	
	@RequestMapping("/hello4")
	public boolean index4() {
		Map<Object,Object> map = new HashMap<Object,Object>();
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", "4");
		return RedisUtils.hmset("xlk3", map);
	}
	
	@RequestMapping("/hello5")
	public Map<Object,Object> index5(){
		return RedisUtils.hmget("xlk3");
	}
}
