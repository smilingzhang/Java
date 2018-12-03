package com;

public class Car {
	private int speed;

	public Car() {
		// TODO Auto-generated constructor stub
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public void start() {
		System.out.println("Æû³µÒÑÆô¶¯!");
	}
	public void run() {
		System.out.println("the car is running at"+speed+"km/h");
	}

}
