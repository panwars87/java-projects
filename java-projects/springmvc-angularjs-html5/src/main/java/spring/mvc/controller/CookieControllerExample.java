package spring.mvc.controller;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CookieControllerExample {
	
	@RequestMapping(value = "/readcookie", method=RequestMethod.GET)
    public ModelAndView readCookie(@CookieValue(value = "URL") String URL, HttpServletRequest request,
        HttpServletResponse response) {		
		System.out.println("CookieControllerExample readcookie is called");
		return new ModelAndView("/cookie/cookieView", "cookieValue", URL);
 
    }
	@RequestMapping(value = "/writecookie", method=RequestMethod.GET)
    public String writeCookie(HttpServletRequest request,
        HttpServletResponse response) {		
		
		System.out.println("CookieControllerExample writeCookie is called");
        Cookie cookie = new Cookie("URL", request.getRequestURL().toString());
        response.addCookie(cookie);
        return "/cookie/cookieView";
 
    }


	@RequestMapping(value = "/readAllCookies", method=RequestMethod.GET)
    public ModelAndView readAllCookies(HttpServletRequest request) {		
		System.out.println("CookieControllerExample readAllCookies is called");
		
		Cookie[] cookies = request.getCookies();
		System.out.println("All Cookies in your browsers");
		String cookiesStr = "";
		for(Cookie cookie : cookies){
			System.out.println(cookie.getName() + " : " + cookie.getValue());
			cookiesStr += cookie.getName() + " : " + cookie.getValue() + "<br/>";
		}
	
		
		return new ModelAndView("/cookie/cookieView", "cookieValue", cookiesStr);
 
    }
	
}
