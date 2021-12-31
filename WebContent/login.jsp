<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>

<style>
	b
	{
		color:red;
	}
</style>
	<script src="jquery-3.5.1.js"></script>
	<script src="jquery.validate.min.js"></script>
	 <script>
	/* 	$(function(){
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
						}
					}
			})
		}); */
	function validate()
	{
		type=document.getElementById("type").value
		username=document.getElementById("username").value
		password=document.getElementById("password").value
		
		if(type=="--select--")
		{
			document.getElementById("typeerr").innerHTML=" *Required Field"
			return false;
		}
		if(username=="")
		{
			document.getElementById("usernameerr").innerHTML=" *Required Field"
			return false;
		}
		if(password=="")
		{
			document.getElementById("passworderr").innerHTML=" *Required Field"
			return false;
		}
			return true;
	}
		
	function myFunction()
	{
			var x = document.getElementById("password");
			
			if(x.type==="password")
			{
				x.type = "text" ;
			}
			else
			{
				x.type = "password";
			}	
	}
	
	function clearup(data)
	{
		if(data.value!="")
		{
			data.nextElementSibling.innerHTML="";
		}
	}
	
	</script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<form action="LoginServlet" method="post" onsubmit="return validate()">
	<input type="hidden" name="action" value="login">
	
	<div class="products-breadcrumb">
	 <div class="container">
			<ul>
				<li><i class="fa fa-home" aria-hidden="true"></i><a href="index.jsp">Home</a><span>|</span></li>
				<li>Login</li>
			</ul>
	</div>
	</div>
	<div><center>
	<% String status=(String)request.getAttribute("status");
		if(status != null)
			out.print("<h3 id='color'>"+status+" !!!!");
	%>
	</center></div><br>
	<div class="w3_login top-brands container">
	<div class="w3_login">
			<h3>Sign In</h3>
			<div class="w3_login_module">
				<div class="module form-module">
				  <div class="toggle"><i class="fa fa-times fa-pencil"></i>
				  </div>
					<div class="form">
					<h2>Login to your account</h2>
						<div class="form-group row">
           				  <div class="col-md-12">
		                   <select name="type" id="type" onblur="clearup(this)" class="form-control">
		                   <option selected disabled>--select--</option>
		                   <option value="admin">Admin</option>
		                   <option value="customer">Customer</option>
		                   </select><b id="typeerr"></b>
              			  </div>
         				</div>
					  <input type="text" name="username" id="username" placeholder="Email Address" onblur="clearup(this)"><b id="usernameerr"></b>
					  <input type="password" name="pass" id="password" placeholder="Password" onblur="clearup(this)"><b id="passworderr"></b>
					 
			 <div class="form-group row">
              <div class="col-md-12">
                 <input type="checkbox"  name="showpass" id="showpass" onclick="myFunction()"><b></b>
                 <label for="c_subject" class="text-black">Show Password  </label>
               </div>
         	 </div>
				 <input type="submit" value="Login">
				  </div>
				   <div class="cta"><a href="addcustomer.jsp">New User? Register Now</a></div><br>
				   <div class="cta"><a href="changepassword.jsp">Forgot your password?</a></div>
				</div>
		 </div>
		</div>
		</div>
	</form>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>