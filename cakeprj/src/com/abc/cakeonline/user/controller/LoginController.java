package com.abc.cakeonline.user.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.abc.cakeonline.entity.User;
import com.abc.cakeonline.user.service.UserService;

@Controller
public class LoginController {
	@Resource
	private UserService userService;

	@RequestMapping("/LoginServlet")
	public String login(@RequestParam("mail") String mail, @RequestParam("password") String password,
			HttpServletRequest request, HttpSession session) {

		int i = this.userService.findByMail(mail, password);
		// i==0代表未注册，i==1代表登录成功，i==2代表已注册但密码错误
		if (i == 0) {
			return "unregist";
		} else if (i == 1) {
			User user = new User();
			user.setMail(mail);
			user.setPassword(password);
			session.setAttribute("u", user);
			return "main";
		} else {
			return "passworderror";
		}

	}

}
