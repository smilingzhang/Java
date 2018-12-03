package com.advistor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import com.util.Md5;

public class Advice {

	public Advice() {
		// TODO Auto-generated constructor stub
	}
	public String beforeMethod(JoinPoint joinPoint) {
		System.out.println("被代理方法名字："+joinPoint.getSignature().getName());
		System.out.println("被代理方法参数："+joinPoint.getArgs());
		Object[] args=joinPoint.getArgs();
		args[1]=Md5.getMD5(args[1].toString().getBytes());
		System.out.println(args[1]);
		System.out.println("被代理对象："+joinPoint.getTarget());
		System.out.println("现在调用的是前置方法");
		return (String) args[1];
	}
	
	public void afterReturningMethod(JoinPoint joinPoint, Object result){
		System.out.println("被代理方法名字："+joinPoint.getSignature().getName());
		System.out.println("被代理方法参数："+joinPoint.getArgs());
		System.out.println("被代理对象："+joinPoint.getTarget());
		System.out.println("被代理对象的返回值"+result);
		System.out.println("现在调用的是后置方法");
	}
	
	public Object aroundMethod(ProceedingJoinPoint joinPoint) {
		System.out.println("现在调用的是环绕方法------");		
		Object[] args=joinPoint.getArgs();
		args[1]=Md5.getMD5(args[1].toString().getBytes());
		Object result=null;
		try {
			result=joinPoint.proceed(args);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("现在调用的是环绕方法------");
		return result;
	}
	
	public void throwExMethod(Exception ex) {
		System.out.println("现在调用的是异常方法------");
		System.out.println(ex.getMessage());
		
	}

}
