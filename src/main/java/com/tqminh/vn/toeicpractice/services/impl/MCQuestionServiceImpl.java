package com.tqminh.vn.toeicpractice.services.impl;

import java.sql.SQLException;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tqminh.vn.toeicpractice.common.TypeDefinition;
import com.tqminh.vn.toeicpractice.model.AbstractQuestion;
import com.tqminh.vn.toeicpractice.model.MultipleChoiceQuestion;
import com.tqminh.vn.toeicpractice.repositories.MCQuestionWrapperRepository;
import com.tqminh.vn.toeicpractice.repositories.entities.MCQuestionWrapper;
import com.tqminh.vn.toeicpractice.services.AbstractQuestionService;
import com.tqminh.vn.toeicpractice.services.QuestionService;

@Service("MCQuestionService")
public class MCQuestionServiceImpl extends AbstractQuestionService
        implements QuestionService<MultipleChoiceQuestion> {

    @Autowired
    private MCQuestionWrapperRepository repository;

    @Override
    public int countQuestion() {
        return super.countQuestion(TypeDefinition.MULTIPLE_CHOICE_QUESTION);
    }

    @Override
    public void deleteQuestion(final long id, final String username)
            throws SQLException {
        try {
            super.deleteQuestion(
                id,
                TypeDefinition.MULTIPLE_CHOICE_QUESTION,
                username);
        }
        catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public MultipleChoiceQuestion findQuestion(
        final String username,
        final long id) {
        // TODO: Implement find the question by id.
        return null;
    }

    @Override
    public MultipleChoiceQuestion getQuestion(
        final String username,
        final int index) throws Exception {
        return (MultipleChoiceQuestion) super.getQuestion(
            username,
            index,
            TypeDefinition.MULTIPLE_CHOICE_QUESTION);
    }

    @Override
    public void insertQuestion(final MultipleChoiceQuestion question) {
        try {
            if (question != null) {
                MCQuestionWrapper questionWrapper = new MCQuestionWrapper(
                    question);
                MCQuestionWrapper wrapper = this.repository
                    .save(questionWrapper);
                if (wrapper == null) {
                    throw new NullPointerException(
                        "Can't insert the mutilple-choice question.");
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

    @Override
    public int nextQuestion(final String username) throws Exception {
        return super.nextQuestion(
            username,
            TypeDefinition.MULTIPLE_CHOICE_QUESTION);
    }

    @Override
    public int previousQuestion(final String username) throws Exception {
        return super.previousQuestion(
            username,
            TypeDefinition.MULTIPLE_CHOICE_QUESTION);
    }

    @Override
    public void submit(final String username)
            throws ParseException, SQLException {
        try {
            super.submit(username, TypeDefinition.MULTIPLE_CHOICE_QUESTION);
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
                TypeDefinition.MULTIPLE_CHOICE_QUESTION);
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
        final String selection) {
        super.validate(selection, question, username);
    }

}
