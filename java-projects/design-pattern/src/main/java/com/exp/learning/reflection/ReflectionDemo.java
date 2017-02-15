/**
 * 
 */
package com.exp.learning.reflection;

import java.util.Scanner;

/**
 * @author spanwar
 *
 */
public class ReflectionDemo {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Enter class name: ");
		String name = reader.next();
		Class<?> c = Class.forName(name);
		System.out.printf("Class:%n  %s%n%n", c.getCanonicalName());
	}

}
