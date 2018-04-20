package com.tqminh.vn.toeicpractice.services;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
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
import com.tqminh.vn.toeicpractice.model.Result;
import com.tqminh.vn.toeicpractice.model.task.AbstractQuestionList;
import com.tqminh.vn.toeicpractice.model.task.MCQuestionList;
import com.tqminh.vn.toeicpractice.model.task.PQuestionList;
import com.tqminh.vn.toeicpractice.repositories.MCQuestionWrapperRepository;
import com.tqminh.vn.toeicpractice.repositories.PQuestionWrapperRepository;
import com.tqminh.vn.toeicpractice.repositories.ResultWrapperRepository;
import com.tqminh.vn.toeicpractice.repositories.entities.MCQuestionWrapper;
import com.tqminh.vn.toeicpractice.repositories.entities.PQuestionWrapper;
import com.tqminh.vn.toeicpractice.repositories.entities.ResultWrapper;

public abstract class AbstractQuestionService {
    
    private double score;
    
	@Autowired
	private MCQuestionWrapperRepository mcQuestionRepository;
	
	@Autowired
	private PQuestionWrapperRepository pQuestionRepository;
	
	@Autowired
	private ResultWrapperRepository resultRepository;
	
	@Autowired
	@Qualifier("QuestionListCacheImpl")
	private QuestionListCache<AbstractQuestionList> questionCache; 
	
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
	
	protected Integer nextQuestion(String username, Integer typeQuestion) throws NullPointerException, SQLException{
		try {
			if(typeQuestion == TypeDefinition.MULTIPLE_CHOICE_QUESTION) {
				MCQuestionList mcQuestionList= (MCQuestionList) questionCache.getQuestionList(username);
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
				PQuestionList pQuestionList= (PQuestionList) questionCache.getQuestionList(username);
				int concurrentIndex= pQuestionList.getConcurrentIndex();
				
				if(isCheckNextQuestionIndex(concurrentIndex, typeQuestion)) {
				    pQuestionList.setConcurrentIndex(concurrentIndex + 1);
					return pQuestionList.getConcurrentIndex();
				}
				else {
				    return pQuestionList.getConcurrentIndex();
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return null;
	}
	
	protected Integer previousQuestion(String username, Integer typeQuestion) throws NullPointerException, SQLException{
		try {
			if(typeQuestion == TypeDefinition.MULTIPLE_CHOICE_QUESTION) {
				MCQuestionList mcQuestionList= (MCQuestionList) questionCache.getQuestionList(username);
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
				PQuestionList pQuestionList= (PQuestionList) questionCache.getQuestionList(username);
				int concurrentIndex= pQuestionList.getConcurrentIndex();
				
				if(isCheckPreviousQuestionIndex(concurrentIndex, typeQuestion)) {
				    pQuestionList.setConcurrentIndex(concurrentIndex - 1);
					return pQuestionList.getConcurrentIndex();
				}
				else {
				    return pQuestionList.getConcurrentIndex();
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return null;
	}
	
	protected AbstractQuestion getQuestion(String username, int index, Integer typeQuestion) throws Exception{
	    saveCache(username, typeQuestion, index);
		if(typeQuestion == TypeDefinition.MULTIPLE_CHOICE_QUESTION) {
			return loadMCQuestions(username, index);
		}
		else if(typeQuestion == TypeDefinition.PHOTO_QUESTION) {
			return loadPQuestions(username, index);
		}
		return null;
	}
	
	
	private MultipleChoiceQuestion loadMCQuestions(String username, int index) throws Exception{
		try {
			MCQuestionList mcQuestionList= (MCQuestionList)questionCache.getQuestionList(username);
			MultipleChoiceQuestion question= (MultipleChoiceQuestion) mcQuestionList.getQuestions().get(index);
			return question;
		} catch (Exception e) {
			throw e;
		}
	}
	
	private PhotoQuestion loadPQuestions(String username, int index) throws Exception{
		try {
			PQuestionList pQuestionList= (PQuestionList)questionCache.getQuestionList(username);
			PhotoQuestion question= pQuestionList.getQuestions().get(index);
			return question;
		} catch (Exception e) {
			throw e;
		}
	}
	
	private void saveCache(String username, Integer typeQuestion, int index) throws Exception {
		if(typeQuestion == TypeDefinition.MULTIPLE_CHOICE_QUESTION) {
			if(!questionCache.isCheckUsername(username)) {
				MCQuestionList questionList= getMCQuestionList(username, typeQuestion);
				questionList.setConcurrentIndex(index);
				questionCache.putQuestionList(username, questionList);
			}
		}
		else if(typeQuestion == TypeDefinition.PHOTO_QUESTION){
			if(!questionCache.isCheckUsername(username)) {
				PQuestionList questionList= getPQuestionList(username, typeQuestion);
				questionList.setConcurrentIndex(index);
				questionCache.putQuestionList(username, questionList);
			}
		}	
	}
	
	private MCQuestionList getMCQuestionList(String username, Integer typeQuestion) throws NullPointerException, SQLException{
		try {
			Random random= new Random();
			List<MultipleChoiceQuestion> list= new LinkedList<>();
			Set<Long> set= new HashSet<>();
			int count = countQuestion(typeQuestion);
			indexCache.setIndex(username, set);
			
			while(list.size() <= configuration.getMaxMCQuestion()) {
				long index= random.nextInt(count);
				if(!indexCache.isCheckIndex(username, index)) {
					continue;
				}
				else {
					MCQuestionWrapper questionWrapper= mcQuestionRepository.findOne(index);
					list.add(questionWrapper.getMultipleChoiceQuestion());
				}
			}
			AbstractQuestionList questions= new MCQuestionList(list);
			return (MCQuestionList) questions;
		} catch (Exception e) {
			throw e;
		}
	}
	
	private PQuestionList getPQuestionList(String username, Integer typeQuestion) throws NullPointerException, SQLException{
		try {
			Random random= new Random();
			List<PhotoQuestion> list= new LinkedList<>();
			Set<Long> set= new HashSet<>();
			int count = countQuestion(typeQuestion);
			indexCache.setIndex(username, set);
			
			while(list.size() == configuration.getMaxPQuestion()) {
				long index= random.nextInt(count);
				if(!indexCache.isCheckIndex(username, index)) {
					continue;
				}
				else {
					PQuestionWrapper questionWrapper= pQuestionRepository.findOne(index);
					list.add(questionWrapper.getPhotoQuestion());
				}
			}

			AbstractQuestionList questions= new PQuestionList(list);
			return (PQuestionList) questions;
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	protected void deleteQuestion(long id, int questionType, String username) throws SQLException {
		
		if(!isCheckAdmin(username)) {
	        return;
	    }
	    if(questionType == TypeDefinition.MULTIPLE_CHOICE_QUESTION) {
	    	mcQuestionRepository.delete(id);
        }
        else if (questionType == TypeDefinition.PHOTO_QUESTION) {
            pQuestionRepository.delete(id);
        }
	}
	
	protected List<MCQuestionWrapper> findAllQuestions(String username) throws NullPointerException, SQLException{
	    if(!isCheckAdmin(username)) {
	        return null;
	    }
	    try {
	    	List<MCQuestionWrapper> list= mcQuestionRepository.findAllQuestionList();
	    	return list;
	    } catch (Exception e) {
			throw e;
		}
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
	    	System.out.println(false);
            return false;
        }
	}
	
	protected void updateQuestion(long id, AbstractQuestion question, String username, int questionType) throws NullPointerException, SQLException {
		try {
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
		} catch (Exception e) {
			throw e;
		}
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
			questionCache.removeQuestionList(username);
		}
		else if(typeQuestion == TypeDefinition.PHOTO_QUESTION) {
			questionCache.removeQuestionList(username);
		}
	}
	
	private String getSelection(String selection, AbstractQuestion question) {
	    if(selection.equals("A")) {
	        
	        return question.getAnswerA();
	    }
	    else if (selection.equals("B")) {
	        
	        return question.getAnswerB();
        }
	    else if (selection.equals("C")) {
	        
	        return question.getAnswerC();
        }
	    else {
	        return question.getAnswerD();
        }
	}
	
	private boolean isCheckSelection(String selection, AbstractQuestion question) {
	    if(question.getAnswerTrue().equals(getSelection(selection, question))) {
	        return true;
	    }
	    else {
	        return false;
	    }
	}
	
	protected void validate(String selection, AbstractQuestion question, String username) {
	    if(isCheckSelection(selection, question)) {
	    	score = score + 1;
	        questionCache.getQuestionList(username).setScore(score); 
	    }
	}
	
	private String getTimestamp() {
	    Timestamp timestamp= new Timestamp(System.currentTimeMillis());
	    return timestamp.toString();
	}
	
	private String getDate() throws ParseException {
	    LocalDate localDate= LocalDate.now();
	    System.out.println("Date:" + localDate);
	    return localDate.toString();
	}
	
	private ResultWrapper saveResult(String date, String username, double score, String timestamp) throws SQLException {
		ResultWrapper resultWrapper= resultRepository.findResultByDateAndUsername(date, username);
	    if(resultWrapper == null) {
	        Result result= new Result(username, date, timestamp);
	        result.getMultipleChoices().add(score);
	        ResultWrapper wrapper= new ResultWrapper(result);
	        wrapper = resultRepository.save(wrapper);
	        return wrapper;
	    }
	    else {
	    	Result temporary= resultWrapper.getResult();
	    	temporary.getMultipleChoices().add(score);
	        Result result= new Result(temporary.getUsername(), temporary.getDate(), temporary.getTimestamp(),
	        		temporary.getMultipleChoices(), temporary.getSentences(), temporary.getPhotos());
	    	ResultWrapper wrapper= new ResultWrapper(resultWrapper.getId(), result);
	    	wrapper = resultRepository.save(wrapper);
	        return wrapper;
	    }
	}
	
	protected void submit(String username, Integer typeQuestion) throws ParseException, SQLException {
	    try {
	        AbstractQuestionList abstractQuestionList= questionCache.getQuestionList(username);
	        double score= abstractQuestionList.getScore();
	        String timestamp= getTimestamp();
	        String date= getDate();
	        saveResult(date, username, score, timestamp);
	        score= 0;
	        removeCache(username, typeQuestion);
        }
        catch (Exception e) {
            throw e;
        }
	}
}
