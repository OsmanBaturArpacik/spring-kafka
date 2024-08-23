package com.kafka.producer;

import com.kafka.producer.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProducerApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}

	@Autowired
	private ProducerService producerService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Kafka log send starting...");
		for (int i = 0; i < 10; i++) {
			producerService.sendMessage(String.format("[%d] -- Hello World", i));
		}
		System.out.println("Kafka log sent...");
	}
}
