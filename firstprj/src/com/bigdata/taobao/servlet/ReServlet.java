package com.bigdata.taobao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReServlet
 */

public class ReServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static Connection conn;
	 private  static Statement st;
	 private static  ResultSet rs;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReServlet() {
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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//解决乱码
		request.setCharacterEncoding("UTF-8");//从请求到服务器防止出现乱码问题
		// TODO Auto-generated method stub
		// 1.获取请求
		String name = request.getParameter("username");
		String psw = request.getParameter("password");
		String repsw = request.getParameter("repass");
		String sex = request.getParameter("sex");
		String[] hobby = request.getParameterValues("hobby");//注意多选按钮
		String addr = request.getParameter("jiguan");
		
		//遍历多选按钮的字符串数组
		String like="";
		for(int i=0;i<hobby.length;i++) {
			like=like+hobby[i];
		}
		
		/**解析请求
		Enumeration e=request.getHeaderNames();//获取所有头部信息的名称
		while(e.hasMoreElements()) {
			Object obj=e.nextElement();
			System.out.println(obj+":");
			String val=request.getHeader(obj.toString());//头部信息的具体值
			System.out.println(val);
		}*/
		// 2.实现业务逻辑
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 Conn();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		boolean succ=true;
		boolean flag=false;
		if ((name != null) && (psw != null) && (repsw != null) && (psw.equals(repsw))) {
			flag=true;
			try {
				rs=st.executeQuery("select * from registtable");
				while(rs.next()) {
					if(name.equals(rs.getString("username"))) {
						succ=false;
					}
				}
			} catch (SQLException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		}
		//返回响应
		response.setContentType("text/html;charset=utf-8");//设置响应的返回类型为文本类型
		response.setCharacterEncoding("utf-8");  //防止从服务器返回的时候乱码
		// 3.响应
	
		if (succ&&flag) {
			try {
				insertStu("insert into registtable values(?,?,?,?,?)", name, psw, sex, like, addr);
			} catch (ClassNotFoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
			RequestDispatcher re=request.getRequestDispatcher("PerCenterServlet");//2.转发请求，地址栏不变，一次请求
			re.forward(request, response);
		} else {
			/*out.print("failed");
			out.close();*/
			response.sendRedirect("PerCenterServlet");//重定向,地址改变
		}
	}
	//查询数据库
	
 
   //建立数据库连接
   public static void Conn() throws SQLException{
		// TODO 自动生成的构造函数存根
	   conn = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/regist?useUnicode=true&characterEncoding=UTF-8", "root", "");
		st=conn.createStatement();
	}
	
//向数据库插入数据
	public static int insertStu(String sql, String... args) throws SQLException, ClassNotFoundException {

		int row = 0;
		PreparedStatement ps = null;
		if (sql == null || sql.equals("")) {

			return 0;
		} else {
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			row = ps.executeUpdate();
			return row;
		}

	}

}
