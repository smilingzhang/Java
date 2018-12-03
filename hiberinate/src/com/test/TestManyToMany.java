package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.entity.Power;
import com.entity.Role;

public class TestManyToMany {

	public TestManyToMany() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//读配置文件 、映射文件
		StandardServiceRegistryBuilder ssrb=new StandardServiceRegistryBuilder();
		StandardServiceRegistry ssr=ssrb.configure().build();
		//得到一个session factory
		SessionFactory sf=new MetadataSources(ssr).buildMetadata().buildSessionFactory();
		//得到当前会话
		Session session=sf.openSession();
		//开启事务
		Transaction trans=session.beginTransaction();
				
		Role role=new Role();
		role.setRoleName("CEO");
		
		Power power=new Power();
		power.setPowerName("diaodong");
		Power power2=new Power();
		power2.setPowerName("chuchai");
	
	
        role.getPowers().add(power);
		role.getPowers().add(power2);
		power.getRoles().add(role);
		power2.getRoles().add(role);
		
		session.save(role);
		trans.commit();
		
		session.close();
		sf.close();
		
		
	}

}
