/**
 * 
 */
package com.exp.learning.test;

/**
 * @author spanwar
 *
 */
public class MyClass implements Inter1, Inter2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void log(String str) {
		// TODO Auto-generated method stub
		Inter1.super.log(str);
		Inter1.print(str);
	}

}
