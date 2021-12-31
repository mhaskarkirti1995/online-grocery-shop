<%@page import="com.grocery.pojo.Feedback"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Feedback List</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<% List<Feedback> feedlist = (List<Feedback>)session.getAttribute("feedlist"); %>
	<div class="products-breadcrumb">
		<div class="container">
			<ul>
				<li><i class="fa fa-home" aria-hidden="true"></i><a href="index.jsp">Home</a><span>|</span></li>
				<li>Feedback List</li>
			</ul>
		</div>
	</div>
	<br>
	<table class="timetable_sub">
		<thead>
		<tr>
			<th>Feedback Id</th>
			<th>Customer EmailId</th>
			<th>Rate Grocery</th> 
			<th>Rate Us</th>
			<th>Suggestion</th>
		</tr>
		</thead>
		<tbody>
		<% for(Feedback feed : feedlist){ %>
			<tr>
				<td><%=feed.getFeedbackId() %></td>
				<td><%=feed.getCustomerEmailId() %></td>
				<td><%=feed.getRateGrocery() %></td>
				<td><%=feed.getRateUs() %></td>
				<td><%=feed.getSuggestion() %></td>
			</tr>
		</tbody>
		<%} %>
	</table>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>