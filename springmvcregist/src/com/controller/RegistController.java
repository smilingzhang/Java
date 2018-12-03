package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.User;
@Controller
@RequestMapping("/user")
public class RegistController {

	public RegistController() {
		// TODO Auto-generated constructor stub
	}
	@RequestMapping(value="/regist",method=RequestMethod.GET)
	public String toRegist(Model model) {
		List city =new ArrayList<>();
		city.add("河北省");
		city.add("湖南省");
		city.add("北京");
		model.addAttribute("city",city);
		return "regist";
	}
	@RequestMapping(value="/regist",method=RequestMethod.POST)
	public String regist(User user,Model model) {
		System.out.println("数据已保存到数据库");
		System.out.println(user.getUsername());
		List city =new ArrayList<>();
		city.add("河北省");
		city.add("湖南省");
		city.add("北京");
		model.addAttribute("city",city);	
		return "regist";
		
	}

}
