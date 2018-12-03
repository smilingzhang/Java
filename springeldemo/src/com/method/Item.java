package com.method;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("item")
public class Item {
@Value("#{'tea'.toUpperCase()}")
	private String name;
@Value("#{mathutil.getLength()}")
	private int length;
@Value("#{mathutil.getArea(3)}")
	private double area;

	public Item() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}
	public void show() {
		System.out.println(name);
		System.out.println(length);
		System.out.println(area);
	}
	

}
