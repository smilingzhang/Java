package com;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class MyTag implements Tag{
PageContext context;
	public MyTag() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int doEndTag() throws JspException {  //return this.EVAL_PAGE;结束标签之后接着往标签后边执行；return this.SKIP_PAGE;不执行标签后边的代码
		
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		try {
			this.context.getOut().print("hello word");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.SKIP_BODY; //跳过标签体，还有一个我结束标签体
	}

	@Override
	public Tag getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void release() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPageContext(PageContext arg0) {
		// TODO Auto-generated method stub
		context=arg0;
	}

	@Override
	public void setParent(Tag arg0) {
		// TODO Auto-generated method stub
		
	}

}
