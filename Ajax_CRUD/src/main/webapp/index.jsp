

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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

	
	<script type="text/javascript">
	$(document).ready(function(){
		
		getData();
		$("#sbtn2").hide();
		
	})
	
	function addUser()
	{
		var uname = $("#uname").val();
		var email = $("#email").val();
		var pass = $("#pass").val();
		var dob = $("#dob").val();
		var country = $("#country").val();
		
		$.post("reg",{uname,email,pass,dob,country},function(rt){
			$("#msg").html(rt);
			 getData()
		})
	}
	
	function getData()
	{
		$.get("view",{},function(rt){
			
			const data =  JSON.parse(rt);
			var row="";
			row=row+"<tr><th>Id</th><th>Uname</th><th>Email</th><th>Pass</th><th>DOB</th><th>Counrtry</th></tr>"
			for(var i=0;i<data.length;i++)
			{
				var user = data[i];
				row = row+"<tr><td>"+user.id+"</td><td>"+user.uname+"</td><td>"+user.email+"</td><td>"+user.pass+"</td><td>"+user.dob+"</td><td>"+user.country+"</td><td><button class='btn btn-danger bg-danger' onclick='deleteUser("+user.id+")'>Delete</button></td><td><button class='btn btn-primary bg-primary' onclick='getById("+user.id+")'>Update</button></td></tr>"
			}
			$("#table").html(row);
		})
	}
	
	function deleteUser(uid)
	{
		if(confirm("do u really want to delete?")==true)
		{
			$.post("update",{uid},function(rt){
				alert(rt)
				getData()
			})
		}
		else
		{
			alert("you have canclled")
		}
		
	}
	
	function getById(uid)
	{
		$.get("update",{uid},function(rt){
			
			var data = JSON.parse(rt);
			
			$("#uid").val(data.id);
			$("#uname").val(data.uname);
			$("#email").val(data.email);
			$("#pass").val(data.pass);
			$("#dob").val(data.dob);
			$("#country").val(data.country);
			
			$("#sbtn2").show();
			$("#sbtn1").hide();
		})
	}
	
	function updateUser()
	{
		var uid = $("#uid").val();
		var uname = $("#uname").val();
		var email = $("#email").val();
		var pass = $("#pass").val();
		var dob = $("#dob").val();
		var country = $("#country").val();
		
		$.get("reg",{uid,uname,email,pass,dob,country},function(rt){
			$("#msg").html(rt);
			getData()
			$("#sbtn2").hide();
			$("#sbtn1").show();
		})
	}
	
	function search(value)
	{
		$.get("search",{value},function(rt){
			
			const data =  JSON.parse(rt);
			var row="";
			row=row+"<tr><th>Id</th><th>Uname</th><th>Email</th><th>Pass</th><th>DOB</th><th>Counrtry</th></tr>"
			for(var i=0;i<data.length;i++)
			{
				var user = data[i];
				row = row+"<tr><td>"+user.id+"</td><td>"+user.uname+"</td><td>"+user.email+"</td><td>"+user.pass+"</td><td>"+user.dob+"</td><td>"+user.country+"</td><td><button class='btn btn-danger bg-danger' onclick='deleteUser("+user.id+")'>Delete</button></td><td><button class='btn btn-primary bg-primary' onclick='getById("+user.id+")'>Update</button></td></tr>"
			}
			$("#table").html(row);
		})
	}
	
	</script>
</head>
<body>
	
		<div class="container">
		<div class="row">
		<div class="col-md-4">
		<h1 class="text-success">Add User</h1>
		<span class="text-success" id="msg"></span>
		<span class="text-danger">${err}</span>
		
		<input type="hidden" name="uid" id="uid">
		<div class="form-group">
		<label>Username</label>
		<input type="text" name="uname" id="uname" class="form-control" > 
		</div>
		<div class="form-group">
		<label>Email</label>
		<input type="text" name="email" id="email" class="form-control" >
		</div>
		
		<div class="form-group">
		<label>Password</label>
		<input type="text" name="pass" id="pass" class="form-control" > 
		</div>
		
		<div class="form-group">
		<label>DOB</label>
		<input type="text" name="dob" id="dob" class="form-control" > 
		</div>
		
		
		
		<div class="form-group">
		<label>Country</label>
		<select name="country" id="country" class="form-control">
		<option value="india">India</option>
		<option value="usa">USA</option>
		<option value="uk">UK</option>
		<option value="canada">Canada</option>
		</select>
		</div>
		
		<br>
		
		<button class="btn btn-success" id="sbtn1" onclick="addUser()">Submit</button>
		<button class="btn btn-success" id="sbtn2" onclick="updateUser()">Update</button>
	
		</div>
		<div class="col-md-8">
		<h1 class="text-success">Book Details</h1>
		<input type="text" name="search" id="search" class="form-control" onkeyup="search(value)">
		<table class="table" id="table">
		
		
		
		
		</table>
		
		</div>
		</div>
		</div>
		
</body>
</html>