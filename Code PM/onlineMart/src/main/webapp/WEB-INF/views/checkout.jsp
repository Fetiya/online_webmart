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
        <title>JSP Page</title>
    </head>
    <body>

        <div class="row">  	
            <div class="col-sm-form">
                <div class="contact-form">
                    <h2 class="title text-center">Check Out</h2>
                    <p class="title ">New User check Out Options</p>

                    <p class="title ">
                        <a class="title" style="color:#fe980f;font-size: 13px; text-decoration: underline" href= "#">Register Account</a>
                        <a class="title" style="color:#fe980f;font-size: 13px; text-decoration: underline" href= "#"> Guest Checkout</a>
                    </p>


                    <p class="title ">Bill To</p>
                    <form:form commandName="payment" modelAttribute="payment" action="cardValidation" method="post">
                        <table>
                            <tr class="form-group col-md-12" style="width: 181%">
                                <td class="td-label">Full Name:</td>
                                <td class="td-input"><form:input path="name"  placeholder="First Name and Last Name" class="form-control" /></td>
                                <td><form:errors path="name" cssClass="error" /></td>
                            </tr>

                            <tr class="form-group col-md-12" style="width: 181%" >
                                <td class="td-label">Card Type:</td>
                                <td class="td-input" class="td-input" >
                                    <form:select path="cardType"  placeholder="Card Type *"  class="form-control" >
                                        <form:option value="visa">Visa</form:option>
                                        <form:option value="masterCard">Master Card</form:option>
                                    </form:select>
                                </td>
                                <td><form:errors path="cardType" cssClass="error" /></td>
                            </tr>

                            <tr class="form-group col-md-12" style="width: 181%">
                                <td class="td-label">Card Number:</td>
                                <td class="td-input"><form:input path="cardNumber"  placeholder="Card Number *"  class="form-control"/></td>
                                <td><form:errors path="cardNumber" cssClass="error" /></td>
                            </tr>
                            <tr class="form-group col-md-12" style="width: 181%">
                                <td class="td-label">Card Security Number:</td>
                                <td class="td-input"><form:input path="securityNumber" placeholder="Card Security Number *" class="form-control"/></td>
                                <td><form:errors path="securityNumber" cssClass="error" /></td>
                            </tr>

                            <tr class="form-group col-md-12" style="width: 181%">
                                <td class="td-label">Expiry Date : </td>
                                <td class="td-input"><form:input path="expiryDate"   placeholder="Expiry Date *" class="form-control"/></td>
                                <td><form:errors path="expiryDate" cssClass="error" /></td>
                            </tr>
                            <tr class="form-group col-md-12" style="width: 181%">
                                <td class="td-label">Total Amount : </td>
                                <td class="td-input"><form:input path="totalAmount"   placeholder="total amount" class="form-control"/></td>
                            </tr>
                            <tr class="form-group col-md-12">
                                <td class="td-label"> 
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
</section>
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.scrollUp.min.js"></script>
<script src="js/jquery.prettyPhoto.js"></script>
<script src="js/main.js"></script>
</body>
</html>
