<%@page import="com.grocery.pojo.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Update Customer</title>
	<script src="jquery-3.5.1.js"></script>
	<script src="jquery.validate.min.js"></script>
	<!-- <script>
		$(function()
		{
			$("form").validate
			({
				rules : 
				{
					custid : {required : true},
					custname : {required : true},
					custemail : {required : true},
					pass : 
					{
						required : true,
						maxlength : 16,
						minlength : 8
					},
					
					contact : 
					{
						required : true,
						minlength : 10,
						maxlength : 10
					},
					custadd : { required : true }
				}	
			})	
		})
		
	</script> -->
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
				data[i].nextElementSibling.innerHTML=" Required Field"
				data[i].nextElementSibling.style.color="red"
				count++;
				
			}
		
			
			if(data[4].value!="" && data[4].value.length!=10)
			{
				data[4].nextElementSibling.innerHTML=" Please enter correct contact number.";
				data[4].nextElementSibling.style.color="red";
				count++;
			}
			
			 if(data[3].value!="" && data[3].value.length<8)
			{
				data[3].nextElementSibling.innerHTML=" Password length should be 8 or greather than 8"
				data[3].nextElementSibling.style.color="red"
				count++;
			}
			if(data[3].value!="" && (!pattern1.test(data[3].value) || !pattern2.test(data[3].value) || !pattern3.test(data[3].value) || !pattern4.test(data[3].value)))
			{
				data[3].nextElementSibling.innerHTML=" password should contain combination of digits, small, capital and special character"
				data[3].nextElementSibling.style.color="red"
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
	
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<% Customer cust=(Customer)session.getAttribute("cust"); %>
	<form action="CustomerServlet" method="post" onsubmit="return validate()">
	<input type="hidden" name="action" value="update">

	<div class="products-breadcrumb">
		<div class="container">
			<ul>
				<li><i class="fa fa-home" aria-hidden="true"></i><a href="index.jsp">Home</a><span>|</span></li>
				<li>Update Customer</li>
			</ul>
		</div>
	</div>
	<br>
	
	<div class="site-section">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<h2 class="h3 mb-5 text-black">Update Customer</h2>
					</div>
		
          <div class="col-md-12">
             <div class="p-3 p-lg-5 border">
             
                  <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_subject" class="text-black">Customer Id : <span class="text-danger">*</span></label>
                    <input type="number" class="form-control demo" name="custid" id="custid" value="<%= cust.getCustomerId()%>" onblur="clearup(this)" readonly><b></b>
                  </div>
                </div>
                                    
                 <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_subject" class="text-black">Customer Name : <span class="text-danger">*</span></label>
                    <input type="text" class="form-control demo" name="custname" id="custname" value="<%= cust.getCustomerName()%>" onblur="clearup(this)"><b ></b>
                  </div>
                </div>
                
          		<div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_subject" class="text-black">Customer Email Id : <span class="text-danger">*</span> </label>
                    <input type="email" class="form-control demo" name="custemail" id="custemail" value="<%= cust.getCustomerEmailId()%>" onblur="clearup(this)"><b ></b>
                  </div>
                </div>
				                
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_subject" class="text-black">Customer Password :  <span class="text-danger">*</span> </label>
                    <input type="password" class="form-control demo" name="pass" id="pass" value="<%= cust.getCustomerPassword()%>" onblur="clearup(this)"><b></b>
                  </div>
                </div>
				
				  <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_subject" class="text-black">Contact Number : <span class="text-danger">*</span> </label>
                    <input type="number" class="form-control demo" name="contact" id="contact" value="<%= cust.getCustomerContact()%>" onblur="clearup(this)"><b></b>          
                 </div>
                </div>
                
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_message" class="text-black">Customer Address :<span class="text-danger">*</span> </label>
                   <textarea class="form-control demo" name="custadd" id="custadd" rows="5" cols="21"><%= cust.getCustomerAddress()%></textarea><b></b>
                  </div>
                </div>
                
                <div class="form-group row">
                  <div class="col-lg-12">
                    <input type="submit" class="btn btn-primary btn-lg btn-block" value="Update">
                  </div>
                </div>
		</div>
		</div>
		</div>
		</div>
		</div>
	</form>
		<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>