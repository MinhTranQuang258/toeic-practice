package com.tqminh.vn.toeicpractice.controllers;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tqminh.vn.toeicpractice.common.Constant;
import com.tqminh.vn.toeicpractice.configuration.GeneralConfiguration;
import com.tqminh.vn.toeicpractice.model.AbstractQuestion;
import com.tqminh.vn.toeicpractice.model.MultipleChoiceQuestion;
import com.tqminh.vn.toeicpractice.services.QuestionService;

@Controller
public class MCQuetionController {

    private final Map<String, Object> map = new HashMap<>();
    
    @Autowired
    private GeneralConfiguration generalConfiguration;

    @Autowired
    @Qualifier("MCQuestionService")
    private QuestionService<MultipleChoiceQuestion> mcQuestionService;

    @RequestMapping(value = "/grammar", method = RequestMethod.GET)
    public String getGrammer(final Model model, final HttpSession session)
            throws Exception {
        String username = (String) session.getAttribute("username");
        MultipleChoiceQuestion question = this.mcQuestionService
            .getQuestion(username, 1);
        model.addAttribute("question", question);
        model.addAttribute("name", username);
        this.map.put("question", question);
        return Constant.Page.USER_GRAMMAR_PAGE;
    }
    
    private String displayQuestionGrammarAgain(final Model model) {
        MultipleChoiceQuestion question;
        try {
            question = (MultipleChoiceQuestion) this.map.get("question");
            model.addAttribute("question", question);
            this.map.put("question", question);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return Constant.Page.USER_GRAMMAR_PAGE;
    }
    
    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    public String validateQuestion(final HttpServletRequest servletRequest,
        final HttpSession session,
        final Model model) {
        String username = (String) session.getAttribute("username");
        String selection = servletRequest.getParameter("answerGroup");
        if (selection == null) {
            return this.displayQuestionGrammarAgain(model);
        }
        AbstractQuestion question = (AbstractQuestion) this.map.get("question");
        try {
            this.mcQuestionService.validateQuestion(username, question, selection);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/nextMCQuestion";
    }

    @RequestMapping(value = "/nextMCQuestion", method = RequestMethod.GET)
    public String nextQuestion(final HttpSession session, final Model model)
            throws Exception {
        String username = (String) session.getAttribute("username");
        int index = this.mcQuestionService.nextQuestion(username);
        MultipleChoiceQuestion question = this.mcQuestionService
            .getQuestion(username, index);

        model.addAttribute("question", question);
        this.map.put("question", question);
        if (index < this.generalConfiguration.getMaxMCQuestion()) {
            return Constant.Page.USER_GRAMMAR_PAGE;
        }
        else {
            return Constant.Page.USER_GRAMMAR_LAST_PAGE;
        }
    }

    @RequestMapping(value = "/submitMCQuestion", method = RequestMethod.POST)
    public String submit(final HttpSession session) {
        String username = (String) session.getAttribute("username");
        try {
            this.mcQuestionService.submit(username);
        }
        catch (ParseException | SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/user";
    }
}
