package com.djsoft.hrmapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.djsoft.hrmapp.service.HrmService;

@Controller
public class JobController {
	@Autowired
	private HrmService hrmService;
	@RequestMapping(value="/job/selectjob")
	public String selectJob(Model model){
		model.addAttribute("jobs", hrmService.findJob());
		return "job/job";
	}
}
