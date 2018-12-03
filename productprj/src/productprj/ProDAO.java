package productprj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProDAO {
	private ResultSet rs;
	public ProDAO() {
		// TODO Auto-generated constructor stub
	}
	public ResultSet queryPro(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/product?useUnicode=true&characterEncoding=UTF-8","root","");
			Statement st=conn.createStatement();
			rs=st.executeQuery("select * from pro");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}

}
