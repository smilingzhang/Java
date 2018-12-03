package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.entity.Course;
import com.entity.Grade;
import com.entity.Stu;

public class ManyToMany {

	public ManyToMany() {
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
		
		Stu stu=new Stu();
		stu.setName("ʫʫ");
		
		Course course=new Course();
		course.setCourseName("���ݿ�");
		
		Grade grade=new Grade();
		grade.setScore(100);
		grade.setStus(stu);
		grade.setCourses(course);
		
		session.save(grade);
		
		trans.commit();
		session.close();
		sf.close();
	}

}
