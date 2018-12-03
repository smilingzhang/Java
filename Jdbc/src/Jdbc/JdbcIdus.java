package Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Jdbc.Student;

public class JdbcIdus {
	private Connection conn;
	private Statement st;
	private ResultSet rs;
	
	public JdbcIdus() {
		// TODO �Զ����ɵĹ��캯�����
	}
	//���²���
	public int update(String sql) {
		int row=0;
		try {
			conn=JdbcPro.getConn();
			st=conn.createStatement();
			row=st.executeUpdate(sql);
			JdbcPro.closeConn(conn, st, rs);
			
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return row;
	}
	//��ѯ����
	public ArrayList<Student> queryStuById(int id){//ByName ByGrade����
		ArrayList<Student> ls=new ArrayList<>();
		try {
			conn=JdbcPro.getConn();
	        st=conn.createStatement();
	        rs=st.executeQuery("select * from student where id="+id+"");
	        while(rs.next()) {
	        	Student s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setGrade(rs.getFloat("grade"));
				ls.add(s);
	        }
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return ls;
	}
	//ɾ��
	public int delStuById(int id) {//ByName ByGrade����
		int i=0;
		try {
			conn=JdbcPro.getConn();
			st=conn.createStatement();
			i=st.executeUpdate("delete from student where id="+id+"");
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return i;
	}
	//����
	public  int insertStu(Student stu) {	
		int i=0;
		try {
			conn=JdbcPro.getConn();
			PreparedStatement pt=conn.prepareStatement("insert into student values(?,?,?)");
			pt.setInt(1, stu.getId());
			pt.setString(2, stu.getName());
			pt.setFloat(3, stu.getGrade());
			i=pt.executeUpdate();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return i;
	}
	//���£�����ΪStudent����
	public int updateStu(Student stu) {
		int i=0;
		
		return i;
	}
	public static void main(String[] args) {
		JdbcIdus test=new JdbcIdus();
		int i=0;
		//���ø���
		/*
		i=test.update("update student set id=672 where id=678");
		System.out.println(i);*/
		//���ò�ѯ
		/*ArrayList<Student> list =new ArrayList<Student>();
		list=test.queryStuById(671);
		for(Student s:list) {
			System.out.println(s);
		}*/
		//����ɾ��
		/*
		i=test.delStuById(667);
		System.out.println(i);*/
		//���ò���
		Student stu=new Student();
		stu.setId(673);
		stu.setName("shuang");
		stu.setGrade(99);
		i=test.insertStu(stu);
		System.out.println(i);
		
	}
    
}
