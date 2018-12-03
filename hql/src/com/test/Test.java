package com.test;

import org.hibernate.Transaction;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.entity.Student;
import com.util.BaseDao;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		//�õ��Ự
		Session session=BaseDao.getSessionFactory().openSession();
		//��������
		Transaction trans=session.beginTransaction();
		
		
		Query query=session.createQuery("from Student s");
		//�����������棬�ٴβ�ѯʱ�Ͳ���ִ��select
		query.setCacheable(true); 
		List<Student> list=query.list();
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getName());
		}
		
		
		
		Query query2=session.createQuery("from Student s ");
		query2.setCacheable(true);
		List<Student> list2=query2.list();
		for(int i=0;i<list2.size();i++) {
			System.out.println(list2.get(i).getName());
		}
		
		trans.commit();
		BaseDao.closeConnection();
	}

}
