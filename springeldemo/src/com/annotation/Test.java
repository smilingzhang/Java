package com.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		Memory memory = (Memory)ctx.getBean("memory");
		Computer computer=(Computer)ctx.getBean("computer");
		System.out.println(computer.getMemoryNum());
		memory.setMemoryNum(2048);
		System.out.println(computer.getMemoryNum());
		System.out.println(memory.getMemoryNum());
		System.out.println(computer.getMemory().getMemoryNum());
		
	}

}
