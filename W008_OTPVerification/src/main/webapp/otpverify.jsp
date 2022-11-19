<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OTP verification</title>
</head>
<body>
<span>${err}</span>
<form action="otp">
<input type="text" name="otp" placeholder="enter otp">
<input type="submit">
</form>
</body>
</html>