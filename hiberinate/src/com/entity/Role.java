package com.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * 与Power
 * 多对多：第三个表无业务逻辑
 * */
@Entity
@Table(name="role")
public class Role {
	private int id;
	
	private String roleName;
	private Set<Power> powers=new HashSet<Power>();

	public Role() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="distribute",joinColumns=@JoinColumn(name="roleId"),inverseJoinColumns=@JoinColumn(name="powerId"))
	public Set<Power> getPowers() {
		return powers;
	}
	public void setPowers(Set<Power> powers) {
		this.powers = powers;
	}
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	

}
