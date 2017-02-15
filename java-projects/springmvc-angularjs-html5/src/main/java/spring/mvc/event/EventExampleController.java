package spring.mvc.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventExampleController implements ApplicationContextAware{
	
	private ApplicationContext applicationContext;
	
	@RequestMapping(value = "/publishCustomEvent.html", method=RequestMethod.GET)
	public ModelAndView publishCustomEvent() {
		applicationContext.publishEvent(new CustomEvent("Custom Event"));
		return null;
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
		
	}

}
