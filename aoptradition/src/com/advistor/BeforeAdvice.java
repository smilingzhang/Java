package com.advistor;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

import com.util.Md5;



public class BeforeAdvice implements MethodBeforeAdvice{

	public BeforeAdvice() {
		// TODO Auto-generated constructor stub
	}
//参数为被代理类中的方法，被代理类，参数
	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		System.out.println(arg0.getName());
		System.out.println(arg2.getClass().getName());
		System.out.println(arg1[0]);
		arg1[1]=Md5.getMD5(arg1[1].toString().getBytes());
		System.out.println(arg1[1]);
		
	}

}
