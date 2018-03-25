package com.tqminh.vn.toeicpractice.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tqminh.vn.toeicpractice.model.form.Register;

@Controller
public class RegisterController {
	
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
	
}
