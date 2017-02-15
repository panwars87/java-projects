package spring.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

//@Controller is removed hence this is XML config
public class ControllerXMLConfig extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("Controller With XML Config is called");	
		return null;
	}
}
