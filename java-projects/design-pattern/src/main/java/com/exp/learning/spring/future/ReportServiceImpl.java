package com.exp.learning.spring.future;

import java.time.LocalDate;
import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;

interface ReportService{
	Future<String> generateReport();
}

@EnableAsync
class ReportServiceImpl implements ReportService{
	
	@Async()
	public Future<String> generateReport() {
		// TODO Auto-generated method stub
		System.out.println("Report request received : "+ Thread.currentThread().getName());
		try{
			Thread.sleep(15000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		String msg = "report generate succesfully on "+ LocalDate.now();
		return new AsyncResult<String>(msg);
	}
	
}
