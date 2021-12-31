<%@page import="com.grocery.pojo.Grocery"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Update Grocery</title>
	<script src="jquery-3.5.1.js"></script>
	<script src="jquery.validate.min.js"></script>
	<!-- <script>
		$(function()
		{
			$("form").validate
			({
				rules : 
				{
					groid : { required : true },
					groname :{ required : true },
					type : {required : true},
					brand : {required : true },
					description : { required : true },
					qty : {required : true },
					mfgdate : {required : true},
					expirydate : {required : true } ,
					availablein : {required : true},
					price : { required : true}
					
				}
			})
			
		})
	</script> -->
<style>
	b
	{
		color:red;
	}
</style>
	<script>
		function validate()
		{
			groceryname=document.getElementById("groname").value
			grocerytype=document.getElementById("type").value
			grocerybrand=document.getElementById("brand").value
			grocerydescription=document.getElementById("description").value
			groceryqty=document.getElementById("qty").value
			mfgdate=document.getElementById("mfgdate").value
			expirydate=document.getElementById("expirydate").value
			groceryavailablein=document.getElementById("availablein").value
			groceryprice=document.getElementById("price").value
			
			if(groceryname=="")
			{
				document.getElementById("gronameerr").innerHTML=" *Required Field";
				return false;
			}
			
			if(grocerytype=="")
			{
				document.getElementById("typeerr").innerHTML=" *Required Field"
				return false;
			}
			
			if(grocerybrand=="")
			{
				document.getElementById("branderr").innerHTML=" *Required Field"
				return false;
			}
			
			if(grocerydescription=="")
			{
				document.getElementById("descerr").innerHTML=" *Required Field"
				return false;
			}
			
			if(groceryqty=="")
			{
				document.getElementById("qtyerr").innerHTML=" *Required Field"
				return false;
			}
			
			if(mfgdate=="")
			{
				document.getElementById("mfgdateerr").innerHTML=" *Required Field"
				return false;
			}
			
			if(expirydate=="")
			{
				document.getElementById("expiryerr").innerHTML=" *Required Field"
				return false;
			}
			if(groceryavailablein=="")
			{
				document.getElementById("availableinerr").innerHTML=" *Required Field"
				return false;
			}
			
			if(groceryprice=="")
			{
				document.getElementById("priceerr").innerHTML=" *Required Field"
				return false;
			}
						
			return true;
		}
		
		function clearup(data)
		{
			if(data.value!="")
			{
				data.nextElementSibling.innerHTML="";
			}
		}
		
	</script>
<title>Update Grocery</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<% Grocery gro=(Grocery)session.getAttribute("gro"); %>
<form action="GroceryServlet" method="post" enctype="multipart/form-data" onsubmit="return validate()">
	<input type="hidden" name="action" value="update">
		<div class="products-breadcrumb">
		<div class="container">
			<ul>
				<li><i class="fa fa-home" aria-hidden="true"></i><a href="index.jsp">Home</a><span>|</span></li>
				<li>Update Grocery</li>
			</ul>
		</div>
	</div>
	<br>
	
	<div class="site-section">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<h2 class="h3 mb-5 text-black">Update Grocery</h2>
					</div>
		
          <div class="col-md-12">
          
             <div class="p-3 p-lg-5 border">
             	  
             	  <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_subject" class="text-black">Grocery Id : <span class="text-danger">*</span></label>
                    <input type="number" class="form-control" name="groid" id="groid" value="<%= gro.getGroceryId()%>"  onblur="clearup(this)" readonly ><b id="groiderr"></b>
                  </div>
                </div>
                
                  <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_subject" class="text-black">Grocery Name : <span class="text-danger">*</span></label>
                    <input type="text" class="form-control" name="groname" id="groname" value="<%= gro.getGroceryName()%>" onblur="clearup(this)"><b id="gronameerr"></b>
                  </div>
                </div>
                  
                  <div class="form-group row">
                  <div class="col-md-12">
                   <label for="c_email" class="text-black">Grocery Type : <span class="text-danger">*</span></label>
                    <input type="text" class="form-control" name="type" id="type" value="<%= gro.getGroceryType()%>" onblur="clearup(this)"><b id="typeerr"></b>
                  <!-- <select name="type" id="type" onblur="clearup(this)" class="form-control">
						<option selected disabled>--select--</option>
						<option>Rice</option>
						<option>Soap</option>
						<option>Oil</option>
						<option>Sprouts</option>
						<option>Masala</option>
						<option>Atta</option>
						<option>Dry Fruits</option>			
				</select>
				<b id="typeerr"></b> -->
                 </div>
                </div>
                
                 <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_subject" class="text-black">Grocery Brand : <span class="text-danger">*</span></label>
                    <input type="text" class="form-control" name="brand" id="brand" value="<%= gro.getGroceryBrand()%>" onblur="clearup(this)"><b id="branderr"></b>
                  </div>
                </div>
                
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_message" class="text-black">Grocery Description :<span class="text-danger">*</span> </label>
                    <textarea name="description" id="description" cols="30" rows="7"  onblur="clearup(this)" class="form-control"><%=gro.getGroceryDescription()%></textarea><b id="descerr"></b>
                  </div>
                </div>
                
                 <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_subject" class="text-black">Grocery Quantity : <span class="text-danger">*</span></label>
                    <input type="number" class="form-control" name="qty" id="qty" value="<%= gro.getGroceryQty()%>" onblur="clearup(this)"><b id="qtyerr" ></b>
                  </div>
                </div>
     
				<div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_subject" class="text-black">Grocery Manufacture Date : <span class="text-danger">*</span> </label>
                    <input type="date" class="form-control" name="mfgdate" id="mfgdate" value="<%= gro.getMfgDate()%>" onblur="clearup(this)"><b id="mfgdateerr" ></b>
                  </div>
                </div>
				                
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_subject" class="text-black">Grocery Expiry Date :  <span class="text-danger">*</span> </label>
                    <input type="date" class="form-control" name="expirydate" id="expirydate" value="<%= gro.getExpiryDate()%>" onblur="clearup(this)"><b id="expiryerr"></b>
                  </div>
                </div>
				
				 <div class="form-group row">
                  <div class="col-md-12">
                   <label for="c_email" class="text-black">Grocery Available In : <span class="text-danger">*</span></label>
					 <input type="text" class="form-control" name="availablein" id="availablein" value="<%= gro.getAvailableIn()%>" onblur="clearup(this)"><b id="availableinerr"></b>
					<!-- <select name="availablein" id="availablein" onblur="clearup(this)" class="form-control">
						<option selected disabled>--select--</option>
						<option>Liters</option>
						<option>KG</option>
						<option>Dozens</option>				
					</select>
					<b id="availableerr"></b> -->
				</div>
				</div>
				
				 <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_subject" class="text-black">Grocery Price : <span class="text-danger">*</span> </label>
                    <input type="text" class="form-control" name="price" id="price" value="<%= gro.getGroceryPrice()%>" onblur="clearup(this)"><b id="priceerr"></b>          
                 </div>
                </div>
                
                <div class="form-group row">
                  <div class="col-md-12">
                  <div> <img src="ImageController?groid=<%=gro.getGroceryId() %>" alt="Image"></div>
                    <label for="c_subject" class="text-black">Grocery Image : <span class="text-danger">*</span> </label>
                    <input type="file" class="form-control" name="groimage" id="groimage" height="100" width="200" value="<%= gro.getGroceryImage()%>"onblur="clearup(this)"><b id="medimageerr"></b>          
                 </div>
                </div>
                
                <div class="form-group row">
                  <div class="col-lg-6">
                    <input type="submit" class="btn btn-primary btn-lg btn-block" value="Update Grocery">
                  </div>
                  <div class="col-lg-6">
                    <input type="reset" class="btn btn-primary btn-lg btn-block" value="Cancel">
                  </div>
                </div>
		
				</div>
			</div>
		</div>
	</div>
</div>
</form>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>