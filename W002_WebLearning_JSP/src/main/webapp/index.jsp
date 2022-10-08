<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<form action="reg" method="post">
		<span style="color: green;">${msg}</span>
		
		<input type="text" name="uname" placeholder="enter username">
		<input type="text" name="email" placeholder="enter email">
		<input type="text" name="pass" placeholder="enter password">
		<input type="submit">
		</form>
</body>
</html>