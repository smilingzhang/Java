package com.entity;

import java.util.HashSet;
import java.util.Set;

public class Cake {
	private int id;
	private String name;
	private int price;
	private int size; 
	//蛋糕类型与蛋糕 单向多对一
	private CakeType cakeType;
	/*public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	//蛋糕评论一对多
	private Set<Comment> comments=new HashSet<Comment>();*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public CakeType getCakeType() {
		return cakeType;
	}
	public void setCakeType(CakeType cakeType) {
		this.cakeType = cakeType;
	}
	public Cake() {
		// TODO Auto-generated constructor stub
	}

}
