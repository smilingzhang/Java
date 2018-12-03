package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.Province;
import com.entity.User;
@Controller
@RequestMapping("/user")
public class UserController {

	public UserController() {
		// TODO Auto-generated constructor stub
	}
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String toAdd(Model model) {
		User user=new User();
		model.addAttribute("user", user);
		List<Province> pro=new ArrayList();
		Province p1=new Province();
		p1.setId(1);
		p1.setName("河北省");
		Province p2=new Province();
		p2.setId(2);
		p2.setName("山东省");
		pro.add(p1);
		pro.add(p2);
		model.addAttribute("pros", pro);
		return "user";
		
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(User user) {
		System.out.println("用户id为："+user.getId());
		System.out.println("省份编号为："+user.getProvince().getId());
		System.out.println("省份名字为："+user.getProvince().getName());
		return "index";
	}
	

}
