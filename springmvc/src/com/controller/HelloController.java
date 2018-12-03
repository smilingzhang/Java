package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	public HelloController() {
		// TODO Auto-generated constructor stub
	}
	@RequestMapping("/hello/{username}")
	public String hi(@PathVariable String username,Model model) {
		System.out.println("hello");
		model.addAttribute("name", username);
		return "main";
		
	}

}
