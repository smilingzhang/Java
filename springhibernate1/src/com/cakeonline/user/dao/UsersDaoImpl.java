package com.cakeonline.user.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.cakeonline.entity.Users;
@Repository
public class UsersDaoImpl {
	@Resource
	private SessionFactory sessionFactory; //dao��ע��sessionFactory

	public UsersDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public void saveUsers(Users users) {
		//save�������ز��������ֵ
		 this.sessionFactory.getCurrentSession().save(users);
	}

}
