package com.entity;

import java.util.HashSet;
import java.util.Set;

public class CakeType {
	private int id;
	private String name;
	//单向一对多
	private Set<CakeType> childTypes=new HashSet<CakeType>();
	//单向多对一
	private CakeType parentId;
	
	

	public CakeType() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CakeType getCakeType() {
		return parentId;
	}

	public void setCakeType(CakeType parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<CakeType> getChildTypes() {
		return childTypes;
	}

	public void setChildTypes(Set<CakeType> childTypes) {
		this.childTypes = childTypes;
	}

}
