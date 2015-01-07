<%-- 
    Document   : productDetail
    Created on : Jan 5, 2015, 9:06:59 AM
    Author     : Fetiya
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            <img src="resources/bootstrap/image/productImage/${product.id}" class="newarrival" alt="" />
            <h2>${product.name}</h2>
            <p>ID: ${product.id}</p>
            <img src="images/product-details/rating.png" alt="" />
            <span>
                <span>US ${product.price}</span>
                <!--								
                                                                                        
                                                                                        <button type="button" class="btn btn-fefault cart">
                                                                                                <i class="fa fa-shopping-cart"></i>
                                                                                                Add to cart
                                                                                        </button>
                -->

                <form:form commandName="product" action="${pageContext.request.contextPath}/addToCart/${product.id}" method="post">

                    <label>Quantity:</label>   <input type="text" name="quantity" value ="1" size="3"/>
                    <input style="background-color:lightgoldenrodyellow" type="submit" value="Add to cart"/>

                </form:form>
            </span>
            <p><b>Availability:</b> In Stock</p>
            <p><b>Condition:</b> New</p>
            <p><b>Brand:</b> E-SHOPPER</p>
            <a href=""><img src="images/product-details/share.png" class="share img-responsive"  alt="" /></a>
   


    </body>
</html>
