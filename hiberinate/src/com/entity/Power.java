package com.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="power")
public class Power {
private int id;
private String powerName;
private Set<Role> roles=new HashSet<Role>();
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getPowerName() {
	return powerName;
}

public void setPowerName(String powerName) {
	this.powerName = powerName;
}
@ManyToMany(mappedBy="powers")
public Set<Role> getRoles() {
	return roles;
}

public void setRoles(Set<Role> roles) {
	this.roles = roles;
}

	public Power() {
		// TODO Auto-generated constructor stub
	}

}
