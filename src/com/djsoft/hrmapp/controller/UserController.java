package com.djsoft.hrmapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.djsoft.hrmapp.domain.User;
import com.djsoft.hrmapp.service.HrmService;

@Controller
@SessionAttributes("user")
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
			model.addAttribute("user", user);
			//客户端跳转到main页面
			return "redirect:/main";
		}else {
			//设置登录失败提示信息
			model.addAttribute("message","登录名或密码错误！请重新输入");
			//服务器内部跳转到登录页面
			return "forward:/loginform";
		}
	}
	/**
	 * 处理查询请求
	 * @param pageIndex 请求的是第几页
	 * @param employee 模糊查询参数
	 * @param Model model
	 * */
	@RequestMapping(value="/user/selectuser")
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
	@RequestMapping("/user/adduser")
	public String addUser(@ModelAttribute User user,Model model){
		hrmService.addUser(user);
		//model.addAttribute("user", user);
		//设置跳转到添加页面
		return "forward:/user/selectuser";
	}
	/**
	 * 处理修改用户请求
	 * @param flag 标记，1表示跳转到修改页面，2表示执行修改操作
	 * @param user 要修改用户的对象
	 */
	@RequestMapping("/user/updateuserform")
	public String updateUserForm(@RequestParam int id,Model model){
		//设置客户端跳转到查询请求
		model.addAttribute("user", hrmService.findUserById(id));
		return "/user/updateuserform";

	}
	/**
	 * 处理修改用户请求
	 * @param flag 标记，1表示跳转到修改页面，2表示执行修改操作
	 * @param user 要修改用户的对象
	 */
	@RequestMapping("/user/updateuser")
	public String updateUser(@ModelAttribute User user){
		hrmService.modifyUser(user);
		//设置客户端跳转到查询请求
		return "redirect:/user/selectuser";

	}
	/**
	 * 处理删除用户请求
	 * @param ids 需要删除的id字符串
	 */
	@RequestMapping("/user/removeuser")
	public String removeUser(String id){
		//根据id删除用户
		hrmService.removeUserById(Integer.parseInt(id));
		return "forward:/user/selectuser";
	}
}
