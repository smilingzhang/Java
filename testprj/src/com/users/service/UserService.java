package com.users.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.users.dao.UserDao;
import com.users.entity.User;

@Service
@Transactional(readOnly=false)
public class UserService {
	@Resource
	private UserDao userDao;
	

	public UserService() {
		// TODO Auto-generated constructor stub
	}
	public void addUser(User user) {
		this.userDao.add(user);
	}
	

}
