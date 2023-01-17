<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>payment</title>
<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
</head>
<body>
<input type="text" id="amt">
<button id="rzp-button1">Pay</button>
<script src="https://checkout.razorpay.com/v1/checkout.js"></script>
<script>

	document.getElementById('rzp-button1').onclick = function(e){
	e.preventDefault();
	var amt = document.getElementById('amt').value
	$.post('payment',{amt:amt},function(rt){
		alert(rt)
		const order = JSON.parse(rt);
		alert(order)
		
		var options = {
		    "key": "rzp_test_D7fyiKPK2FeOfs", // Enter the Key ID generated from the Dashboard
		  	"currency": "INR",
		    "name": "Tops tech",
		    "description": "Test Transaction",
		    "image":"C:\Users\chintan\Desktop\logo-tops.png",
		    "order_id": order.id, //This is a sample Order ID. Pass the `id` obtained in the response of Step 1
		    "handler": function (response){
		        alert(response.razorpay_payment_id);
		        alert(response.razorpay_order_id);
		        alert(response.razorpay_signature)
		    }
		};
		var rzp1 = new Razorpay(options);
		rzp1.on('payment.failed', function (response){
		        alert(response.error.code);
		        alert(response.error.description);
		        alert(response.error.source);
		        alert(response.error.step);
		        alert(response.error.reason);
		        alert(response.error.metadata.order_id);
		        alert(response.error.metadata.payment_id);
		});
		rzp1.open();
	})
		

    
}
</script>
</body>
</html>