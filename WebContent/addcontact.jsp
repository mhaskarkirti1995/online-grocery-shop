<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.grocery.pojo.Customer"%>
<%@page import="com.grocery.pojo.Contact"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Us</title>
<script type="text/javascript">

function validate()
{	
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

<form action="ContactServlet" method="post" onsubmit="return validate()">
<% String user = (String)session.getAttribute("user"); %>
<% Customer customer=(Customer)session.getAttribute("cust"); %>	

	<div class="products-breadcrumb">
		<div class="container">
			<ul>
				<li><i class="fa fa-home" aria-hidden="true"></i><a href="index.jsp">Home</a><span>|</span></li>
				<li>Mail Us</li>
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
	<div class="mail">
			<h3>Mail Us</h3>
			<div class="agileinfo_mail_grids">
				<div class="col-md-4 agileinfo_mail_grid_left">
					<ul>
						<li><i class="fa fa-home" aria-hidden="true"></i></li>
						<li>address<span>Ghodbunder Rd,</span>
						<span>Kapurbawdi, Thane West</span>
						</li>
					</ul>
					
					<ul>
						<li><i class="fa fa-envelope" aria-hidden="true"></i></li>
						<li>email<span>store@grocery.com</a></span></li>
					</ul>
					<ul>
						<li><i class="fa fa-phone" aria-hidden="true"></i></li>
						<li>call to us<span>(+022) 25252656</span></li>
					</ul>
				</div>
				
				 <div class="col-md-8 agileinfo_mail_grid_right demo">
 						<div class="col-md-6 wthree_contact_left_grid demo">
							<input type="text" name="name" placeholder="Name*" class="demo" onblur="clearup(this)"><b></b>
							<input type="email" name="email" placeholder="Email*" class="demo" onblur="clearup(this)"><b></b>
						</div>
						<div class="col-md-6 wthree_contact_left_grid demo">
							<input type="text" name="contact" placeholder="Telephone*" onblur="clearup(this)">
							<input type="text" name="subject" placeholder="Subject*" class="demo" onblur="clearup(this)"><b></b>
						</div>
						<div class="clearfix"> </div>
							<textarea  name="message" placeholder="Message"></textarea><b></b>
							<input type="submit" value="Submit">
							<input type="reset" value="Clear">
				</div>
				<div class="clearfix"> </div>
			</div>
			</div>
		<div>
		<iframe src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d15069.997476516817!2d72.980981!3d19.2170565!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0xc1a03a7e4e3df30b!2sBB-THANE-%20THANE(WEST)-HIGH%20STREET%20MALL!5e0!3m2!1sen!2sin!4v1600449108562!5m2!1sen!2sin" 
		width="1400" height="450" frameborder="0" style="border:0;" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
	</div>
</form>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>