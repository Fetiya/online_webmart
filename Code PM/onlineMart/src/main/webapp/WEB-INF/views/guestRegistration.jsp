<%-- 
    Document   : guestRegistration
    Created on : Jan 7, 2015, 8:25:04 PM
    Author     : Kabiraj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
                </div><!--/breadcrums-->

                <div class="step-one">
                    <h2 class="heading">Step1</h2>
                </div>
                <!--/checkout-options-->

                <div class="register-req">
                    <p>Please use Register And Checkout to easily get access to your order history, or use Checkout as Guest</p>
                </div><!--/register-req-->

                <div class="shopper-informations">
                    <div class="row">
                        <!--                                    
                                                                <div class="col-sm-3">
                                                                        <div class="shopper-info">
                                                                                <p>Shopper Information</p>
                                                                                <form>
                                                                                        <input type="text" placeholder="Display Name">
                                                                                        <input type="text" placeholder="User Name">
                                                                                        <input type="password" placeholder="Password">
                                                                                        <input type="password" placeholder="Confirm password">
                                                                                </form>
                                                                                
                                                                        </div>
                                                                </div>-->
                        <div class="col-sm-5 clearfix">
                            <div class="bill-to">
                                <p>Guest Registration</p>
                                <div class="form-one">
                                    <form:form  commandName="customer" action="guestRegistration" method="post"> 

                                       First Name: <form:input path="firstName" placeholder="First Name" />
                                        Middle Name: <form:input path="middleName" placeholder="Middle Name"/>
                                       Last Name:  <form:input path="lastName" placeholder="Last Name *"/>
                                       Email: <form:input type="text" path="email" placeholder="Email*"/>
                                      Address:  <form:input type="text" path="address.city" placeholder="Address  *"/>						
                                      Zip:  <form:input type="text" path="address.zip" placeholder="Zip"/>
                                       
                                      Phone:  <form:input type="text" path="telnum" name="Phone" placeholder="Phone *"/>

                                        <form:button class="btn btn-primary" type="submit">Continue </form:button>

                                    </form:form>
                                </div>
                            </div>
                        </div>
                        <!--					<div class="col-sm-4">
                                                                        <div class="order-message">
                                                                                <p>Shipping address</p>
                                                                                <textarea name="message"  placeholder="Notes about your order, Special Notes for Delivery" rows="16"></textarea>
                                                                                <label><input type="checkbox"> Shipping to bill address</label>
                                                                        </div>	
                                                                </div>-->

                    </div>
                </div>
            </div>
        </section> <!--/#cart_items-->







        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.scrollUp.min.js"></script>
        <script src="js/jquery.prettyPhoto.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>