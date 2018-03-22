package com.tqminh.vn.toeicpractice.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tqminh.vn.toeicpractice.model.Account;
import com.tqminh.vn.toeicpractice.model.form.Register;
import com.tqminh.vn.toeicpractice.services.impl.AccountServiceImpl;

@Controller
public class HomeController {
	
	@Autowired
	private AccountServiceImpl accountService;
	
	@RequestMapping(value= {"/displayLogin", "/"}, method= RequestMethod.GET)
    public String displayLogin(Model model) {
		model.addAttribute("account", new Account());
        return "login";
    }
	
	@RequestMapping(value= {"/login"}, method= RequestMethod.POST)
    public String login(@ModelAttribute("account") Account account, HttpSession httpSession) {
//		TODO: handling when the login button was clicked.
		String page= accountService.loginAccount(account);
		return page;
    }
	
	@RequestMapping(value= "/displayRegister", method= RequestMethod.GET)
	public String displayRegister(Model model) {
		model.addAttribute("register", new Register());
		return "register";
	}
	
	@RequestMapping(value= "/register", method= RequestMethod.POST)
	public String register(@ModelAttribute("register")Register register, HttpSession httpSession) {
		if(register.getPassword().equals(register.getRepassword())) {
//			TODO: defining register services.
			return null;
		}
		else {
//			TODO: handling when re-password incorrectly.
			return "";
		}
	}
    
    @RequestMapping(value= "/displayQuestion", method= RequestMethod.GET)
	public String displayQuestion() {
		return "question";
	}
    
}
