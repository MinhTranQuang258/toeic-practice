package com.tqminh.vn.toeicpractice.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tqminh.vn.toeicpractice.model.Account;
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
    public String login(@ModelAttribute("account") Account account, HttpSession httpSession) throws Exception {
		httpSession.setAttribute("username", account.getUsername());
		String page= accountService.loginAccount(account);
		return page;
    }
}
