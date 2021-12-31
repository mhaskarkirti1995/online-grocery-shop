<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<title>Payment</title>
<script src="jquery-3.5.1.js"></script>
<script src="jquery.validate.min.js"></script>
<script>
	function validate()
	{
		data=document.getElementsByClassName("demo");
		count=0;
		
		for(var i=0;i<data.length;i++)
		{
			if(data[i].value=="")
			{
				data[i].nextElementSibling.innerHTML=" *Required Field"
				data[i].nextElementSibling.style.color="red"
				count++;
			}
			 if(data[1].value!="" && data[1].value.length!=16)
			{
				data[1].nextElementSibling.innerHTML=" Please enter correct card number.";
				data[1].nextElementSibling.style.color="red";
				count++;
			}
			if(data[2].value!="" && data[2].value.length!=3)
			{
				data[2].nextElementSibling.innerHTML=" Please enter correct CVV number.";
				data[2].nextElementSibling.style.color="red";
				count++;
			} 
			
		}
		if(count>0)
			return false;
		else
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
</head>
	
<body>
<jsp:include page="header.jsp"></jsp:include>

	<div class="products-breadcrumb">
		<div class="container">
			<ul>
				<li><i class="fa fa-home" aria-hidden="true"></i><a href="index.html">Home</a><span>|</span></li>
				<li>Payment</li>
			</ul>
		</div>
	</div>
<!-- payment -->
		<div class="privacy about">
			<h3>Pay<span>ment</span></h3>
			
	  <div class="checkout-right">
        <div id="parentHorizontalTab">
            <ul class="resp-tabs-list hor_1">
				<li>Cash on delivery (COD)</li>
                <li>Credit/Debit</li>
            </ul>
            <div class="resp-tabs-container hor_1">
				<div>
                      <div class="vertical_post check_box_agile">
						<h5>COD</h5>
							<div class="checkbox">								
								<div class="check_box_one cashon_delivery">
									<label class="anim">
											<input type="checkbox" class="checkbox">
												 <span> We also accept Credit/Debit card on delivery. Please Check with the agent.</span> 
									</label> 
							</div>					
						</div>
					</div>
       			 </div>
     <div>
       <form action="PaymentServlet" method="post" class="creditly-card-form agileinfo_form" onsubmit="return validate()">
			<section class="creditly-wrapper wthree, w3_agileits_wrapper">
				<div class="credit-card-wrapper">
					<div class="first-row form-group">
						<div class="controls">
							<label class="control-label">Name on Card</label>
								<input class="billing-address-name form-control demo" type="text" name="nameoncard" id="nameoncard" placeholder="Enter Name On Card" onblur="clearup(this)"><b></b>
						</div>
				<div class="w3_agileits_card_number_grids">
					<div class="w3_agileits_card_number_grid_left">
						<div class="controls">
							<label class="control-label">Card Number</label>
								<input class="number credit-card-number form-control demo" type="text" name="cardnumber" id="cardnumber" placeholder="Enter Card Number" onblur="clearup(this)"><b></b>
						</div>
					</div>
				<div class="w3_agileits_card_number_grid_right">
					<div class="controls">
						<label class="control-label">CVV</label>
							<input class="security-code form-control demo" inputmode="numeric" type="text" name="cvvnumber" id="cvvnumber" placeholder="Enter CVV Code" onblur="clearup(this)"><b></b>
					</div>
				</div>
				<div class="clear"> </div>
				</div>
					<div class="controls">
						<label class="control-label">Expiry Date Formate(MM / YY)</label>
							<input class="expiration-month-and-year form-control demo" type="text" name="expirydate" id="expirydate" placeholder="MM / YY" onblur="clearup(this)"><b></b>
					<div>
				</div>
				<button class="submit"><span>Make a Payment </span></button>
				</div>
				</div>
				</div>
				</section>
				</form>
    	    </div>
     	 </div>
	</div>
</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
<!-- js -->
<script src="js/jquery-1.11.1.min.js"></script>
<!-- easy-responsive-tabs -->    
<link rel="stylesheet" type="text/css" href="css/easy-responsive-tabs.css " />
<script src="js/easyResponsiveTabs.js"></script>
<!-- //easy-responsive-tabs --> 
	<script type="text/javascript">
    $(document).ready(function() {
        //Horizontal Tab
        $('#parentHorizontalTab').easyResponsiveTabs({
            type: 'default', //Types: default, vertical, accordion
            width: 'auto', //auto or any width like 600px
            fit: true, // 100% fit in a container
            tabidentify: 'hor_1', // The tab groups identifier
            activate: function(event) { // Callback function if tab is switched
                var $tab = $(this);
                var $info = $('#nested-tabInfo');
                var $name = $('span', $info);
                $name.text($tab.text());
                $info.show();
            }
        });
    });
</script>
<!-- <!-- credit-card -->
		<script type="text/javascript" src="js/creditly.js"></script>
        <link rel="stylesheet" href="css/creditly.css" type="text/css" media="all" />

		<script type="text/javascript">
			/* $(function() {
			  var creditly = Creditly.initialize(
				  '.creditly-wrapper .expiration-month-and-year',
				  '.creditly-wrapper .credit-card-number',
				  '.creditly-wrapper .security-code',
				  '.creditly-wrapper .card-type');

			  $(".creditly-card-form .submit").click(function(e) {
				e.preventDefault();
				var output = creditly.validate();
				if (output) {
				  // Your validated credit card output
				  console.log(output);
				}
			  });
			}); */
		</script>
//credit-card
 -->
</body>
</html>