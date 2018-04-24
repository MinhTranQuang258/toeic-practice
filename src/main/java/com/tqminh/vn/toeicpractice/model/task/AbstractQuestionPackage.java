/*
 * Class: AbstractQuestionList
 *
 * Created on Apr 13, 2018
 *
 * (c) Copyright Swiss Post Solution, unpublished work
 * All use, disclosure, and/or reproduction of this material is prohibited
 * unless authorized in writing.  All Rights Reserved.
 * Rights in this program belong to:
 * Swiss Post Solution.
 * Floor 4-5-8, ICT Tower, Quang Trung Software City
 */
package com.tqminh.vn.toeicpractice.model.task;

import java.util.List;

import com.tqminh.vn.toeicpractice.model.AbstractQuestion;

public abstract class AbstractQuestionPackage {

    public abstract int getConcurrentIndex();

    public abstract List<? extends AbstractQuestion> getQuestions();

    public abstract double getScore();

    public abstract void setScore(double score);

}
