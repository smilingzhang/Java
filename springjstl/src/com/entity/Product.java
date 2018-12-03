package com.entity;

import java.util.List;

public class Product {
	
	private int id;
	private String name;
	//复选框
	private boolean soldOut;
	private List<String> color;
	private String favourateColor;
	private List<String> size;
	//单选按钮
	private String sellType;
	private String producingArea;
	
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
	public boolean getSoldOut() {
		return soldOut;
	}
	public void setSoldOut(boolean soldOut) {
		this.soldOut = soldOut;
	}
	public List<String> getColor() {
		return color;
	}
	public void setColor(List<String> color) {
		this.color = color;
	}
	public String getFavourateColor() {
		return favourateColor;
	}
	public void setFavourateColor(String favourateColor) {
		this.favourateColor = favourateColor;
	}
	public List<String> getSize() {
		return size;
	}
	public void setSize(List<String> size) {
		this.size = size;
	}
	public String getSellType() {
		return sellType;
	}
	public void setSellType(String sellType) {
		this.sellType = sellType;
	}
	public String getProducingArea() {
		return producingArea;
	}
	public void setProducingArea(String producingArea) {
		this.producingArea = producingArea;
	}
	
}
