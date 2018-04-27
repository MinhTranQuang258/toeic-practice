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
import com.tqminh.vn.toeicpractice.model.packages.AbstractQuestionPackage;
import com.tqminh.vn.toeicpractice.model.packages.MCQuestionPackge;
import com.tqminh.vn.toeicpractice.model.packages.PQuestionPackage;
import com.tqminh.vn.toeicpractice.repositories.MCQuestionWrapperRepository;
import com.tqminh.vn.toeicpractice.repositories.PQuestionWrapperRepository;
import com.tqminh.vn.toeicpractice.repositories.ResultWrapperRepository;
import com.tqminh.vn.toeicpractice.repositories.entities.MCQuestionWrapper;
import com.tqminh.vn.toeicpractice.repositories.entities.PQuestionWrapper;
import com.tqminh.vn.toeicpractice.repositories.entities.ResultWrapper;

/**
 * The Class AbstractQuestionService.
 */
public abstract class AbstractQuestionService {

    /** The configuration. */
    @Autowired
    private GeneralConfiguration configuration;

    /** The index cache. */
    @Autowired
    @Qualifier("IndexCache")
    private IndexCache<Long> indexCache;

    /** The mc question repository. */
    @Autowired
    private MCQuestionWrapperRepository mcQuestionRepository;

    /** The p question repository. */
    @Autowired
    private PQuestionWrapperRepository pQuestionRepository;

    /** The question cache. */
    @Autowired
    @Qualifier("QuestionListCacheImpl")
    private QuestionListCache<AbstractQuestionPackage> questionCache;

    /** The result repository. */
    @Autowired
    private ResultWrapperRepository resultRepository;

    /** The score. */
    private double score;

    /**
     * Count question.
     *
     * @param questionType the question type
     * @return the int
     */
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

    /**
     * Delete question.
     *
     * @param id the id
     * @param questionType the question type
     * @param username the username
     * @throws SQLException the SQL exception
     */
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

    /**
     * Find all questions.
     *
     * @param username the username
     * @return the list
     * @throws NullPointerException the null pointer exception
     * @throws SQLException the SQL exception
     */
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

    /**
     * Find question.
     *
     * @param username the username
     * @param id the id
     * @param questionType the question type
     * @return the abstract question
     * @throws Exception the exception
     */
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

    /**
     * Gets the date.
     *
     * @return the date
     * @throws ParseException the parse exception
     */
    private String getDate() throws ParseException {
        LocalDate localDate = LocalDate.now();
        return localDate.toString();
    }

    /**
     * Gets the MC question list.
     *
     * @param username the username
     * @param typeQuestion the type question
     * @return the MC question list
     * @throws NullPointerException the null pointer exception
     * @throws SQLException the SQL exception
     */
    private MCQuestionPackge getMCQuestionList(
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
            AbstractQuestionPackage questions = new MCQuestionPackge(list);
            return (MCQuestionPackge) questions;
        }
        catch (Exception e) {
            throw e;
        }
    }

    /**
     * Gets the p question list.
     *
     * @param username the username
     * @param typeQuestion the type question
     * @return the p question list
     * @throws NullPointerException the null pointer exception
     * @throws SQLException the SQL exception
     */
    private PQuestionPackage getPQuestionList(
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

            AbstractQuestionPackage questions = new PQuestionPackage(list);
            return (PQuestionPackage) questions;
        }
        catch (Exception e) {
            throw e;
        }
    }

    /**
     * Gets the question.
     *
     * @param username the username
     * @param index the index
     * @param typeQuestion the type question
     * @return the question
     * @throws Exception the exception
     */
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

    /**
     * Gets the selection.
     *
     * @param selection the selection
     * @param question the question
     * @return the selection
     */
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

    /**
     * Gets the timestamp.
     *
     * @return the timestamp
     */
    private String getTimestamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp.toString();
    }

    /**
     * Checks if is check admin.
     *
     * @param username the username
     * @return true, if is check admin
     */
    private boolean isCheckAdmin(final String username) {
        if (username.equals(Constant.Admin.USER_NAME)) {
            return true;
        }
        else {
            System.out.println(false);
            return false;
        }
    }

    /**
     * Checks if is check next question index.
     *
     * @param index the index
     * @param typeQuestion the type question
     * @return the boolean
     * @throws NullPointerException the null pointer exception
     */
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

    /**
     * Checks if is check previous question index.
     *
     * @param index the index
     * @param typeQuestion the type question
     * @return the boolean
     * @throws NullPointerException the null pointer exception
     */
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

    /**
     * Checks if is check selection.
     *
     * @param selection the selection
     * @param question the question
     * @return true, if is check selection
     */
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

    /**
     * Load MC questions.
     *
     * @param username the username
     * @param index the index
     * @return the multiple choice question
     * @throws Exception the exception
     */
    private MultipleChoiceQuestion loadMCQuestions(
        final String username,
        final int index) throws Exception {
        try {
            MCQuestionPackge mcQuestionList = (MCQuestionPackge) this.questionCache
                .getQuestionList(username);
            MultipleChoiceQuestion question = (MultipleChoiceQuestion) mcQuestionList
                .getQuestions().get(index);
            return question;
        }
        catch (Exception e) {
            throw e;
        }
    }

    /**
     * Load P questions.
     *
     * @param username the username
     * @param index the index
     * @return the photo question
     * @throws Exception the exception
     */
    private PhotoQuestion loadPQuestions(final String username, final int index)
            throws Exception {
        try {
            PQuestionPackage pQuestionList = (PQuestionPackage) this.questionCache
                .getQuestionList(username);
            PhotoQuestion question = pQuestionList.getQuestions().get(index);
            return question;
        }
        catch (Exception e) {
            throw e;
        }
    }

    /**
     * Next question.
     *
     * @param username the username
     * @param typeQuestion the type question
     * @return the integer
     * @throws NullPointerException the null pointer exception
     * @throws SQLException the SQL exception
     */
    protected Integer nextQuestion(
        final String username,
        final Integer typeQuestion) throws NullPointerException, SQLException {
        try {
            if (typeQuestion == TypeDefinition.MULTIPLE_CHOICE_QUESTION) {
                MCQuestionPackge mcQuestionList = (MCQuestionPackge) this.questionCache
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
                PQuestionPackage pQuestionList = (PQuestionPackage) this.questionCache
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

    /**
     * Previous question.
     *
     * @param username the username
     * @param typeQuestion the type question
     * @return the integer
     * @throws NullPointerException the null pointer exception
     * @throws SQLException the SQL exception
     */
    protected Integer previousQuestion(
        final String username,
        final Integer typeQuestion) throws NullPointerException, SQLException {
        try {
            if (typeQuestion == TypeDefinition.MULTIPLE_CHOICE_QUESTION) {
                MCQuestionPackge mcQuestionList = (MCQuestionPackge) this.questionCache
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
                PQuestionPackage pQuestionList = (PQuestionPackage) this.questionCache
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

    /**
     * Removes the cache.
     *
     * @param username the username
     * @param typeQuestion the type question
     */
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

    /**
     * Save cache.
     *
     * @param username the username
     * @param typeQuestion the type question
     * @param index the index
     * @throws Exception the exception
     */
    private void saveCache(
        final String username,
        final Integer typeQuestion,
        final int index) throws Exception {
        if (typeQuestion == TypeDefinition.MULTIPLE_CHOICE_QUESTION) {
            if (!this.questionCache.isCheckUsername(username)) {
                MCQuestionPackge questionList = this
                    .getMCQuestionList(username, typeQuestion);
                questionList.setConcurrentIndex(index);
                this.questionCache.putQuestionList(username, questionList);
            }
        }
        else if (typeQuestion == TypeDefinition.PHOTO_QUESTION) {
            if (!this.questionCache.isCheckUsername(username)) {
                PQuestionPackage questionList = this
                    .getPQuestionList(username, typeQuestion);
                questionList.setConcurrentIndex(index);
                this.questionCache.putQuestionList(username, questionList);
            }
        }
    }

    /**
     * Save result.
     *
     * @param date the date
     * @param username the username
     * @param score the score
     * @param timestamp the timestamp
     * @return the result wrapper
     * @throws SQLException the SQL exception
     */
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

    /**
     * Submit.
     *
     * @param username the username
     * @param typeQuestion the type question
     * @throws ParseException the parse exception
     * @throws SQLException the SQL exception
     */
    protected void submit(final String username, final Integer typeQuestion)
            throws ParseException, SQLException {
        try {
            AbstractQuestionPackage abstractQuestionList = this.questionCache
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

    /**
     * Update question.
     *
     * @param id the id
     * @param question the question
     * @param username the username
     * @param questionType the question type
     * @throws NullPointerException the null pointer exception
     * @throws SQLException the SQL exception
     */
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

    /**
     * Validate.
     *
     * @param selection the selection
     * @param question the question
     * @param username the username
     */
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
