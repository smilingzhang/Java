package com.staticproxy;

public class UserServiceImpl implements UserService{

	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean login(String name, String password) {
		if(name.equals("zhangsan")&&password.equals("666")) {
			System.out.println("用户已登录成功");
			return true;
		}else {
			System.out.println("用户登录失败");
			return false;
		}
	}

}
