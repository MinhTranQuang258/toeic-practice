/*
 * Class: AstractController
 *
 * Created on Apr 19, 2018
 *
 * (c) Copyright Swiss Post Solution, unpublished work
 * All use, disclosure, and/or reproduction of this material is prohibited
 * unless authorized in writing.  All Rights Reserved.
 * Rights in this program belong to:
 * Swiss Post Solution.
 * Floor 4-5-8, ICT Tower, Quang Trung Software City
 */
package com.tqminh.vn.toeicpractice.controllers;


import com.tqminh.vn.toeicpractice.model.AbstractQuestion;
import com.tqminh.vn.toeicpractice.model.MultipleChoiceQuestion;
import com.tqminh.vn.toeicpractice.model.mapping.Question;

public abstract class AstractController {
    
    protected AbstractQuestion prepareQuestion(String radio, Question question) {
        MultipleChoiceQuestion multipleChoiceQuestion= new MultipleChoiceQuestion();
        multipleChoiceQuestion.setDetailQuestion(question.getDetailQuestion());
        multipleChoiceQuestion.setAnswerA(question.getAnswerA());
        multipleChoiceQuestion.setAnswerB(question.getAnswerB());
        multipleChoiceQuestion.setAnswerC(question.getAnswerC());
        multipleChoiceQuestion.setAnswerD(question.getAnswerD());
        if(radio.equals("A")) {
            multipleChoiceQuestion.setAnswerTrue(question.getAnswerA());
            return multipleChoiceQuestion;
        }
        else if(radio.equals("B")) {
            multipleChoiceQuestion.setAnswerTrue(question.getAnswerB());
            return multipleChoiceQuestion;    
        }
        else if (radio.equals("C")) {
            multipleChoiceQuestion.setAnswerTrue(question.getAnswerC());
            return multipleChoiceQuestion;
        }
        else {
            multipleChoiceQuestion.setAnswerTrue(question.getAnswerD());
            return multipleChoiceQuestion;
        }
    }
    
}
