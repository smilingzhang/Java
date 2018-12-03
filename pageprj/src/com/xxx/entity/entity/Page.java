package com.xxx.entity.entity;

import java.util.List;

public class Page<T> {

	public Page(int pageSize,int pageNum) {
		// TODO Auto-generated constructor stub
		super();
		this.pageNum=pageNum;
		this.pageSize=pageSize;
	}
	private List<Product> list;
	private int prePageNum;//��һҳ
	private int nextPageNum;//��һҳ
	private int totalCount;//����������
	private int totalPageNum;//��ҳ��
	private int pageSize;//ÿҳ��С
	private int pageNum;//��ǰҳ
	public List<Product> getList() {
		return list;
	}
	public void setList(List<Product> list) {
		this.list = list;
	}
	public int getPrePageNum() {
		return prePageNum;
	}
	public void setPrePageNum(int prePageNum) {
		this.prePageNum = prePageNum;
	}
	public int getNextPageNum() {
		return nextPageNum;
	}
	public void setNextPageNum(int nextPageNum) {
		this.nextPageNum = nextPageNum;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		
	}
	public int getTotalPageNum() {
		return totalPageNum;
	}
	public void setTotalPageNum(int totalCount) {
		if(totalCount%pageSize==0) {
			this.totalPageNum=totalCount/pageSize;
		}else {
			this.totalPageNum=(totalCount/pageSize)+1;
		}
		
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
}
