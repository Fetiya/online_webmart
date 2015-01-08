<%-- 
    Document   : checkOutSelection
    Created on : Jan 7, 2015, 11:46:16 PM
    Author     : Kabiraj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
 
	

	<section id="cart_items">
		<div class="container">
			<div class="breadcrumbs">
				<ol class="breadcrumb">
				  <li><a href="#">Home</a></li>
				  <li class="active">Check out</li>
				</ol>
			</div>

			<div class="step-one">
				<h2 class="heading">Step1</h2>
			</div>
			<div class="checkout-options">
				<h3>New User</h3>
				<p>Checkout options</p>
				<ul class="nav">
					<li>
						<label><a href="login">Returning User</a></label>
                                                
					</li>
				<li>
						<label><a href="guestRegistration">Guest Checkout</a> </label>
                                                
					</li>
					<li>
						<label><a href="addCredential">New User Sign Up</a> </label>
					</li>
				</ul>
			</div><!--/checkout-options-->

			
			
			

			
			<div class="register-req">
				<p>Please use Register And Checkout to easily get access to your order history, or use Checkout as Guest</p>
			</div><!--/register-req-->
		</div>
	</section> <!--/#cart_items-->

	

	
	


    <script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.scrollUp.min.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
</body>
</html>

