package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

	public UserController() {
		// TODO Auto-generated constructor stub
	}
	@RequestMapping("/login")
	public void login() {
		System.out.println("��¼");
	}
	@RequestMapping("/list")
	public void list() {
		System.out.println("�û��б�");
				
	}

}
