package com.xlk;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.xlk.kafkaConfigure.ConsumerGroup;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
        ConsumerGroup consumerGroup = new ConsumerGroup();
        consumerGroup.execute();
	}
}
