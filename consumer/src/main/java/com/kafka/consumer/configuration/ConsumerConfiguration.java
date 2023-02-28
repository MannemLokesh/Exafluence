package com.kafka.consumer.configuration;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.bson.Document;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.stereotype.Component;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Component
public class ConsumerConfiguration
{
	private static MongoCollection<Document> Devicecollection = null;
	private KafkaConsumer<String, String> consumer =null;
	
	public void consume(Properties property) throws JSONException 
	{
		try 
		{
			MongoClient mongoClient = MongoClients.create(property.getProperty("mongodbUri")); //Getting URI from application.properties file
			MongoDatabase db = mongoClient.getDatabase(property.getProperty("database")); //Getting database name from application.properties file
			Devicecollection = db.getCollection(property.getProperty("collection")); //Getting collection name from application.properties file		
		
			Logger logger = LoggerFactory.getLogger(ConsumerConfiguration.class.getName());
			String bootstrapServers = property.getProperty("bootstrapServers"); //Getting bootstrapServers port from application.properties file
		
			//Getting groupID from application.properties file
			String grp_id = property.getProperty("grp_id"); 
			
			//Getting topic name from application.properties file
			String topic = property.getProperty("topic");
		
			//Creating consumer properties
			Properties properties = new Properties();
			properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
			properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
			properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class.getName());
			properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, grp_id);
			properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
			
			//Creating consumer Object
			consumer= new KafkaConsumer<String, String>(properties);
			
			if(consumer==null)
			{
				throw new IllegalArgumentException("Unable to create Object for Consumer");
			}
			
			//Subscribing
			consumer.subscribe(Arrays.asList(topic));
			
			// polling
			while(true) 
			{
				ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
				for(ConsumerRecord<String, String> record : records) 
				{
					logger.info("Key: " + record.key() + ", Value:" + record.value());
					logger.info("Partition:" + record.partition() + ",Offset:" + record.offset());
					Document doc = Document.parse(record.value());
					Devicecollection.insertOne(doc);
				}
			}
		}
		catch (Exception e) 
		{
			//Handle server down or failed query here.
			throw new IllegalArgumentException("Unable to load");
		}
		finally //Closing the resources
		{
			consumer.close();
		}
	}
}
