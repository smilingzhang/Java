package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.entity.LoginUser;
import com.entity.UserInfo;

public class TestOneToOne {

	public TestOneToOne() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		//读配置文件 、映射文件
		StandardServiceRegistryBuilder ssrb=new StandardServiceRegistryBuilder();
		StandardServiceRegistry ssr=ssrb.configure().build();
		//得到一个session factory
		SessionFactory sf=new MetadataSources(ssr).buildMetadata().buildSessionFactory();
		//得到当前会话
		Session session=sf.openSession();
		//开启事务
		Transaction trans=session.beginTransaction();
		
		//插入
		LoginUser lUser=new LoginUser();
		lUser.setLoginName("lijunxia");
		lUser.setPassWord("666666");
		lUser.setMail("111@qq.com");
		
		UserInfo userInfo=new UserInfo();
		userInfo.setRealName("wudada");
		
		lUser.setUserInfo(userInfo);
		userInfo.setLoginUser(lUser);
		
		session.save(lUser);//插入逻辑主表
		
		//查询
//		LoginUser loginUser=session.get(LoginUser.class, "zhangsan");
//		loginUser.getUserInfo().getRealName();
		
		trans.commit();
		session.close();
		sf.close();
	}

}
