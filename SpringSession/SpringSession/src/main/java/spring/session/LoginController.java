package spring.session;

import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class LoginController {
	
	@Autowired
	private ApplicationContext context;

	@RequestMapping(value = "/login", method= RequestMethod.GET)
	public String login(HttpServletResponse response){
		
		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		for(String bean: beanDefinitionNames) {
			System.out.println(bean);
		}
		
		
		return "login";
	}
	
	@RequestMapping(value = "/fail", method= RequestMethod.POST)
	public String fail(HttpServletResponse response){
		return "fail";
	}
	
	
	@RequestMapping(value = "/success", method= RequestMethod.POST)
	public String success(HttpServletResponse response){
		return "success";
	}
	
	@RequestMapping(value = "/logout", method= RequestMethod.POST)
	public String logout(HttpServletResponse response){
		return "login";
	}
}