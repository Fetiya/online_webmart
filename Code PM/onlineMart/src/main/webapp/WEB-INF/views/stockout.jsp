<%-- 
    Document   : stockout
    Created on : Jan 7, 2015, 9:21:03 AM
    Author     : Fetiya
--%>

<%@page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
    
    </head>

    <body>

        <section id="cart_items">
            <div class="container">
                <div class="breadcrumbs">
                    <ol class="breadcrumb">
                        <li><a href="#">Home</a></li>
                        <li class="active">Stockout</li>
                    </ol>
                </div>
                <div class="user_info">
                <p>${message}</p>          
                </div>
                <div class="table-responsive cart_info">
                    <table class="table table-condensed">
                        <thead>
                            <tr class="cart_menu">
                                <td></td>
                                <td class="image">Item</td>
                                <td class="price">Price</td>
                                <td class="quantity">Requested Quantity</td>
                                <td class="quantity">Available Quantity</td>
                                
                                <td>Edit</td>
                                <td>Delete</td>
                            </tr>
                        </thead>
                        <tbody>

                        <tbody>


                            <c:forEach var="cartItem" items="${stockOutItems}" varStatus="loopStatus" >
                                <tr >
                                    <form:form  commandName="cartUpdate" action="${pageContext.request.contextPath}/cart/edit/${cartItem.product.id}" method="post" enctype="multipart/form-data" >


                                        <td class="cart_product">
                                            <a href="">   <img src="productImage/${cartItem.product.id}" 
                                                               width="100" height="100" alt=""></a>
                                        </td>
                                        <td class="cart_description">
                                            <h4><a href="">${cartItem.product.name}</a></h4>
                                            <p>Web ID: ${cartItem.id}</p>
                                            <p>${cartItem.product.description}</p>
                                        </td>
                                        <td class="cart_price">
                                            <p>${cartItem.product.price}</p>
                                        </td>
                                        <td class="cart_quantity">
                                            <div class="cart_quantity_button">
                                                <form:input path="quantity"  class="cart_quantity_input" type="text" name="quantity" value="${cartItem.quantity}" autocomplete="off" size="2"/>

                                            </div>
                                        </td>
                                        <td> <p>${cartItem.product.quantity}</td>
                                        <td><input class="btn btn-primary" type="submit" value="Update" />
                                        </td>
                                        <td class="cart_delete">
                                            <a class="cart_quantity_delete" href="${pageContext.request.contextPath}/cart/delete/${cartItem.product.id}"><i class="fa fa-times"></i></a>
                                        </td>
                                    </form:form>
                                </tr>

                            </c:forEach>
                        </tbody>
                    </table>
                </div>

            </div>
        </section> <!--/#cart_items-->

        <section id="do_action">
            <div class="container">

            </div>
        </section><!--/#do_action-->

    </body>
</html>
