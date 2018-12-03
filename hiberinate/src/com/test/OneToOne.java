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
		//�������ļ� ��ӳ���ļ�
		StandardServiceRegistryBuilder ssrb=new StandardServiceRegistryBuilder();
		StandardServiceRegistry ssr=ssrb.configure().build();
		//�õ�һ��session factory
		SessionFactory sf=new MetadataSources(ssr).buildMetadata().buildSessionFactory();
		//�õ���ǰ�Ự
		Session session=sf.openSession();
		//��������
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
