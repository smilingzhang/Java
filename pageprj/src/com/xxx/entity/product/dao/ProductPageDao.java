package com.xxx.entity.product.dao;
//查数据
//获取数据的总条数
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xxx.entity.entity.Product;
import com.xxx.entity.util.BaseDao;

public class ProductPageDao {

	public ProductPageDao() {
		// TODO Auto-generated constructor stub
	}
	public List<Product> findAll(int pageNum,int pageSize){
		ArrayList<Product> list=new ArrayList<>();
		Connection conn=BaseDao.getConnection();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("select * from pro limit ?,?");
			ps.setInt(1, (pageNum-1)*pageSize);
			ps.setInt(2, pageSize);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Product p=new Product();
				p.setId(rs.getInt(1)); //1代表字段在数据库表中的位置
				p.setName(rs.getString(2));
				p.setPrice(rs.getInt(3));
				list.add(p);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	public int findCount() {
		int count=0;
		Connection conn=BaseDao.getConnection();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("select count(id) from pro");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				count=rs.getInt(1);
			}
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

}
