package com.advistor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundAdvice implements MethodInterceptor{

	public AroundAdvice() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		System.out.println("方法开始执行");
		//让实现类中的业务逻辑方法执行，如果去掉，实现类中的方法不执行
		System.out.println(arg0.getMethod().getDeclaringClass().getName());
		Object result = arg0.proceed();
		System.out.println("方法结束执行");
		return false;
	}

}
