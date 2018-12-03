package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;



/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("username");
		String psw=request.getParameter("password");
		if("zs".equals(name)&&"123".equals(psw)) {
			//2.写cookie
			Cookie c=new Cookie("un", name);
			c.setMaxAge(60*60*24);//设置保存在cookie中的最大时长，默认保存30分钟
			response.addCookie(c);//把cookie响应给客户端
			PrintWriter out=response.getWriter();
			out.print("success");
			out.close();
			//获得session
		/*	HttpSession session=request.getSession();//建立session参数可以为true/false,如果时false则不会建立新的会话，没有获取到时返回值为null
			session.setAttribute("username", name);//session的Attribute在转发请求和重定向时都可以共享数据，而request只能在转发请求时共享
			*/
			//关闭session
		}else {
			response.sendRedirect("index.jsp");
		}
	}

}
