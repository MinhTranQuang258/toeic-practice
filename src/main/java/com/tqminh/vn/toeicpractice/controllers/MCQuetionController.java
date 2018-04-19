package com.tqminh.vn.toeicpractice.controllers;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tqminh.vn.toeicpractice.common.Constant;
import com.tqminh.vn.toeicpractice.model.AbstractQuestion;
import com.tqminh.vn.toeicpractice.model.MultipleChoiceQuestion;
import com.tqminh.vn.toeicpractice.services.QuestionService;

@Controller
public class MCQuetionController {
    
    private Map<String, Object> map= new HashMap<>();
	
	@Autowired
	@Qualifier("MCQuestionService")
	private QuestionService<MultipleChoiceQuestion> mcQuestionService;

	
	@RequestMapping(value= "/grammar", method= RequestMethod.GET)
	public String getGrammer(Model model, HttpSession session) throws Exception {
		String username= (String)session.getAttribute("username");
		MultipleChoiceQuestion question= mcQuestionService.getQuestion(username, 1);
		model.addAttribute("question", question);
		map.put("question", question);
		return Constant.Page.USER_GRAMMAR_PAGE;
	}
	
	@RequestMapping(value= "/validate" , method= RequestMethod.POST)
    public String validate(HttpServletRequest servletRequest, HttpSession session) throws Exception {
		String username= (String)session.getAttribute("username");
        String selection= servletRequest.getParameter("answerGroup");
        AbstractQuestion question= (AbstractQuestion) map.get("question");
        mcQuestionService.validateQuestion(username, question, selection);
        
        return "redirect:/nextMCQuestion";
    }
	
	@RequestMapping(value= "/nextMCQuestion", method= RequestMethod.GET)
	public String nextQuestion(HttpSession session, Model model) throws Exception {
		String username= (String) session.getAttribute("username");
		int index= mcQuestionService.nextQuestion(username);
		
		MultipleChoiceQuestion question= mcQuestionService.getQuestion(username, index);
		
		model.addAttribute("question", question);
		map.put("question", question);
		return Constant.Page.USER_GRAMMAR_PAGE;
	}

	@RequestMapping(value= "/submitMCQuestion", method= RequestMethod.POST)
	public String submit(HttpSession session) {
	    String username= (String) session.getAttribute("username");
	    try {
            mcQuestionService.submit(username);
        }
        catch (ParseException | SQLException e) {
            e.printStackTrace();
        }
	    return "redirect:/";
	}
}
