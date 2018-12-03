package com.test;


import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.entity.CakeType;
import com.entity.Classes;
import com.entity.Student;

import antlr.collections.impl.LList;



public class TestOneToMany {

	public TestOneToMany() {
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
			//���Ե���һ�Զ�	
//			Student s1=new Student();
//			s1.setStuName("zhenghhh");
//			s1.setAge(17);
//			Student s2=new Student();
//			s2.setStuName("yangyang");
//			s2.setAge(20);
//			HashSet< Student> hSet=new HashSet<Student>();
//			hSet.add(s1);
//			hSet.add(s2);
//			Classes c1=new Classes();
//			c1.setName("jijin666");
//			c1.setStudents(hSet);
//			session.save(c1);
		
			//���Ե�����һ
//			Classes c2=new Classes();
//			c2.setName("ledou");
//			
//			Student s3=new Student();
//			s3.setStuName("wangyuyu");
//			s3.setAge(3);
//			s3.setClasses(c2);
//			
//			Student s4=new Student();
//			s4.setStuName("yuanyuan");
//			s4.setAge(3);
//			s4.setClasses(c2);
//			session.save(s3);
//			session.save(s4);
				
			//����˫��
		/*	Classes classes=new Classes();
			classes.setName("benfang3");
			
			Student student1=new Student();
			student1.setAge(6);
			student1.setStuName("jiaojiao");
			student1.setClasses(classes);
			
			Student student2=new Student();
			student2.setAge(6);
			student2.setStuName("jiajia");
			student2.setClasses(classes);
		//�������������һ��set���ϵķ���������	
//			classes.getStudents().add(student1);
//			classes.getStudents().add(student2);
			
			HashSet<Student> hSet=new HashSet<Student>();
			hSet.add(student2);
			hSet.add(student1);
			classes.setStudents(hSet);
			session.save(classes);
		*/
			//����������˫��һ�Զ� cakeType
			Query query=session.createQuery("from CakeType c  where c.parentType = 'null'");
			List<CakeType> list = query.list();
			for(int i=0;i<list.size();i++) {
				System.out.print(list.get(i).getName()+"::");
				Set< CakeType> hSet=list.get(i).getCakes();
				for(Iterator iterator=hSet.iterator();iterator.hasNext();) {
					CakeType cakeType=(CakeType)iterator.next();
					System.out.print(cakeType.getName()+"��");
				}			
				System.out.println("");
			}
			trans.commit();
			session.close();
			sf.close();
	}

}
