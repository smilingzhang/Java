package com.constructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("com")
public class Computer {
	@Value("#{new com.constructor.Memory(33)}")
	private Memory memory;
	@Value("#{new int []{1,2,3}}")
	private int a[];

	public Computer() {
		// TODO Auto-generated constructor stub
	}
	public void show() {
		System.out.println(a[2]);
		System.out.println(memory.getMemoryNum());
	}
	

}
