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
		//读配置文件 、映射文件
		StandardServiceRegistryBuilder ssrb=new StandardServiceRegistryBuilder();
		StandardServiceRegistry ssr=ssrb.configure().build();
		//得到一个session factory
		SessionFactory sf=new MetadataSources(ssr).buildMetadata().buildSessionFactory();
		//得到当前会话
		Session session=sf.openSession();
		//开启事务
		Transaction trans=session.beginTransaction();
		
		Stu stu=new Stu();
		stu.setName("诗诗");
		
		Course course=new Course();
		course.setCourseName("数据库");
		
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
