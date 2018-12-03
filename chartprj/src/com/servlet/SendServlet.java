package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendServlet
 */
@WebServlet("/SendServlet")
public class SendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendServlet() {
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
		//先拿到要发送的内容
		String msg=request.getParameter("msg");
		//发送的人的名字是什么，在session中获取
		String name=request.getSession().getAttribute("myname").toString();
		String temp=name+"说："+msg;
		//2.把说的内容放到集合，再放到servletcontext中，让所有人都可以看见每个人说话的内容
		Object obj=this.getServletContext().getAttribute("msgs");
		if(obj==null) {
			ArrayList list=new ArrayList<>();
			list.add(temp);
			this.getServletContext().setAttribute("msgs", list);
		}else {
			java.util.List<String> list=(ArrayList)obj;
			list.add(temp);
			this.getServletContext().setAttribute("msgs", list);
		}
		response.sendRedirect("send.jsp");
	}
	

}
