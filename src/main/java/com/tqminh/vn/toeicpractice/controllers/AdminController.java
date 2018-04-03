package com.tqminh.vn.toeicpractice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tqminh.vn.toeicpractice.common.Constant;
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
	public String displayAdminAddPage(Model model) {
		model.addAttribute("question", new Question());
		return Constant.Page.ADMIN_ADD_PAGE;
	}
	
	@RequestMapping(value= "/insertPQuestion", method= RequestMethod.POST)
	public void insertPQuestion() {
	    
	}
	
	@RequestMapping(value= "/insertMCQuestion", method= RequestMethod.POST)
    public void insertMCQuestion() {
        
    }
}
