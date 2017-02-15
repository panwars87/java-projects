package com.exp.learning.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author spanwar
 *
 */
public class Java8ForEachExample {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
		Collections.sort(names, (String a, String b) -> {
		    return b.compareTo(a);
		});
		Collections.sort(names, (String a, String b) -> b.compareTo(b));
	}
	
	public void oldJavaCompare(){
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

		Collections.sort(names, new Comparator<String>() {
		    @Override
		    public int compare(String a, String b) {
		        return b.compareTo(a);
		    }
		});
	}
	
	public void forEachTest(){
		LocalDate date = LocalDate.now();
		System.out.println(date);
		
		List<String> items = new ArrayList<>();
		items.add("A");
		items.add("B");
		items.add("C");
		items.add("D");
		items.add("E");

		//lambda
		//Output : A,B,C,D,E
		items.forEach(item->System.out.println(item));
		
		//method reference
		//Output : A,B,C,D,E
		items.forEach(System.out::println);

		//Output : C
		items.forEach(item->{
			if("C".equals(item)){
				System.out.println(item);
			}
		});
	}
}
