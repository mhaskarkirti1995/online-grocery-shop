<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Footer Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Grocery Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript">
addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- font-awesome icons -->
<link href="css/font-awesome.css" rel="stylesheet" type="text/css" media="all" /> 
<!-- //font-awesome icons -->
<!-- js -->
<script src="js/jquery-1.11.1.min.js"></script>
<script src="jquery-3.5.1.js"></script>
<!-- //js -->
<link href='//fonts.googleapis.com/css?family=Ubuntu:400,300,300italic,400italic,500,500italic,700,700italic' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>

<link rel="stylesheet" href="popup.css">

<!-- popup start JQuery !-->
<!-- <script>
	$(function () 
	{
	    $("form").submit(function(){
	       $(".hover_bkgr_fricc").show();
	    });
        $('.hover_bkgr_fricc').click(function(){
	        $('.hover_bkgr_fricc').hide();
	    });
	    $('.popupCloseButton').click(function(){
	        $('.hover_bkgr_fricc').hide();
	    });
	});
</script> -->

<!-- popup-end JQuery-->
</head>
<body>
<br>
<br>
<div class="hover_bkgr_fricc">
    <span class="helper"></span>
    <div>
        <div class="popupCloseButton">&times;</div>
        <p>Congratulation You Have Successfully<br/> Opened Your Inbox for Amazing Deals and Offer</p>
    </div>
</div>
<div>
<!-- newsletter -->
	<div class="newsletter">
		<div class="container">
			<div class="w3agile_newsletter_left">
				<h3>Stay updated with the latest offers</h3>
			</div>
			<div class="w3agile_newsletter_right">
				<form action="SubscriberServlet" method="post" >
					<input type="email" name="email" Placeholder="Email" required="">
					<input type="submit" value="subscribe now" id="hover_bkgr_fricc">
				</form>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div></div>
	
<!-- //newsletter -->
<!-- footer -->
	<div class="footer">
		<div class="container">
			<div class="col-md-3 w3_footer_grid">
				<h3>information</h3>
				<ul class="w3_footer_grid_list">
					<li><a href="faqs.jsp">FAQ's</a></li>
					<li><a href="aboutus.jsp">About Us</a></li>
					<li><a href="grocerylist.jsp">Best Deals</a></li>
					<li><a href="addcontact.jsp">Contact Us</a></li>
				</ul>
			</div>
			<div class="col-md-3 w3_footer_grid">
				<h3>policy info</h3>
				<ul class="w3_footer_grid_list">
					<li><a href="faqs.jsp">FAQ's</a></li>
					<li><a href="faqs.jsp">privacy policy</a></li>
					<li><a href="faqs.jsp">terms of use</a></li>
				</ul>
			</div>
			<div class="col-md-3 w3_footer_grid">
				<h3>what in stores</h3>
				<ul class="w3_footer_grid_list">
					<li><a href="grocerylist.jsp">Soft Drinks</a></li>
					<li><a href="grocerylist.jsp">Snacks</a></li>
					<li><a href="grocerylist.jsp">Grocery</a></li>
					<li><a href="grocerylist.jsp">Dry Fruits & Nuts</a></li>
					<li><a href="grocerylist.jsp">Households</a></li>
					<li><a href="grocerylist.jsp">Rise & Other Grains</a></li>
				</ul>
			</div>
			<div class="col-md-3 w3_footer_grid">
				<h3>twitter posts</h3>
				<ul class="w3_footer_grid_list1">
					<li><label class="fa fa-twitter" aria-hidden="true"></label><i><a href="faqs.jsp">01 day ago</a></i><span> <a href="#"></a>
						
						<a href="#"></a></span></li>
					<li><label class="fa fa-twitter" aria-hidden="true"></label><i><a href="faqs.jsp">02 day ago</a></i><span> <a href="#"></a>
						
						<a href="#"></a></span>
					</li>
				</ul>
			</div>
			<div class="clearfix"> </div>
			<div class="agile_footer_grids">
				<div class="col-md-3 w3_footer_grid agile_footer_grids_w3_footer">
					<div class="w3_footer_grid_bottom">
						<h4>100% secure payments</h4>
						<img src="images/card.png" alt=" " class="img-responsive" />
					</div>
				</div>
				<div class="col-md-3 w3_footer_grid agile_footer_grids_w3_footer">
					<div class="w3_footer_grid_bottom">
						<h5>connect with us</h5>
						<ul class="agileits_social_icons">
							<li><a href="#" class="facebook"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
							<li><a href="faqs.jsp" class="twitter"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
							<li><a href="addcontact.jsp" class="google"><i class="fa fa-google-plus" aria-hidden="true"></i></a></li>
							<li><a href="#" class="instagram"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>
						</ul>
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
			<div class="wthree_footer_copy">
			 <p>
              Copyright &copy;
              <script>document.write(new Date().getFullYear());</script> 
              All rights reserved by Kirti K. Mhaskar  <i class="icon-heart" aria-hidden="true"></i>
             </p>
			</div>

        </div>
		</div>
	</div>
<!-- //footer -->
<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>
<script>
$(document).ready(function(){
    $(".dropdown").hover(            
        function() {
            $('.dropdown-menu', this).stop( true, true ).slideDown("fast");
            $(this).toggleClass('open');        
        },
        function() {
            $('.dropdown-menu', this).stop( true, true ).slideUp("fast");
            $(this).toggleClass('open');       
        }
    );
});
</script>
<!-- here stars scrolling icon -->
	<script type="text/javascript">
		$(document).ready(function() {
			/*
				var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
				};
			*/
								
			$().UItoTop({ easingType: 'easeOutQuart' });
								
			});
	</script>
<!-- //here ends scrolling icon -->
<script src="js/minicart.js"></script>
<script>
		paypal.minicart.render();

		paypal.minicart.cart.on('checkout', function (evt) {
			var items = this.items(),
				len = items.length,
				total = 0,
				i;

			// Count the number of each item in the cart
			for (i = 0; i < len; i++) {
				total += items[i].get('quantity');
			}

			if (total < 3) {
				alert('The minimum order quantity is 3. Please add more to your shopping cart before checking out');
				evt.preventDefault();
			}
		});

	</script>
</body>
</html>

</body>
</html>