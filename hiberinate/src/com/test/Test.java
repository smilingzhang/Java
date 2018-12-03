package com.test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.Transaction;
import com.entity.Student;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		Student s =new Student();
		s.setStuId(30);
		s.setStuName("liangjie");
		s.setAge(17);
		//读配置文件 、映射文件
		StandardServiceRegistryBuilder ssrb=new StandardServiceRegistryBuilder();
		StandardServiceRegistry ssr=ssrb.configure().build();
		//得到一个session factory
		
		SessionFactory sf = new MetadataSources(ssr).buildMetadata().buildSessionFactory();
		//得到当前会话
		Session session=sf.openSession();
		//开启事务
		Transaction trans=session.beginTransaction();
		//进行数据库 增 操作
		session.save(s);
		
	/*	//数据库 查 操作
		Student s1=session.get(Student.class, 1);
		System.out.println(s1.getStuId());
		System.out.println(s1.getStuName());
		System.out.println(s1.getAge());
		System.out.println(s1.getAvgAge());
		//查完数据库之后可以直接对数据库进行更新操作
		s1.setStuName("caishuang");
	*/
		//对数据库 改 操作
		//session.update(s);
		//对数据库 删 操作
		
		//提交事务
		trans.commit();
		session.close();
		sf.close();
		
		
	}

}
