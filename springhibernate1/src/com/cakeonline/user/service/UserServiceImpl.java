package com.cakeonline.user.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cakeonline.entity.Users;
import com.cakeonline.user.dao.UsersDaoImpl;

@Service
@Transactional(readOnly=false)
public class UserServiceImpl { 
	@Resource
	private UsersDaoImpl usersDaoImpl;

	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean regist(Users users) {
		
		try{
			users.setRegistTime(new Date());
			users.setIp("127.10.9.7");
			this.usersDaoImpl.saveUsers(users);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
			
		
		
	}

}
