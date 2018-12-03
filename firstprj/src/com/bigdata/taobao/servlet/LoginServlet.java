package com.bigdata.taobao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.获取请求
		String name=request.getParameter("username");//获取用户请求参数
		String psw=request.getParameter("password");
		//2.实现业务功能
		boolean succ=false;
		if("zhangsan".equals(name)&& "123".equals(psw)){
			succ=true;
		}
		//3.响应
		if(succ) {
			/*PrintWriter out=response.getWriter();
			out.print("welcome"+name);
			out.close();*/
			//3.request里边存的东西还能不能拿到
			request.setAttribute("email","信");//在服务器开辟空间，把东西存进去
		
			response.sendRedirect("PerCenterServlet");//1.实现了重定向，PerCenter拿不到信息,因为重定向的第二次请求并没有发信息，地址栏改变
			RequestDispatcher re=request.getRequestDispatcher("PerCenterServlet");//2.转发请求，地址栏不变，一次请求
			re.forward(request, response);
		}else {
			response.sendRedirect("index.html");//出现错误就跳转页面
		}
	}

}
