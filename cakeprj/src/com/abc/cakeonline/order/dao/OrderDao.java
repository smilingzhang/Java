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

	// 向订单表、订单详情表里同时插入数据
	public void insertOrder(Order order) {
		Session session=this.sessionFactory.getCurrentSession();
		session.save(order);
	}

}
