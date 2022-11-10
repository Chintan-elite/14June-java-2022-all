<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

	<script type="text/javascript">
	
	$(document).ready(function(){
		
		$.get("country",{},function(rt){
			$("#country").html(rt);
		})
		
	})
	function getState(cid)
	{
		$.get("state",{cid:cid},function(rt){
			$("#state").html(rt);
		})
	}
	</script>
</head>
<body>
		
		<select id="country" onchange="getState(value)">
		<option>---Select country---</option>
		</select>
		
		<select id="state">
		<option>---Select state---</option>
		</select>
</body>
</html>