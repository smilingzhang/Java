package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.entity.Address;
import com.entity.People;

public class OneToOne {

	public OneToOne() {
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
		
		People people=new People();
		people.setName("xueli");
		
		Address address=new Address();
		address.setAddressName("BeiJing");
		
		people.setAddress(address);
		address.setPeople(people);
		
		session.save(people);
		trans.commit();
		
		session.close();
		sf.close();
	}

}
