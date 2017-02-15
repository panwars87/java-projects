package spring.mvc.schedule;

import java.util.Date;
import org.springframework.scheduling.annotation.Scheduled;

public class ScheduleTask{

	 @Scheduled(fixedDelay = 10000)
	 public void fixedDelaySchedule(){
	        System.out.println("ScheduleTask fixedDelaySchedule Every 10 seconds is called: "+ new Date());
	 }
	 
	 //every 30 seconds (seconds, minutes, hours, day of month, month, day of week, year(optional)) 	 
	 @Scheduled(cron="0/30 * * * * ?")
	 public void cronSchedule(){
	        System.out.println("ScheduleTask cronSchedule Every 30 seconds is called: "+ new Date());
	 }
	 
}
