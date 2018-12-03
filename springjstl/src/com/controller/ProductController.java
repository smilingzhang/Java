package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.Product;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	public ProductController() {
		// TODO Auto-generated constructor stub
	}
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String toAdd(Model model) {
		Product product=new Product();
		model.addAttribute("pro",product);
		List<String> sizes=new ArrayList<String>();
		sizes.add("xl");
		sizes.add("xxl");
		sizes.add("xxxl");
		List<String> pa=new ArrayList<String>();
		pa.add("china");
		pa.add("america");
		model.addAttribute("sizes", sizes);
		model.addAttribute("pa", pa);
		return "product";
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(Product product) {
		System.out.println(product.getId());
		System.out.println(product.getName());
		System.out.println(product.getSoldOut());
		for(String temp:product.getColor())
			System.out.println(temp);
		System.out.println(product.getFavourateColor());
		for(String temp:product.getSize())
			System.out.println(temp);
		System.out.println(product.getSellType());
		System.out.println(product.getProducingArea());
		return "index";
	}
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String edit(Model model) {
		return "product";
	}
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String toEdit(Product product) {
		return "index";
	}

}
