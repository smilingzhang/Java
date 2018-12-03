package com.jd.shop.car.service;

import java.util.HashMap;

import com.jd.shop.entity.Product;

public class Car {
    //把购物车放到一个map集合 key=id,value=CarItem
	HashMap<String, CarItem> hs=new HashMap<String, CarItem>();
	public HashMap<String, CarItem> getHs() {
		return hs;
	}
	public void setHs(HashMap<String, CarItem> hs) {
		this.hs = hs;
	}
	public Car() {
		// TODO Auto-generated constructor stub
	}
	public void add(Product p) {
		//如果购物车里已经有了这个物品，则在原有基础上+1，如果没有则将数量设置为1
		if(hs.containsKey(p.getId())) {//containKey()判断是否存在这个id(key值)，get()取出此id对应得value,此时是一个CarItem对象
			int count=hs.get(p.getId()).getCount()+1;
			hs.get(p.getId()).setCount(count);	
		}else {
			CarItem c=new CarItem();
			c.setP(p);
			c.setCount(1);
			hs.put(p.getId(), c);
		}
		
	}

}
