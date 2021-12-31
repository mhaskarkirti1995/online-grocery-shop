<%@page import="com.grocery.dao.CustomerDaoImpl"%>
<%@page import="com.grocery.pojo.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer List</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<% List<Customer> custlist=(List<Customer>)session.getAttribute("custlist"); %>
<% CustomerDaoImpl cdao = new CustomerDaoImpl(); %>

	<div class="products-breadcrumb">
		<div class="container">
			<ul>
				<li><i class="fa fa-home" aria-hidden="true"></i><a href="index.jsp">Home</a><span>|</span></li>
				<li>Customer List</li>
			</ul>
		</div>
	</div>
	<br>
	<div><center>
	<% String status = (String)request.getAttribute("status"); 
		if(status!=null)
			out.print("<h3 id='color'>"+ status +" !!!");
	%>
	
	</center></div><br>
	<table class="timetable_sub">
		<thead>
		<tr>
			<th>Customer ID</th>
			<th>Customer Name</th>
			<th>Customer EmailId</th>
			<th>Customer Password</th>
			<th>Contact Number</th>
			<th>Customer Address</th>
			<th colspan=2>Action</th>
		</tr>
		</thead>
		
		<tbody>
		
		<%for(Customer cust : custlist) {
			String password = cdao.getEncryptedPassword(cust.getCustomerPassword());	
		%>
		<tr>
			<td><%= cust.getCustomerId() %></td>
			<td><%= cust.getCustomerName() %></td>
			<td><%= cust.getCustomerEmailId()%></td>
			<td><%-- <%= cust.getCustomerPassword() %> --%><%= password %></td>
			<td><%= cust.getCustomerContact()%></td>
			<td><%= cust.getCustomerAddress() %></td>
			
			 <td><a href="CustomerServlet?action=delete&custid=<%= cust.getCustomerId() %>">Delete</a></td>
			<td><a href="CustomerServlet?action=update&custemail=<%= cust.getCustomerEmailId()%>">Update</a></td>
 	   </tr>
 	   </tbody>
		<%} %>
	</table>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>