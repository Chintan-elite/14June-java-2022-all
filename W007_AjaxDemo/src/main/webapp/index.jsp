<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

	<script type="text/javascript">
	
	$(document).ready(function(){
		
		
		
	})
	
	function search()
	{
		var pname = $("#pname").val()
		$.get("product",{pname:pname},function(rt){
			//alert(rt)
			$("#data").html(rt)
		})
	}
	
	</script>


</head>

<body>
	<input type="text" name="pname" id="pname" onkeyup="search()">
	<div id="data"></div>
</body>
</html>