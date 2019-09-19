package com.bsnc.rest.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestService {
	
	public static final String IP = "192.168.0.37";
	public static final String PORT = "9092";
	public static final String TOPIC_NAME = "bsnc";
		
	public static void main(String[] args) {
		SpringApplication.run(RestService.class, args);
	}
}
