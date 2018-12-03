package com.advistor;

import org.springframework.aop.ThrowsAdvice;


public class ExceptionAdvice implements ThrowsAdvice{

	public ExceptionAdvice() {
		// TODO Auto-generated constructor stub
	}
	public void afterThrowing(Exception e) {
		System.out.println("“Ï≥£¿‡–Õ£∫"+e.getMessage());
	}

}
