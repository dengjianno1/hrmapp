package com.djsoft.hrmapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.djsoft.hrmapp.service.HrmService;

@Controller
public class EmployeeController {
	@Autowired
	public HrmService hrmService;
	@RequestMapping(value="/employee/selectemployee")
	public String selectEmployee(Model model){
		model.addAttribute("employees", hrmService.findEmployee());
		return "employee/employee";
	}
}
