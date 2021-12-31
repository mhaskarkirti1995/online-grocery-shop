<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<script src="jquery-3.5.1.js"></script>
	<script src="jquery.validate.min.js"></script>
	<script>
		function validate()
		{
			pattern1=/[0-9]/
			pattern2=/[a-z]/
			pattern3=/[A-Z]/
			pattern4=/[! @ # % $ & *]/
			
			data=document.getElementsByClassName("demo");
			count=0;
			
			for(var i=0;i<data.length;i++)
			{
				if(data[i].value=="")
				{
					data[i].nextElementSibling.innerHTML=" *Required Field"
					data[i].nextElementSibling.style.color="red"
					count++;
					
				}
			
				
				if(data[3].value!="" && data[3].value.length!=10)
				{
					data[3].nextElementSibling.innerHTML=" Please enter correct contact number.";
					data[3].nextElementSibling.style.color="red";
					count++;
				}
				
				 if(data[2].value!="" && data[2].value.length<8)
				{
					data[2].nextElementSibling.innerHTML=" Password length should be 8 or greather than 8"
					data[2].nextElementSibling.style.color="red"
					count++;
				}
				if(data[2].value!="" && (!pattern1.test(data[2].value) || !pattern2.test(data[2].value) || !pattern3.test(data[2].value) || !pattern4.test(data[2].value)))
				{
					data[2].nextElementSibling.innerHTML=" password should contain combination of digits, small, capital and special character"
					data[2].nextElementSibling.style.color="red"
					count++;
				} 
			}	
			
			if(count>0)
				return false;
			else
				return true;
			}
		function clearup(data)
		{
			if(data.value!="")
			{
				data.nextElementSibling.innerHTML="";			
			}
		}
	</script>
	<script>
/* by using $.ajax check customer emailid already present or not  */

	$(document).ready(function()
	{
		$("#custemail").change(function()
		{
			var custemail=$("#custemail").val();
			$.ajax
			({
				type:'GET',
				data:{name:"checkcustemail",custemail:custemail},
				url: 'CustomerServlet',
				success:function(result)
				{
					$("#custemailerr").html(result);
				}
			});
		});

		$("#password").change(function()
		{
			var password = $("#password").val();
			$.ajax
			({
				type : 'GET',
				data : {name : "checkpassword", password:password},
				url : 'CustomerServlet',
				success : function(result)
				{
					$("#passworderr").html(result);
				}
			});
		});	
		
		$("#contact").change(function()
		{
			var contact= $("#contact").val();
			$.ajax
			({
				type : 'GET',
				data : {name:"checkcontact",contact:contact},
				url : 'CustomerServlet',
				success : function(result)
				{
					$("#contacterr").html(result);
				}
			});
		});
	});
	
	</script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<form action="CustomerServlet" method="post" onsubmit="return validate()">
	<input type="hidden" name="action" value="add">
		
	<div class="products-breadcrumb">
		<div class="container">
			<ul>
				<li><i class="fa fa-home" aria-hidden="true"></i><a href="index.jsp">Home</a><span>|</span></li>
				<li>Sign Up</li>
			</ul>
		</div>
	</div><br>
	<div><center>
	<%		
		String status = (String)request.getAttribute("status");
		if(status!=null)
		{
			out.print("<h3 id = 'color'>"+ status);
		}
	%>
	</center></div>
		<div class="w3_login top-brands container">
			<h3>Sign Up</h3>
			<div class="w3_login_module">
				<div class="module form-module">
				  <div class="toggle"><i class="fa fa-times fa-pencil"></i>
				  </div>
				   <div class="form">
					<h2>Create an account</h2>
					
					<input type="text" name="custname" id="custname" placeholder="Username" class="demo" onblur="clearup(this)"><b></b>
					<input type="email" name="custemail" id="custemail" placeholder="Email Address" class="demo" onblur="clearup(this)"><b></b><b id="custemailerr"></b>  
					<input type="password" name="pass" id="password" placeholder="Password" class="demo" onblur="clearup(this)"><b></b><b id="passworderr"></b>
					<input type="text" name="contact" id="contact" placeholder="Phone Number" class="demo" onblur="clearup(this)"><b ></b><b id="contacterr"></b>
					<textarea name="custadd" id="custadd" cols="30" rows="7"  class="form-control demo" placeholder="Address" class="demo" onblur="clearup(this)"></textarea><b></b><BR>
					
					<input type="submit" value="Register">
				  </div>
				</div>
			</div>
			</div>

</form>
	
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>