package com.cakeonline.user.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.cakeonline.entity.Users;
@Repository
public class UsersDaoImpl {
	@Resource
	private SessionFactory sessionFactory; //dao里注入sessionFactory

	public UsersDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public void saveUsers(Users users) {
		//save方法返回插入的主键值
		 this.sessionFactory.getCurrentSession().save(users);
	}

}
