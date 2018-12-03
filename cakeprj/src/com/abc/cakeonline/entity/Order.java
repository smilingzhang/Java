package com.abc.cakeonline.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
@Entity
@Table(name="tbl_order")
public class Order {
	private int id;
	private String phone;
	//单向多对一 
	private User user;
	//双向一对多
	private Set<OrderDetail> orderDetails=new HashSet<OrderDetail>();
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	@ManyToOne(cascade =CascadeType.ALL)
	@JoinColumn(name="mail")
	@NotFound(action=NotFoundAction.IGNORE) 
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	@OneToMany(mappedBy="order",targetEntity=OrderDetail.class,cascade=CascadeType.ALL)
	public Set<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Order() {
		// TODO Auto-generated constructor stub
	}

}
