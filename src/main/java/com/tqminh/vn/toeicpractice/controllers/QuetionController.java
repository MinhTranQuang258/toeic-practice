package com.tqminh.vn.toeicpractice.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tqminh.vn.toeicpractice.common.Constant;
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
	
	@RequestMapping(value= "/logOut", method= RequestMethod.GET)
	public String logOut(HttpSession session, Model model) {
		String username= (String) session.getAttribute("username");
		accountService.logout(username);
		model.addAttribute("account", new Account());
		return "login";
	}
	
	@RequestMapping(value= "/grammer", method= RequestMethod.GET)
	public String getGrammer(Model model, HttpSession session) throws Exception {
		String username= (String)session.getAttribute("username");
		model.addAttribute("question", mcQuestionService.getQuestion(username, 1));
		return Constant.Page.USER_GRAMMER_PAGE;
	}
	
	@RequestMapping(value= "/photo", method= RequestMethod.GET)
	public String getPhoto(Model model) {
	    return null;
	}
	
	@RequestMapping(value= "/nextQuestion", method= RequestMethod.GET)
	public String nextQuestion(HttpSession session, Model model) throws Exception {
	    try {
	    	System.out.println("next");
	    	String username= (String)session.getAttribute("username");
			int index = mcQuestionService.nextQuestion(username);
			model.addAttribute("question", mcQuestionService.getQuestion(username, index));
			return Constant.Page.USER_GRAMMER_PAGE;
		} catch (Exception e) {
			throw e;
		}
	}
	
	@RequestMapping(value= "/backQuestion", method= RequestMethod.GET)
    public String backQuestion(HttpSession session, Model model) throws Exception{
        try {
        	System.out.println("back");
        	String username= (String)session.getAttribute("username");
			int index = mcQuestionService.previousQuestion(username);
			model.addAttribute("question", mcQuestionService.getQuestion(username, index));
			return Constant.Page.USER_GRAMMER_PAGE;
		} catch (Exception e) {
			throw e;
		}
    }
	
	@RequestMapping(value= "/submit", method= RequestMethod.POST)
	public void submit() {
	    
	}
}
