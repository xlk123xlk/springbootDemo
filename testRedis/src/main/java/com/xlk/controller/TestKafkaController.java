package com.xlk.controller;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.xlk.entity.Message;

@RestController
public class TestKafkaController {

	@Autowired
    private  KafkaTemplate<String, String> kafkaTemplate;
	private  Gson gson = new GsonBuilder().create();
	@RequestMapping("kafka")
	public void test() {
		Message message = new Message();
		message.setId(System.currentTimeMillis());
		message.setMsg(UUID.randomUUID().toString());
		message.setSendTime(new Date());
		kafkaTemplate.send("topic-ideal", gson.toJson(message));
		System.out.println(gson.toJson(message));
	}
}
