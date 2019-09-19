package com.bsnc.rest.controller;

import java.util.Properties;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bsnc.rest.model.CommonResponseBean;
import com.bsnc.rest.model.ICommonResponseBean;
import com.bsnc.rest.model.ResultResBean;
import com.bsnc.rest.service.RestService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@RestController
@RequestMapping("/bsnc")
public class Controller {
	
	String ip = RestService.IP;
	String port = RestService.PORT;
	String topic = RestService.TOPIC_NAME;

	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(value = "/conlab", method = RequestMethod.POST)
	@ResponseBody
	public ICommonResponseBean jsonREQ(@RequestBody String payload) {
		
		JsonParser parser = new JsonParser();
		JsonObject jsonObject = parser.parse(payload).getAsJsonObject();
		
		String message = "안녕하세요. 저는 과거에서 보낸 메시지에요 내 말을 잘라 보세요";
		
		Properties properties = new Properties();
		System.out.println("ip: " + ip);
		System.out.println("port: " + port);
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, ip + ":" + port);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
					
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, message);
        try {
            producer.send(record, (metadata, exception) -> {
                if (exception != null) {
                    System.out.println("exception : " + exception);
                }
            });
        } catch (Exception e) {
        	return new CommonResponseBean(counter.incrementAndGet(), -500, e.getMessage());
        } finally {
            producer.flush();
        }
		return new ResultResBean(counter.incrementAndGet());
	}
	
	@RequestMapping(value = "/exit", method = RequestMethod.POST)
	@ResponseBody
	public void jsonEXIT(@RequestBody String payload) {
		
		JsonParser parser = new JsonParser();
		JsonObject jsonObject = parser.parse(payload).getAsJsonObject();
		
		String message = "exit";
		
		Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, ip + ":" + port);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
					
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, message);
        try {
            producer.send(record, (metadata, exception) -> {
                if (exception != null) {
                    System.out.println("exception : " + exception);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.flush();
        }


	}
	
}
