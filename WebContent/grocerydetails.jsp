<%@page import="com.grocery.pojo.Grocery"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Grocery Details</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<% Grocery gro = (Grocery)session.getAttribute("grocery"); %>
<% 	String admin = (String)session.getAttribute("admin");
	String user = (String)session.getAttribute("user");
%>
<div class="products-breadcrumb">
		<div class="container">
			<ul>
				<li><i class="fa fa-home" aria-hidden="true"></i><a href="index.jsp">Home</a><span>|</span></li>
				<li>Grocery Details</li>
			</ul>
		</div>
	</div>
	<br>
	
	<div class="site-section">
      <div class="container">
       <div class="row">
          <div class="title-section text-center col-12">
            <h2 class="text-uppercase">Grocery Details</h2>
          </div>
        </div>
       </div>
      </div><br>
      
      <table class="table table-bordered" >
		<thead class="timetable_sub">
			<tr><th>Grocery Name</th><td style="color:black;"><%= gro.getGroceryName() %></td></tr>
			<tr><th>Grocery Type</th><td style="color:black;"><%= gro.getGroceryType() %></td></tr>
			<tr><th>Grocery Brand</th><td style="color:black;"><%= gro.getGroceryBrand() %></td></tr>
			<tr><th>Grocery Description</th><td style="color:black;"><%= gro.getGroceryDescription() %></td></tr>
			<tr><th>Quantity</th><td style="color:black;"><%= gro.getGroceryQty() %></td></tr>
			<tr><th>Manufacture Date</th><td style="color:black;"><%= gro.getMfgDate() %></td></tr>
			<tr><th>Expiry Date</th><td style="color:black;"><%= gro.getExpiryDate() %></td></tr>
			<tr><th>Available In</th><td style="color:black;"><%= gro.getAvailableIn() %></td></tr>
			<tr><th>Grocery Price</th><td style="color:black;"><%= gro.getGroceryPrice() %></td></tr>
			
			
			<%if(admin!=null && user==null) {%>
			<tr><th></th>			
			<td><a href="GroceryServlet?action=update&groid=<%= gro.getGroceryId() %>">Delete</a>
			<a href="GroceryServlet?action=update&groid=<%= gro.getGroceryId() %>">Update</a></td>
			<%} %>
			<%if(admin==null && user!=null) {
				if(gro.getGroceryQty()<0)
				{
			%>
			<th></th><td><a href="" onclick="return false";><strike>Add to cart</strike><b style="color:red">Out of Stock</b></a></td>
			
			<% } else { %>
			
			<th></th><td><a href="CartServlet?action=addtocart&groid=<%= gro.getGroceryId() %>">Add to Cart</a></td>
			
			<%}}%>
			<tr>
		</thead>
	</table>
		
      
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>