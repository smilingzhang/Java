package com.entity;
import javax.persistence.CascadeType;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;


import com.entity.Classes;
@Entity
@Table(name="student")
public class Student {
	private int stuId;
	private String stuName;
	private int age;
	//单向多对一
	private Classes classes;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="classid")
	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

}
