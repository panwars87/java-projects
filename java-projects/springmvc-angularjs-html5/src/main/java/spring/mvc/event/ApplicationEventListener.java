package spring.mvc.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.ServletRequestHandledEvent;

@Component
public class ApplicationEventListener implements ApplicationListener<ServletRequestHandledEvent> {

	@Override
	public void onApplicationEvent(ServletRequestHandledEvent event) {		
		System.out.println("ApplicationEventListener: " + event);
		//logging can be done here
	
		System.out.println("Application event ServletRequestHandledEvent: " + event.getProcessingTimeMillis());
		System.out.println("URL: " + event.getRequestUrl());		
	}

}
