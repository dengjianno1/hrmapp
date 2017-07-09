package com.djsoft.hrmapp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.djsoft.hrmapp.domain.User;
import com.djsoft.hrmapp.service.HrmService;
import com.djsoft.hrmapp.util.comman.HrmConstants;

@Controller
public class UserController {
	/**
	 * 自动注入UserService
	 */
	@Autowired
	@Qualifier("hrmService")
	private HrmService hrmService;
	/**
	 * 处理登录请求
	 * @param loginname 登录名
	 * @param password 密码
	 * @return 跳转的视图
	 */
	@RequestMapping("/login")
	public String login(@RequestParam("loginname") String loginname,@RequestParam("password") String password,Model model){
		//调用业务逻辑组件判断用户是否可以登录
		User user=hrmService.login(loginname, password);
		if (user!=null) {
			//将用户保存到HttpSession当中
			//session.setAttribute(HrmConstants.USER_SESSION, user);
			model.addAttribute("user", user);
			//客户端跳转到main页面
			return "redirect:/main";
		}else {
			//设置登录失败提示信息
			model.addAttribute("message","登录名或密码错误！请重新输入");
			//服务器内部跳转到登录页面
			return "forward:/loginForm";
		}
	}
	/**
	 * 处理查询请求
	 * @param pageIndex 请求的是第几页
	 * @param employee 模糊查询参数
	 * @param Model model
	 * */
	@RequestMapping(value="/user/selectUser")
	 public String selectUser(
			 @ModelAttribute User user,
			 Model model){
		System.out.println("user = " + user);
		/** 查询用户信息     */
		List<User> users = hrmService.findUser(user);
		model.addAttribute("users", users);
		return "user/user";
		
	}
	/**
	 * 处理添加请求
	 * @param flag 标记，1表示跳转到修改页面，2表示执行修改操作
	 * @param user 要修改用户的对象
	 */
	@RequestMapping("/user/showadduser")
	public String showAddUser(){
		//设置跳转到添加页面
		return "user/showAddUser";
	}
	/**
	 * 处理添加请求
	 * @param flag 标记，1表示跳转到修改页面，2表示执行修改操作
	 * @param user 要修改用户的对象
	 */
	@RequestMapping("/user/addUser")
	public String addUser(@ModelAttribute User user,Model model){
		hrmService.addUser(user);
		//model.addAttribute("user", user);
		//设置跳转到添加页面
		return "forward:/user/selectUser";
	}
	/**
	 * 处理修改用户请求
	 * @param flag 标记，1表示跳转到修改页面，2表示执行修改操作
	 * @param user 要修改用户的对象
	 */
	@RequestMapping("/user/showupdateUser")
	public String showUpdateUser(){
		//返回
		return "user/showUpdateUser";
	}
	/**
	 * 处理修改用户请求
	 * @param flag 标记，1表示跳转到修改页面，2表示执行修改操作
	 * @param user 要修改用户的对象
	 */
	@RequestMapping("/user/updateUser")
	public String updateUser(@ModelAttribute User user){
		//执行修改操作
		user.setId(6);
		hrmService.modifyUser(user);
		//设置客户端跳转到查询请求
		return "redirect:/user/selectUser";

	}
}
