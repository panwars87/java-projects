package com.exp.learning.test;

public interface Inter2 {
	
	default void log(String str){
		System.out.println("I2 logging::"+str);
	}
}
