package com.users.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.users.entity.User;
import com.users.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;

	public UserController() {
		// TODO Auto-generated constructor stub
	}
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String toAddUser() {
		return "login";
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addUser(@RequestParam(value="userName") String name,
			HttpServletRequest request) {
		
		User user=new User();
		user.setUserName(name);
		
		this.userService.addUser(user);
		return "index";
	}
}
