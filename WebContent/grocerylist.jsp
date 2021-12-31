<%@page import="com.grocery.pojo.Grocery"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Grocery Store</title>
<style>
b
{
	color:red;
}
</style>
<script>

function filterfunction()
{
	groname = document.getElementById("groceryname").value
	grobrand = document.getElementById("grocerybrand").value
	if(groname=="")
	{
		document.getElementById("gronameerr").innerHTML = "* Required Field";
		return false;
	}
	if(grobrand=="")
	{
		document.getElementById("grobranderr").innerHTML = "* Required Field";
		return false;
	}
	return true;
}
function sortfunction()
{

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
	<% List<Grocery> grocerylist = (List<Grocery>)session.getAttribute("grolist"); %>
	<% 	String admin = (String)session.getAttribute("admin");
		String user = (String)session.getAttribute("user");
	%>
	
	<div class="products-breadcrumb">
		<div class="container">
			<ul>
				<li><i class="fa fa-home" aria-hidden="true"></i><a href="index.jsp">Home</a><span>|</span></li>
				<li>Grocery Store</li>
			</ul>
		</div>
	</div><br>
	<form action="GroceryServlet" onsubmit="return filterfunction()">
	<center>
	<div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_subject" >Filter : <span class="text-danger">*</span></label>
                    <input type="text" name="groname" id="groceryname" Placeholder="Enter Product" onblur="clearup(this)" style="border-style: double;border-width: 5px;height: 50px; width: 350px;border-color: green;"><b id="gronameerr"></b>
                    <input type="text" name="grobrand" id="grocerybrand" placeholder="Enter Brand " onblur="clearup(this)" style="border-style: double;border-width: 5px;height: 50px; width: 350px;border-color: green;"><b id="grobranderr"></b>
                    <input type="submit" name="action" value="Filter" style="height:50px;width:200px;background-color: #84B83F;">
                  </div>
              </div>
           </center>
      </form>
      <form action="GroceryServlet" onsubmit="return sortfunction()">     
	<% if(user==null && admin!=null){ %>
	<div class="form-group row">
        <div class="col-lg-16">
			<input type="submit" name="groname" value="Sort(A-Z)" class="btn btn-primary btn-lg btn-block">
			<input type="hidden" name="action" value="sort">
		</div>
	</div>
	<%} %>
	</form>
	<form action="GroceryServlet">
	<div>
	<center>
	<% String status = (String)request.getAttribute("status");
		if(status!=null)
			out.print("<h3 id='color'>" +status +" !!!");
	%>
	</center>
	</div>
	<br>
	<div class="top-brands">
	<div class="container">
	<div class="w3ls_w3l_banner_nav_right_grid w3ls_w3l_banner_nav_right_grid_veg">
    	<h3 class="w3l_fruit">Popular Products</h3>
	    	<div class="w3ls_w3l_banner_nav_right_grid1 w3ls_w3l_banner_nav_right_grid1_veg">							
			<%
				for(Grocery gro : grocerylist) {
			%>
			<div class="col-md-3 w3ls_w3l_banner_left">
				<div class="hover14 column">
					<div class="agile_top_brand_left_grid w3l_agile_top_brand_left_grid">
						<div class="agile_top_brand_left_grid_pos">
							<img src="images/offer.png" alt=" " class="img-responsive" />
						</div>
						<div class="agile_top_brand_left_grid1">
							<figure>
								<div class="snipcart-item block">
									<div class="snipcart-thumb">
										<a href="GroceryServlet?action=details&groid=<%= gro.getGroceryId()%>"><img src="ImageController?groid=<%= gro.getGroceryId() %>" alt="Loading" 
										 height="160" width="140"/></a>
										 <p><a href="GroceryServlet?action=details&groid=<%= gro.getGroceryId()%>"><%= gro.getGroceryName() %></a></p>
										<h4>Brand : <%= gro.getGroceryBrand() %></h4>
										<h4>Rs. <%= gro.getGroceryPrice() %></h4>
										<h4><%=gro.getAvailableIn() %></h4>
									</div>
									<div class="snipcart-details">
										<form action="CartServlet" method="get">
											<fieldset>
											<% if(user==null && admin!=null){  %>
												<a href="GroceryServlet?action=delete&groid=<%= gro.getGroceryId() %>">Delete</a>
												<a href="GroceryServlet?action=update&groid=<%= gro.getGroceryId()%>">Update</a>
											<%} %>
											<% if(user!=null && admin==null){  
												if(gro.getGroceryQty()<=0)
												{
											%>
												<td><a href="" onclick="return false";><strike>Add to cart</strike><b style="color:red">Out of Stock</b></a></td>
											<%} else { %>
												<!-- <input type="submit" name="groid" value="Add to cart" class="button" /> -->
												<a href="CartServlet?action=addtocart&groid=<%= gro.getGroceryId() %>">Add to Cart</a>
											<%} }%>
											</fieldset>
										</form>
									</div>
								</div>
							</figure>
						</div>
					</div>
					</div>
			<br></div>
		<%} %>								
		</div>
	</div></div></div><br>
		
	<!-- grocery table -->
<%-- 	 <table class="timetable_sub">
		<thead>
		<tr>
			<th>Grocery ID</th>
			<th>Grocery Name</th>
			<th>Grocery Type</th>
			<th>Grocery Brand</th>
			<th>Grocery Description</th>
			<th>Quantity</th>
			<th>Manufacture Date</th>
			<th>Expiry Date</th>
			<th>Available In</th>
			<th>Grocery Price</th>
			<th>Grocery Image</th>
			<% if(user!=null || admin!=null){  %>
			<th colspan=3>Action</th>
			<%} %>
		</tr> 
		</thead>

		<tbody>
		<%for(Grocery gro : grocerylist) { %>
		<tr>
			<td><%= gro.getGroceryId() %></td>
			<td><%= gro.getGroceryName() %></td>
			<td><%= gro.getGroceryType() %></td>
			<td><%= gro.getGroceryBrand() %></td>
			<td><%= gro.getGroceryDescription()%></td>
			<td><%= gro.getGroceryQty() %></td>
			<td><%= gro.getMfgDate() %></td>
			<td><%= gro.getExpiryDate() %></td>
			<td><%= gro.getAvailableIn() %></td>
			<td><%= gro.getGroceryPrice() %></td>
			<td><%= gro.getGroceryImage() %></td>
			<td><img src="ImageController?groid=<%=gro.getGroceryId() %>" height="110px" width="150px"></td> 
			<% if(user==null && admin!=null){  %>
			<td><a href="GroceryServlet?action=delete&groid=<%= gro.getGroceryId() %>">Delete</a></td>
			<td><a href="GroceryServlet?action=update&groid=<%= gro.getGroceryId()%>">Update</a></td>
			<%} %>
			<% if(user!=null && admin==null){  %>
			<td><a href="CartServlet?action=addtocart&groid=<%= gro.getGroceryId() %>">Add to Cart</a></td>
			<%} %>
		</tr>
		</tbody>
		
		<%} %> 
	</table> --%>
	</form>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>