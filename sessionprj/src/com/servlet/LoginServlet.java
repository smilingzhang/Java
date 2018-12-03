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
			//2.дcookie
			Cookie c=new Cookie("un", name);
			c.setMaxAge(60*60*24);//���ñ�����cookie�е����ʱ����Ĭ�ϱ���30����
			response.addCookie(c);//��cookie��Ӧ���ͻ���
			PrintWriter out=response.getWriter();
			out.print("success");
			out.close();
			//���session
		/*	HttpSession session=request.getSession();//����session��������Ϊtrue/false,���ʱfalse�򲻻Ὠ���µĻỰ��û�л�ȡ��ʱ����ֵΪnull
			session.setAttribute("username", name);//session��Attribute��ת��������ض���ʱ�����Թ������ݣ���requestֻ����ת������ʱ����
			*/
			//�ر�session
		}else {
			response.sendRedirect("index.jsp");
		}
	}

}
