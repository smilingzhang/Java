package com.abc.cakeonline.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
@Entity
@Table(name="product")
public class Cake {
	private int id;
	private String name;
	private int size;
	private int price;
	private int discount;
	private String tag;
	private int level;
	private String bigimg;
	private String img1;
	private String img2;
	private String img3;
	private String digest; 
	//双向一对多
	private CakeType cakeType;
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
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

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getBigimg() {
		return bigimg;
	}

	public void setBigimg(String bigimg) {
		this.bigimg = bigimg;
	}

	public String getImg1() {
		return img1;
	}

	public void setImg1(String img1) {
		this.img1 = img1;
	}

	public String getImg2() {
		return img2;
	}

	public void setImg2(String img2) {
		this.img2 = img2;
	}

	public String getImg3() {
		return img3;
	}

	public void setImg3(String img3) {
		this.img3 = img3;
	}
	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

	public Cake() {
		// TODO Auto-generated constructor stub
	}
@ManyToOne()
@JoinColumn(name="type",insertable=false,updatable=false)
@NotFound(action=NotFoundAction.IGNORE) 
	public CakeType getCakeType() {
		return cakeType;
	}

	public void setCakeType(CakeType cakeType) {
		this.cakeType = cakeType;
	}
	

}
