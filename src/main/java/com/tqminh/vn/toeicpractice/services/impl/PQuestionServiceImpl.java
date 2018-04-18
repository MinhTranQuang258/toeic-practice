package com.tqminh.vn.toeicpractice.services.impl;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tqminh.vn.toeicpractice.common.TypeDefinition;
import com.tqminh.vn.toeicpractice.configuration.GeneralConfiguration;
import com.tqminh.vn.toeicpractice.model.AbstractQuestion;
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
	public void insertQuestion(PhotoQuestion question) throws NullPointerException, SQLException{
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
	public void updateQuestion(long id, AbstractQuestion question, String username) throws SQLException {
		try {
            super.updateQuestion(id, question, username, TypeDefinition.PHOTO_QUESTION);
        }
        catch (NullPointerException e) {
            throw e;
        }
        catch (SQLException e) {
            throw e;
        }
	}
	
	@Override
	public void deleteQuestion(long id, String username) throws SQLException {
		try {
            super.deleteQuestion(id, TypeDefinition.PHOTO_QUESTION, username);
        }
        catch (SQLException e) {
            throw e;
        }
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
    public void validateQuestion(
        String username,
        AbstractQuestion question,
        String selection) throws Exception {
        
    }

    @Override
	public PhotoQuestion getQuestion(String username, int index) throws Exception {
		try {
			return (PhotoQuestion) super.getQuestion(username, index, TypeDefinition.PHOTO_QUESTION);
		} catch (Exception e) {
			throw e;
		}
	}
	
	private boolean isCheckFolderName() {
	    int count= repository.countDuplicatedFolder(configuration.getPhotoPath());
	    if(count > 0) {
	        return false;
	    }
	    else {
            return true;
        }
	}
	
	@Override
    public PhotoQuestion findQuestion(String username, long id) {
        return null;
    }

    @Override
	public String loadFilePatch() throws IOException {
		if(queue.isEmpty() && isCheckFolderName()) {
			readFile();
		}
		String patch= queue.poll();
		return patch;
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
	public void submit(String username) throws ParseException, SQLException {
		try {
            super.submit(username, TypeDefinition.PHOTO_QUESTION);
        }
        catch (ParseException e) {
            throw e;
        }
        catch (SQLException e) {
            throw e;
        }
	}
}
