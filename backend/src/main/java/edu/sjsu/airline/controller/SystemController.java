package edu.sjsu.airline.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin( origins = "*" )
public class SystemController {
	
	@RequestMapping(path = "/api/v1/login", method = RequestMethod.POST)
	public String login( ) { 
		
		return "Welcome";
		
	}
	
	@RequestMapping(path = "/api/v1/logout", method = RequestMethod.POST)
	public String logout( ) { 
		
		return "Logout";
		
	}
	
}
