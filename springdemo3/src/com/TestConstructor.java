package com;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestConstructor {

	public TestConstructor() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		Person person=(Person)ctx.getBean("person");
		person.sayHello();
		person.driveCar();
		List list=person.getList();
		System.out.println(list.size());
	}

}
