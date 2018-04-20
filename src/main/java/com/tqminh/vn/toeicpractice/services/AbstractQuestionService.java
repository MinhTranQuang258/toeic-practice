package com.tqminh.vn.toeicpractice.services;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDate;
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

    @Autowired
    private GeneralConfiguration configuration;

    @Autowired
    @Qualifier("IndexCache")
    private IndexCache<Long> indexCache;

    @Autowired
    private MCQuestionWrapperRepository mcQuestionRepository;

    @Autowired
    private PQuestionWrapperRepository pQuestionRepository;

    @Autowired
    @Qualifier("QuestionListCacheImpl")
    private QuestionListCache<AbstractQuestionList> questionCache;

    @Autowired
    private ResultWrapperRepository resultRepository;

    private double score;

    protected int countQuestion(final Integer questionType) {
        int count = 0;
        try {
            if (questionType == TypeDefinition.MULTIPLE_CHOICE_QUESTION) {
                count = this.mcQuestionRepository.countQuestionById();
            }
            else if (questionType == TypeDefinition.PHOTO_QUESTION) {
                count = this.pQuestionRepository.countQuestionById();
            }
        }
        catch (Exception e) {
            throw e;
        }
        return count;
    }

    protected void deleteQuestion(
        final long id,
        final int questionType,
        final String username) throws SQLException {

        if (!this.isCheckAdmin(username)) {
            return;
        }
        if (questionType == TypeDefinition.MULTIPLE_CHOICE_QUESTION) {
            this.mcQuestionRepository.delete(id);
        }
        else if (questionType == TypeDefinition.PHOTO_QUESTION) {
            this.pQuestionRepository.delete(id);
        }
    }

    protected List<MCQuestionWrapper> findAllQuestions(final String username)
            throws NullPointerException, SQLException {
        if (!this.isCheckAdmin(username)) {
            return null;
        }
        try {
            List<MCQuestionWrapper> list = this.mcQuestionRepository
                .findAllQuestionList();
            return list;
        }
        catch (Exception e) {
            throw e;
        }
    }

    protected AbstractQuestion findQuestion(
        final String username,
        final long id,
        final Integer questionType) throws Exception {
        if (!this.isCheckAdmin(username)) {
            return null;
        }
        if (questionType == TypeDefinition.MULTIPLE_CHOICE_QUESTION) {
            MCQuestionWrapper mcQuestionWrapper = this.mcQuestionRepository
                .findOne(id);
            return mcQuestionWrapper.getMultipleChoiceQuestion();
        }
        else if (questionType == TypeDefinition.PHOTO_QUESTION) {
            PQuestionWrapper pQuestionWrapper = this.pQuestionRepository
                .findOne(id);
            return pQuestionWrapper.getPhotoQuestion();
        }
        return null;
    }

    private String getDate() throws ParseException {
        LocalDate localDate = LocalDate.now();
        return localDate.toString();
    }

    private MCQuestionList getMCQuestionList(
        final String username,
        final Integer typeQuestion) throws NullPointerException, SQLException {
        try {
            Random random = new Random();
            List<MultipleChoiceQuestion> list = new LinkedList<>();
            Set<Long> set = new HashSet<>();
            int count = this.countQuestion(typeQuestion);
            this.indexCache.setIndex(username, set);

            while (list.size() <= this.configuration.getMaxMCQuestion()) {
                long index = random.nextInt(count);
                if (!this.indexCache.isCheckIndex(username, index)) {
                    continue;
                }
                else {
                    MCQuestionWrapper questionWrapper = this.mcQuestionRepository
                        .findOne(index);
                    list.add(questionWrapper.getMultipleChoiceQuestion());
                }
            }
            AbstractQuestionList questions = new MCQuestionList(list);
            return (MCQuestionList) questions;
        }
        catch (Exception e) {
            throw e;
        }
    }

    private PQuestionList getPQuestionList(
        final String username,
        final Integer typeQuestion) throws NullPointerException, SQLException {
        try {
            Random random = new Random();
            List<PhotoQuestion> list = new LinkedList<>();
            Set<Long> set = new HashSet<>();
            int count = this.countQuestion(typeQuestion);
            this.indexCache.setIndex(username, set);

            while (list.size() == this.configuration.getMaxPQuestion()) {
                long index = random.nextInt(count);
                if (!this.indexCache.isCheckIndex(username, index)) {
                    continue;
                }
                else {
                    PQuestionWrapper questionWrapper = this.pQuestionRepository
                        .findOne(index);
                    list.add(questionWrapper.getPhotoQuestion());
                }
            }

            AbstractQuestionList questions = new PQuestionList(list);
            return (PQuestionList) questions;
        }
        catch (Exception e) {
            throw e;
        }
    }

    protected AbstractQuestion getQuestion(
        final String username,
        final int index,
        final Integer typeQuestion) throws Exception {
        this.saveCache(username, typeQuestion, index);
        if (typeQuestion == TypeDefinition.MULTIPLE_CHOICE_QUESTION) {
            return this.loadMCQuestions(username, index);
        }
        else if (typeQuestion == TypeDefinition.PHOTO_QUESTION) {
            return this.loadPQuestions(username, index);
        }
        return null;
    }

    private String getSelection(
        final String selection,
        final AbstractQuestion question) {
        if (selection.equals("A")) {

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

    private String getTimestamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp.toString();
    }

    private boolean isCheckAdmin(final String username) {
        if (username.equals(Constant.Admin.USER_NAME)) {
            return true;
        }
        else {
            System.out.println(false);
            return false;
        }
    }

    private Boolean isCheckNextQuestionIndex(
        final int index,
        final Integer typeQuestion) throws NullPointerException {
        switch (typeQuestion) {
        case 1:
            if (index >= Constant.QuestionLimit.MC_QUESTION_LIMIT) {
                return false;
            }
            else {
                return true;
            }
        case 2:
            if (index >= Constant.QuestionLimit.P_QUESTION_LIMIT) {
                return false;
            }
            else {
                return true;
            }
        default:
            return null;
        }
    }

    private Boolean isCheckPreviousQuestionIndex(
        final int index,
        final Integer typeQuestion) throws NullPointerException {
        switch (typeQuestion) {
        case 1:
            if (index <= Constant.LimitIndex.MIN_MC_QUESTION_INDEX) {
                return false;
            }
            else {
                return true;
            }
        case 2:
            if (index <= Constant.LimitIndex.MIN_PHOTO_QUESTION_INDEX) {
                return false;
            }
            else {
                return true;
            }
        default:
            return null;
        }
    }

    private boolean isCheckSelection(
        final String selection,
        final AbstractQuestion question) {
        if (question.getAnswerTrue()
            .equals(this.getSelection(selection, question))) {
            return true;
        }
        else {
            return false;
        }
    }

    private MultipleChoiceQuestion loadMCQuestions(
        final String username,
        final int index) throws Exception {
        try {
            MCQuestionList mcQuestionList = (MCQuestionList) this.questionCache
                .getQuestionList(username);
            MultipleChoiceQuestion question = (MultipleChoiceQuestion) mcQuestionList
                .getQuestions().get(index);
            return question;
        }
        catch (Exception e) {
            throw e;
        }
    }

    private PhotoQuestion loadPQuestions(final String username, final int index)
            throws Exception {
        try {
            PQuestionList pQuestionList = (PQuestionList) this.questionCache
                .getQuestionList(username);
            PhotoQuestion question = pQuestionList.getQuestions().get(index);
            return question;
        }
        catch (Exception e) {
            throw e;
        }
    }

    protected Integer nextQuestion(
        final String username,
        final Integer typeQuestion) throws NullPointerException, SQLException {
        try {
            if (typeQuestion == TypeDefinition.MULTIPLE_CHOICE_QUESTION) {
                MCQuestionList mcQuestionList = (MCQuestionList) this.questionCache
                    .getQuestionList(username);
                int concurrentIndex = mcQuestionList.getConcurrentIndex();

                if (this
                    .isCheckNextQuestionIndex(concurrentIndex, typeQuestion)) {
                    mcQuestionList.setConcurrentIndex(concurrentIndex + 1);
                    return mcQuestionList.getConcurrentIndex();
                }
                else {
                    return mcQuestionList.getConcurrentIndex();
                }
            }
            else if (typeQuestion == TypeDefinition.PHOTO_QUESTION) {
                PQuestionList pQuestionList = (PQuestionList) this.questionCache
                    .getQuestionList(username);
                int concurrentIndex = pQuestionList.getConcurrentIndex();

                if (this
                    .isCheckNextQuestionIndex(concurrentIndex, typeQuestion)) {
                    pQuestionList.setConcurrentIndex(concurrentIndex + 1);
                    return pQuestionList.getConcurrentIndex();
                }
                else {
                    return pQuestionList.getConcurrentIndex();
                }
            }
        }
        catch (Exception e) {
            throw e;
        }
        return null;
    }

    protected Integer previousQuestion(
        final String username,
        final Integer typeQuestion) throws NullPointerException, SQLException {
        try {
            if (typeQuestion == TypeDefinition.MULTIPLE_CHOICE_QUESTION) {
                MCQuestionList mcQuestionList = (MCQuestionList) this.questionCache
                    .getQuestionList(username);
                int concurrentIndex = mcQuestionList.getConcurrentIndex();

                if (this.isCheckPreviousQuestionIndex(
                    concurrentIndex,
                    typeQuestion)) {
                    mcQuestionList.setConcurrentIndex(concurrentIndex - 1);
                    return mcQuestionList.getConcurrentIndex();
                }
                else {
                    return mcQuestionList.getConcurrentIndex();
                }
            }
            else if (typeQuestion == TypeDefinition.PHOTO_QUESTION) {
                PQuestionList pQuestionList = (PQuestionList) this.questionCache
                    .getQuestionList(username);
                int concurrentIndex = pQuestionList.getConcurrentIndex();

                if (this.isCheckPreviousQuestionIndex(
                    concurrentIndex,
                    typeQuestion)) {
                    pQuestionList.setConcurrentIndex(concurrentIndex - 1);
                    return pQuestionList.getConcurrentIndex();
                }
                else {
                    return pQuestionList.getConcurrentIndex();
                }
            }
        }
        catch (Exception e) {
            throw e;
        }
        return null;
    }

    private void removeCache(
        final String username,
        final Integer typeQuestion) {
        this.indexCache.removeIndex(username);
        if (typeQuestion == TypeDefinition.MULTIPLE_CHOICE_QUESTION) {
            this.questionCache.removeQuestionList(username);
        }
        else if (typeQuestion == TypeDefinition.PHOTO_QUESTION) {
            this.questionCache.removeQuestionList(username);
        }
    }

    private void saveCache(
        final String username,
        final Integer typeQuestion,
        final int index) throws Exception {
        if (typeQuestion == TypeDefinition.MULTIPLE_CHOICE_QUESTION) {
            if (!this.questionCache.isCheckUsername(username)) {
                MCQuestionList questionList = this
                    .getMCQuestionList(username, typeQuestion);
                questionList.setConcurrentIndex(index);
                this.questionCache.putQuestionList(username, questionList);
            }
        }
        else if (typeQuestion == TypeDefinition.PHOTO_QUESTION) {
            if (!this.questionCache.isCheckUsername(username)) {
                PQuestionList questionList = this
                    .getPQuestionList(username, typeQuestion);
                questionList.setConcurrentIndex(index);
                this.questionCache.putQuestionList(username, questionList);
            }
        }
    }

    private ResultWrapper saveResult(
        final String date,
        final String username,
        final double score,
        final String timestamp) throws SQLException {
        ResultWrapper resultWrapper = this.resultRepository
            .findResultByDateAndUsername(date, username);
        if (resultWrapper == null) {
            Result result = new Result(username, date, timestamp);
            result.getMultipleChoices().add(score);
            ResultWrapper wrapper = new ResultWrapper(result);
            wrapper = this.resultRepository.save(wrapper);
            return wrapper;
        }
        else {
            Result temporary = resultWrapper.getResult();
            temporary.getMultipleChoices().add(score);
            Result result = new Result(temporary.getUsername(),
                temporary.getDate(), temporary.getTimestamp(),
                temporary.getMultipleChoices(), temporary.getSentences(),
                temporary.getPhotos());
            ResultWrapper wrapper = new ResultWrapper(resultWrapper.getId(),
                result);
            wrapper = this.resultRepository.save(wrapper);
            return wrapper;
        }
    }

    protected void submit(final String username, final Integer typeQuestion)
            throws ParseException, SQLException {
        try {
            AbstractQuestionList abstractQuestionList = this.questionCache
                .getQuestionList(username);
            double score = abstractQuestionList.getScore();
            String timestamp = this.getTimestamp();
            String date = this.getDate();
            this.saveResult(date, username, score, timestamp);
            score = 0;
            this.removeCache(username, typeQuestion);
        }
        catch (Exception e) {
            throw e;
        }
    }

    protected void updateQuestion(
        final long id,
        final AbstractQuestion question,
        final String username,
        final int questionType) throws NullPointerException, SQLException {
        try {
            if (!this.isCheckAdmin(username)) {
                return;
            }
            if (questionType == TypeDefinition.MULTIPLE_CHOICE_QUESTION) {
                MultipleChoiceQuestion multipleChoiceQuestion = (MultipleChoiceQuestion) question;
                MCQuestionWrapper questionWrapper = new MCQuestionWrapper(id,
                    multipleChoiceQuestion);
                this.mcQuestionRepository.save(questionWrapper);
            }
            else if (questionType == TypeDefinition.PHOTO_QUESTION) {
                PhotoQuestion photoQuestion = (PhotoQuestion) question;
                PQuestionWrapper questionWrapper = new PQuestionWrapper(id,
                    photoQuestion);
                this.pQuestionRepository.save(questionWrapper);
            }
        }
        catch (Exception e) {
            throw e;
        }
    }

    protected void validate(
        final String selection,
        final AbstractQuestion question,
        final String username) {
        if (this.isCheckSelection(selection, question)) {
            this.score = this.score + 1;
            this.questionCache.getQuestionList(username).setScore(this.score);
        }
    }
}
