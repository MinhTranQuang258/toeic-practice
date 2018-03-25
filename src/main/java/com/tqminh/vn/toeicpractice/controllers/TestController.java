package com.tqminh.vn.toeicpractice.controllers;

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
import com.tqminh.vn.toeicpractice.services.QuestionService;

@RestController
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
//		MCQuestionWrapper questionWrapper=  repo.findQuestionById(1L);
		MCQuestionWrapper questionWrapper= mCQuestionWrapperRepository.findOne(5L);
		if(questionWrapper.getMultipleChoiceQuestion() == null) {
			System.out.println("Null");
		}
		return questionWrapper.getMultipleChoiceQuestion();
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
}
