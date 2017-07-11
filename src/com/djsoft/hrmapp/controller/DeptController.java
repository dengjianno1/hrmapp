package com.djsoft.hrmapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.djsoft.hrmapp.domain.Dept;
import com.djsoft.hrmapp.service.HrmService;

@Controller
public class DeptController {
	@Autowired
	private HrmService hrmService;
	@RequestMapping(value="/dept/selectdept")
	public String selectDept(Model model){
		List<Dept> depts=hrmService.findDept();
		model.addAttribute("depts", depts);
		return "dept/dept";
	}
	@RequestMapping(value="/dept/adddept")
	public String addDept(@ModelAttribute Dept dept){
		hrmService.addDept(dept);
		return "forward:/dept/selectdept";
	}
	@RequestMapping(value="/dept/removedept")
	public String removeDept(@RequestParam int id){
		hrmService.removeDeptById(id);
		return "forward:/dept/selectdept";
	}
	@RequestMapping(value="dept/updatedeptform")
	public String updateDeptForm(@RequestParam int id,Model model){
		model.addAttribute("dept", hrmService.findDeptById(id));
		return "dept/updatedeptform";
	}
	@RequestMapping(value="/dept/updatedept")
	public String updateDept(@ModelAttribute Dept dept){
		hrmService.modifyDept(dept);
		return "forward:/dept/selectdept";
	}
}
