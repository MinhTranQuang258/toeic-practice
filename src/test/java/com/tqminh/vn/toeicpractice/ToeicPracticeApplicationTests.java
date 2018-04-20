package com.tqminh.vn.toeicpractice;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tqminh.vn.toeicpractice.model.Account;
import com.tqminh.vn.toeicpractice.model.MultipleChoiceQuestion;
import com.tqminh.vn.toeicpractice.repositories.AccountWrapperRepository;
import com.tqminh.vn.toeicpractice.repositories.MCQuestionWrapperRepository;
import com.tqminh.vn.toeicpractice.repositories.entities.AccountWrapper;
import com.tqminh.vn.toeicpractice.repositories.entities.MCQuestionWrapper;
import com.tqminh.vn.toeicpractice.services.impl.MCQuestionServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ToeicPracticeApplicationTests {

    @Autowired
    private AccountWrapperRepository accountWrapperRepository;

    @Autowired
    private MCQuestionServiceImpl mCQuestionServiceImpl;

    @Autowired
    private MCQuestionWrapperRepository mcQuestionWrapperRepository;

    @Test
    public void addNewAccount() {
        Account account = new Account();
        account.setAge(21);
        account.setName("Minh");
        account.setPassword("12345");
        account.setUsername("tqminh");
        AccountWrapper accountWrapper = new AccountWrapper(account);
        AccountWrapper newAccountWrapper = this.accountWrapperRepository
            .save(accountWrapper);
        Assert.assertNotNull(newAccountWrapper);

    }

    @Test
    public void addQuestion() {

        MCQuestionWrapper mcQuestionWrapper = new MCQuestionWrapper();
        MultipleChoiceQuestion multipleChoiceQuestion = new MultipleChoiceQuestion();
        multipleChoiceQuestion.setAnswerA("A");
        multipleChoiceQuestion.setAnswerA("B");
        multipleChoiceQuestion.setAnswerA("C");
        multipleChoiceQuestion.setAnswerA("D");
        multipleChoiceQuestion.setAnswerTrue("abcd");
        mcQuestionWrapper.setMultipleChoiceQuestion(multipleChoiceQuestion);
        this.mcQuestionWrapperRepository.save(mcQuestionWrapper);
    }

    @Test
    public void checkCount() {
        Assert.assertTrue(this.countAccount());
    }

    public boolean countAccount() {
        long count = this.accountWrapperRepository.count();
        if (count == 0) {
            return false;
        }
        else {
            return true;
        }
    }

    @Test
    public void deleteAccountById() {
        this.accountWrapperRepository.delete(2L);
    }

    @Test
    public void deleteQuestion() {
        this.mcQuestionWrapperRepository.delete(4L);

    }

    @Test
    public void fingQuestion() {
        MultipleChoiceQuestion multipleChoiceQuestion = new MultipleChoiceQuestion();
        multipleChoiceQuestion.setAnswerA("A");
        multipleChoiceQuestion.setAnswerA("B");
        multipleChoiceQuestion.setAnswerA("C");
        multipleChoiceQuestion.setAnswerA("D");
        multipleChoiceQuestion.setAnswerTrue("abcd");
        this.mCQuestionServiceImpl.insertQuestion(multipleChoiceQuestion);
    }

    @Test
    public void getAllAccount() {
        List<AccountWrapper> wrappers = (List<AccountWrapper>) this.accountWrapperRepository
            .findAll();
        for (AccountWrapper accountWrapper : wrappers) {
            Assert.assertNotNull(accountWrapper);
        }
    }

}
