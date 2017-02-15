package spring.mvc.orm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.bean.User;

@Controller
public class ORMContoller {
	
	@Autowired
	private ORMExample ormExample;

	@RequestMapping(value = "/ormFindAllUsers", method=RequestMethod.GET)
    public ModelAndView ormFindAllUsers() {		
		System.out.println("ORMContoller ormFindAllUsers is called");
		List<User> users = ormExample.queryfindAllUsersJPA();		
		return new ModelAndView("/orm/orm", "users", users);
    }
	
	@RequestMapping(value = "/ormUpdateUser/iduser/{iduser}/enabled/{enabled}", method=RequestMethod.GET)
	public ModelAndView ormUpdateUser(
    		@PathVariable(value="iduser") int iduser, 
    		@PathVariable(value="enabled") boolean enabled) {				
		System.out.println("ORMContoller ormUpdateUser is called");
		boolean result = ormExample.updateUser(iduser, enabled);
        return new ModelAndView("/orm/orm", "result", result);
 
    }

	@RequestMapping(value = "/ormDeleteUser/iduser/{iduser}", method=RequestMethod.GET)
    public ModelAndView ormDeleteUser(@PathVariable(value="iduser") int iduser) {		
		System.out.println("ORMContoller jdbcDelete is called");
		boolean result = ormExample.deleteUser(iduser);
		return new ModelAndView("/orm/orm", "result", result);
    }
	
	@RequestMapping(value = "/ormInsertUser/username/{username}/password/{password}/enabled/{enabled}", method=RequestMethod.GET)
    public ModelAndView ormInsertUser(
    		@PathVariable(value="username") String username, 
    		@PathVariable(value="password") String password, 
    		@PathVariable(value="enabled") boolean enabled) {				
		System.out.println("ORMContoller ormInsertUser is called");
		boolean result = ormExample.insertUser(username, password, enabled);
        return new ModelAndView("/orm/orm", "result", result);
 
    }
	
}
