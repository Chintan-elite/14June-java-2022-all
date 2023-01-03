<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>home</title>
</head>
<body>
 <h1>Welcome,home</h1>
 
 <table border="1" width="100%">
 <tr>
 <th>Id</th>
 <th>Name</th>
 <th>Email</th>
 <th>Pass</th>
 <th colspan="2">Action</th>
 </tr>
 
 <c:forEach items="${data}" var="dt">
 <tr>
 <td>${dt.getId()}</td>
 <td>${dt.getName()}</td>
 <td>${dt.getEmail()}</td>
 <td>${dt.getPass()}</td>
 <td><a href="delete/${dt.getId()}">Delete</a></td>
 <td><a href="update/${dt.getId()}">Update</a></td>
 </tr>
 </c:forEach>
 </table>
 
</body>
</html>