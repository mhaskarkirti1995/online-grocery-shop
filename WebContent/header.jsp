<%@page import="com.grocery.pojo.Cart"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Grocery Store</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Grocery Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- font-awesome icons -->
<link href="css/font-awesome.css" rel="stylesheet" type="text/css" media="all" /> 
<!-- //font-awesome icons -->
<!-- js -->
<script src="js/jquery-1.11.1.min.js"></script>
<!-- //js -->
<link href='//fonts.googleapis.com/css?family=Ubuntu:400,300,300italic,400italic,500,500italic,700,700italic' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script>
<style type="text/css">
	#color
	{
		color: red;
	}
</style>
</head>
	
<body>

	<% 	String admin = (String)session.getAttribute("admin");
		String user = (String)session.getAttribute("user");
	%>

	<div class="agileits_header">
		<div class="w3l_offers">
			<a href="index.jsp">Today's special Offers !</a>
		</div>
		<div class="w3l_search">
		<%if((user==null && admin==null)||(user!=null && admin==null)) { %>
			<form action="GroceryServlet">
				<input type="text" name="groname" value="Search a product..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search a product...';}" required="">
				<input type="submit" value=" ">
				<input type="hidden" name="action" value="searchproduct">
		<%} %>
			</form>
		<%if(user==null && admin!=null) { %>
			<form action="OrderServlet">
				<input type="text" name="custemail" value="Search an Order " onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search a product...';}" required="">
				<input type="submit" value=" ">
				<input type="hidden" name="action" value="searchorder">
		<%} %>
			</form>
		</div>
		
		<%if(user!=null && admin==null){ %>
		<div class="product_list_header">  
			<form action="CartServlet" method="get" class="last">
			 <input type="hidden" name="action" value="showcart" />
			     <fieldset>   
			         <!-- <input type="hidden" name="cmd" value="_cart" /> -->
			         <input type="submit" name="submit" value="View your cart" class="button" />
                </fieldset>
            </form>
		</div>
		<% } %>
				
		<%if(user==null && admin==null){ %>
		<div class="w3l_header_right">
			<ul>
				<li class="dropdown profile_details_drop">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user" aria-hidden="true"></i><span class="caret"></span></a>
					<div class="mega-dropdown-menu">
						<div class="w3ls_vegetables">
							<ul class="dropdown-menu drp-mnu">
								<li><a href="login.jsp">Login</a></li> 
								<li><a href="addcustomer.jsp">Sign Up</a></li>
							</ul>
						</div>                  
					</div>	
				</li>
			</ul>
		</div>
		<%} %>
		<div class="w3l_header_right1">
			<h2><a href="addcontact.jsp">Contact Us</a></h2>
		</div>
		<div class="clearfix"> </div>
	</div>

	<script>
	$(document).ready(function() {
		 var navoffeset=$(".agileits_header").offset().top;
		 $(window).scroll(function(){
			var scrollpos=$(window).scrollTop(); 
			if(scrollpos >=navoffeset){
				$(".agileits_header").addClass("fixed");
			}else{
				$(".agileits_header").removeClass("fixed");
			}
		 }); 
	});
	</script>

	<div class="logo_products">
		<div class="container">
			<div class="w3ls_logo_products_left">
				<h1><a href="grocerylist.jsp"><span>Grocery</span> Store</a></h1>
			</div>
			<% if(user==null && admin==null) { %>
			<div class="w3ls_logo_products_left1">
				<ul class="special_items">
					<li><a href="index.jsp">Home</a><i>/</i></li>
					<li><a href="GroceryServlet">Grocery Store</a><i>/</i></li>
					<li><a href="addcustomer.jsp">Sign Up</a><i>/</i></li>
					<li><a href="login.jsp">Sign In</a><i>/</i></li>
					<li><a href="aboutus.jsp">About Us</a></li>
				</ul>
			</div>
			<%} %>
			<% if(user!=null && admin==null) { %>
			<div class="w3ls_logo_products_left1">
				<ul class="special_items">
					<li><a href="index.jsp">Home</a><i>/</i></li>
					<li><a href="GroceryServlet">Grocery Store</a><i>/</i></li>
					<li><a href="CustomerServlet?action=update&custemail=<%=user%>">Edit Profile</a><i>/</i></li>
					<li><a href="addfeedback.jsp?action=update&custemailid=<%=user %>">Feedback</a><i>/</i></li>
					<li><a href="OrderServlet?action=myorders&custemail=<%=user%>">My Orders</a><i>/</i></li>
					<li><a href="addcontact.jsp?action=update&custemail=<%=user %>">Contact Us</a><i>/</i></li>
					<li><a href="aboutus.jsp">About Us</a><i>/</i></li>
					<li><a href="LoginServlet">Log Out</a></li>
				</ul>
			</div>
			<%} %>
			
			<% if(user==null && admin!=null) { %>
			<div class="w3ls_logo_products_left1">
				<ul class="special_items">
					<li><a href="index.jsp">Home</a><i>/</i></li>
					<li><a href="GroceryServlet">Grocery Store</a><i>/</i></li>
					<li><a href="addgrocery.jsp">Add Grocery</a><i>/</i></li>
					<li><a href="CustomerServlet">Customer List</a><i>/</i></li>
					<li><a href="FeedbackServlet">Feedback List</a><i>/</i></li>
					<li><a href="OrderServlet">Order List</a><i>/</i></li>
					<li><a href="SubscriberServlet">Subscriber List</a><i>/</i></li>
					<li><a href="ContactServlet">Contact List</a></li>

				</ul>
			</div>
			<%} %>
			<div class="w3ls_logo_products_left1">
				<ul class="phone_email">
					<li><i class="fa fa-phone" aria-hidden="true"></i>(+022) 25252656</li>
					<li><i class="fa fa-envelope-o" aria-hidden="true"></i>store@grocery.com</a></li>
					<% if(user==null && admin!=null) { %>
					<li><a href="aboutus.jsp">About Us</a></li>
					<li><a href="LoginServlet">Log Out</a></li>
					<%} %>
				</ul>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>

</body>
</html>