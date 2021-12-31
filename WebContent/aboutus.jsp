<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>About Us</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

	<div class="products-breadcrumb">
		<div class="container">
			<ul>
				<li><i class="fa fa-home" aria-hidden="true"></i><a href="index.jsp">Home</a><span>|</span></li>
				<li>About Us</li>
			</ul>
		</div>
	</div>

	<div class="banner">
		<div class="w3l_banner_nav_left">
			<nav class="navbar nav_bottom">
			  <div class="navbar-header nav_2">
				  <button type="button" class="navbar-toggle collapsed navbar-toggle1" data-toggle="collapse" data-target="#bs-megadropdown-tabs">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				  </button>
			   </div> 
				<div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
					<ul class="nav navbar-nav nav_1">
						<li><a href="grocerylist.jsp">Household Items</a></li>
						<li><a href="grocerylist.jsp">Atta & Other Flours</a></li>
						<li><a href="grocerylist.jsp">Rise & Other Grains</a></li>
						<li><a href="grocerylist.jsp">Dry Fruits & Nuts</a></li>
						<li ><a href="grocerylist.jsp">Edible Oils<span></span></a>
						<li><a href="grocerylist.jsp">Biscuits ,Snacks & Chocklets</a></li>
						<li><a href="grocerylist.jsp">Sugar , Salt & Ghee</a></li>
						<li><a href="grocerylist.jsp">Spices</a></li>	
						<li><a href="grocerylist.jsp">Soft Drinks, Juices & Energy Drinks</a></li>
					</ul>
				 </div><!-- /.navbar-collapse -->
			</nav>
		</div>

	<div class="w3l_banner_nav_right">
		<div class="privacy about">
			<h3>About Us</h3>
			<h5>Online grocery store in Mumbai</h5>
			<p class="animi">Order online. All your favourite products from the low price online supermarket
			 for grocery home delivery in Thane, Mumbai, Navi Mumbai. Lowest prices guaranteed on 
			 Patanjali, Aashirvaad, Maggi, Saffola, Fortune, Nestle, Amul, Surf Excel, Ariel, Vim, and others.
			 Online grocery store is a low-price online supermarket that allows you to order products and gets them delivered to your doorstep.
			</p><br>
			<h5>Get the best offers on food, groceries & home needs</h5>
			
			<div class="agile_about_grids">
				<div class="col-md-6 agile_about_grid_right">
					<img src="images/31.jpg" alt=" " class="img-responsive" />
				</div>
				<div class="col-md-6 agile_about_grid_left">
					<h4>Brands :</h4><br>
					<ol>
						<li>Himalaya</li>
						<li>Aashirvad</li>
						<li>Patanjali</li>
						<li>Coca-Cola</li>
						<li>Madhur</li>
						<li>Kissan</li>
					</ol>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
	<div class="clearfix"></div>
	</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>