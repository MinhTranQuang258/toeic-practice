package com.tqminh.vn.toeicpractice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tqminh.vn.toeicpractice.common.Constant;
import com.tqminh.vn.toeicpractice.model.form.Question;

@Controller
public class AdminController {
	
	@RequestMapping(value= "/displayAdmin", method= RequestMethod.GET)
	public String displayAdminPage(Model model) {
		model.addAttribute("question", new Question());
		return Constant.Page.ADMIN_PAGE;
	}
	
	@RequestMapping(value= "/displayAdminEdit", method= RequestMethod.GET)
	public String displayAdminEditPage() {
		return Constant.Page.ADMIN_EDIT_PAGE;
	}
	
	@RequestMapping(value= "/displayAdminAdd", method= RequestMethod.GET)
	public String displayAdminAddPage() {
		return Constant.Page.ADMIN_ADD_PAGE;
	}
}
