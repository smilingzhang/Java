package com.dynamicproxy;

import com.dynamicproxy.UserService;

public class UserServiceImpl implements UserService{

	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean login(String name, String password) {
		System.out.println("�ѵ�¼");
		return true;
	}

}
