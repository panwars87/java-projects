package spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import spring.mvc.orm.ORMExample;

@Controller
public class JSTLTestController {
	 
	 @Autowired
	 private ORMExample ormExample;
	 
	 @RequestMapping(value="/jstlReturnUsers", method=RequestMethod.GET)
	 public ModelAndView listUsers() {
		 return new ModelAndView("jstl/jstl","users", ormExample.queryfindAllUsersJPA());
	 }
	 
	 @RequestMapping(value="/jstlUser", method=RequestMethod.GET)
	 public ModelAndView getUser() {;
		 return new ModelAndView("jstl/jstl","user", ormExample.queryFindByIdUser(1));
	 }
	 
	 @RequestMapping(value="/jstlHTML", method=RequestMethod.GET)
	 public ModelAndView returnHTML() {
		 //"<html><head><title>Hello</title></head><body></body></html>"
		 return new ModelAndView("jstl/jstl", "html", "<font color='red'><b>Test Color Red</b></font>");
	 }
}
