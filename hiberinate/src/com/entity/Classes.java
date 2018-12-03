package com.entity;

import java.util.HashSet;
import java.util.Set;
//import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * ��Student
 * ����һ�Զ�
 * 	@OneToMany(targetEntity=Student.class,cascade= {CascadeType.ALL})
	@JoinColumn(name="classid")
 * ������һ
 * ˫��һ�Զ�
 * */


@Entity
@Table(name="classes")
public class Classes {
	private int id;
	private String name;
	//�༶�� ѧ���� ����һ�Զ�
	private Set<Student> students=new HashSet<Student>(0);//0��ʾ�����ĳ�ʼ����Ϊ0
	public Classes() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	@OneToMany(mappedBy="classes",targetEntity=Student.class,cascade= {CascadeType.ALL})
//	@JoinColumn(name="classid")
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
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

}
