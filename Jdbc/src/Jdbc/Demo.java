package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {

	public Demo() {
		// TODO �Զ����ɵĹ��캯�����
	}
    //����
	public static void insertStu() {//ע�����id����������������ͳɼ�������õ�������ɹ����سɹ�
    
	}
    //ɾ��
	public static void deleteStu() {

	}
    //����
	public static void updateStu() {

	}
    //��ѯ
	public static void queryStu() {

	}

	public static void main(String[] args) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");// ������ݿ������Ƿ�����//.newInstance()�õ�һ�����ݿ��driver�ӿ�
			String url = "jdbc:mysql://127.0.0.1:3306/demo?useUnicode=true&characterEncoding=UTF-8";// ip��ַ�Ͷ˿ں�
			Connection conn = DriverManager.getConnection(url, "root", "");// ���ݿ������ַ������û���������,�õ�һ�����ݿ�����
			Statement stmt = conn.createStatement();// ���ݿ��һ������״̬
			ResultSet rs = stmt.executeQuery("select * from student");// ִ�в�ѯ��䣬�����ĸ��� ���� ɾ������executeUpdate()
			while (rs.next()) {
				System.out.println(rs.getString("name") + "  " + rs.getInt("id"));
			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		System.out.println("finish");
	}

}
