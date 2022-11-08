<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Index</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</head>
<body>
		
		<div class="container">
		
		<div class="row">
		<div class="col-md-4 m-auto">
		<h1>Registration form</h1>
		<form action="reg">
					
					<div class="form-group">
					<label>Username</label>
					<input type="text" name="uname" class="form-control" value="<%if(request.getParameter("uname")!=null){request.getParameter("uname");}%>" >
					<span class="text-danger">${unameErr}</span>
					</div>
					
					<div class="form-group">
					<label>Email</label>
					<input type="text" name="email" class="form-control" value="<%if(request.getParameter("email")!=null){request.getParameter("email");}%>" >
					<span class="text-danger">${emailErr}</span>
					</div>
					
					<div class="form-group">
					<label>Password</label>
					<input type="password" name="pass" class="form-control" value="<%if(request.getParameter("pass")!=null){request.getParameter("pass");}%>" >
					<span class="text-danger">${passErr}</span>
					
					</div>
					
					<br>
					<input type="submit" class="btn btn-success" >
					<input type="reset" class="btn btn-primary">
					</form>	
					
		</div>
		</div>

					
					
	</div>
</body>
</html>