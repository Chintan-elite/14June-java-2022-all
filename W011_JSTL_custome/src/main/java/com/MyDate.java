package com;

import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MyDate extends TagSupport {
	
	@Override
	public int doStartTag() throws JspException {
		
		 JspWriter out=pageContext.getOut();  
		    try{  
		        out.print(new Date());  
		    }catch(Exception e){e.printStackTrace();}  
		      
		    return SKIP_BODY;  
	}
}
