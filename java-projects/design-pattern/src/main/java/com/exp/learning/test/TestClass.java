/**
 * 
 */
package com.exp.learning.test;

import java.util.Properties;

/**
 * @author spanwar
 *
 */
public class TestClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(System.getProperties());
		//specify -Dtest.property=value in run configs->arguments
		System.out.println(System.getProperty("test.property","default"));
	}

}
