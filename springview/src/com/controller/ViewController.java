package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

	public ViewController() {
		// TODO Auto-generated constructor stub
	}
	@RequestMapping("/hello")
	public String hi(Model model) {
		model.addAttribute("hi", "hi hi hi");
		return "hello";
	}
	@RequestMapping("/test")
	public String test(Model model) {
		model.addAttribute("test", "tttttt");
		return "test";
	}

}
