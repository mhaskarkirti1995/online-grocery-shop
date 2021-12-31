<%@page import="com.grocery.pojo.Contact"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact List</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<% List<Contact> conlist=(List<Contact>) session.getAttribute("conlist"); %>

<div class="products-breadcrumb">
		<div class="container">
			<ul>
				<li><i class="fa fa-home" aria-hidden="true"></i><a href="index.jsp">Home</a><span>|</span></li>
				<li>Contact List</li>
			</ul>
		</div>
	</div>
	<br>
	<table class="timetable_sub">
		<thead>
		<tr>
			<th>Contact ID</th>
			<th>Customer Name</th>
			<th>Contact Number</th>
			<th>Customer Email Id</th>
			<th>Subject</th>
			<th>Message</th>
		</tr>
		</thead>
		<tbody>
		
		<%for(Contact con: conlist) { %>
		
		<tr>
			<td><%= con.getContactId() %></td>
			<td><%= con.getCustName() %></td>
			<td><%= con.getContactNumber()%></td>
			<td><%= con.getEmailId() %></td>
			<td><%= con.getSubject() %></td>
			<td><%= con.getMessage() %></td>
 	   </tr>
 	   </tbody>
		<%} %>
		
		</table>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>