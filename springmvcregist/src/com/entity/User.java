package com.entity;

import java.io.Serializable;
import java.util.List;

import javafx.scene.chart.PieChart.Data;

public class User{
	private String username;
	private String password;
	//private Data date;
	private String sex;
	private List<String> hobby;
	private String city;

	public User() {
		// TODO Auto-generated constructor stub
	}

	

	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*public Data getDate() {
		return date;
	}

	public void setDate(Data date) {
		this.date = date;
	}*/

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	

	public List<String> getHobby() {
		return hobby;
	}

	public void setHobby(List<String> hobby) {
		this.hobby = hobby;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	

}
