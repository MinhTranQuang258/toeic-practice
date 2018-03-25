package com.tqminh.vn.toeicpractice.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tqminh.vn.toeicpractice.model.Account;
import com.tqminh.vn.toeicpractice.model.MultipleChoiceQuestion;
import com.tqminh.vn.toeicpractice.model.PhotoQuestion;
import com.tqminh.vn.toeicpractice.services.AccountService;
import com.tqminh.vn.toeicpractice.services.QuestionService;

@Controller
public class QuetionController {
	
	@Autowired
	@Qualifier("MCQuestionService")
	private QuestionService<MultipleChoiceQuestion> mcQuestionService;

	@Autowired
	@Qualifier("PQuestionService")
	private QuestionService<PhotoQuestion> pQuestionService;
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value= "/displayQuestion", method= RequestMethod.GET)
	public String displayQuestion(HttpSession session) {
		return "question";
	}
	
	@RequestMapping(value= "/logOut", method= RequestMethod.GET)
	public String logOut(HttpSession session, Model model) {
		String username= (String) session.getAttribute("username");
		accountService.logout(username);
		model.addAttribute("account", new Account());
		return "login";
	}
	
	@RequestMapping(value= "/grammer", method= RequestMethod.GET)
	public String getGrammer(Model model) throws Exception {
		
		model.addAttribute("question", mcQuestionService.getQuestion(1));
		return "question";
	}
}
