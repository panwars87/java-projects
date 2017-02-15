package com.exp.learning.test;

public interface Inter1 {
	
	default void log(String str){
		System.out.println("I1 logging::"+str);
	}
	
	static void print(String str){
		System.out.println("Printing "+str);
	}
}
