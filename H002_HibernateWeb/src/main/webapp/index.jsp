<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
		<form action="reg" method="post">
		<input type="hidden" name="id" value="${sdata.getId()}" >
		<input type="text" name="name" placeholder="Enter name" value="${sdata.getName()}">
		<input type="text" name="email" placeholder="Enter email" value="${sdata.getEmail()}">
		<input type="text" name="pass" placeholder="Enter pass" value="${sdata.getPassword()}">
		<input type="submit">
		<a href="view">View all</a>
		</form>
</body>
</html>