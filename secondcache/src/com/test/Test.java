package com.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.entity.Student;

public class Test {

	public Test() {
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
		
		
		Query query=session.createQuery("from Student s");
		//开启二级缓存，再次查询时就不再执行select
		query.setCacheable(true); 
		List<Student> list=query.list();
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getId());
		}
		
		
		
		Query query2=session.createQuery("from Student s where s.id='1'");
		query2.setCacheable(true);
		List<Student> list2=query2.list();
		for(int i=0;i<list2.size();i++) {
			System.out.println(list2.get(i).getName());
		}
		
		trans.commit();
		session.close();
		sf.close();
	
	}

}