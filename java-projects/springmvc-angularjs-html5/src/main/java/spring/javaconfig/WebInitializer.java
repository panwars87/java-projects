package spring.javaconfig;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
	/*	AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();  
		context.register(JavaConfig.class);  		
		context.setServletContext(servletContext); 
		Dynamic servlet = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(context));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);*/

		
	}
	
	

}
