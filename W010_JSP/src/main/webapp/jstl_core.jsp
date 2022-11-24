<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>core</title>
</head>
<body>
	
	<%-- <c:if test="${10<20}">
	<c:out value="ok"></c:out>
	</c:if> --%>
	
	
<%-- 	<c:forEach var="dt" begin="1" end="10">
	<c:out value="${dt}"></c:out>
	</c:forEach>
	 --%>
	
	<c:set var="marks" value="42"></c:set>
	
	<c:choose>
	<c:when test="${marks>90}">
	<c:out value="Grade A"></c:out>
	</c:when>
	<c:when test="${marks>50 && marks<90}">
	<c:out value="Grade B"></c:out>
	</c:when>
	<c:otherwise>
	<c:out value="Invalid"></c:out>
	</c:otherwise>
	</c:choose>
	
</body>
</html>