package spring.mvc.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Component
public class ExceptionHandler implements HandlerExceptionResolver{
	
	private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

	
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object object, Exception exception) {		
		System.out.println("Spring MVC Exception Handling");
		logger.error("Error: ", exception);		
		return new ModelAndView("error/exception","exception","ExceptionHandler message: " + exception.toString());
	}

}
