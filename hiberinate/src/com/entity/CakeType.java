package com.entity;

import java.util.HashSet;
import java.util.Set;

public class CakeType {
	private int id;
	private String name;
	private Set<CakeType> cakes=new HashSet<CakeType>();
	private CakeType parentType;

	public CakeType() {
		// TODO Auto-generated constructor stub
	}

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

	public Set<CakeType> getCakes() {
		return cakes;
	}

	public void setCakes(Set<CakeType> cakes) {
		this.cakes = cakes;
	}

	public CakeType getParentType() {
		return parentType;
	}

	public void setParentType(CakeType parentType) {
		this.parentType = parentType;
	}

	
	

}
