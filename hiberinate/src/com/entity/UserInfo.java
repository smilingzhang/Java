package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="userinfo")
public class UserInfo {
	private String loginName;
	private String realName;
	private LoginUser loginUser;
	
	public UserInfo() {
		// TODO Auto-generated constructor stub
	}
@Id
@GeneratedValue(generator="mine")
@GenericGenerator(name="mine",strategy="foreign",parameters= {@Parameter(name="property",value="loginUser")})
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}
@OneToOne(mappedBy="userInfo")
	public LoginUser getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(LoginUser loginUser) {
		this.loginUser = loginUser;
	}

}
/**
 * ���������һ��һ
 * UserInfo�����һ������ֶ�
 * userinfo.hbm.xml�ĳ�
 * <class name="UserInfo" table="userinfo">
		<id name="loginName">
			<column name="loginName"></column>
			<generator class="identity">   ����дforeign,һ��Ҫ�ĳɱ�ģ����򱨿�ָ���쳣
				<param name="property">loginUser</param>
			</generator>
		</id>
		<property name="realName" column="realName"></property>
		<many-to-one name="loginUser" class="LoginUser" column="���" unique="true" />
	</class>
	
	
	������ӳ���ļ���д
	<one-to-one name="userInfo" class="UserInfo" cascade="all" property-ref="loginUser">
 * 
 * */
