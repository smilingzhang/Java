package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.GenericGenerator;
/**
 * 与UserInfo
 * 主键关联的一对一（UserInfo表其中一个属性既是主键又是外键）
 * */

@Entity
@Table(name="loginuser")
public class LoginUser {
	private String loginName;
	private String passWord;
	private String mail;
	private UserInfo userInfo;
	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
@OneToOne(cascade=CascadeType.ALL)
@PrimaryKeyJoinColumn(name="loginName")
	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	@Id
	@GeneratedValue(generator="mine")
	@GenericGenerator(name="mine" ,strategy="assigned")
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public LoginUser() {
		// TODO Auto-generated constructor stub
	}

}
