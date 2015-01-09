<%-- 
    Document   : productByVendor
    Created on : Jan 5, 2015, 11:18:45 PM
    Author     : dipika
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2 class="title text-center">Products</h2>
        <c:forEach var="product" items="${productlist}"  >


                <div class="col-sm-4">
                    <div class="product-image-wrapper">
                        <div class="single-products">
                            <div class="productinfo text-center">
                                <img src="productImage/${product.id}" alt="" />
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
                   </div>
                </div>

            </c:forEach>
           
    </body>
</html>
