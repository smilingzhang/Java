package com.servlet;
/**
 * 
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Hello
 */
@WebServlet("/Hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hello() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//≤‚ ‘ServletContextListener
		this.getServletContext().setAttribute("count", 1);
		this.getServletContext().setAttribute("count", 2);
		this.getServletContext().removeAttribute("count");
		//≤‚ ‘httpSessionlistener
	/**	HttpSession s =request.getSession();
		s.setAttribute("name", "zhangsan");
		s.invalidate();*/
		//≤‚ ‘HttpSessionBindingListener
		Student stu=new Student("zhangsan",18);
		HttpSession session=request.getSession();
		session.setAttribute("sename", stu);
		session.removeAttribute("sename");
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
