<%-- 
    Document   : productList
    Created on : Oct 17, 2014, 10:41:58 PM
    Author     : dipika
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>oak products</title>
    </head>
    <body>
        <h2>Search Results : </h2>
       

            <c:forEach var="product" items="${productList}">
                <div class="col-sm-4">
                    <div class="product-image-wrapper">
                        <div class="single-products">
                            <div class="productinfo text-center">
                                <img src="resources/bootstrap/images/productImages/${product.id}.jpg" alt="" />
                                <h2>$ ${product.price}</h2>
                                <p>${product.name}</p>
                                <a href="addToCart/${product.id}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                            </div>
                            <div class="product-overlay">
                                <div class="overlay-content">
                                    <h2>$ ${product.price}</h2>
                                    <p>${product.name}</p>
                                    <a href="addToCart/${product.id}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                </div>
                            </div>
                        </div>
                        <div class="choose">
                            <ul class="nav nav-pills nav-justified">
                                <li><a href="#"><i class="fa fa-plus-square"></i>Add to wishlist</a></li>
                                <li><a href="#"><i class="fa fa-plus-square"></i>Add to compare</a></li>
                            </ul>
                        </div>
                    </div>



                    </tr>
                    <%--</form:form>--%> 
                </c:forEach>
           </body>
</html>
