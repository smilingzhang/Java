package com.bigdata.taobao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet implements Servlet {

	public HelloServlet() {
		// TODO �Զ����ɵĹ��캯�����
	}

	@Override
	public void destroy() {  /**���ٵ�ʱ��ִ��һ��,���ٷ���:�ڷ���������Ǹ����Ϳ��ԣ�����ڿ���̨���������ֹ��*/
		// TODO �Զ����ɵķ������
		System.out.println("destory");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {/**�����ش���Ŀʱ��ִֻ��һ��*/
		// TODO �Զ����ɵķ������
		System.out.println("init");

	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO �Զ����ɵķ������
/**ֻҪ�пͻ������ִ�У���ִ�ж�Σ����������ֻ������������Զ��ִ��*/
		System.out.println("ser");
		String name=arg0.getParameter("name");//�����������д���֣�����һ���ı��������
		name="hello"+name;//����ҵ���߼�
		PrintWriter out=arg1.getWriter();//����������ͻ���
		out.print(name);//��Ӧ������Ҫд���ͻ��˵�����
		out.close();
	}

}
