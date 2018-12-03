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
		// TODO 自动生成的构造函数存根
	}

	@Override
	public void destroy() {  /**销毁的时候执行一次,销毁方法:在服务器里点那个红点就可以，如果在控制台点红点就是终止了*/
		// TODO 自动生成的方法存根
		System.out.println("destory");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {/**当加载此项目时，只执行一次*/
		// TODO 自动生成的方法存根
		System.out.println("init");

	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO 自动生成的方法存根
/**只要有客户请求就执行，可执行多次，这五个方法只有这个方法可以多次执行*/
		System.out.println("ser");
		String name=arg0.getParameter("name");//请求，引号里边写名字，比如一个文本框的名字
		name="hello"+name;//处理业务逻辑
		PrintWriter out=arg1.getWriter();//把输出流给客户端
		out.print(name);//响应，代表要写给客户端的内容
		out.close();
	}

}
