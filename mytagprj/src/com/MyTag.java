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
	public int doEndTag() throws JspException {  //return this.EVAL_PAGE;������ǩ֮���������ǩ���ִ�У�return this.SKIP_PAGE;��ִ�б�ǩ��ߵĴ���
		
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
		return this.SKIP_BODY; //������ǩ�壬����һ���ҽ�����ǩ��
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
