/**
 * 
 */
package com.exp.learning.generics;

import java.util.Arrays;
import java.util.List;

/**
 * @author spanwar
 *
 */
public class GenericsDemo {

	/**
	 * @param args
	 */
	public static void main(String... args) {
		// TODO Auto-generated method stub
		Box<String> integerBox = new Box<String>();
		integerBox.set("Shashant");
		System.out.println(integerBox.get());

		Pair<Integer, String> p1 = new Pair<>(1, "apple");
		Pair<Integer, String> p2 = new Pair<>(1, "apple");
		boolean same = GenericsDemo.<Integer, String>compare(p1, p2);
		System.out.println("Boolean value: "+ same);

		String[] names = {"Shashant", "Shubham", "Shweta", "Aahan"};
		List<String> stringList = Arrays.asList(names);
		Integer[] numbers = {100,110,120,130,200};
		List<Integer> numberList = Arrays.asList(numbers);
		GenericsDemo.printList(stringList);
		GenericsDemo.printList(numberList);	
	}

	public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
		return p1.getKey().equals(p2.getKey()) &&
				p1.getValue().equals(p2.getValue());
	}

	public static void printList(List<?> list){
		System.out.println(list.toString());
	}

}


//E - Element
//K - Key
//N - Number
//T - Type
//V - Value
class Box<T> {
	// T stands for "Type"
	private T t;

	public void set(T t) { this.t = t; }
	public T get() { return t; }
}

class Pair<K, V> {

	private K key;
	private V value;

	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public void setKey(K key) { this.key = key; }
	public void setValue(V value) { this.value = value; }
	public K getKey()   { return key; }
	public V getValue() { return value; }
}