package spring.mvc.event;

import org.springframework.context.ApplicationEvent;

public class CustomEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;

	public CustomEvent(String string) {
		super(string);
	}
	
	public String getDetail() {
	    
		return "Custom Event detail method is called";
		//return (String) (getSource());
	}

}
