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
	
	//�����û�
	public void add(User user) {
		save(user);
	}
	
	//ͨ��idɾ���û�
	public boolean delById(int id) {
		return delete(User.class, id);
	}
	
	//�������ʵ��
	
	public List<User> getAllUsers(){
		return findAll(User.class);
	}

}
