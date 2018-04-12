package com.tqminh.vn.toeicpractice.services;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.tqminh.vn.toeicpractice.cache.IndexCache;
import com.tqminh.vn.toeicpractice.cache.QuestionListCache;
import com.tqminh.vn.toeicpractice.common.Constant;
import com.tqminh.vn.toeicpractice.common.TypeDefinition;
import com.tqminh.vn.toeicpractice.configuration.GeneralConfiguration;
import com.tqminh.vn.toeicpractice.model.AbstractQuestion;
import com.tqminh.vn.toeicpractice.model.MultipleChoiceQuestion;
import com.tqminh.vn.toeicpractice.model.PhotoQuestion;
import com.tqminh.vn.toeicpractice.model.list.MCQuestionList;
import com.tqminh.vn.toeicpractice.model.list.PQuestionList;
import com.tqminh.vn.toeicpractice.repositories.MCQuestionWrapperRepository;
import com.tqminh.vn.toeicpractice.repositories.PQuestionWrapperRepository;
import com.tqminh.vn.toeicpractice.repositories.entities.MCQuestionWrapper;
import com.tqminh.vn.toeicpractice.repositories.entities.PQuestionWrapper;

public abstract class AbstractQuestionService {
	
	@Autowired
	private MCQuestionWrapperRepository mcQuestionRepository;
	
	@Autowired
	private PQuestionWrapperRepository pQuestionRepository;
	
	@Autowired
	@Qualifier("MCQuestionListCache")
	private QuestionListCache<MCQuestionList> mcCache;
	
	@Autowired
	@Qualifier("PQuestionListCache")
	private QuestionListCache<PQuestionList> pCache;
	
	@Autowired
	@Qualifier("IndexCache")
	private IndexCache<Long> indexCache;
	
	@Autowired
	private GeneralConfiguration configuration;
	
	private Boolean isCheckNextQuestionIndex(int index, Integer typeQuestion) throws NullPointerException{
		switch (typeQuestion) {
		case 1:
			if(index >= Constant.QuestionLimit.MC_QUESTION_LIMIT) {
				return false;
			}
			else {
				return true;
			}
		case 2:
			if(index >= Constant.QuestionLimit.P_QUESTION_LIMIT) {
				return false;
			}
			else {
				return true;
			}
		default:
			return null;
		}
	}
	
	private Boolean isCheckPreviousQuestionIndex(int index, Integer typeQuestion) throws NullPointerException{
		switch (typeQuestion) {
		case 1:
			if(index <= Constant.LimitIndex.MIN_MC_QUESTION_INDEX) {
				return false;
			}
			else {
				return true;
			}
		case 2:
			if(index <= Constant.LimitIndex.MIN_PHOTO_QUESTION_INDEX) {
				return false;
			}
			else {
				return true;
			}
		default:
			return null;
		}
	}
	
	protected Integer nextQuestion(String username, Integer typeQuestion) throws Exception{
		if(typeQuestion == TypeDefinition.MULTIPLE_CHOICE_QUESTION) {
			MCQuestionList mcQuestionList= mcCache.getQuestionList(username);
			int concurrentIndex= mcQuestionList.getConcurrentIndex();
			
			if(isCheckNextQuestionIndex(concurrentIndex, typeQuestion)) {
			    mcQuestionList.setConcurrentIndex(concurrentIndex + 1);
				return mcQuestionList.getConcurrentIndex();
			}
			else {
			    return mcQuestionList.getConcurrentIndex();
			}
		}
		else if(typeQuestion == TypeDefinition.PHOTO_QUESTION) {
			PQuestionList pQuestionList= pCache.getQuestionList(username);
			int concurrentIndex= pQuestionList.getConcurrentIndex();
			
			if(isCheckNextQuestionIndex(concurrentIndex, typeQuestion)) {
			    pQuestionList.setConcurrentIndex(concurrentIndex + 1);
				return pQuestionList.getConcurrentIndex();
			}
			else {
			    return pQuestionList.getConcurrentIndex();
			}
		}
		return null;
	}
	
	protected Integer previousQuestion(String username, Integer typeQuestion) throws Exception{
		if(typeQuestion == TypeDefinition.MULTIPLE_CHOICE_QUESTION) {
			MCQuestionList mcQuestionList= mcCache.getQuestionList(username);
			int concurrentIndex= mcQuestionList.getConcurrentIndex();
			
			if(isCheckPreviousQuestionIndex(concurrentIndex, typeQuestion)) {
			    mcQuestionList.setConcurrentIndex(concurrentIndex - 1);
				return mcQuestionList.getConcurrentIndex();
			}
			else {
			    return mcQuestionList.getConcurrentIndex();
			}
		}
		else if(typeQuestion == TypeDefinition.PHOTO_QUESTION) {
			PQuestionList pQuestionList= pCache.getQuestionList(username);
			int concurrentIndex= pQuestionList.getConcurrentIndex();
			
			if(isCheckPreviousQuestionIndex(concurrentIndex, typeQuestion)) {
			    pQuestionList.setConcurrentIndex(concurrentIndex - 1);
				return pQuestionList.getConcurrentIndex();
			}
			else {
			    return pQuestionList.getConcurrentIndex();
			}
		}
		return null;
	}
	
	protected AbstractQuestion getQuestion(String username, int index, Integer typeQuestion) throws Exception{
		try {
			if(typeQuestion == TypeDefinition.MULTIPLE_CHOICE_QUESTION) {
				saveCache(username, typeQuestion, index);
				return loadMCQuestions(username, index);
			}
			else if(typeQuestion == TypeDefinition.PHOTO_QUESTION) {
				saveCache(username, typeQuestion, index);
				return loadPQuestions(username, index);
			}
		}
		catch (Exception e) {
			throw e;
		}
		return null;
	}
	
	private MultipleChoiceQuestion loadMCQuestions(String username, int index) throws Exception{
		MultipleChoiceQuestion question= loadMCQuestionList(username).getQuestions().get(index);
		return question;
	}
	
	private PhotoQuestion loadPQuestions(String username, int index) throws Exception{
		PhotoQuestion question= loadPQuestionList(username).getQuestions().get(index);
		return question;
	}
	
	private MCQuestionList loadMCQuestionList(String username) {
		MCQuestionList questionList= mcCache.getQuestionList(username);
		return questionList;
	}
	
	private PQuestionList loadPQuestionList(String username) {
		PQuestionList questionList= pCache.getQuestionList(username);
		return questionList;
	}
	
	protected void saveCache(String username, Integer typeQuestion, int index) throws Exception {
		if(typeQuestion == TypeDefinition.MULTIPLE_CHOICE_QUESTION) {
			if(!mcCache.isCheckUsername(username)) {
				MCQuestionList questionList= getMCQuestionList(username, typeQuestion);
				questionList.setConcurrentIndex(index);
				mcCache.putQuestionList(username, questionList);
			}
		}
		else if(typeQuestion == TypeDefinition.PHOTO_QUESTION){
			if(!pCache.isCheckUsername(username)) {
				PQuestionList questionList= getPQuestionList(username, typeQuestion);
				questionList.setConcurrentIndex(index);
				pCache.putQuestionList(username, questionList);
			}
		}	
	}
	
	private MCQuestionList getMCQuestionList(String username, Integer typeQuestion) throws Exception{
		Random random= new Random();
		List<MultipleChoiceQuestion> list= new LinkedList<>();
		Set<Long> set= new HashSet<>();
		int count = countQuestion(typeQuestion);
		indexCache.setIndex(username, set);
		
		while(list.size() <= Constant.QuestionLimit.MC_QUESTION_LIMIT) {
			long index= random.nextInt(count);
			if(!indexCache.isCheckIndex(username, index)) {
				continue;
			}
			else {
				MCQuestionWrapper questionWrapper= mcQuestionRepository.findOne(index);
				list.add(questionWrapper.getMultipleChoiceQuestion());
			}
		}
		MCQuestionList questions= new MCQuestionList(list);
		return questions;
	}
	
	private PQuestionList getPQuestionList(String username, Integer typeQuestion) throws Exception{
		Random random= new Random();
		List<PhotoQuestion> list= new LinkedList<>();
		Set<Long> set= new HashSet<>();
		int count = countQuestion(typeQuestion);
		indexCache.setIndex(username, set);
		
		while(list.size() == Constant.QuestionLimit.MC_QUESTION_LIMIT) {
			long index= random.nextInt(count);
			if(!indexCache.isCheckIndex(username, index)) {
				continue;
			}
			else {
				PQuestionWrapper questionWrapper= pQuestionRepository.findOne(index);
				list.add(questionWrapper.getPhotoQuestion());
			}
		}

		PQuestionList questions= new PQuestionList(list);
		return questions;
	}
	
	protected Queue<AbstractQuestion> loadQuestionList(String username, int typeQuestion){
	    if(isCheckAdmin(username)) {
	        return null;
	    }
	    List<AbstractQuestion> mcQuestionList= new LinkedList<>();
	    if(typeQuestion == TypeDefinition.MULTIPLE_CHOICE_QUESTION) {
	        
	        List<MCQuestionWrapper> list= (List<MCQuestionWrapper>) mcQuestionRepository.findAll();
	        for (MCQuestionWrapper mcQuestionWrapper : list) {
                mcQuestionList.add(mcQuestionWrapper.getMultipleChoiceQuestion());
            }
	    }
	    else if (typeQuestion == TypeDefinition.PHOTO_QUESTION) {
            
        }
	    return null;
	}
	
	protected AbstractQuestion findQuestion(String username, long id, Integer questionType) throws Exception{
	    if(!isCheckAdmin(username)) {
	        return null;
	    }
	    if(questionType == TypeDefinition.MULTIPLE_CHOICE_QUESTION) {
            MCQuestionWrapper mcQuestionWrapper= mcQuestionRepository.findOne(id);
            return mcQuestionWrapper.getMultipleChoiceQuestion();
        }
        else if (questionType == TypeDefinition.PHOTO_QUESTION) {
            PQuestionWrapper pQuestionWrapper= pQuestionRepository.findOne(id);
            return pQuestionWrapper.getPhotoQuestion();
        }
	    return null;
	}
	
	private boolean isCheckAdmin(String username) {
	    if(username.equals(Constant.Admin.USER_NAME)) {
	        return true;
	    }
	    else {
            return false;
        }
	}
	
	protected void updateQuestion(long id, AbstractQuestion question, String username, int questionType) {
	    if(!isCheckAdmin(username)) {
	        return;
	    }
	    if(questionType == TypeDefinition.MULTIPLE_CHOICE_QUESTION) {
	        MultipleChoiceQuestion multipleChoiceQuestion= (MultipleChoiceQuestion)question;
	        MCQuestionWrapper questionWrapper= new MCQuestionWrapper(id, multipleChoiceQuestion);
	        mcQuestionRepository.save(questionWrapper);
	    }
        else if (questionType == TypeDefinition.PHOTO_QUESTION) {
            PhotoQuestion photoQuestion= (PhotoQuestion) question;
            PQuestionWrapper questionWrapper= new PQuestionWrapper(id, photoQuestion);
            pQuestionRepository.save(questionWrapper);
        }
	}
	
	protected void DeteleQuestion(long id) {
	    
	}
	
	protected int countQuestion(Integer questionType) {
		int count = 0;
		try {
			if(questionType == TypeDefinition.MULTIPLE_CHOICE_QUESTION) {
				count= mcQuestionRepository.countQuestionById();
			}
			else if(questionType == TypeDefinition.PHOTO_QUESTION){
				count= pQuestionRepository.countQuestionById();
			}
		} catch (Exception e) {
			throw e;
		}
		return count;
	}
	
	private void removeCache(String username, Integer typeQuestion) {
		indexCache.removeIndex(username);
		if(typeQuestion == TypeDefinition.MULTIPLE_CHOICE_QUESTION) {
			mcCache.removeQuestionList(username);
		}
		else if(typeQuestion == TypeDefinition.PHOTO_QUESTION) {
			pCache.removeQuestionList(username);
		}
	}
	
	protected void submit(String username, Integer typeQuestion) {
		removeCache(username, typeQuestion);
	}
}
