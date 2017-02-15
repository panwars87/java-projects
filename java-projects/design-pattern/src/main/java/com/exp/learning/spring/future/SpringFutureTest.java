/**
 * 
 */
package com.exp.learning.spring.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * @author spanwar
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = { ReportServiceImpl.class })
public class SpringFutureTest {
	
	@Autowired
	private ReportService rs;
	
    @Test
    public void test() throws InterruptedException, ExecutionException {
		System.out.println("Report request sent.............." + Thread.currentThread().getName());
		Future<String> msg = rs.generateReport();
		Future<String> msg2 = rs.generateReport();
		
		while (true){
			if (msg.isDone()) {
	            System.out.println("Result from asynchronous process - " + msg.get());
	        }
	        if (msg2.isDone()) {
	            System.out.println("Result from asynchronous process - " + msg2.get());
	            break;
	        }
	        System.out.println("Continue doing something else. ");
	        Thread.sleep(1000);
	    }
    }
}

