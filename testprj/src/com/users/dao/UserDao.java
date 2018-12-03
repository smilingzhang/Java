package com.users.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.users.entity.User;
import com.util.BaseDao;
@Repository
public class UserDao extends BaseDao<User>{

	public UserDao() {
		// TODO Auto-generated constructor stub
	}
	
	//增加用户
	public void add(User user) {
		save(user);
	}
	
	//通过id删除用户
	public boolean delById(int id) {
		return delete(User.class, id);
	}
	
	//获得所有实体
	
	public List<User> getAllUsers(){
		return findAll(User.class);
	}

}
