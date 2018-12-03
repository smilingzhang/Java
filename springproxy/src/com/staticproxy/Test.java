package com.staticproxy;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		StaticProxy staticProxy=new StaticProxy(new UserServiceImpl());
		staticProxy.login("zhangsan", "123");
	}

}
