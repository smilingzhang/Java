package com.cakeonline.user.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cakeonline.entity.Users;
import com.cakeonline.user.service.UserServiceImpl;

@Controller
@RequestMapping("/users")
public class UsersController {
	@Resource
	private UserServiceImpl userServiceImpl;

	public UsersController() {
		// TODO Auto-generated constructor stub
	}
	@RequestMapping(value="/regist",method=RequestMethod.GET)
	public String toRegist() {
		System.out.println("注册前的准备");
		return "regist";
	}
	@RequestMapping(value="/regist",method=RequestMethod.POST)
	public String regist(Users users,HttpSession session) {
		boolean b=this.userServiceImpl.regist(users);
		if(b) {
			session.setAttribute("users", users);
			return "index";
		}else {
			return "redirect:regist";
		}
		
	}

}
