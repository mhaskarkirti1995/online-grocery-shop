<%@page import="com.grocery.pojo.Subscriber"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subscriber List</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<% List<Subscriber> sublist=(List<Subscriber>)session.getAttribute("sublist"); %>

<div class="products-breadcrumb">
		<div class="container">
			<ul>
				<li><i class="fa fa-home" aria-hidden="true"></i><a href="index.jsp">Home</a><span>|</span></li>
				<li>Subscriber List</li>
			</ul>
		</div>
	</div>
	<br>
	<table class="timetable_sub">
		<thead>
		<tr>
			<th>Subscriber ID</th>
			<th>Email Id</th>
		</tr>
		</thead>
		<tbody>
		
		<% for(Subscriber sub : sublist) { %>
		<tr>
			<td><%= sub.getSubscribeId() %></td>
			<td><%= sub.getEmailId() %></td>
	  </tr>
 	   </tbody>
		<%} %>
		
		</table>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>