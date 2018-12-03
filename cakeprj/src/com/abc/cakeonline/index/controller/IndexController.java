package com.abc.cakeonline.index.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.abc.cakeonline.cake.service.CakeService;
import com.abc.cakeonline.entity.Cake;
import com.abc.cakeonline.entity.CakeType;
import com.abc.cakeonline.type.service.CakeTypeService;

@Controller
public class IndexController {
	@Resource
	private CakeTypeService cakeTypeService;
	@Resource
	private CakeService cakeService;

	@RequestMapping("/IndexServlet")
	public String index(HttpServletRequest request) {
		List<CakeType> cakeType = this.cakeTypeService.find();
		request.getServletContext().setAttribute("cakeType", cakeType);

		List<Cake> cake = this.cakeService.maxHeight();
		request.setAttribute("cake", cake);

		return "index";
	}

}
