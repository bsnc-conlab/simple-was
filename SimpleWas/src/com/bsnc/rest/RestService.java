package com.bsnc.rest;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestService {
	
	public static final String IP = "192.168.0.37";
	public static final String PORT = "9092";
	public static final String TOPIC_NAME = "justin";
		
	public static void main(String[] args) {
		SpringApplication.run(RestService.class, args);
	}
}
