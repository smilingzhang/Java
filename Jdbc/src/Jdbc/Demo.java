package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {

	public Demo() {
		// TODO 自动生成的构造函数存根
	}
    //插入
	public static void insertStu() {//注意插入id主键，插入的姓名和成绩从哪里得到；插入成功返回成功
    
	}
    //删除
	public static void deleteStu() {

	}
    //更新
	public static void updateStu() {

	}
    //查询
	public static void queryStu() {

	}

	public static void main(String[] args) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");// 检测数据库驱动是否能用//.newInstance()得到一个数据库的driver接口
			String url = "jdbc:mysql://127.0.0.1:3306/demo?useUnicode=true&characterEncoding=UTF-8";// ip地址和端口号
			Connection conn = DriverManager.getConnection(url, "root", "");// 数据库连接字符串，用户名，密码,得到一次数据库连接
			Statement stmt = conn.createStatement();// 数据库的一个连接状态
			ResultSet rs = stmt.executeQuery("select * from student");// 执行查询语句，其他的更新 插入 删除都用executeUpdate()
			while (rs.next()) {
				System.out.println(rs.getString("name") + "  " + rs.getInt("id"));
			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		System.out.println("finish");
	}

}
