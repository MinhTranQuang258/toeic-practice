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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.tqminh.vn.toeicpractice.services.StatisticalService;

@Controller
public class StatisticalController {

    @Autowired
    @Qualifier("StatisticalService")
    private StatisticalService statisticalService;

}
