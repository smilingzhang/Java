package com.staticproxy;

public class StaticProxy implements UserService{
	private UserService userService;

	public StaticProxy(UserService userService) {
		// TODO Auto-generated constructor stub
		this.userService=userService;
	}

	@Override
	public boolean login(String name, String password) {
		// TODO Auto-generated method stub
		boolean isLogin=userService.login(name, password);
		System.out.println("ÈÕÖ¾µÇÂ¼");
		return isLogin;
	}

}
