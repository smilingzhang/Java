package com.abc.cakeonline.user.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.abc.cakeonline.entity.User;
@Repository
public class UserDao {
	@Resource
	private SessionFactory sessionFactory;

	// 用户的注册信息插入到用户表中
	public void insertUsers(User user) {
		Session session=this.sessionFactory.getCurrentSession();
		session.save(user);
	}

	// 通过用户登录时的mail判断用户是否注册以及是否登录成功
	public int findUser(String mail, String password) {
		Session session=this.sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User u where u.mail=? ");
		query.setParameter(0, mail);
		List<User> list=query.list();
		if(list.size()==0) {
			return 0; //代表未注册
		}else {
			if(list.get(0).getPassword().equals(password)) {
				return 1; //登录成功
			}else {
				return 2; //登录成功但密码错误
			}
		}
	}
	//通过用户的mail查用户信息
	public User findByMail(String mail) {
		Session session =this.sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User u where u.mail=?");
		query.setParameter(0, mail);
		return (User) query.list().get(0);
	}

}
