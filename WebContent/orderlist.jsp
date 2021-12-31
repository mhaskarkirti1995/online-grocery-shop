<%@page import="com.grocery.pojo.Order"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order List</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<form>
	<% List<Order> ordlist = (List<Order>)session.getAttribute("ordlist"); %>
	
	<%	String user = (String)session.getAttribute("user"); 
		String admin = (String) session.getAttribute("admin");
	%>
	
		<div class="products-breadcrumb">
		<div class="container">
			<ul>
				<li><i class="fa fa-home" aria-hidden="true"></i><a href="index.jsp">Home</a><span>|</span></li>
				<li>Order List</li>
			</ul>
		</div>
	</div>
	<br>
	<div><center>
	<%		
		String status = (String)request.getAttribute("status");
		if(status!=null)
		{
			out.print("<h3 id = 'color'>"+ status);
		}
	%>
	</center></div><br>
	<table class="timetable_sub">
		<thead>
		<tr>
			<th>Order Id</th>
			<th>Customer EmailId</th>
			<th>Order Status</th>
			<th>Order Date</th>
			<th>Total Bill</th>
			<% if(user!=null && admin==null) { %>
			<th>Action</th>
			<%} %>
		</tr>
		</thead>
		<tbody>
		<% for(Order order : ordlist ) { %>
			<tr>
				<td><%=order.getOrderId() %></td>
				<td><%=order.getCustomerEmailId() %></td>
				<td><%=order.getOrderStatus() %></td>
				<td><%=order.getOrderDate() %></td>
				<td><%=order.getTotalBill() %></td>
				
				<% if(user!=null &&  admin==null) {%>
				<td><a href="OrderServlet?action=cancelorder&orderid=<%=order.getOrderId() %>">CancelOrder</a></td>
				<%} %>
			</tr>
		</tbody>
		<%} %>
		
	</table>
	<br>
	<% if(user!=null &&  admin==null) {%>
		<div><Center><h4>No more orders</h4></Center></div>
	<%} %>
	
<jsp:include page="footer.jsp"></jsp:include>
</form>
</body>
</html>