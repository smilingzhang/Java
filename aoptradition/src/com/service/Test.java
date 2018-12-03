package com.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		UserService userService=(UserService)ctx.getBean("UserServiceProxy");
		boolean isRegist=userService.login("zhangsan", "123456");
		System.out.println("×¢²áÊÇ·ñ³É¹¦£º"+isRegist);
	}
}
