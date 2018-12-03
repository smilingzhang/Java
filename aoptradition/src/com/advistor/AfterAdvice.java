package com.advistor;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class AfterAdvice implements AfterReturningAdvice{

	public AfterAdvice() {
		// TODO Auto-generated constructor stub
	}
//参数为实现类中方法的返回值、方法名、参数数组、实现类名
	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println(arg0);
		System.out.println(arg1.getName());
		System.out.println(arg2[0]);
		System.out.println(arg3.getClass().getName());
		System.out.println("用户注册成功，赠送100积分。");
	}

}
