package com.abc.cakeonline.type.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.abc.cakeonline.entity.CakeType;
@Repository
public class CakeTypeDao {
	@Resource
	private SessionFactory sessionFactory;

	// 把所有蛋糕类型都查出来
	public List<CakeType> findAll() {
		Session session=this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from CakeType ct where ct.parentType is null");
		return q.list();
	}

}
