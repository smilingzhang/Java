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
		//1.��ȡ����
		String name=request.getParameter("username");//��ȡ�û��������
		String psw=request.getParameter("password");
		//2.ʵ��ҵ����
		boolean succ=false;
		if("zhangsan".equals(name)&& "123".equals(psw)){
			succ=true;
		}
		//3.��Ӧ
		if(succ) {
			/*PrintWriter out=response.getWriter();
			out.print("welcome"+name);
			out.close();*/
			//3.request��ߴ�Ķ������ܲ����õ�
			request.setAttribute("email","��");//�ڷ��������ٿռ䣬�Ѷ������ȥ
		
			response.sendRedirect("PerCenterServlet");//1.ʵ�����ض���PerCenter�ò�����Ϣ,��Ϊ�ض���ĵڶ�������û�з���Ϣ����ַ���ı�
			RequestDispatcher re=request.getRequestDispatcher("PerCenterServlet");//2.ת�����󣬵�ַ�����䣬һ������
			re.forward(request, response);
		}else {
			response.sendRedirect("index.html");//���ִ������תҳ��
		}
	}

}
