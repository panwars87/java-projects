package spring.mvc.form;

import javax.validation.Valid;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import spring.mvc.validator.RegisterBeanValidator;

@Controller
@RequestMapping("/registerForm")
@SessionAttributes("registerBean")
public class RegisterFormController {

	 @ModelAttribute("registerBean")
	 public Register createRegisterFormBean() {
	 	return new Register();
	 }

	 @RequestMapping(method=RequestMethod.GET)  
	 public ModelAndView registerForm() {  
		 return new ModelAndView("form/register"); 
	 }  
	 
	 @RequestMapping(method=RequestMethod.POST)
	 public ModelAndView processSubmit(@ModelAttribute("registerBean") @Valid Register registerBean, 
			 						   BindingResult result, Model model, RedirectAttributes redirectAttrs) {
			
			System.out.println("RegisterFormController post called");
			System.out.println("Validation result: " + result);
			
			if (result.hasErrors()) {
				return new ModelAndView("form/register"); 
			}
				return new ModelAndView("success/success","message","Registered");  
		}
	  
	 @RequestMapping(value="/passwordValidator", method=RequestMethod.POST)
	 public ModelAndView passwordValidator(@ModelAttribute("registerBean") Register registerBean, BindingResult result)
	    throws Exception
	  {
		 
		RegisterBeanValidator registerBeanValidator = new RegisterBeanValidator();
		registerBeanValidator.validate(registerBean, result);
		
		System.out.println("registerBeanValidator hasErrors(): "+ result.hasErrors());
		
		if (result.hasErrors()) {
			return new ModelAndView("form/register"); 
		}
			return new ModelAndView("success/success","message","Registered"); 
	    
	  }


}
