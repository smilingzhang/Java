package com.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.entity.Cup;

@Repository  
public class CupDaoImpl extends JdbcDaoSupport implements CupDao{

	public CupDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void saveCup(Cup cup) {
		// TODO Auto-generated method stub
		String sql="insert into cup values(?,?,?)";
		int count=this.getJdbcTemplate().update(sql, new Object[] {cup.getCupId(),cup.getCupPrice(),cup.getCupBrand()});
		System.out.println(count);
		
	}

}
