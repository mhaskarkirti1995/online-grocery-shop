<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Empty Cart</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<form>
<div class="products-breadcrumb">
		<div class="container">
			<ul>
				<li><i class="fa fa-home" aria-hidden="true"></i><a href="index.jsp">Home</a><span>|</span></li>
				<li>Empty Cart</li>
			</ul>
		</div>
	</div>
<div>
	<center><img alt="loading" src="emptycart.png"></center>

</div>
<div>
	<center><h3>Your Cart is Empty</h3></center>
</div><br>
<div>
	<center><h4 style="color:gray;">Add item to it now.</h4></center>
</div>
<br>
 <div class="form-group row">
       <center>   
        <div class="col-lg-16">
    		<a href="GroceryServlet"><input type="button" class="btn btn-primary btn-lg " value="Shop Now"></a>
        </div>
       </center>
 </div>
 </form>
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>