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
		
		//�������
		request.setCharacterEncoding("UTF-8");//�����󵽷�������ֹ������������
		// TODO Auto-generated method stub
		// 1.��ȡ����
		String name = request.getParameter("username");
		String psw = request.getParameter("password");
		String repsw = request.getParameter("repass");
		String sex = request.getParameter("sex");
		String[] hobby = request.getParameterValues("hobby");//ע���ѡ��ť
		String addr = request.getParameter("jiguan");
		
		//������ѡ��ť���ַ�������
		String like="";
		for(int i=0;i<hobby.length;i++) {
			like=like+hobby[i];
		}
		
		/**��������
		Enumeration e=request.getHeaderNames();//��ȡ����ͷ����Ϣ������
		while(e.hasMoreElements()) {
			Object obj=e.nextElement();
			System.out.println(obj+":");
			String val=request.getHeader(obj.toString());//ͷ����Ϣ�ľ���ֵ
			System.out.println(val);
		}*/
		// 2.ʵ��ҵ���߼�
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 Conn();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO �Զ����ɵ� catch ��
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
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
			}
		}
		//������Ӧ
		response.setContentType("text/html;charset=utf-8");//������Ӧ�ķ�������Ϊ�ı�����
		response.setCharacterEncoding("utf-8");  //��ֹ�ӷ��������ص�ʱ������
		// 3.��Ӧ
	
		if (succ&&flag) {
			try {
				insertStu("insert into registtable values(?,?,?,?,?)", name, psw, sex, like, addr);
			} catch (ClassNotFoundException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			
			RequestDispatcher re=request.getRequestDispatcher("PerCenterServlet");//2.ת�����󣬵�ַ�����䣬һ������
			re.forward(request, response);
		} else {
			/*out.print("failed");
			out.close();*/
			response.sendRedirect("PerCenterServlet");//�ض���,��ַ�ı�
		}
	}
	//��ѯ���ݿ�
	
 
   //�������ݿ�����
   public static void Conn() throws SQLException{
		// TODO �Զ����ɵĹ��캯�����
	   conn = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/regist?useUnicode=true&characterEncoding=UTF-8", "root", "");
		st=conn.createStatement();
	}
	
//�����ݿ��������
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
