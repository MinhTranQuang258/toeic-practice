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
        implements QuestionService<PhotoQuestion>, PhotoService {

    @Autowired
    private GeneralConfiguration configuration;

    private Queue<String> queue;

    @Autowired
    private PQuestionWrapperRepository repository;

    @Override
    public int countPhoto() throws IOException {
        return this.readFile().size();
    }

    @Override
    public int countQuestion() {
        return super.countQuestion(TypeDefinition.PHOTO_QUESTION);
    }

    @Override
    public void deleteQuestion(final long id, final String username)
            throws SQLException {
        try {
            super.deleteQuestion(id, TypeDefinition.PHOTO_QUESTION, username);
        }
        catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public PhotoQuestion findQuestion(final String username, final long id) {
        return null;
    }

    @Override
    public PhotoQuestion getQuestion(final String username, final int index)
            throws Exception {
        try {
            return (PhotoQuestion) super.getQuestion(
                username,
                index,
                TypeDefinition.PHOTO_QUESTION);
        }
        catch (Exception e) {
            throw e;
        }
    }

    @PostConstruct
    public void initialize() {
        this.queue = new ConcurrentLinkedQueue<>();
    }

    @Override
    public void insertQuestion(final PhotoQuestion question)
            throws NullPointerException, SQLException {
        try {
            if (this.isCheckQuestionInfo(question)) {
                PQuestionWrapper questionWrapper = new PQuestionWrapper(
                    question);
                PQuestionWrapper pQuestionWrapper = this.repository
                    .save(questionWrapper);
                if (pQuestionWrapper == null) {
                    throw new NullPointerException(
                        "Can't insert the Photo Question.");
                }
            }
            else {
                throw new NullPointerException();
            }
        }
        catch (Exception e) {
            throw e;
        }
    }

    private boolean isCheckFolderName() {
        int count = this.repository
            .countDuplicatedFolder(this.configuration.getPhotoPath());
        if (count > 0) {
            return false;
        }
        else {
            return true;
        }
    }

    private boolean isCheckQuestionInfo(final PhotoQuestion photoQuestion) {
        if (photoQuestion != null) {
            if ((photoQuestion.getAnswerA() != null)
                    && (photoQuestion.getAnswerB() != null)
                    && (photoQuestion.getAnswerC() != null)
                    && (photoQuestion.getAnswerD() != null)
                    && (photoQuestion.getAnswerTrue() != null)) {
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
    public String loadFilePatch() throws IOException {
        if (this.queue.isEmpty() && this.isCheckFolderName()) {
            this.readFile();
        }
        String patch = this.queue.poll();
        return patch;
    }

    @Override
    public int nextQuestion(final String username) throws Exception {
        return super.nextQuestion(username, TypeDefinition.PHOTO_QUESTION);
    }

    @Override
    public int previousQuestion(final String username) throws Exception {
        return super.previousQuestion(username, TypeDefinition.PHOTO_QUESTION);
    }

    private Queue<String> readFile() throws IOException {
        File[] files = new File(this.configuration.getPhotoPath()).listFiles();
        for (File file : files) {
            if (file.isFile()) {
                this.queue.add(file.getAbsolutePath());
            }
        }
        return this.queue;
    }

    @Override
    public void submit(final String username)
            throws ParseException, SQLException {
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

    @Override
    public void updateQuestion(
        final long id,
        final AbstractQuestion question,
        final String username) throws SQLException {
        try {
            super.updateQuestion(
                id,
                question,
                username,
                TypeDefinition.PHOTO_QUESTION);
        }
        catch (NullPointerException e) {
            throw e;
        }
        catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public void validateQuestion(
        final String username,
        final AbstractQuestion question,
        final String selection) throws Exception {

    }
}
