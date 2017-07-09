/**
 * 
 */
package com.djsoft.hrmapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping(value={"/","/loginForm"})
	public String home() {
		return "loginForm";
	}
	@RequestMapping(value="/main")
	public String hrmMain(){
		return "main";
	}
}
