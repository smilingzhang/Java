package com;

public class Student {
	private String name;
	private int id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}
	public String toString() {
		return "the name is"+name+"the id is"+id;
	}
}
