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

	// �����򶩵����в������ݵķ��������ض�����ˮ��
	public void insertOrderService(Order order) {
		this.orderDao.insertOrder(order);
	}
}
