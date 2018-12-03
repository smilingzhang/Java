package com.abc.cakeonline.order.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.abc.cakeonline.entity.Order;
@Repository
public class OrderDao {

	@Resource
	private SessionFactory sessionFactory;

	// �򶩵��������������ͬʱ��������
	public void insertOrder(Order order) {
		Session session=this.sessionFactory.getCurrentSession();
		session.save(order);
	}

}
