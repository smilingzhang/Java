package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
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
		//1.获取客户请求，昵称
		String name=request.getParameter("username");
		//2.从servletcontext中取集合
		Object obj=this.getServletContext().getAttribute("names");
		//obj==null为第一个进聊天室的人
		if(obj==null) {
			//把自己的名字存到自己的session，session针对用户自己，别人看不到
			request.getSession().setAttribute("myname", name);
			//把用户的名字放到集合
			ArrayList list=new ArrayList<>();
			list.add(name);
			//再把集合放到servletconntext,因为要让所有的用户都可以看到别人的昵称
			this.getServletContext().setAttribute("names", list);
			response.sendRedirect("main.jsp");
		}else {
			boolean isExist=false;
			ArrayList<String> list= (ArrayList)obj;
			for(String temp:list) {
				if(temp.equals(name)) {
					isExist=true;
					break;//存在重名的就跳出循环
				}
			}
			if(isExist) {
				//给用户的信息：您的昵称已被占用
				request.setAttribute("msg", "您的昵称已被使用！");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else {
				//没有重名的
				request.getSession().setAttribute("myname", name);
				list.add(name);
				this.getServletContext().setAttribute("names", list);
				response.sendRedirect("main.jsp");
			}
		}
	}

}
