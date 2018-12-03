package Jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import java.sql.Connection;

public class JdbcPro {
	private static String driverName;
	private static String url;
	private static String user;
	private static String psw;

	//��̬����飬���ʼ��ʱ�������ݿ�����
	static {
		//���������ļ�,Load�������������resource��ȡ��Դ��������
		InputStream in=JdbcPro.class.getClassLoader().getResourceAsStream("dbinfo.properties");
		Properties pro=new Properties();
		try {
			pro.load(in);//�������ֽ�����ȡ�����б�����Ԫ�ضԣ�
			//��ȡ�������� url user psw
			driverName =pro.getProperty("driverName");//ʹ��ָ���ļ���������
			url=pro.getProperty("url");
			user=pro.getProperty("user");
			psw=pro.getProperty("psw");
			
			//��������
			Class.forName(driverName);
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	//��ȡ���Ӻ���
	public static Connection getConn() throws SQLException {
		return DriverManager.getConnection(url,user,psw);
	}
	//�ͷ���Դ����
	public static void closeConn(Connection conn,Statement st,ResultSet rs) {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		if(st!=null) {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		
	}

}
