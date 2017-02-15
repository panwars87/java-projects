package spring.mvc.scope;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ScopeController {
	
	
	@RequestMapping(value = "/scopeSession", method=RequestMethod.GET)
	 public ModelAndView scope(HttpSession session) {		
	
		System.out.println("ScopeController scope is called");
		session.setAttribute("sessionObject", "Value in session object");
		//session.setMaxInactiveInterval(15); seconds
		return new ModelAndView("/scope/scope");		 
	}

	@RequestMapping(value = "/invalidate", method=RequestMethod.GET)
	 public ModelAndView invalidate(HttpSession session) {				
		session.invalidate();
		System.out.println("ScopeController invalidate is called");
		return new ModelAndView("/scope/scope");		 
	}
	
	
}
