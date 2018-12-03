package com.advistor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import com.util.Md5;

public class Advice {

	public Advice() {
		// TODO Auto-generated constructor stub
	}
	public String beforeMethod(JoinPoint joinPoint) {
		System.out.println("�����������֣�"+joinPoint.getSignature().getName());
		System.out.println("��������������"+joinPoint.getArgs());
		Object[] args=joinPoint.getArgs();
		args[1]=Md5.getMD5(args[1].toString().getBytes());
		System.out.println(args[1]);
		System.out.println("���������"+joinPoint.getTarget());
		System.out.println("���ڵ��õ���ǰ�÷���");
		return (String) args[1];
	}
	
	public void afterReturningMethod(JoinPoint joinPoint, Object result){
		System.out.println("�����������֣�"+joinPoint.getSignature().getName());
		System.out.println("��������������"+joinPoint.getArgs());
		System.out.println("���������"+joinPoint.getTarget());
		System.out.println("���������ķ���ֵ"+result);
		System.out.println("���ڵ��õ��Ǻ��÷���");
	}
	
	public Object aroundMethod(ProceedingJoinPoint joinPoint) {
		System.out.println("���ڵ��õ��ǻ��Ʒ���------");		
		Object[] args=joinPoint.getArgs();
		args[1]=Md5.getMD5(args[1].toString().getBytes());
		Object result=null;
		try {
			result=joinPoint.proceed(args);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("���ڵ��õ��ǻ��Ʒ���------");
		return result;
	}
	
	public void throwExMethod(Exception ex) {
		System.out.println("���ڵ��õ����쳣����------");
		System.out.println(ex.getMessage());
		
	}

}
