package com.advistor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundAdvice implements MethodInterceptor{

	public AroundAdvice() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		System.out.println("������ʼִ��");
		//��ʵ�����е�ҵ���߼�����ִ�У����ȥ����ʵ�����еķ�����ִ��
		System.out.println(arg0.getMethod().getDeclaringClass().getName());
		Object result = arg0.proceed();
		System.out.println("��������ִ��");
		return false;
	}

}
