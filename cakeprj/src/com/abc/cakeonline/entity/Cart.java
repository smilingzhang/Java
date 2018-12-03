package com.abc.cakeonline.entity;

import java.util.HashMap;

public class Cart {

	public Cart() {
		// TODO Auto-generated constructor stub
	}

	private HashMap<Integer, CartItem> hMap = new HashMap<Integer, CartItem>();

	public HashMap<Integer, CartItem> gethMap() {
		return hMap;
	}

	public void sethMap(HashMap<Integer, CartItem> hMap) {
		this.hMap = hMap;
	}

	public void add(Cake cake) {
		if (hMap.containsKey(cake.getId())) {
			int count = hMap.get(cake.getId()).getCount() + 1;
			hMap.get(cake.getId()).setCount(count);
		} else {
			CartItem cartItem = new CartItem();
			cartItem.setCake(cake);
			cartItem.setCount(1);
			hMap.put(cake.getId(), cartItem);
		}
	}
}
