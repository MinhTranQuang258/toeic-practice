package com.tqminh.vn.toeicpractice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value= {"/login", "/"}, method= RequestMethod.GET)
    public String login() {
        return "login";
    }
	
	@RequestMapping(value= "/register", method= RequestMethod.GET)
	public String register() {
		return "register";
	}
        
    @RequestMapping(value= "/question", method= RequestMethod.GET)
	public String question() {
		return "question";
	}
	
}
