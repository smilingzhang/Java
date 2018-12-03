package com.abc.cakeonline.user.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abc.cakeonline.entity.User;
import com.abc.cakeonline.user.dao.UserDao;

@Service
@Transactional(readOnly = false)
public class UserService {

	@Resource
	private UserDao userDao;

	public void inser(User user) {
		this.userDao.insertUsers(user);
	}

	@Transactional(readOnly = true)
	public int findByMail(String mail, String password) {
		int i = this.userDao.findUser(mail, password);
		return i;
	}

	public User find(String mail) {
		return this.userDao.findByMail(mail);
	}
}
