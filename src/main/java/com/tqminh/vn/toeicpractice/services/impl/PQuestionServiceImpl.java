package com.tqminh.vn.toeicpractice.services.impl;

import java.io.File;
import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tqminh.vn.toeicpractice.common.TypeDefinition;
import com.tqminh.vn.toeicpractice.configuration.GeneralConfiguration;
import com.tqminh.vn.toeicpractice.model.PhotoQuestion;
import com.tqminh.vn.toeicpractice.repositories.PQuestionWrapperRepository;
import com.tqminh.vn.toeicpractice.repositories.entities.PQuestionWrapper;
import com.tqminh.vn.toeicpractice.services.AbstractQuestionService;
import com.tqminh.vn.toeicpractice.services.PhotoService;
import com.tqminh.vn.toeicpractice.services.QuestionService;

@Service("PQuestionService")
public class PQuestionServiceImpl extends AbstractQuestionService 
implements QuestionService<PhotoQuestion>, PhotoService{
	
	@Autowired
	private PQuestionWrapperRepository repository;
	
	@Autowired
	private GeneralConfiguration configuration;
	
	private Queue<String> queue;
	
	@PostConstruct
	public void initialize() {
		queue = new ConcurrentLinkedQueue<>();
	}
	
	@Override
	public String insertQuestion(PhotoQuestion question) {
		try {
			if(isCheckQuestionInfo(question)) {
				PQuestionWrapper questionWrapper= new PQuestionWrapper(question);
				PQuestionWrapper pQuestionWrapper= repository.save(questionWrapper);
				if(pQuestionWrapper == null) {
					throw new NullPointerException("Can't insert the Photo Question.");
				}
			}
			else {
				throw new NullPointerException();
			}
		} catch (Exception e) {
			throw e;
		}
		return null;
	}
	
	private boolean isCheckQuestionInfo(PhotoQuestion photoQuestion) {
		if(photoQuestion != null) {
			if(photoQuestion.getAnswerA() != null && photoQuestion.getAnswerB() != null && photoQuestion.getAnswerC() != null 
					&& photoQuestion.getAnswerD() != null && photoQuestion.getAnswerTrue() != null) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
		
	}

	@Override
	public PhotoQuestion updateQuestion(long id) {
		// TODO: handle to update question if necessary.
		return null;
	}

	@Override
	public PhotoQuestion deleteQuestion(long id) {
		// TODO: handle to delete question if necessary.
		return null;
	}

	@Override
	public int countQuestion() {
		return super.countQuestion(TypeDefinition.PHOTO_QUESTION);
	}

	@Override
	public int nextQuestion(String username) throws Exception {
		return super.nextQuestion(username, TypeDefinition.PHOTO_QUESTION);
	}

	@Override
	public int previousQuestion(String username) throws Exception {
		return super.previousQuestion(username, TypeDefinition.PHOTO_QUESTION);
	}

	@Override
	public double validateQuestion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PhotoQuestion getQuestion(String username, int index) throws Exception {
		try {
			return (PhotoQuestion) super.getQuestion(username, index, TypeDefinition.PHOTO_QUESTION);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public String loadFilePatch() throws IOException {
		if(queue.isEmpty()) {
			readFile();
		    return queue.poll();		
		}
		else{
			String patch= queue.poll();
			if(patch != null) {
				return patch;
			}
			else {
				return null;
			}
		}
	}

	
	private Queue<String> readFile() throws IOException{
	        File[] files= new File(configuration.getPhotoPath()).listFiles();
	        for(File file : files){
	        	if(file.isFile()){
	        		queue.add(file.getAbsolutePath());
	        	}
	     }
	     return queue;
	 }

	@Override
	public int countPhoto() throws IOException {
		return readFile().size();
	}

	@Override
	public void submit(String username) {
		super.submit(username, TypeDefinition.PHOTO_QUESTION);
	}
}
