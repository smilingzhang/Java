package com;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class LoopTag extends BodyTagSupport {
	int count;
	PageContext context;
	BodyContent bc;
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public int doAfterBody() throws JspException {
		if(count>0) {
			count--;
			return EVAL_BODY_AGAIN;
		}else {
			return SKIP_BODY;
		}
	}

	@Override
	public int doEndTag() throws JspException {
		try {
			context.getOut().print(bc.getString());
			System.out.print(bc.getString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	@Override
	public int doStartTag() throws JspException {
		if(count>0) {
			return this.EVAL_BODY_BUFFERED;//把Body读入存在的输出流中
		}else {
			return SKIP_BODY;
		}
	}

	@Override
	public void setBodyContent(BodyContent b) {
		// TODO Auto-generated method stub
		bc=b;
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		// TODO Auto-generated method stub
		context=pageContext;
	}

	public LoopTag() {
		// TODO Auto-generated constructor stub
	}

}
