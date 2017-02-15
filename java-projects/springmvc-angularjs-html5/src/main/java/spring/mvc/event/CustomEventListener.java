package spring.mvc.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class CustomEventListener implements ApplicationListener<CustomEvent> {

	@Override
	public void onApplicationEvent(CustomEvent customEvent) {
		System.out.println("CustomEventListener onApplicationEvent(CustomEvent customEvent) is called: " + customEvent.getDetail());		
	}

}
