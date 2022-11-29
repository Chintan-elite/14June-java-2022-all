<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">

	setTimeout(() => {
		prompt("ohk")
	}, 5000);

</script>
</head>
<body>
	<form action="upload" method="post" enctype="multipart/form-data"> 
	<input type="text" name="name">
	<input type="file" name="file">
	<input type="submit">
	 </form>
</body>
</html>