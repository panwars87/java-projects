package com.exp.learning.demo;

/**
 * @author spanwar
 *
 */
public class Demo {

	static{
		System.out.println("This is a static block, this will execute first");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo d = new Demo();
		
		//Static nested class
		Demo.TestNestClass tnc = new Demo.TestNestClass();
		Demo.TestNestClass.conditionalDemo(30, 20);
		Demo.TestNestClass.whileDemo(2);
		tnc.nonStaticMethod();
		
		//non-static nested class
		Demo.NestedClassDemo nsd = d.new NestedClassDemo();
		nsd.printName("Shashant");
	}
	
	static class TestNestClass{
		
		public static void whileDemo(int value){
			int i=0;
			while(i<value){
				System.out.println("Count is: " + i);
				i++;
			}
		}
		
		public static void conditionalDemo(int value1, int value2){
			int result = (value1 > value2) ? value1 : value2;
			System.out.println(result + " is greater.");
		}
		
		public void nonStaticMethod(){
			System.out.println("This is non static method inside static nested class");
		}
	}
	
	class NestedClassDemo{
		public void printName(String name){
			System.out.println(name);
		}
	}
}