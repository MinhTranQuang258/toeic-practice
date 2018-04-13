package com.tqminh.vn.toeicpractice.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tqminh.vn.toeicpractice.model.Account;
import com.tqminh.vn.toeicpractice.model.mapping.Register;
import com.tqminh.vn.toeicpractice.services.AccountService;

@Controller
public class RegisterController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private HomeController homeController;
	
	@RequestMapping(value= "/displayRegister", method= RequestMethod.GET)
	public String displayRegister(Model model) {
		model.addAttribute("register", new Register());
		return "register";
	}
	
	@RequestMapping(value= "/register", method= RequestMethod.POST)
	public String register(@ModelAttribute("register")Register register, HttpSession httpSession, Model model) {
		Account account= new Account(register.getName(), register.getAge(), register.getUsername(), register.getPassword());
		if(register.getPassword().equals(register.getRepassword())) {
			accountService.registerAccount(account);
			return homeController.displayLogin(model);
		}
		else {
//			TODO: handling when re-password incorrectly.
//			return "";
		}
		return null;
	}
	
}
