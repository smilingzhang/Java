package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		//����xml������
		//Computer pc=(Computer)ctx.getBean("Computer");
		//����ע�������
		Computer pc=(Computer)ctx.getBean(Computer.class);
		pc.play();
	}
}
