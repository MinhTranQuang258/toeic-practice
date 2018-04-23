/*
 * Class: UserHomeController
 *
 * Created on Apr 23, 2018
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

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tqminh.vn.toeicpractice.common.Constant;

@Controller
public class UserHomeController {

    @RequestMapping(value= "/user", method= RequestMethod.GET)
    public String displayUserHome(HttpSession session, Model model) {
        model.addAttribute("name", session.getAttribute("username"));
        return Constant.Page.USER_HOME_PAGE;
    }
    
}
