<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Change Password</title>

	<script src="jquery-3.5.1.js"></script>
	<script src="jquery.validate.min.js"></script>
	<script>
		/* $(function(){
			$("form").validate
			({
				rules :
					{
						type : { required : true},
						username : {required : true},
						pass : 
						{
							required : true,
							minlength : 8,
							maxlength : 16
						},
						confirmpass :  
						{
							required : true,
							equalTo : "#password" 
						}
					}
			})
		}) */
		
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
				if(data[i].value=="--select--")
				{
					data[i].nextElementSibling.innerHTML=" *Required Field"
					data[i].nextElementSibling.style.color="red"
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
				if(data[3].value!="" && data[3].value != data[2].value)
				{
					data[2].nextElementSibling.innerHTML=" Confirm Password Should be Same"
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
	
		function myFunction()
		{
			var x = document.getElementById("password");
			var y = document.getElementById("confirmpass");
			
			if(x.type==="password" || y.type==="password")
			{
				x.type = "text";
				y.type = "text";
			}
			else
			{
				x.type = "password";
				y.type= "password"
			}
		}
	</script>	
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<form action="LoginServlet" method="post" onsubmit="return validate()">
<input type="hidden" name="action" value="change">

<div class="products-breadcrumb">
	 <div class="container">
			<ul>
				<li><i class="fa fa-home" aria-hidden="true"></i><a href="index.jsp">Home</a><span>|</span></li>
				<li>Change Password</li>
			</ul>
	</div>
	</div>
	<br>
	<div><center>
	<% String status=(String)request.getAttribute("status");
		if(status != null)
			out.print("<h3 id='color'>"+status+" !!!!");
	%>
	</center></div><br>
	<div class="w3_login">
			<h3>Change Password</h3>
			<div class="w3_login_module">
				<div class="module form-module">
				  <div class="toggle"><i class="fa fa-times fa-pencil"></i>
				  </div>
					<div class="form">
					<h2>Change Password</h2>
						<div class="form-group row">
           				  <div class="col-md-12">
		                   <select name="type" id="type"  class="form-control demo" onblur="clearup(this)">
		                   <option selected disabled>--select--</option>
		                   <option value="admin">Admin</option>
		                   <option value="customer">Customer</option>
		                   </select><b></b>
              			  </div>
         				</div>
					  <input type="text" name="username" id="username" class="demo" placeholder="Email Address" onblur="clearup(this)"><b></b>
					  <input type="password" name="pass" id="password" class="demo" placeholder="New Password" onblur="clearup(this)"><b></b>
					  <input type="password" name="confirmpass" id="confirmpass" class="demo" placeholder="Confirm Password" onblur="clearup(this)"><b></b>
					 
			 		<div class="form-group row">
             		 <div class="col-md-12">
              		   	<input type="checkbox"  name="showpass" id="showpass" onclick="myFunction()"><b></b>
               		 	<label for="c_subject" class="text-black">Show Password  </label>
            		  </div>
         			</div>
						<input type="submit" value="Change Password">
				  </div>
				</div>
		 </div>
	</div>
</form>
		
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>