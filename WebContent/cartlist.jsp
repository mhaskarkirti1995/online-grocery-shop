<%@page import="com.grocery.dao.GroceryDaoImpl"%>
<%@page import="com.grocery.pojo.Grocery"%>
<%@page import="com.grocery.pojo.Cart"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart List</title>
<script src="jquery-3.5.1.js"></script>
<script>
//this function is used for calculating total bill when we are changing qty in cart 
	function totalbill()
	{
		var groQty = $(".qty");
		var groPrice = $(".price");
				
		var totalBill = 0;
		var discount = 0;
		var finalBill = 0
		
		for(var i=0; i<groQty.length ;i++)
		{
			totalBill = totalBill + ( groQty[i].value * groPrice[i].value ) ;	
		}
		$("#tbill").text("Rs."+ totalBill);
		discount = (totalBill/100)*15;
		$("#discount").text("Rs."+ discount+" (15%)");
		finalBill =(totalBill-discount)+49;
		$("#finalbill").text("Rs. "+finalBill);
		
	}
//this function is used for setting qty as one when user tries to make it 0 or leess than 	
	$(function()
			{
				$(".qty").click(function()
				{
					var groqty = $(".qty");
					
					for(var i = 0 ; i< groqty.length ; i++)
					{
						if(groqty[i].value <= 0)
						{
							$(".qty").val(1);
						}
						else
						{
							totalbill();
						}
					}
				})
				totalbill();
			});
			
// ajax this function is used for to updating qty from mysql table & grocerylist table
	$(function()
	{
		$(".placeorder").click(function()
		{
				var groceryQuantity = $(".qty").val();
				var cartId = $(".id").html();
				
				$.ajax
				({
					type : 'POST',
					data : {action : "updatequantity", groceryQuantity:groceryQuantity, cartId:cartId},
					url : 'CartServlet',
					success : function(result)
					{
					//	alert(result);
					}
				});		
		});	
	});
	
	//THis function is used for total qty available in grocery table
	 $(function()
	{
		$(".qty").click(function()
		{
			var fq = $(".qty");
			var groceryQuantity = $(".tgqty");
			
			for(var i=0 ; i<fq.length ; i++)
			{
				if(+fq[i].value > + groceryQuantity[i].value)
				{
					fq[i].value = 	groceryQuantity[i].value;
					alert("Only " + groceryQuantity[i].value + " quantity is available for this product.")
				}
				else
				{
					totalbill();
				}
			}
		});
		totalbill();
	});
	
	//this function is used for updating cart qty if we are already selected any item it will just update qty 	
	 	$(document).ready(function()
	 	{
	 		$(".qty").click(function()
	 		{
	 			var fq=$(".qty");
	 			var id=$(".id");
	 			for(var i=0 ; i<fq.length;i++)
	 			{
	 				if(+fq[i].value>=1)
	 				{
	 					$.ajax
	 					({
	 						type:'GET',
	 						data:{cartgqty:fq[i].value,cartid:id[i].value,action:"update"},
	 						url:'CartServlet',
	 						success:function(result)
	 						{
	 							
	 						}
	 					});
	 				}
	 			}
	 		});		
	 	});
</script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

	<% List<Cart> clist =(List<Cart>)session.getAttribute("cartlist"); %>
	<% 	String admin = (String)session.getAttribute("admin");
		String user = (String)session.getAttribute("user");
	%>
	<form action="OrderServlet" method="post">
	<input type="hidden" name="action" value="placeorder">
	
	<div class="products-breadcrumb">
		<div class="container">
			<ul>
				<li><i class="fa fa-home" aria-hidden="true"></i><a href="index.jsp">Home</a><span>|</span></li>
				<li>Cart List</li>
			</ul>
		</div>
	</div>
	<br>
	<div>
	<center>
	<% String status = (String)request.getAttribute("status");
		if(status!=null)
			out.print("<h3 id='color'>" +status +" !!!");
	%>
	</center>
	</div><br>
	
		<center><h3><u>Checkout</u></h3></center>	<br>
		<% Integer count = (Integer)session.getAttribute("count");%>
	<h3>Your Shopping Cart Contains : <%= count %> Products</h3>
	<br>
		<table class="timetable_sub">
		<thead>
		<tr>
			<th>Cart Id</th>
			<th>Product</th>
			<th>Grocery Name</th> 
			<th>Grocery Quantity</th>
			<th>Grocery Price</th>
			<th>Action</th>
		</tr>
	</thead>	
	<tbody>
	<% for(Cart cart : clist)
		{
			Grocery gro;
			GroceryDaoImpl gdao = new GroceryDaoImpl();
			gro = gdao.searchGroceryById(cart.getGroceryId());
		%>
		<tr>
			<td class="id"><%= cart.getCartId() %></td>
			<%-- <td><%= cart.getGroceryId() %></td> --%>
			<td><img src="ImageController?groid=<%=gro.getGroceryId() %>" height="110px" width="150px" class="imgqty"></td>
			<td><%= cart.getGroceryName() %></td>
			<td><input type="number" class="qty" name="groqty" id="groqty" value="<%= cart.getGroceryQty() %>">
				<input type="hidden" class="tgqty" value="<%= gro.getGroceryQty() %>"></td>
			<td><input type=text class="price" name="groprice" id="groprice" value="<%= cart.getGroceryPrice() %>" readonly></td>
			
			<td><a href="CartServlet?action=delete&cartid=<%= cart.getCartId()%>">Delete</a></td>
		</tr>
			<%} %>	
		<tr>
		<td colspan="4"><h4>Sub Total : </h4></td>
		<td colspan="2"><h4 id="tbill"></h4></td>
		</tr>
		<tr>
		<td colspan="4"><h4>Delivery Charges : </h4></td>
		<td colspan="2"><h4>+ Rs.49</h4></td>
		</tr>
		
		<tr>
		<td colspan="4"><h4>Your Total Savings : </h4></td>
		<td colspan="2"><h4 id="discount"></h4></td>
		</tr>
		<tr>
		<td colspan="4"><h4>Total Bill : </h4></td>
		<td colspan="2"><h4 id="finalbill"></h4></td>
		</tr>
		</tbody>	
	</table>
	 <br>
		<div class="checkout-right-basket">
			 <a href="payment.jsp">Make a Payment <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span></a>
	   	</div>
	   	<div class="clearfix"> </div>
	  <br> 	
	 <div class="form-group row">
             <div class="col-lg-12">
                <input type="submit" class="btn btn-primary btn-lg btn-block placeorder" value="Place Order">
             </div>
		</div>
	<div class="clearfix"> </div>
	</form>
			<jsp:include page="footer.jsp"></jsp:include>
	
</body>
</html>