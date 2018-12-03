package com.xxx.entity.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {

	public BaseDao() {
		// TODO Auto-generated constructor stub
	}
	//只在加载类的时候执行一次
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		try {
			Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/product?useUnicode=true&characterEncoding=UTF-8","root","");
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
