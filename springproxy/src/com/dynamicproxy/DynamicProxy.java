package com.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler{
	private Object handler;

	public DynamicProxy() {
		// TODO Auto-generated constructor stub
	}
	public Object bind(Object handler) {
		this.handler = handler;
		return Proxy.newProxyInstance(handler.getClass().getClassLoader(), handler.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
		Object result = null;
		result = arg1.invoke(handler, arg2);
		System.out.println("ÈÕÖ¾£º" + arg2[0] +  "µÇÂ¼");
		return result;
	}

}
