package com.entity;

public class OrderDetail {
	private int id;
	private int count;
	//双向
	private Order orders;
//蛋糕和明细 单向多对一
	private Cake cakes;
	public Cake getCakes() {
		return cakes;
	}

	public void setCakes(Cake cakes) {
		this.cakes = cakes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Order getOrders() {
		return orders;
	}

	public void setOrders(Order orders) {
		this.orders = orders;
	}

	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}

}
