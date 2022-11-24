<%@page import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@page import="java.util.Scanner"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp" isELIgnored="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
</head>
<body>

		<%!
		int a; 
		int b;
		//int a = 10;
		//int b = 20;
		
		%>
		
		<%
		Scanner sc = new Scanner(System.in);
		a=10;
		b = 0;
		int c = a/b;
		
		%>
		
		<%=c %>
		
		
		<span>${abc}</span>
		
		
		
		
</body>
</html>