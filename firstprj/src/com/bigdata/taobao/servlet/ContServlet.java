package com.bigdata.taobao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContServlet
 */

public class ContServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //ͳ�Ʒ��ʵĴ�����ContextServlet����Ϊȫ�ֱ���
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.ServletContext�ӿ�
		/*ServletContext context=this.getServletContext();//����һ��ServletContext����
		context.getInitParameter("count");//��ȡ��ʼ����
		Object obj=context.getAttribute("count");
		if(obj==null) {
			context.setAttribute("count", 1);
		}else {
			int count=Integer.parseInt(obj.toString());
			count++;
			context.setAttribute("count", count);
		}
		PrintWriter out=response.getWriter();
		out.print(obj);
		out.close();*/
		//2.ServletConfig,�ֲ���ʼ����,ת��������Թ����ض��򲻿���
		/**ServletConfig s=this.getServletConfig();
		String val=s.getInitParameter("num");
		System.out.println(val);
		request.setAttribute("name", val);
		RequestDispatcher rs=request.getRequestDispatcher("PerCenterServlet");
		rs.forward(request, response);
	//	response.sendRedirect("PerCenterServlet");*/
		
		//3.ȫ�ֳ�ʼ�������ض����ת�����󶼿��Թ������ݣ���ServletContext�����setAttribute()��getAttribute()
		ServletContext s=this.getServletContext();
		String a=s.getInitParameter("count");
		System.out.println(a);
		s.setAttribute("name", a);
	/*	RequestDispatcher rs=request.getRequestDispatcher("PerCenterServlet");
		rs.forward(request, response);*/
		response.sendRedirect("PerCenterServlet");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
