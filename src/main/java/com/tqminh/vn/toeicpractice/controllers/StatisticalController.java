/*
 * Class: StatisticalController
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

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tqminh.vn.toeicpractice.common.Constant;
import com.tqminh.vn.toeicpractice.model.Result;
import com.tqminh.vn.toeicpractice.services.StatisticalService;

@Controller
public class StatisticalController {
    
    @Autowired
    @Qualifier("StatisticalService")
    private StatisticalService statisticalService;
    
    @RequestMapping(value="/admin/statistication")
    public String displayStatistication(Model model) {
        try {
            int concurrentUser= statisticalService.getConcurrentUser();
            List<Result> results= statisticalService.getTopTenScore(LocalDate.now().toString());
            
            for (Result result : results) {
                result.getMultipleChoices();
            }
            
            model.addAttribute("concurrentUser", concurrentUser);
            model.addAttribute("results", results);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return Constant.Page.DASH_BOARD_PAGE;
    }
    
    @RequestMapping(value= "/admin/search", method= RequestMethod.GET)
    public String searchResult(@RequestParam String search, Model model) {
        try {
            Result result = statisticalService.getResultByUsername(search, LocalDate.now().toString());
            if(result != null) {
                model.addAttribute("results", result);
            }
            else {
                return "redirect:/admin/statistication";
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return Constant.Page.DASH_BOARD_PAGE;
    }

}
