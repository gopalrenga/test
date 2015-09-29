package com.verizon.vzforum.controller;
 
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.verizon.vzforum.model.Login;
import com.verizon.vzforum.service.LoginService;

@Controller
@RequestMapping("/vzw")
public class WelcomeController {
 
	@Autowired
	LoginService loginService;
	
	private final static Logger logger = LoggerFactory.getLogger(WelcomeController.class);
 
	@RequestMapping(value = "/login", method = RequestMethod.POST,produces="application/json")
	public @ResponseBody  String welcome(@RequestBody Login login) {
		JSONObject responseObj=loginService.doLoginCheck(login);
 
		return responseObj.toString();
 
	}
	
	@RequestMapping(value = "/dologin", method = RequestMethod.GET,produces="application/json")
	public @ResponseBody  String test() {
 
		return "{ 'status':'sucess'}";
 
	}
	
	
 
	
 
}