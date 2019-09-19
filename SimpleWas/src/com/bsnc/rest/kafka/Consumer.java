package com.bsnc.rest.kafka;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class Consumer {
	public static void main(String[] args) {
        Properties configs = new Properties();
        //set Configuration
        configs.put("bootstrap.servers", "localhost:9092");     //kafka server host, port
        configs.put("session.timeout.ms", "10000");             //set session
        configs.put("group.id", "justin");                //set topic
        configs.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");    //key deserializer
        configs.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");  //value deserializer
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(configs);    //create consumer
        consumer.subscribe(Arrays.asList("justin"));      //sey topic 
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(500);
            for (ConsumerRecord<String, String> record : records) {
                String s = record.topic();
                if ("justin".equals(s)) {
                    System.out.println(record.value());
                } else {
                    throw new IllegalStateException("get message on topic " + record.topic());
                }
            }
        }   
    }
    
}