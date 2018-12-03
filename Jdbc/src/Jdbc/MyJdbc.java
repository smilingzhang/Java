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
		// TODO 自动生成的构造函数存根
		conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo?useUnicode=true&characterEncoding=UTF-8","root","");
		st=conn.createStatement();
	}
	 //插入
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
		//return st.executeUpdate("insert into student values("+id+","+name+","+grade+")");//注意插入id主键，插入的姓名和成绩从哪里得到；插入成功返回成功
		
	}*/
	public static int insertStu(int id,String name,float grade) throws SQLException {
		return st.executeUpdate("insert into student values("+id+","+name+","+grade+")");
	}
	  //删除
	public static int deleteStu(int iid) throws SQLException {
		return st.executeUpdate("delete from student where id="+iid+"");
	}
	    //更新,不定参数
	public static int updateStu(String sql,String ... args) throws SQLException {
		 int row=0;
	        //获取驱动
	       PreparedStatement ps =null;
	       if(sql==null||sql.equals("")){
	           return row;
	       }else{
	        //sql语句预处理
	        ps =conn.prepareStatement(sql);
	        //赋值
	        for (int i = 0; i < args.length; i++) {
	             ps.setObject(i+1, args[i]);
	         }
	            row = ps.executeUpdate();
	             return row;
	        }

	}
	    //查询
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
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
    	
    	}
    }
