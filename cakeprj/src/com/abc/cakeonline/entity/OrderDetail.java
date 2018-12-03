package com.abc.cakeonline.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
@Entity
@Table(name="orderdetail")
public class OrderDetail {
	private int id;
	private int count;
	//双向一对多
	private Order order;
	//单向多对一
	private Cake cake;
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	
	@ManyToOne
	@JoinColumn(name="orderid")
	@NotFound(action=NotFoundAction.IGNORE) 
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cakeid")
	@NotFound(action=NotFoundAction.IGNORE) 
	public Cake getCake() {
		return cake;
	}

	public void setCake(Cake cake) {
		this.cake = cake;
	}

	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}

}
