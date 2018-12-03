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
		//1.��ȡ�ͻ������ǳ�
		String name=request.getParameter("username");
		//2.��servletcontext��ȡ����
		Object obj=this.getServletContext().getAttribute("names");
		//obj==nullΪ��һ���������ҵ���
		if(obj==null) {
			//���Լ������ִ浽�Լ���session��session����û��Լ������˿�����
			request.getSession().setAttribute("myname", name);
			//���û������ַŵ�����
			ArrayList list=new ArrayList<>();
			list.add(name);
			//�ٰѼ��Ϸŵ�servletconntext,��ΪҪ�����е��û������Կ������˵��ǳ�
			this.getServletContext().setAttribute("names", list);
			response.sendRedirect("main.jsp");
		}else {
			boolean isExist=false;
			ArrayList<String> list= (ArrayList)obj;
			for(String temp:list) {
				if(temp.equals(name)) {
					isExist=true;
					break;//���������ľ�����ѭ��
				}
			}
			if(isExist) {
				//���û�����Ϣ�������ǳ��ѱ�ռ��
				request.setAttribute("msg", "�����ǳ��ѱ�ʹ�ã�");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else {
				//û��������
				request.getSession().setAttribute("myname", name);
				list.add(name);
				this.getServletContext().setAttribute("names", list);
				response.sendRedirect("main.jsp");
			}
		}
	}

}
