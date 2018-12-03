package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyJdbc {
    private static Connection conn;
    private static Statement st;
    private static  ResultSet rs;
	public MyJdbc() throws SQLException {
		// TODO �Զ����ɵĹ��캯�����
		conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo?useUnicode=true&characterEncoding=UTF-8","root","");
		st=conn.createStatement();
	}
	 //����
	/*public static int insertStu(String sql,String ...args) throws SQLException {
		int row=0;
		PreparedStatement ps=null;
		if(sql==null||sql.equals("")) {
			
			return 0;	
		}
		else {
			ps=conn.prepareStatement(sql);
			for(int i=0;i<args.length;i++) {
				ps.setObject(i+1, args[i]);
			}
			row=ps.executeUpdate();
			return row;
		}
		//return st.executeUpdate("insert into student values("+id+","+name+","+grade+")");//ע�����id����������������ͳɼ�������õ�������ɹ����سɹ�
		
	}*/
	public static int insertStu(int id,String name,float grade) throws SQLException {
		return st.executeUpdate("insert into student values("+id+","+name+","+grade+")");
	}
	  //ɾ��
	public static int deleteStu(int iid) throws SQLException {
		return st.executeUpdate("delete from student where id="+iid+"");
	}
	    //����,��������
	public static int updateStu(String sql,String ... args) throws SQLException {
		 int row=0;
	        //��ȡ����
	       PreparedStatement ps =null;
	       if(sql==null||sql.equals("")){
	           return row;
	       }else{
	        //sql���Ԥ����
	        ps =conn.prepareStatement(sql);
	        //��ֵ
	        for (int i = 0; i < args.length; i++) {
	             ps.setObject(i+1, args[i]);
	         }
	            row = ps.executeUpdate();
	             return row;
	        }

	}
	    //��ѯ
	public static void queryStu() throws SQLException {
		rs=st.executeQuery("select * from student");
		while(rs.next()) {
			System.out.println(rs.getInt("id")+"  "+rs.getString("name")+" "+rs.getFloat("grade"));
		}
	}
	
    public static void main(String[] args) throws SQLException {
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			MyJdbc mj=new MyJdbc();
			String name="yang";
		    System.out.println(mj.insertStu(680,"lisi",98));
			//System.out.println(mj.deleteStu(667));
			//System.out.println(mj.updateStu("update student set name=?where id=?", "cai","667"));
			mj.queryStu();
		
			
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
    	
    	}
    }
