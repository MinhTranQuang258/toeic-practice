package com.tqminh.vn.toeicpractice.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tqminh.vn.toeicpractice.common.Constant;
import com.tqminh.vn.toeicpractice.model.AbstractQuestion;
import com.tqminh.vn.toeicpractice.model.MultipleChoiceQuestion;
import com.tqminh.vn.toeicpractice.model.PhotoQuestion;
import com.tqminh.vn.toeicpractice.model.form.Question;
import com.tqminh.vn.toeicpractice.services.QuestionService;

@Controller
public class AdminController {
    
    @Autowired
    @Qualifier("MCQuestionService")
    private QuestionService<MultipleChoiceQuestion> mcQuestionService;

    @Autowired
    @Qualifier("PQuestionService")
    private QuestionService<PhotoQuestion> pQuestionService;
	
	@RequestMapping(value= "/displayAdmin", method= RequestMethod.GET)
	public String displayAdminPage(Model model) {
		model.addAttribute("question", new Question());
		return Constant.Page.ADMIN_PAGE;
	}
	
	@RequestMapping(value= "/displayAdminEdit", method= RequestMethod.GET)
	public String displayAdminEditPage() {
		return Constant.Page.ADMIN_EDIT_PAGE;
	}
	
	@RequestMapping(value= "/displayAdminAdd", method= RequestMethod.GET)
	public String displayAdminAdd() {
	    return Constant.Page.ADMIN_ADD_PAGE;
	}
	
	@RequestMapping(value= "/displayAdminAddGrammar", method= RequestMethod.GET)
	public String displayAdminAddGrammarPage(Model model) {
		model.addAttribute("question", new Question());
		return Constant.Page.ADMIN_ADD_GRAMMAR;
	}
        
        @RequestMapping(value= "/displayAdminAddListening", method= RequestMethod.GET)
	public String displayAdminAddListeningPage(Model model) {
		model.addAttribute("question", new Question());
		return Constant.Page.ADMIN_ADD_LISTENING;
	}
	
        @RequestMapping(value= "/displayAdminAddReading", method= RequestMethod.GET)
	public String displayAdminAddReadingPage(Model model) {
		model.addAttribute("question", new Question());
		return Constant.Page.ADMIN_ADD_READING;
	}
        
	@RequestMapping(value= "/insertPQuestion", method= RequestMethod.POST)
	public void insertPQuestion() {
	    
	}
	
	private AbstractQuestion prepareQuestion(String radio, Question question) {
	    MultipleChoiceQuestion multipleChoiceQuestion= new MultipleChoiceQuestion();
	    multipleChoiceQuestion.setDetailQuestion(question.getDetailQuestion());
	    multipleChoiceQuestion.setAnswerA(question.getAnswerA());
	    multipleChoiceQuestion.setAnswerB(question.getAnswerB());
	    multipleChoiceQuestion.setAnswerC(question.getAnswerC());
	    multipleChoiceQuestion.setAnswerD(question.getAnswerD());
	    if(radio.equals("A")) {
	        multipleChoiceQuestion.setAnswerTrue(question.getAnswerA());
	        return multipleChoiceQuestion;
	    }
	    else if(radio.equals("B")) {
	        multipleChoiceQuestion.setAnswerTrue(question.getAnswerB());
            return multipleChoiceQuestion;    
	    }
	    else if (radio.equals("C")) {
	        multipleChoiceQuestion.setAnswerTrue(question.getAnswerC());
            return multipleChoiceQuestion;
        }
	    else {
	        multipleChoiceQuestion.setAnswerTrue(question.getAnswerD());
            return multipleChoiceQuestion;
	    }
	    
	}
	
	@RequestMapping(value= "/insertMCQuestion", method= RequestMethod.POST)
    public String insertMCQuestion(@ModelAttribute("question") Question question, Model model, HttpServletRequest request) {
	    String radio= request.getParameter("rightAnswer");
	    MultipleChoiceQuestion multipleChoiceQuestion= (MultipleChoiceQuestion)prepareQuestion(radio, question);
	    mcQuestionService.insertQuestion(multipleChoiceQuestion);
        return displayAdminAddGrammarPage(model);
    }
}
