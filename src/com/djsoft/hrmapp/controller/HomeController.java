/**
 * 
 */
package com.djsoft.hrmapp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.djsoft.hrmapp.domain.User;

@Controller
public class HomeController {
	@RequestMapping(value={"/","/loginform"})
	public String home() {
		return "loginform";
	}
	@RequestMapping(value="/main")
	public String hrmMain(@ModelAttribute User user){
		return "main";
	}
	@RequestMapping(value="/removesession")
	public String removeSession(HttpSession session){
		session.removeAttribute("user");
		return "main";
	}
}
