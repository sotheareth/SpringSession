package spring.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/main")
public class SringSession {

	private static final String NAME = "name";

	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	@ResponseBody
	public String hi(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		String name = "Word";
		if(session.getAttribute(NAME) !=  null){
			name = (String) session.getAttribute(NAME);
		}

		// create a greeting with the name
		String greeting = String.format("Hello %s!", name);

		return greeting;
	}

	@RequestMapping(value = "/hi", method = RequestMethod.POST)
	@ResponseBody
	public String postHi(HttpServletRequest req, HttpServletResponse resp) {
		String name = req.getParameter(NAME);
		// store the name variable as a session attribute
		req.getSession().setAttribute(NAME, name);
		return name;
	}
	
	
	@RequestMapping(value = "/test")
	public String test(HttpServletResponse response){
		return "test";
	}
}
