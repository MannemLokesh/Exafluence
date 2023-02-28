package com.kafka.producer.configurations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

public class ProducerConfiguration 
{
	private Socket socket = null;
	private BufferedReader input = null;
	private Properties properties;
	
	public void Client1(String address, int port, Properties properties) throws JSONException, IOException 
	{
		//Establishing the connection
		try 
		{
			socket = new Socket(address, port);
			//Reading input data from socket server
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.properties=properties;

			
			String line;
			//Reading data from Socket server and storing it in String using BufferedReder
			while((line=input.readLine())!=null)
			{
				//Converting input data from String to JSONArray
				JSONArray array = new JSONArray(line);

				//Reading Each line From JSONArray
				for(int i = 0; i < array.length(); i++) 
				{
					//Converting each line as JSONObject 
					JSONObject object = array.getJSONObject(i);
				
					//Getting the KafkaTemplate and ProducerConfiguration form the method kafkaTemplate()
					KafkaTemplate<String, String> kafkaTemplate = kafkaTemplate();
					kafkaTemplate.send("Producer", object.toString());
				}
			}
		}
		catch(SocketException e) 
		{
			throw new IllegalArgumentException("Unable to load ");
		} 
		catch(IOException i) 
		{
			throw new IllegalArgumentException("Unable to load ");
		}
		catch(Exception e) 
		{
			throw new IllegalArgumentException("Unable to load ");
		}
		finally //Closing the resources
		{
			input.close();
			socket.close();
		}
	}

	public KafkaTemplate<String, String> kafkaTemplate()
	{
		return new KafkaTemplate<>(producerConfig());
	}

	public ProducerFactory<String, String> producerConfig() 
	{
		Map<String, Object> config = new HashMap<>();
		
		//Getting bootstrap_server value from application.properties file
		String bootstrap_server = properties.getProperty("bootstrap_server");

		//config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrap_server);		
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory<>(config);
	}
}
