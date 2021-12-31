<%@page import="com.grocery.pojo.Order"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Receipt</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<% Order order = (Order)session.getAttribute("placeorder"); %>
	
<div class="products-breadcrumb">
		<div class="container">
			<ul>
				<li><i class="fa fa-home" aria-hidden="true"></i><a href="index.jsp">Home</a><span>|</span></li>
				<li>Bill Receipt</li>
			</ul>
		</div>
	</div><br>
	<div>
	<center>
	<% String status = (String)request.getAttribute("status");
		if(status!=null)
			out.print("<h3 id='color'>" +status +" !!!");
	%>
	</center>
	</div>
	<div>
    <center><h2 class="h3 mb-5 text-black">Receipt</h2></center>
    </div>
    <br>
	<c:if test="${placeorder!=null}" >	
	
	<table class="table table-bordered" >
		<thead class="timetable_sub">
			<tr >
				<th >Order Id</th>
				<td style="color:black;">${placeorder.orderId}</td>
			</tr>
			<tr>
				<th>Customer Email Id</th>
				<td style="color:black;">${placeorder.customerEmailId}</td>
			</tr>
			<tr>
				<th>Order Status</th>
				<td style="color:black;">${placeorder.orderStatus}</td>
			</tr>
			<tr>
				<th>Order Date</th>
				<td style="color:black;">${placeorder.orderDate}</td>
			</tr>
			<tr>
				<th>Total Bill</th>
				<td style="color:black;">${placeorder.totalBill}</td>
			</tr>
			
			</thead>
	</table>
	</c:if>
	<c:if test="${placeorder==null}">
		<center><h2>No Order Placed</h2></center>
	</c:if>
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>