package com.abc.cakeonline.entity;

import java.util.List;

public class Page {
	private List<Cake> cake;
	private int prePageNum;// ��һҳ
	private int nextPageNum;// ��һҳ
	private int pageNum;// ��ǰҳ
	private int totalCount;// ����������
	private int pageSize;// ÿҳ�ж�������ҳ���С
	private int totalPageCount;// ��ҳ��

	public Page(int pageNum, int pageSize) {
		// TODO Auto-generated constructor stub
		super();
		this.pageNum = pageNum;
		this.pageSize = pageSize;
	}

	public List<Cake> getCake() {
		return cake;
	}

	public void setCake(List<Cake> cake) {
		this.cake = cake;
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

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalCount) {
		if (totalCount % pageSize == 0) {
			this.totalPageCount = totalCount / pageSize;
		} else {
			this.totalPageCount = (totalCount / pageSize) + 1;
		}
	}

}
