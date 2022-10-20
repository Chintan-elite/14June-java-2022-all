<%@page import="model.Book"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

</head>
<body>
		<div class="container">
		<div class="row">
		<div class="col-md-4">
		<h1 class="text-success">Add Book</h1>
		<span class="text-success">${msg}</span>
		<span class="text-danger">${err}</span>
		<form action="reg" method="get">
		<input type="hidden" name="uid" value="${user.getBid()}">
		<div class="form-group">
		<label>Bookname</label>
		<input type="text" name="bname" class="form-control" value="${user.getBname()}"> 
		</div>
		<div class="form-group">
		<label>Price</label>
		<input type="text" name="price" class="form-control" value="${user.getPrice()}">
		</div>
		<br>
		<input type="submit" class="btn btn-success">
		<input type="reset" class="btn btn-primary">
		</form>
		</div>
		<div class="col-md-8">
		<h1 class="text-success">Book Details</h1>
		<table class="table">
		<tr>
		<th>Book Id</th>
		<th>Bookname</th>
		<th>Price</th>
		<th colspan="2">Action</th>
		</tr>
		
		<%
			ArrayList<Book> al =(ArrayList<Book>)request.getAttribute("data");
			for(Book b  :al)
			{ %>
				<tr>
				<td><%=b.getBid()%></td>
				<td><%=b.getBname() %></td>
				<td><%=b.getPrice() %></td>
				<td><a href="update?uid=<%=b.getBid()%>&&action=delete" class="btn btn-danger">Delete</a></td>
				<td><a href="update?uid=<%=b.getBid()%>&&action=update" class="btn btn-warning">Update</a></td>
				
				</tr>
		<%}
		%>
		
		
		</table>
		
		</div>
		</div>
		</div>
		
</body>
</html>