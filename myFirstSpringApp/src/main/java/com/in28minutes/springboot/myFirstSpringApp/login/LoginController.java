package com.in28minutes.springboot.myFirstSpringApp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	// logger level is defined in application file, like info, warn, debug
//	private Logger logger = LoggerFactory.getLogger(getClass());
	// http://localhost:8080/login?name=Steve
//	@RequestMapping("login")
//	public String sayHelloJsp(@RequestParam String name, String age, ModelMap model) {
//		model.put("name", name);
//		model.put("age", age);
////		logger.debug("Request params are name: {} age: {}",name, age);
//		return "login";
//	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String goToWelcomePage(@RequestParam String name, String password, ModelMap model) {
		model.put("name", name);
		model.put("password", password);
		return "welcome";
	}

}
