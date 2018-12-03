package com.jd.shop.product.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.jd.shop.entity.Product;

public class ProductDao {
	private Connection conn;
	private Statement st;
	private ResultSet rs;

	public ProductDao() {
		// TODO Auto-generated constructor stub
	}
	public Connection conNet() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/product?useUnicode=true&characterEncoding=UTF-8","root","");
		return conn;
	}
	public ArrayList<Product> findAll(){
	    ArrayList<Product> list=new ArrayList<Product>();
	    try {
			conn=conNet();
			st=conn.createStatement();
			rs=st.executeQuery("select * from pro");
			while(rs.next()) {
			    	Product pro=new Product();
			    	pro.setId(rs.getString("id"));
			    	pro.setName(rs.getString("name"));
			    	pro.setPrice(rs.getFloat("price"));
			    	list.add(pro);
			 }
			 return list;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(st!=null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	   
	}
	public Product findById(String id) {
		try {
			conn=conNet();
			st=conn.createStatement();
			rs=st.executeQuery("select * from pro where id="+id+"");
			Product p=new Product();
			if(rs.next()) {
				p.setId(rs.getString("id"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getFloat("price"));
			}
			return p;	    
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(st!=null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
