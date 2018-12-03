package com.dao;

import java.util.List;

import com.entity.Book;

public interface BookDao {
	public Integer saveBook(Book book);
	public void saveBooks(List<Book> list);
	public Book findById(Integer bookid);
	public List<Book> findAll();
	public List<Book> findAllByRowMapper();
	public Integer findCount();
	public Double findMyAverage();
}
