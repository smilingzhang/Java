package com.entity;

import java.io.Serializable;
/**
 * 
 *@desc:文档类
 *@author chunhui
 *@date:Nov 21, 20183:16:42 PM
 */
@Document(indexName="blog",type="blog")
public class EsDoc implements Serializable {
	@Id
	private String id;//ES要求为String类型
	private String title;
	private String summary;
	private String content;

	protected  EsDoc() {//JPA要求有无参构造,防止直接使用
	}
	public EsDoc(String title,String summary,String content) {
		this.title=title;
		this.summary=summary;
		this.content=content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return String.format("EsDoc[id='%s',title='%s',summary='%s',content='%s']", id,title,summary,content);
	}

}
