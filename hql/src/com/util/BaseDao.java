package com.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class BaseDao {
	private static StandardServiceRegistryBuilder ssrb;
	private static StandardServiceRegistry ssr;
	private static SessionFactory sf;
	private static Session session;

	public BaseDao() {
		// TODO Auto-generated constructor stub
	}
	public static SessionFactory getSessionFactory() {
		//�������ļ� ��ӳ���ļ�
		ssrb=new StandardServiceRegistryBuilder();
		ssr=ssrb.configure().build();
		//�õ�һ��session factory
		sf=new MetadataSources(ssr).buildMetadata().buildSessionFactory();
		return sf;
	}
	public static void closeConnection() {
		if(session!=null) {
			session.close();
		}
		if(sf!=null) {
			sf.close();
		}
	}

}
