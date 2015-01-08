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
        <script>
            function confirmComplete() {
                alert("confirmComplete");
                var answer = confirm("Are you sure you want to delete the item from the shopping cart?");
                if (answer == true)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        </script>
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

                        <h4 style="font:red">${message}</h4>          

                        <div class="table-responsive cart_info">
                            <table class="table table-condensed">
                                <thead>
                                    <tr class="cart_menu">
                                        <td class="image">Item</td>
                                        <td class="description"></td>
                                        <td class="price">Price</td>
                                        <td class="quantity">Requested Quantity</td>
                                        <td class="quantity">Available Quantity</td>
                                        
                                        <td></td>
                                    </tr>
                                </thead>
                                <tbody>

                                <tbody>


                                    <c:forEach var="cartItem" items="${stockOutItems}" varStatus="loopStatus" >
                                        <tr >


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
                                            <td> <p>${cartItem.product.quantity}</td>
                                          
                                            <td class="cart_delete">
                                                <a class="cart_quantity_delete" href="${pageContext.request.contextPath}/cart/delete/${cartItem.id}"><i class="fa fa-times"></i></a>
                                            </td>
                                         
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
