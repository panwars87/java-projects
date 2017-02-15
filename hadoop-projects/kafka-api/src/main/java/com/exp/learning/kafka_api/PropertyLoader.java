package com.exp.learning.kafka_api;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {
	
	public PropertyLoader(){};
	
	public static Properties getProperty(String propertyFileName) throws Exception {
		// TODO Auto-generated constructor stub
		Properties property = new Properties();
		try{
			InputStream props = PropertyLoader.class.getResourceAsStream("producer.props");
			property.load(props);
			System.out.println("Property loaded successfully ....");
		} catch (IOException cnfe) {
			System.err.format("Exception while loading property, error message is {}", cnfe.getMessage());
			throw cnfe;
		}
		return property;
	}

}
