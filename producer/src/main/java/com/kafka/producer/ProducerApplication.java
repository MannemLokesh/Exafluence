package com.kafka.producer;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.json.JSONException;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kafka.producer.configurations.ProducerConfiguration;

@SpringBootApplication
public class ProducerApplication 
{
	public static void main(String[] args) throws JSONException, IOException 
	{
		//Creating Object for ProducerConfiguration class
		ProducerConfiguration producer = new ProducerConfiguration();
		
		//To read data from application.properties file
		FileReader fileReader = new FileReader("src/main/resources/application.properties");
		Properties properties = new Properties();
		properties.load(fileReader);
		
		//Getting host value from application.properties file
		String host = properties.getProperty("host");
		//Getting socket_port value from application.properties file
		String socket = properties.getProperty("socket_port");
		
		//If the values are error than it will raise error.
		if (socket == null || host==null)
		{
			throw new IllegalArgumentException("Unable to load ");
		}
		
		//TypeCasting the port value (String to integer)
		int socketPort = Integer.parseInt(socket);
		
		//calling the method
		producer.Client1(host,socketPort,properties);
	}
}