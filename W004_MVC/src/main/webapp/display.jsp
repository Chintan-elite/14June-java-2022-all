<%@page import="model.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>display</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

</head>
<body>
		
		<div class="container">
		<div class="row">
		<div class="col-md-6 m-auto">
		<h1 align="center">User Data</h1>
		<table class="table table-dark table-striped">
		<tr>
		<th>Id</th>
		<th>Uname</th>
		<th>Email</th>
		<th>Password</th>
		<th colspan="2">Action</th>
		</tr>
		
		<%-- <%
		ArrayList<User> al = (ArrayList)request.getAttribute("data");
			for(User u : al)
			{ %>
				<tr>
				<td><%=u.getId()%></td>
				<td><%=u.getUname() %></td>
				<td><%=u.getEmail()%></td>
				<td><%=u.getPass() %></td>
				<td><a class="btn btn-primary" href="update?uid=<%=u.getId()%>">Update</a></td>
				<td><a class="btn btn-danger" href="delete?did=<%=u.getId()%>">Delete</a></td>
				</tr>
			<%}
		%> --%>
		
		
		<c:forEach items="${data}" var="u">
		<tr>
				<td>${u.getId()}</td>
				<td>${u.getUname()}</td>
				<td>${u.getEmail() }</td>
				<td>${u.getPass()}</td>
				<td><a class="btn btn-primary" href="update?uid=${u.getId()}>">Update</a></td>
				<td><a class="btn btn-danger" href="delete?did=${u.getId()}">Delete</a></td>
				</tr>
		</c:forEach>
		
		
		
		</table>

	</div>
		</div>
		</div>
		
</body>
</html>