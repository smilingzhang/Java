package com.entity;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
@Entity
@Table(name="address")
public class Address {
	private int id;
	private String addressName;
	private People people;
	public Address() {
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
	public String getAddressName() {
		return addressName;
	}
	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}
	@OneToOne()
	@JoinColumn(name="peopleId")
	public People getPeople() {
		return people;
	}
	public void setPeople(People people) {
		this.people = people;
	}
	

}
