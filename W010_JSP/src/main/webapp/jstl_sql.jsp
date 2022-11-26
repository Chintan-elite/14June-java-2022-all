<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<sql:setDataSource driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/14june" user="root" password="root" var="ds"/>

		<sql:query var="rs" dataSource="${ds}">
		select * from user
		</sql:query>

	<table>
	<tr>
	<td>Id</td>
	<td>uname</td>
	<td>email</td>
	<td>password</td>
	</tr>
	
		<c:forEach var="dt" items="${rs.rows}">
		<tr>
		<td>${dt.id}</td>
		<td>${dt.uname}</td>
		<td>${dt.email}</td>
		<td>${dt.pass}</td>
		</tr>
		</c:forEach>

	</table>
</body>
</html>