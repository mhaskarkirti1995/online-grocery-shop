<%@page import="com.grocery.pojo.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="star.css">
<link rel="stylesheet" href="rateuscss.css">
<style>
	b
	{
		color:red;
	}
</style>
<script type="text/javascript">

function validate()
{
	data=document.getElementsByName("rategrocery");
	data1=document.getElementsByName("rateus");
	
	check=0;
	check1=0;
	
	for(i=0;i<data.length;i++)
	{
		for(j=0;j<data1.length;j++)
		{
			if(data[i].checked)
			{
				check=1;
			}
			if(data1[j].checked)
			{
				check1=1;
			}
		}
	}
	if(check==0)
	{
		document.getElementById("rategroerr").innerHTML=" *Required Field"
		return false;
	}
	if(check1==0)
	{ 
		document.getElementById("rateuserr").innerHTML=" *Required Field"
		return false;
	}
	else
	{
		return true;
	}
}

function clearup(fun)
{
	alert("in");
	data=document.getElementsByName("rategrocery");
	data1=document.getElementsByName("rateus");

	/* for(var i=0;i<data.length;i++)
	{
		alert("for")
		if(data[i].checked)
		{alert("if")
			document.getElementById("rategroerr").innerHTML="";
		}
	} */
	for(var i=0;i<data1.length;i++)
	{
		alert("for")
		if(data1[i].checked)
		{ 
			alert("if")
			document.getElementById("rateuserr").innerHTML="";
		}
	}
}
</script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<form action="FeedbackServlet" method="post" onsubmit="return validate()">
	<input type="hidden" name="action" value="addfeedback">
	
	<% String user = (String)session.getAttribute("user"); %>
	<% Customer customer=(Customer)session.getAttribute("cust"); %>	
	
		<div class="products-breadcrumb">
		<div class="container">
			<ul>
				<li><i class="fa fa-home" aria-hidden="true"></i><a href="index.jsp">Home</a><span>|</span></li>
				<li>Feedback</li>
			</ul>
		</div>
	</div>
	<br>
	<div class="site-section">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<h2 class="h3 mb-5 text-black">Send Feedback</h2>
					</div>
		
          <div class="col-md-12">
          
             <div class="p-3 p-lg-5 border">
             
                  <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_subject" class="text-black">Customer Email Id : <span class="text-danger">*</span> </label>
                    <input type="email" class="form-control" name="custemailid" id="custemailid" onblur="clearup(this)" value="<%= customer.getCustomerEmailId() %>" readonly><b id="custemailiderr"></b>
                  </div>
                </div>
                
                <div class="form-group row">
                  <div class="col-md-12">
                	  <label for="c_subject" class="text-black" >Rate Grocery : <span class="text-danger">*</span></label>
						 <div class="ratting-wrapper" align="left" >
							  <input type="radio" name="rategrocery" id="star-1" value="5" ><label style="margin-bottom: 4.5rem" for="star-1"></label>
							  <input type="radio" name="rategrocery" id="star-2" value="4" ><label style="margin-bottom: 4.5rem" for="star-2"></label>
							  <input type="radio" name="rategrocery" id="star-3" value="3" ><label style="margin-bottom: 4.5rem" for="star-3"></label>
							  <input type="radio" name="rategrocery" id="star-4" value="2" ><label style="margin-bottom: 4.5rem" for="star-4"></label>
							  <input type="radio" name="rategrocery" id="star-5" value="1" ><label style="margin-bottom: 4.5rem" for="star-5"></label>
							  <input type="hidden" onblur="clearup(this)">	 
						</div><b id="rategroerr"></b>
				</div>
			</div>
			
			 <div class="form-group row">
                  <div class="col-md-12">
                	  <label for="c_subject" class="text-black" >Rate Us : <span class="text-danger">*</span></label><br>
                	  <br>
                	   <div class="ratting-wrapper1" align="left" onblur="clearup(this)">
            	   	 		<input type="radio" name="rateus" id="star-11" value="Excellent"><label style="margin-bottom: 4.5rem" for="star-11"><p>Excellent </p></label>
							<input type="radio" name="rateus" id="star-12" value="Good" ><label style="margin-bottom: 4.5rem" for="star-12"><p> Good</p></label>
							<input type="radio" name="rateus" id="star-13" value="Poor" ><label style="margin-bottom: 4.5rem" for="star-13"><p> Poor </p></label>
							<input type="hidden" onblur="clearup(this)">
						</div><b id="rateuserr"></b>
				</div>
			</div>
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_message" class="text-black">Suggestion :</label>
                   <textarea class="form-control" name="suggestion" id="suggestion" rows="5" cols="21"></textarea><b></b>
                  </div>
                </div>
                
                <div class="form-group row">
                  <div class="col-lg-12">
                    <input type="submit" class="btn btn-primary btn-lg btn-block" value="Send">
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