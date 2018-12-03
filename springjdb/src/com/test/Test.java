package com.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.business.BookService;
import com.entity.Book;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		//≤‚ ‘Cup
	/*	CupService cupbiz=(CupService)ctx.getBean("cup");
		Cup cup=new Cup();
		cup.setCupId(5);
		cup.setCupPrice(28);
		cup.setCupBrand("qing");
		cupbiz.addCup(cup);
	*/
		//≤‚ ‘Book
		BookService bookService=(BookService)ctx.getBean("book");
		List<Book> list=new ArrayList<>();
		for(int i=0;i<5;i++) {
			Book book=new Book();
			book.setBookId(i);
			book.setBookName("cai"+i);
			book.setBookPrice(i+20);
			list.add(book);
		}
		bookService.addBooks(list);
		System.out.println("ok!");
	}

}
