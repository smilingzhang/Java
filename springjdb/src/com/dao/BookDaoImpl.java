package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.entity.Book;

@Repository
public class BookDaoImpl extends JdbcDaoSupport implements BookDao{
	public BookDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	//插入数据并返回自增主键值
	@Override
	public Integer saveBook(Book book) {
		// TODO Auto-generated method stub
		final String sql="insert into book values(?,?,?)";
		KeyHolder keyHolder=new GeneratedKeyHolder();
		this.getJdbcTemplate().update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0) throws SQLException {
				PreparedStatement ps=arg0.prepareStatement(sql);
				ps.setInt(1, book.getBookId());
				ps.setString(2, book.getBookName());
				ps.setInt(3, book.getBookPrice());
				return ps;
			}
		},keyHolder);
		return keyHolder.getKey().intValue();
	}
	//批量插入数据
	@Override
	public void saveBooks(List<Book> list) {
		final String sql="insert into book values(?,?,?)";
		this.getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement arg0, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				arg0.setInt(1, list.get(arg1).getBookId());
				arg0.setString(2, list.get(arg1).getBookName());
				arg0.setInt(3, list.get(arg1).getBookPrice());	
			}	
			@Override
			public int getBatchSize() {
				// TODO Auto-generated method stub
				return list.size();
			}
		});
		
	}
	//查询单个数据并返回
	@Override
	public Book findById(Integer bookid) {
		String sql="select * from book where bookId=?";
		final Book book=new Book();
		this.getJdbcTemplate().query(sql,new Object[] {bookid},new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet arg0) throws SQLException {
				book.setBookId(arg0.getInt(1));
				book.setBookName(arg0.getString(2));
				book.setBookPrice(arg0.getInt(3));		
			}
		});
		return book;
	}
	//查询全部数据并返回 方法一
	@Override
	public List<Book> findAll() {
		String sql="select * from book";
		final List<Book>list=new ArrayList<Book>();
		this.getJdbcTemplate().query(sql, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				Book book=new Book();
				book.setBookId(rs.getInt(1));
				book.setBookName(rs.getString(2));
				book.setBookId(rs.getInt(3));
				list.add(book);
			}
		});
		return list;
	}
	//查询全部数据并返回 方法二
	@Override
	public List<Book> findAllByRowMapper() {
		String sql="select* from book";
		List<Book> books=this.getJdbcTemplate().query(sql, new RowMapper() {

			@Override
			public Object mapRow(ResultSet arg0, int arg1) throws SQLException {
				Book book=new Book();
				book.setBookId(arg0.getInt(1));
				book.setBookName(arg0.getString(2));
				book.setBookPrice(arg0.getInt(3));
				return book;
			}
		});
		return books;
	}
	//统计数量（普通查询 queryForObject）
	@Override
	public Integer findCount() {
		String sql="select count(*) from book";
		return this.getJdbcTemplate().queryForObject(sql, Integer.class);//第二个参数为sql语句返回数据的类型
	}
	//统计平均值，查询1行，多列的情况下
	@Override
	public Double findMyAverage() {
		String sql="select sum(bookPrice) count(*) from book";
		double avg=this.getJdbcTemplate().queryForObject(sql, new RowMapper<Double>() {

			@Override
			public Double mapRow(ResultSet arg0, int arg1) throws SQLException {
				int s=arg0.getInt(1);
				int c=arg0.getInt(2);
				return (double)s/c;
			}
		});
		return avg;
	}

}
