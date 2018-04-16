/*
 * Class: QuestionController
 *
 * Created on Apr 16, 2018
 *
 * (c) Copyright Swiss Post Solution, unpublished work
 * All use, disclosure, and/or reproduction of this material is prohibited
 * unless authorized in writing.  All Rights Reserved.
 * Rights in this program belong to:
 * Swiss Post Solution.
 * Floor 4-5-8, ICT Tower, Quang Trung Software City
 */
package com.tqminh.vn.toeicpractice.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tqminh.vn.toeicpractice.model.Account;
import com.tqminh.vn.toeicpractice.services.AccountService;

@Controller
public class GeneralQuestionController {
    
    @Autowired
    private AccountService accountService;

    @RequestMapping(value= "/logOut", method= RequestMethod.GET)
    public String logOut(HttpSession session, Model model) {
        String username= (String) session.getAttribute("username");
        accountService.logout(username);
        model.addAttribute("account", new Account());
        return "login";
    }
    
    
    
}
