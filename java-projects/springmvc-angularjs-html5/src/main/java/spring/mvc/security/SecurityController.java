package spring.mvc.security;
import javax.annotation.security.RolesAllowed;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecurityController {
	
	  //JSR Security
	  @RolesAllowed(value={"ROLE_SUPER_USER","ROLE_ADMIN"})
	  @RequestMapping(value="/adminOrSuperUserCanCall", method=RequestMethod.GET)
	  public ModelAndView adminOrSuperUserCanCall() {
		  System.out.println("SecurityController adminOrSuperUserCanCall JSR is called with ADMIN ROLE");
		  return new ModelAndView("/admin/admin");		  
	  }
	  
	  //Spring Security
	  //SpEL usage at method level security
	  @PreAuthorize("hasRole('ROLE_ADMIN') || hasRole('ROLE_SUPER_USER') || hasRole('ROLE_USER')")
	  @RequestMapping(value="/userOrAdminCanCallSpEL", method=RequestMethod.GET)
	  public ModelAndView userOrAdminCanCall() {
		  System.out.println("SecurityController userOrAdminCanCall is called with ROLE_ADMIN or ROLE_USER");
		  return new ModelAndView("/user/profile");
	  }
	  
	  //Spring Security
	  @Secured(value={"ROLE_ADMIN"})
	  @RequestMapping(value="/adminMethodSecured", method=RequestMethod.GET)
	  public ModelAndView adminMethodSecured() {
		  System.out.println("SecurityController adminMethodSecured is called with ADMIN ROLE");
		  return new ModelAndView("/admin/admin");
		  
	  }
	  
	  
	
}
