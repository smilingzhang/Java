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
public class RegistController {
	@Resource
	private UserService userService;

	@RequestMapping("/RegistServlet")
	public String regist(@RequestParam("mail") String mail, @RequestParam("username") String username,
			@RequestParam("password") String password, HttpServletRequest request, HttpSession session) {

		User user = new User();
		user.setMail(mail);
		user.setUsername(username);
		user.setPassword(password);
		user.setRegist(new java.sql.Date(new java.util.Date().getTime()));
		this.userService.inser(user);
		session.setAttribute("users", user);
		return "registsuccess";

	}

}
