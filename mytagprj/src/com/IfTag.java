package com;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class IfTag extends BodyTagSupport {
	
	boolean show;
	

	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}

	public IfTag() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return super.doEndTag();
	}

	@Override
	public int doStartTag() throws JspException {
		if(show) {
			return EVAL_BODY_INCLUDE; //÷¥––±Í«©ÃÂ
		}else {
			return SKIP_BODY;
		}
	}

	@Override
	public void setBodyContent(BodyContent b) {
		// TODO Auto-generated method stub
		super.setBodyContent(b);
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		// TODO Auto-generated method stub
		super.setPageContext(pageContext);
	}

}
