package com.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
@Component("dataitem")
public class DataItem {
	private List list=new ArrayList<>();
	private Map map=new HashMap();
	private List<Student> students = new ArrayList<Student>();

	public DataItem() {
		// TODO Auto-generated constructor stub
		list.add("aa");
		list.add("bb");
		map.put("1", "111");
		map.put("2", "222");
		students.add(new Student("zhangsan",18));
		students.add(new Student("lisi", 20));
		students.add(new Student("wangwu", 25));
	}

	public List getList() {
		return list;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public void setList(List list) {
		this.list = list;
	}


	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	

}
