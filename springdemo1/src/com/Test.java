package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		//基于xml的配置
		//Computer pc=(Computer)ctx.getBean("Computer");
		//基于注解的配置
		Computer pc=(Computer)ctx.getBean(Computer.class);
		pc.play();
	}
}
