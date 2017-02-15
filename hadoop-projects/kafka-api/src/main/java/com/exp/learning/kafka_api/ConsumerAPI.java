package com.exp.learning.kafka_api;

import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.common.TopicPartition;

import com.google.common.io.Resources;

import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.Properties;

public class ConsumerAPI {

	//private static Logger log = Logger.getLogger(ProducerAPI.class);
	private static String TOPIC_NAME = "";
	private static String KRB_CONF = "java.security.krb5.conf";
	private static String SECURE_AUTH_LOGIN_CONF = "java.security.auth.login.config";
	private static String SECURE_AUTH_SUBJECT_CRED_ONLY = "javax.security.auth.useSubjectCredsOnly";
	
	public static void main(String[] args) throws Exception {
		
		KafkaConsumer<byte[], byte[]> consumer;
		try (InputStream props = Resources.getResource("consumer.props").openStream()) {
			Properties properties = new Properties();
			properties.load(props);
			TOPIC_NAME = properties.getProperty("topic.name");
			System.setProperty(KRB_CONF, properties.getProperty(KRB_CONF));
			System.setProperty(SECURE_AUTH_LOGIN_CONF, properties.getProperty(SECURE_AUTH_LOGIN_CONF));
			System.setProperty(SECURE_AUTH_SUBJECT_CRED_ONLY, properties.getProperty(SECURE_AUTH_SUBJECT_CRED_ONLY));
			
			consumer = new KafkaConsumer<>(properties);
		}
		
		TestConsumerRebalanceListener rebalanceListener = new TestConsumerRebalanceListener();
		consumer.subscribe(Collections.singletonList(TOPIC_NAME), rebalanceListener);
		
		System.out.printf("Fetching messages from topic %s", TOPIC_NAME);
		while (true) {
			ConsumerRecords<byte[], byte[]> records = consumer.poll(0);
			if(records == null){
				System.out.println("Something is wrong records is null");
			}
			for (ConsumerRecord<byte[], byte[]> record : records) {
				System.out.printf("Received Message topic = %s, partition = %s, offset = %d, key = %s", record.topic(), record.partition(), record.offset(), record.key());
				System.out.println(" value = "+ record.value());
			}

			consumer.commitSync();
		}

	}

	private static class  TestConsumerRebalanceListener implements ConsumerRebalanceListener {
		@Override
		public void onPartitionsRevoked(Collection<TopicPartition> partitions) {
			System.out.println("Called onPartitionsRevoked with partitions:" + partitions);
		}

		@Override
		public void onPartitionsAssigned(Collection<TopicPartition> partitions) {
			System.out.println("Called onPartitionsAssigned with partitions:" + partitions);
		}
	}

}
