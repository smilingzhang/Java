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
@Table(name="tbl_type")
public class CakeType {
	private int id;
	private String name;
	//单向一对多
	private Set<CakeType> cakeTypes=new HashSet<CakeType>();
	//单向多对一
	private CakeType parentType;
	//双向一对多
	private Set<Cake> cakes=new HashSet<Cake>();

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	@OneToMany(mappedBy="parentType",targetEntity=CakeType.class,cascade= {CascadeType.REMOVE})
	//@JoinColumn(name="parent")
	public Set<CakeType> getCakeTypes() {
		return cakeTypes;
	}

	public void setCakeTypes(Set<CakeType> cakeTypes) {
		this.cakeTypes = cakeTypes;
	}
	@ManyToOne()
	@JoinColumn(name="parent")
	@NotFound(action=NotFoundAction.IGNORE) 
	public CakeType getParentType() {
		return parentType;
	}
	public void setParentType(CakeType parentType) {
		this.parentType = parentType;
	}
	@OneToMany(mappedBy="cakeType",targetEntity=Cake.class,cascade=CascadeType.REMOVE)
	public Set<Cake> getCakes() {
		return cakes;
	}
	public void setCakes(Set<Cake> cakes) {
		this.cakes = cakes;
	}
	
}
