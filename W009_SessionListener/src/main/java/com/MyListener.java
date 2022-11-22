package com;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyListener implements HttpSessionListener
{
	int currentUsers=0;
	int totalUser = 0;
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		currentUsers++;
		totalUser++;
		ServletContext cx = se.getSession().getServletContext();
		cx.setAttribute("cu", currentUsers);
		cx.setAttribute("tu", totalUser);
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		currentUsers--;
		ServletContext cx = se.getSession().getServletContext();
		cx.setAttribute("cu", currentUsers);
	}
}
