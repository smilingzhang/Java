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
		//得到会话
		Session session=BaseDao.getSessionFactory().openSession();
		//开启事务
		Transaction trans=session.beginTransaction();
		
		
		Query query=session.createQuery("from Student s");
		//开启二级缓存，再次查询时就不再执行select
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
