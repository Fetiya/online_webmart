<%-- 
    Document   : productList
    Created on : Oct 17, 2014, 10:41:58 PM
    Author     : dipika
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>JSP Page</title>
    </head>
    <body>
        <h2>Search Results : </h2>
        <!--features_items-->
        <h2 class="title text-center">Search Results</h2>
         <c:forEach var="product" items="${products}"  >


                <div class="col-sm-4">
                    <div class="product-image-wrapper">
                        <div class="single-products">
                            <div class="productinfo text-center">
                            
                                 <img src="productImage/${product.id}" />
                                <h2>$ ${product.price}</h2>
                                <p>${product.name}</p>
                                <a href="${pageContext.request.contextPath}/addToCart/${product.id}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                            </div>
                            <div class="product-overlay">
                                <div class="overlay-content">
                                    <h2>$ ${product.price}</h2>
                                    <p>${product.name}</p>
                                    <a href="${pageContext.request.contextPath}/addToCart/${product.id}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                </div>
                            </div>
                        </div>
                        
                    </div>
                </div>

            </c:forEach>
    </body>
</html>      


