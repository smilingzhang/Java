package com.staticproxy;

public class UserServiceImpl implements UserService{

	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean login(String name, String password) {
		if(name.equals("zhangsan")&&password.equals("666")) {
			System.out.println("�û��ѵ�¼�ɹ�");
			return true;
		}else {
			System.out.println("�û���¼ʧ��");
			return false;
		}
	}

}
