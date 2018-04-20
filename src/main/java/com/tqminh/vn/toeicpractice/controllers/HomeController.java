package com.tqminh.vn.toeicpractice.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tqminh.vn.toeicpractice.common.Constant;
import com.tqminh.vn.toeicpractice.model.Account;
import com.tqminh.vn.toeicpractice.services.AccountService;

@Controller
public class HomeController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = { "/displayLogin",
        "/" }, method = RequestMethod.GET)
    public String displayLogin(final Model model) {
        model.addAttribute("account", new Account());
        return Constant.Page.LOGIN_PAGE;
    }

    @RequestMapping(value = { "/login" }, method = RequestMethod.POST)
    public String login(
        @ModelAttribute("account") final Account account,
        final HttpSession httpSession) throws Exception {
        httpSession.setAttribute("username", account.getUsername());
        String page = this.accountService.loginAccount(account);
        return page;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logOut(final HttpSession session, final Model model) {
        String username = (String) session.getAttribute("username");
        this.accountService.logout(username);
        model.addAttribute("account", new Account());
        return "login";
    }

}
