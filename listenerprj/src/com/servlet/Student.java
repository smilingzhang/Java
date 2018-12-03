package com.servlet;

import com.listener.HttpSessionBindingListener;

public class Student extends HttpSessionBindingListener {
	private String name;
	private int age;

	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(String name ,int age) {
		this.name=name;
		this.age=age;
	}
    public String toString() {
		return "student's name is "+this.name+"age is "+this.age;
    }
}
