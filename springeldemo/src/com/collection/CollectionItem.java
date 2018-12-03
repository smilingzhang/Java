package com.collection;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component("collectionitem")
public class CollectionItem {
	@Value("#{dataitem.list}")
	private List list;
	
	@Value("#{dataitem.list[1]}")
	private String listValue;
	
	@Value("#{dataitem.map['1']}") //'1'代表/取map中键为1所对应的value
	private String mapValue;
	
	@Value("#{dataitem.students.?[age>18]}")//？代表选择
	private List<Student> selStu;
	
	@Value("#{dataitem.map.?[key == '1']}")
	private Map selMap;
	
	
	@Value("#{dataitem.students.?[age>18].![name]}")
	private List nameList;
	
	public CollectionItem() {
		// TODO Auto-generated constructor stub
	}
	public void show() {
		System.out.println(list.size());
		System.out.println(listValue);
		System.out.println(mapValue);
		//for(int i=0;i<selStu.size();i++) {
		System.out.println((selStu.get(0)).getAge());
		
		System.out.println(selMap);
		for(int i=0;i<nameList.size();i++) {
			System.out.println(nameList.get(i));
		}
	}

}
