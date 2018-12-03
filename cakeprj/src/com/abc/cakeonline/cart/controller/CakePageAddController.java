package com.abc.cakeonline.cart.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.abc.cakeonline.cake.service.CakeDetailService;
import com.abc.cakeonline.entity.Cake;
import com.abc.cakeonline.entity.Cart;

@Controller
public class CakePageAddController { // 分页检索页面加入购物车
	@Resource
	private CakeDetailService cakeDetailService;

	@RequestMapping("/CakePageAddServlet")
	public String addCart(@RequestParam(value = "id", required = false) String requestId, HttpServletRequest request,
			HttpSession session) {
		int id = 0;
		Cart cart = null;
		id = Integer.parseInt(requestId);
		Cake cake = this.cakeDetailService.findId(id);
		Object obj = session.getAttribute("cart");
		if (obj == null) {
			cart = new Cart();
		} else {
			cart = (Cart) obj;
		}
		cart.add(cake);
		session.setAttribute("cart", cart);
		return "redirect:CakeDetailServlet?id=" + requestId + "";
	}

}
