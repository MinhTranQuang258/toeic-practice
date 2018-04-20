package com.tqminh.vn.toeicpractice.controllers;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tqminh.vn.toeicpractice.common.Constant;
import com.tqminh.vn.toeicpractice.configuration.GeneralConfiguration;
import com.tqminh.vn.toeicpractice.model.AbstractQuestion;
import com.tqminh.vn.toeicpractice.model.MultipleChoiceQuestion;
import com.tqminh.vn.toeicpractice.model.PhotoQuestion;
import com.tqminh.vn.toeicpractice.model.mapping.Question;
import com.tqminh.vn.toeicpractice.repositories.entities.MCQuestionWrapper;
import com.tqminh.vn.toeicpractice.services.QuestionService;
import com.tqminh.vn.toeicpractice.services.QuestionWrapperService;

@Controller
public class AdminController extends AstractController {

    @Autowired
    private GeneralConfiguration generalConfiguration;

    private final Map<String, Object> map = new HashMap<>();

    @Autowired
    @Qualifier("MCQuestionService")
    private QuestionService<MultipleChoiceQuestion> mcQuestionService;

    @Autowired
    @Qualifier("MCQuestionWrapperService")
    private QuestionWrapperService mcQuestionWrapperService;

    @Autowired
    @Qualifier("PQuestionService")
    private QuestionService<PhotoQuestion> pQuestionService;

    @RequestMapping(value = "/deleteQuestion", method = RequestMethod.POST)
    public String deteleQuestion(
        final HttpSession session,
        final HttpServletRequest request) {
        String username = (String) session.getAttribute("username");
        System.out.println(request.getAttribute("delete"));
        try {
            this.mcQuestionService.deleteQuestion(4, username);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/adminEdit";
    }

    @RequestMapping(value = "/displayAdminAddGrammar", method = RequestMethod.GET)
    public String displayAdminAddGrammarPage(final Model model) {
        model.addAttribute("question", new Question());
        return Constant.Page.ADMIN_ADD_GRAMMAR_PAGE;
    }

    @RequestMapping(value = "/displayAdminAddListening", method = RequestMethod.GET)
    public String displayAdminAddListeningPage(final Model model) {
        model.addAttribute("question", new Question());
        return Constant.Page.ADMIN_ADD_LISTENING_PAGE;
    }

    @RequestMapping(value = "/adminAdd", method = RequestMethod.GET)
    public String displayAdminAddPage() {
        return Constant.Page.ADMIN_ADD_PAGE;
    }

    @RequestMapping(value = "/displayAdminAddReading", method = RequestMethod.GET)
    public String displayAdminAddReadingPage(final Model model) {
        model.addAttribute("question", new Question());
        return Constant.Page.ADMIN_ADD_READING_PAGE;
    }

    @RequestMapping(value = "/adminEdit", method = RequestMethod.GET)
    public String displayAdminEditPage(
        final Model model,
        final HttpSession session) {
        String username = (String) session.getAttribute("username");
        List<MCQuestionWrapper> questions = null;
        try {
            questions = this.mcQuestionWrapperService
                .findAllQuestionWarraper(username);
            model.addAttribute("questions", questions);
            model.addAttribute("question", new Question());
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return Constant.Page.ADMIN_EDIT_PAGE;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String displayAdminPage() {
        return Constant.Page.ADMIN_HOME_PAGE;
    }

    @RequestMapping(value = "/admin/grammar", method = RequestMethod.GET)
    public String displayAdminQuestionGrammar(
        final Model model,
        final HttpSession session) {
        String username = (String) session.getAttribute("username");
        MultipleChoiceQuestion question;
        try {
            question = this.mcQuestionService.getQuestion(username, 1);
            model.addAttribute("question", question);
            this.map.put("question", question);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return Constant.Page.ADMIN_QUESTION_GRAMMAR_PAGE;
    }

    private String displayAdminQuestionGrammarAgain(final Model model) {
        MultipleChoiceQuestion question;
        try {
            question = (MultipleChoiceQuestion) this.map.get("question");
            model.addAttribute("question", question);
            this.map.put("question", question);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return Constant.Page.ADMIN_QUESTION_GRAMMAR_PAGE;
    }

    @RequestMapping(value = "/insertMCQuestion", method = RequestMethod.POST)
    public String insertMCQuestion(
        @ModelAttribute("question") final Question question,
        final HttpServletRequest request) {
        String radio = request.getParameter("rightAnswer");
        MultipleChoiceQuestion multipleChoiceQuestion = (MultipleChoiceQuestion) this
            .prepareQuestion(radio, question);
        try {
            this.mcQuestionService.insertQuestion(multipleChoiceQuestion);
        }
        catch (NullPointerException | SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/displayAdminAddGrammar";
    }

    @RequestMapping(value = "/insertPQuestion", method = RequestMethod.POST)
    public void insertPQuestion() {

    }

    @RequestMapping(value = "/admin/nextMCQuestion", method = RequestMethod.GET)
    public String nextQuestion(final HttpSession session, final Model model)
            throws Exception {
        String username = (String) session.getAttribute("username");
        int index = this.mcQuestionService.nextQuestion(username);
        MultipleChoiceQuestion question = this.mcQuestionService
            .getQuestion(username, index);

        model.addAttribute("question", question);
        this.map.put("question", question);
        if (index < this.generalConfiguration.getMaxMCQuestion()) {
            return Constant.Page.ADMIN_QUESTION_GRAMMAR_PAGE;
        }
        else {
            return Constant.Page.ADMIN_QUESTION_GRAMMAR_LAST_PAGE;
        }
    }

    @RequestMapping(value = "/admin/submitMCQuestion", method = RequestMethod.POST)
    public String submit(final HttpSession session) {
        String username = (String) session.getAttribute("username");
        try {
            this.mcQuestionService.submit(username);
        }
        catch (ParseException | SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/admin";
    }

    @RequestMapping(value = "/updateMCQuestion", method = RequestMethod.POST)
    public String updateQuestion(
        @ModelAttribute("question") final Question question,
        final HttpSession session,
        final HttpServletRequest request) {
        String radio = request.getParameter("rightAnswer");
        String username = (String) session.getAttribute("username");
        AbstractQuestion multipleChoiceQuestion = this
            .prepareQuestion(radio, question);
        try {
            this.mcQuestionService
                .updateQuestion(1, multipleChoiceQuestion, username);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/adminEdit";
    }

    @RequestMapping(value = "/admin/validate", method = RequestMethod.POST)
    public String validate(
        final HttpServletRequest servletRequest,
        final HttpSession session,
        final Model model) throws Exception {
        String username = (String) session.getAttribute("username");
        String selection = servletRequest.getParameter("answerGroup");
        if (selection == null) {
            return this.displayAdminQuestionGrammarAgain(model);
        }
        AbstractQuestion question = (AbstractQuestion) this.map.get("question");
        this.mcQuestionService.validateQuestion(username, question, selection);

        return "redirect:/admin/nextMCQuestion";
    }
}
