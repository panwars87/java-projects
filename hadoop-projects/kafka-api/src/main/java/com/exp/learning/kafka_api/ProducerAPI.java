package com.exp.learning.kafka_api;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import com.google.common.io.Resources;

import java.io.InputStream;
import java.util.Properties;

public class ProducerAPI {

	//private static Logger log = Logger.getLogger(ProducerAPI.class);
	private static String TOPIC_NAME = "";
	private static String KRB_CONF = "java.security.krb5.conf";
	private static String SECURE_AUTH_LOGIN_CONF = "java.security.auth.login.config";
	private static String SECURE_AUTH_SUBJECT_CRED_ONLY = "javax.security.auth.useSubjectCredsOnly";
	
	public static void main(String[] args) throws Exception {
		
		Producer<String, String> producer;
		try (InputStream props = Resources.getResource("producer.props").openStream()) {
			Properties properties = new Properties();
			properties.load(props);
			TOPIC_NAME = properties.getProperty("topic.name");
			System.setProperty(KRB_CONF, properties.getProperty(KRB_CONF));
			System.setProperty(SECURE_AUTH_LOGIN_CONF, properties.getProperty(SECURE_AUTH_LOGIN_CONF));
			System.setProperty(SECURE_AUTH_SUBJECT_CRED_ONLY, properties.getProperty(SECURE_AUTH_SUBJECT_CRED_ONLY));
			
			producer = new KafkaProducer<>(properties);
		}
		
		System.out.println("################################Running Producer API main################################");
		TestCallback callback = new TestCallback(); 
		System.out.printf("Pushing messages to topic %s \n", TOPIC_NAME);
		for (long i = 0; i < 20 ; i++) {
			ProducerRecord<String, String> data = new ProducerRecord<String, String>("test-topic", "test message key-" + i, "message-"+i );
			producer.send(data, callback);
		}

		producer.close();

	}


	private static class TestCallback implements Callback {
		@Override
		public void onCompletion(RecordMetadata recordMetadata, Exception e) {
			if (e != null) {
				System.out.format("Error while producing message to topic : {}", recordMetadata);
				e.printStackTrace();
			} else {
				String message = String.format("Sent message to topic:%s partition:%s  offset:%s", recordMetadata.topic(), recordMetadata.partition(), recordMetadata.offset());
				System.out.println(message);
			}
		}
	}

}