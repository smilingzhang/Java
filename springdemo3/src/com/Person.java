package com;

import java.util.List;

public class Person {
	private String name;
	private int age;
	private Car car;
    private List list;

	
    //�вι��죬���췽��ע��
	public Person(String name,int age,Car car) {
		this.name=name;
		this.age=age;
		this.car=car;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Car getCar() {
		return car;
	}
	
    public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	//setter����ע��
	/*public void setCar(Car car) {
		this.car = car;
	}*/
	public void sayHello() {
		System.out.println("my name is"+name+"i am"+age+"years old");
	}
	public void driveCar() {
		car.start();
		car.run();
	}
	

}
