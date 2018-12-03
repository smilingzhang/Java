package com.abc.cakeonline.order.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abc.cakeonline.entity.Order;
import com.abc.cakeonline.order.dao.OrderDao;

@Service
@Transactional(readOnly = false)
public class OrderService {
	@Resource
	private OrderDao orderDao;

	// 调用向订单表中插入数据的方法并返回订单流水号
	public void insertOrderService(Order order) {
		this.orderDao.insertOrder(order);
	}
}
