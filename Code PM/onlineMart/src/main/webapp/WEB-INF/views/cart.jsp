<%-- 
    Document   : cart
    Created on : Jan 3, 2015, 11:18:44 AM
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
            <div class="row">  	
                <div class="col-sm-form">
                    <div class="contact-form">
                        <h2 class="title text-center">Shopping Cart</h2>
                        <c:choose>
                            <c:when test="${ empty cartItems}">
                                <h4  class ="text-center" style="font:red">${message}</h3>          
                                </c:when>
                                <c:otherwise>

                                    <div class="table-responsive cart_info">
                                        <table class="table table-condensed">
                                            <thead>
                                                <tr class="cart_menu">
                                                    <td class="image">Item</td>
                                                    <td class="image">Name</td>
                                                    <td class="price">Price</td>
                                                    <td class="quantity">Quantity</td>
                                                    <td class="total">Total</td>
                                                    <td class="total">Delete</td>
                                                    <td class="total">Edit</td>
                                                </tr>
                                            </thead>
                                            <tbody>

                                            <tbody>

                                                <c:forEach var="cartItem" items="${cartItems}" varStatus="loopStatus" >
                                                    <tr >

                                            <form:form  commandName="cartUpdate" action="${pageContext.request.contextPath}/cart/edit/${cartItem.product.id}" method="post" enctype="multipart/form-data" >
 
                                                <td class="cart_product">
                                                    <a href="">   <img src="productImage/${cartItem.product.id}" 
                                                                       width="100" height="100" alt=""></a>
                                                </td>
                                                <td class="cart_description">
                                                    <h4><a href="">${cartItem.product.name}</a></h4>
                                                    <p>Web ID: ${cartItem.id}</p>
                                                </td>
                                                <td class="cart_price">
                                                    <p>${cartItem.product.price}</p>
                                                </td>
                                                <td class="cart_quantity">
                                                    <div class="cart_quantity_button">
                                                              <form:input path="quantity"  class="cart_quantity_input" type="text" name="quantity" value="${cartItem.quantity}" autocomplete="off" size="2"/>
                                                       
                                                    </div>
                                                </td>

                                             <td><form:errors path="quantity" cssClass="error" /> </td> 
                                                <td class="cart_total">
                                                    <p class="cart_total_price">
                                                        <c:set var="result" value="${cartItem.product.price * cartItem.quantity}"/>
                                                        <c:out value="${result}"/>
                                                        <form:form action="${pageContext.request.contextPath}/cart/edit/${cartItem.id}" method="post">

                                                            <td class="cart_product">
                                                                <a href="">   <img src="productImage/${cartItem.product.id}" 
                                                                                   width="100" height="100" alt=""></a>
                                                            </td>
                                                            <td class="cart_description">
                                                                <h4><a href="">${cartItem.product.name}</a></h4>
                                                                <p>Web ID: ${cartItem.id}</p>
                                                            </td>
                                                            <td class="cart_price">
                                                                <p>${cartItem.product.price}</p>
                                                            </td>
                                                            <td class="cart_quantity">
                                                                <div class="cart_quantity_button">
                                                                    <a class="cart_quantity_up" href=""> + </a>
                                                                    <input class="cart_quantity_input" type="text" name="quantity" value="${cartItem.quantity}" autocomplete="off" size="2"/>
                                                                    <a class="cart_quantity_down" href=""> - </a>
                                                                </div>
                                                            </td>
                                                            <td class="cart_total">
                                                                <p class="cart_total_price">
                                                                    <c:set var="result" value="${cartItem.product.price * cartItem.quantity}"/>
                                                                    <c:out value="${result}"/>




                                                        </form:form>
                                                    </tr>

                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>

                            </div>
                            </section> <!--/#cart_items-->


                                                <a class="btn btn-default check_out" href="checkout">Check Out</a>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </section><!--/#do_action-->

                        </c:otherwise>
                    </c:choose> 

                    </body>
                    </html>
                                                    </p>
                                                </td>

                                                <td><input class="btn btn-primary" type="submit" value="Update" />
                                                </td>

                                                <td class="cart_delete">
                                                    <a class="cart_quantity_delete" href="${pageContext.request.contextPath}/cart/delete/${cartItem.product.id}"><i class="fa fa-times"></i></a>
                                                </td>
