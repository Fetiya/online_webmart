<%-- 
    Document   : checkout
    Created on : Jan 3, 2015, 2:32:54 PM
    Author     : Fetiya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Check Out</title>
    </head>
    <body>
        <div class="row">  	
            <div class="col-sm-form">
                <div class="contact-form">
                    <h2 class="title text-center">Customer Registration</h2>
                    <section id="cart_items">
                        <div class="container">
                           

                            <div class="shopper-informations">
                                <div class="row">

                                    <div class="col-sm-5 clearfix">
                                        <div class="contact-form">
                                            <p class="title">Bill To</p>
                                            <div>
                                                <form action="cardValidation" method="post"> 
                                                    <form:form commandName="payment" modelAttribute="payment" action="cardValidation" method="post">
                                                        <table>
                                                            <tr class="form-group col-md-12">
                                                                <td class="td-label">Full Name:</td>
                                                                <td class="td-input"><form:input path="name" class="form-control" placeholder="Full Name"/></td>
                                                                <td><form:errors path="name" cssClass="error" /></td>
                                                            </tr>

                                                            <tr class="form-group col-md-12">
                                                                <td class="td-label">Card Type:</td>
                                                                <td class="td-input">
                                                                    <form:select path="cardType"  placeholder="Card Type *" >
                                                                        <form:option value="visa">Visa</form:option>
                                                                        <form:option value="masterCard">Master Card</form:option>
                                                                    </form:select>
                                                                </td>
                                                                <td><form:errors path="cardType" cssClass="error" /></td>
                                                            </tr>
                                                            <tr class="form-group col-md-12">
                                                                <td class="td-label">Card Number:</td>
                                                                <td class="td-input"><form:input path="cardNumber"  class="form-control" placeholder="Card Number *"/></td>
                                                                <td><form:errors path="cardNumber" cssClass="error" /></td>
                                                            </tr>
                                                            <tr class="form-group col-md-12">
                                                                <td class="td-label">Card Security Number:</td>
                                                                <td class="td-input"><form:input path="securityNumber" class="form-control" placeholder="Card Security Number *"/></td>
                                                                <td><form:errors path="securityNumber" cssClass="error" /></td>
                                                            </tr>

                                                            <tr class="form-group col-md-12">
                                                                <td class="td-label">Expiry Date :</td>
                                                                <td class="td-input"><form:input path="expiryDate" class="form-control"   placeholder="Expiry Date *"/></td>
                                                                <td><form:errors path="expiryDate" cssClass="error" /></td>
                                                            </tr>

                                                            <tr class="form-group col-md-12">
                                                                <td class="td-input"> 
                                                                    <button class="btn btn-primary" type="submit">Place Order </button>
                                                                </td>
                                                            </tr>
                                                        </table> 
                                                    </form:form>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section> <!--/#cart_items-->
                    <script src="js/jquery.js"></script>
                    <script src="js/bootstrap.min.js"></script>
                    <script src="js/jquery.scrollUp.min.js"></script>
                    <script src="js/jquery.prettyPhoto.js"></script>
                    <script src="js/main.js"></script>
                </div>
            </div>
        </div>
    </body>
</html>
