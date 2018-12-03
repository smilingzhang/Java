package com.dynamicproxy;


public class Test {

	public static void main(String[] args) {
		DynamicProxy lh = new DynamicProxy();
		UserService us = (UserService) lh.bind(new UserServiceImpl());
		us.login("zhangsan", "666");
	}

}
