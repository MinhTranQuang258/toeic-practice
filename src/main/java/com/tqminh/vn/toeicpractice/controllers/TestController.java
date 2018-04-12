package com.tqminh.vn.toeicpractice.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tqminh.vn.toeicpractice.model.Account;
import com.tqminh.vn.toeicpractice.model.MultipleChoiceQuestion;
import com.tqminh.vn.toeicpractice.model.PhotoQuestion;
import com.tqminh.vn.toeicpractice.repositories.AccountWrapperRepository;
import com.tqminh.vn.toeicpractice.repositories.MCQuestionWrapperRepository;
import com.tqminh.vn.toeicpractice.repositories.PQuestionWrapperRepository;
import com.tqminh.vn.toeicpractice.repositories.entities.AccountWrapper;
import com.tqminh.vn.toeicpractice.repositories.entities.MCQuestionWrapper;
import com.tqminh.vn.toeicpractice.repositories.entities.PQuestionWrapper;
import com.tqminh.vn.toeicpractice.services.PhotoService;
import com.tqminh.vn.toeicpractice.services.QuestionService;
import org.springframework.stereotype.Controller;

//@RestController
@Controller
public class TestController {
	
	@Autowired
	@Qualifier("MCQuestionService")
	private QuestionService<MultipleChoiceQuestion> mcQuestionService;
	
	@Autowired
	private AccountWrapperRepository aRepo;
	
	@Autowired
	private MCQuestionWrapperRepository mCQuestionWrapperRepository;
	
	@Autowired
	private PQuestionWrapperRepository pQuestionWrapperRepository;

	@Autowired
	private PhotoService photoService;
	
	@RequestMapping("/save")
	public String save() {
		MultipleChoiceQuestion question= new MultipleChoiceQuestion();
		question.setAnswerA("a");
		question.setAnswerB("b");
		question.setAnswerC("c");
		question.setAnswerD("d");
		question.setDetailQuestion("abcd");
		mcQuestionService.insertQuestion(question);
		return "Done";
	}
	
	@RequestMapping(value= "/get", method= RequestMethod.GET)
	public MultipleChoiceQuestion getGrammer(Model model) throws Exception {
		MultipleChoiceQuestion question=  mcQuestionService.getQuestion("",1);
//		MCQuestionWrapper questionWrapper= mCQuestionWrapperRepository.findOne(5L);
		if(question == null) {
			System.out.println("Null");
		}
		return question;
	}
	
	@RequestMapping("/saveA")
	public void saveA() {
		Account account= new Account();
		account.setAge(22);
		account.setName("M");
		account.setUsername("123");
		account.setPassword("123");
		AccountWrapper accountWrapper= new AccountWrapper(account);
		aRepo.save(accountWrapper);
	}
	
	@RequestMapping("/getA")
	public Account get() {
		return aRepo.findOne(1L).getAccount();
	}
	
	@RequestMapping("/saveP")
	public void saveP() {
		PhotoQuestion question= new PhotoQuestion();
		question.setAnswerA("a");
		question.setAnswerB("b");
		question.setAnswerC("c");
		question.setAnswerD("d");
		question.setPhoto("abcd");
		PQuestionWrapper questionWrapper= new PQuestionWrapper(question);
		pQuestionWrapperRepository.save(questionWrapper);
	}
	
	@RequestMapping("/getP")
	public PhotoQuestion getP() {
		return pQuestionWrapperRepository.findOne(1L).getPhotoQuestion();
	}
        
        @RequestMapping(value= "/adminq", method= RequestMethod.GET)
	public String showQ() {
		return "question";
	}
        
        @RequestMapping(value= "/admin/grammar", method= RequestMethod.GET)
	public String showAdminQuestionGrammar() {
		return "adminQuestionGrammar";
	}
	
        @RequestMapping(value= "/admin/listening", method= RequestMethod.GET)
	public String showAdminQuestionListening() {
		return "adminQuestionListening";
	}
        
        @RequestMapping(value= "/admin/reading", method= RequestMethod.GET)
	public String showAdminQuestionReading() {
		return "adminQuestionReading";
	}
        
        @RequestMapping(value= "/grammar", method= RequestMethod.GET)
	public String showQuestionGrammar() {
		return "questionGrammar";
	}
	
        @RequestMapping(value= "/listening", method= RequestMethod.GET)
	public String showQuestionListening() {
		return "questionListening";
	}
        
        @RequestMapping(value= "/reading", method= RequestMethod.GET)
	public String showQuestionReading() {
		return "questionReading";
	}
        
	@RequestMapping("/getString")
	public String getString() throws IOException {
	    try {
	        return photoService.loadFilePatch();
        }
        catch (Exception e) {
            throw e;
        }
	}
}
