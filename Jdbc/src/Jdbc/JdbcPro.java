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

	//静态代码块，类初始化时加载数据库驱动
	static {
		//加载配置文件,Load返回类加载器，resource读取资源的输入流
		InputStream in=JdbcPro.class.getClassLoader().getResourceAsStream("dbinfo.properties");
		Properties pro=new Properties();
		try {
			pro.load(in);//从输入字节流读取属性列表（键和元素对）
			//获取驱动名称 url user psw
			driverName =pro.getProperty("driverName");//使用指定的键搜索属性
			url=pro.getProperty("url");
			user=pro.getProperty("user");
			psw=pro.getProperty("psw");
			
			//加载驱动
			Class.forName(driverName);
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	//获取连接函数
	public static Connection getConn() throws SQLException {
		return DriverManager.getConnection(url,user,psw);
	}
	//释放资源函数
	public static void closeConn(Connection conn,Statement st,ResultSet rs) {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		if(st!=null) {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
	}

}
