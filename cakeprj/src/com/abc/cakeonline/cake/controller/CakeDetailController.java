package com.abc.cakeonline.cake.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.abc.cakeonline.cake.service.CakeDetailService;
import com.abc.cakeonline.entity.Cake;

@Controller
public class CakeDetailController {
	@Resource
	private CakeDetailService cakeDetailService;

	@RequestMapping("/CakeDetailServlet")
	public String showDetail(@RequestParam(value = "id", required = false) String requestId,
			HttpServletRequest request) {
		int id = 0;
		id = Integer.parseInt(requestId);
		Cake cake = this.cakeDetailService.findId(id);
		request.setAttribute("cakedetail", cake);
		return "single";

	}

}
