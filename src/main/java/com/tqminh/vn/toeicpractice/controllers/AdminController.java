package com.tqminh.vn.toeicpractice.controllers;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.tqminh.vn.toeicpractice.model.mapping.Question;
import com.tqminh.vn.toeicpractice.repositories.entities.MCQuestionWrapper;
import com.tqminh.vn.toeicpractice.services.QuestionService;
import com.tqminh.vn.toeicpractice.services.QuestionWrapperService;

@Controller
public class AdminController {
    
    private Map<String, Object> map= new HashMap<>();
    
    @Autowired
    @Qualifier("MCQuestionService")
    private QuestionService<MultipleChoiceQuestion> mcQuestionService;
    
    @Autowired
    @Qualifier("MCQuestionWrapperService")
    private QuestionWrapperService mcQuestionWrapperService;

    @Autowired
    @Qualifier("PQuestionService")
    private QuestionService<PhotoQuestion> pQuestionService;
	
	@RequestMapping(value= "/admin", method= RequestMethod.GET)
	public String displayAdminPage() {
		return Constant.Page.ADMIN_HOME_PAGE;
	}
	
	@RequestMapping(value= "/adminEdit", method= RequestMethod.GET)
	public String displayAdminEditPage(Model model, HttpSession session) {
		String username= (String)session.getAttribute("username");
		List<MCQuestionWrapper> questions = null;
		try {
			questions = mcQuestionWrapperService.findAllQuestionWarraper(username);
			model.addAttribute("questions", questions);
	        model.addAttribute("question", new Question());
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Constant.Page.ADMIN_EDIT_PAGE;
	}
	
	@RequestMapping(value= "/adminAdd", method= RequestMethod.GET)
	public String displayAdminAddPage() {
	    return Constant.Page.ADMIN_ADD_PAGE;
	}
	
	@RequestMapping(value= "/displayAdminAddGrammar", method= RequestMethod.GET)
	public String displayAdminAddGrammarPage(Model model) {
		model.addAttribute("question", new Question());
		return Constant.Page.ADMIN_ADD_GRAMMAR_PAGE;
	}
        
    @RequestMapping(value= "/displayAdminAddListening", method= RequestMethod.GET)
	public String displayAdminAddListeningPage(Model model) {
		model.addAttribute("question", new Question());
		return Constant.Page.ADMIN_ADD_LISTENING_PAGE;
	}
	
    @RequestMapping(value= "/displayAdminAddReading", method= RequestMethod.GET)
	public String displayAdminAddReadingPage(Model model) {
		model.addAttribute("question", new Question());
		return Constant.Page.ADMIN_ADD_READING_PAGE;
	}
    
    @RequestMapping(value= "/admin/grammar", method= RequestMethod.GET)
    public String displayAdminQuestionGrammar(Model model, HttpSession session) {
        String username= (String)session.getAttribute("username");
        MultipleChoiceQuestion question;
        try {
            question = mcQuestionService.getQuestion(username, 1);
            model.addAttribute("question", question);
            map.put("question", question);
        }
        catch (Exception e) {

            e.printStackTrace();
        }
        
        return Constant.Page.ADMIN_QUESTION_GRAMMAR_PAGE;
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
	
	@RequestMapping(value= "/deleteQuestion", method= RequestMethod.POST)
	public String deteleQuestion(HttpSession session) {
		String username= (String)session.getAttribute("username");
		try {
			mcQuestionService.deleteQuestion(4, username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:/adminEdit";
	}
	
	@RequestMapping(value= "/insertMCQuestion", method= RequestMethod.POST)
    public String insertMCQuestion(@ModelAttribute("question") Question question, HttpServletRequest request) {
	    String radio= request.getParameter("rightAnswer");
	    MultipleChoiceQuestion multipleChoiceQuestion= (MultipleChoiceQuestion)prepareQuestion(radio, question);
	    mcQuestionService.insertQuestion(multipleChoiceQuestion);
        return "redirect:/displayAdminAddGrammar";
    }
	
	@RequestMapping(value= "/updateMCQuestion", method= RequestMethod.POST)
	public String updateQuestion(@ModelAttribute("question") Question question, HttpSession session, HttpServletRequest request) {
		System.out.println("minh");
		String radio= request.getParameter("rightAnswer");
		String username= (String)session.getAttribute("username");
		AbstractQuestion multipleChoiceQuestion= prepareQuestion(radio, question);
		try {
			mcQuestionService.updateQuestion(1, multipleChoiceQuestion, username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:/adminEdit";
	}
	
	@RequestMapping(value= "/admin/validate" , method= RequestMethod.POST)
    public String validate(HttpServletRequest servletRequest, HttpSession session) throws Exception {
        String username= (String)session.getAttribute("username");
        String selection= servletRequest.getParameter("answerGroup");
        AbstractQuestion question= (AbstractQuestion) map.get("question");
        mcQuestionService.validateQuestion(username, question, selection);
        
        return "redirect:/admin/nextMCQuestion";
    }
	
	@RequestMapping(value= "/admin/nextMCQuestion", method= RequestMethod.GET)
    public String nextQuestion(HttpSession session, Model model) throws Exception {
        String username= (String) session.getAttribute("username");
        int index= mcQuestionService.nextQuestion(username);
        
        MultipleChoiceQuestion question= mcQuestionService.getQuestion(username, index);
        
        model.addAttribute("question", question);
        map.put("question", question);
        return Constant.Page.ADMIN_QUESTION_GRAMMAR_PAGE;
    }
	
	@RequestMapping(value= "/admin/submitMCQuestion", method= RequestMethod.POST)
    public String submit() {
        return null;
    }
}
