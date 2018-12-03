package com.advistor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.util.Md5;
@Component
@Aspect
public class Advice {

	public Advice() {
		// TODO Auto-generated constructor stub
	}
	@Before("execution(* com.service.*.*(..))")
	public void beforeMethod(JoinPoint joinPoint) {
		System.out.println("�����������֣�"+joinPoint.getSignature().getName());
		System.out.println("��������������"+joinPoint.getArgs());
		Object[] args=joinPoint.getArgs();
		args[1]=Md5.getMD5(args[1].toString().getBytes());
		System.out.println(args[1]);
		System.out.println("���������"+joinPoint.getTarget());
		System.out.println("���ڵ��õ���ǰ�÷���");
		
	}
//	@AfterReturning(pointcut="execution(* com.service.*.*(..))",returning="result")
	public void afterReturningMethod(JoinPoint joinPoint, Object result){
		System.out.println("�����������֣�"+joinPoint.getSignature().getName());
		System.out.println("��������������"+joinPoint.getArgs());
		System.out.println("���������"+joinPoint.getTarget());
		System.out.println("���������ķ���ֵ"+result);
		System.out.println("���ڵ��õ��Ǻ��÷���");
	}
//	@Around("execution(* com.service.*.*(..))")
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
//	@AfterThrowing(value="execution(* com.service.*.*(..))",throwing="ex")
	public void throwExMethod(Exception ex) {
		System.out.println("���ڵ��õ����쳣����------");
		System.out.println(ex.getMessage());
		
	}

}
