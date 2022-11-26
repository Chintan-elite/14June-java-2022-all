package com;

import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class Cube extends TagSupport {
	
	int number;
	
	
	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	@Override
	public int doStartTag() throws JspException {
		
		 JspWriter out=pageContext.getOut();  
		    try{  
		        out.print(number*number*number);  
		    }catch(Exception e){e.printStackTrace();}  
		      
		    return SKIP_BODY;  
	}
}
