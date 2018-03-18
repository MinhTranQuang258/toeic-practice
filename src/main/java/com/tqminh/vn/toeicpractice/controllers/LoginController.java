package com.tqminh.vn.toeicpractice.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tqminh.vn.toeicpractice.model.Account;

@Controller
public class LoginController {
	
	@RequestMapping(value= {"/login", "/"}, method= RequestMethod.GET)
    public String loadLogin(Model model) {
		model.addAttribute("account", new Account());
        return "login";
    }
	
	@RequestMapping(value= "/login", method= RequestMethod.POST)
	public void loginButtion(@ModelAttribute("account")Account account) {
		
		try {
			System.out.println(account.getUserName());
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
