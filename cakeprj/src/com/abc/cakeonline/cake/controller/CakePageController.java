package com.abc.cakeonline.cake.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.abc.cakeonline.cake.service.CakePageService;
import com.abc.cakeonline.entity.Cake;
import com.abc.cakeonline.entity.Page;

@Controller
public class CakePageController {
	@Resource
	private CakePageService cakePageService;

	@RequestMapping("/CakePageServlet")
	public String page(@RequestParam(value = "pageNum", required = false) String pageNum,
			@RequestParam(value = "level", required = false) String l, HttpServletRequest request) {

		Integer num = 0;
		Integer level = 0;
		if (pageNum == null || pageNum.equals("")) {

			num = 1;
		} else {

			num = Integer.parseInt(pageNum);
		}
		if (l == null || l.equals("")) {

			level = 4;// level默认为4个星的
		} else {

			level = Integer.parseInt(l);
		}

		List<Cake> cakes = this.cakePageService.find(num, 3, level);// 查到的蛋糕
		int count = this.cakePageService.countAll(level);// 蛋糕的总数

		Page page = new Page(num, 3);
		page.setCake(cakes);
		page.setPageNum(num);
		page.setPrePageNum(num - 1);
		page.setNextPageNum(num + 1);
		page.setTotalCount(count);
		page.setTotalPageCount(count);

		request.setAttribute("pages", page);
		request.setAttribute("level", level);
		request.setAttribute("num", count);
		return "products";

	}
}
