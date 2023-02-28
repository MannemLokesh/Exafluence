package com.kafka.consumer;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.json.JSONException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

import com.kafka.consumer.configuration.ConsumerConfiguration;

@SpringBootApplication
@EnableKafka
public class ConsumerApplication
{
	public static void main(String[] args) throws JSONException, IOException 
	{
		ConsumerConfiguration configuration = new ConsumerConfiguration();
		
		//Reading data from application.properties file
		FileReader fileReader = new FileReader("src/main/resources/application.properties");
		Properties properties = new Properties();
		properties.load(fileReader);
		
		configuration.consume(properties);
	}
}
