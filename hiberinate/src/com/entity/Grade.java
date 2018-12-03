package com.entity;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="grade")
public class Grade {
	private int id;
	private int score;
	private Stu stus;
	private Course courses;

	public Grade() {
		// TODO Auto-generated constructor stub
	}
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
@ManyToOne(cascade=CascadeType.ALL)
@JoinColumn(name="stuId")
	public Stu getStus() {
		return stus;
	}

	public void setStus(Stu stus) {
		this.stus = stus;
	}
@ManyToOne(cascade=CascadeType.ALL)
@JoinColumn(name="courseId")
	public Course getCourses() {
		return courses;
	}

	public void setCourses(Course courses) {
		this.courses = courses;
	}
	

}
