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
		//�������ļ� ��ӳ���ļ�
		StandardServiceRegistryBuilder ssrb=new StandardServiceRegistryBuilder();
		StandardServiceRegistry ssr=ssrb.configure().build();
		//�õ�һ��session factory
		SessionFactory sf=new MetadataSources(ssr).buildMetadata().buildSessionFactory();
		//�õ���ǰ�Ự
		Session session=sf.openSession();
		//��������
		Transaction trans=session.beginTransaction();
		
		//����
		LoginUser lUser=new LoginUser();
		lUser.setLoginName("lijunxia");
		lUser.setPassWord("666666");
		lUser.setMail("111@qq.com");
		
		UserInfo userInfo=new UserInfo();
		userInfo.setRealName("wudada");
		
		lUser.setUserInfo(userInfo);
		userInfo.setLoginUser(lUser);
		
		session.save(lUser);//�����߼�����
		
		//��ѯ
//		LoginUser loginUser=session.get(LoginUser.class, "zhangsan");
//		loginUser.getUserInfo().getRealName();
		
		trans.commit();
		session.close();
		sf.close();
	}

}
