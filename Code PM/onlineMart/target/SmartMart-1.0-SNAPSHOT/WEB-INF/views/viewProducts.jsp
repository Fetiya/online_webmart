<%-- 
    Document   : viewProducts
    Created on : Jan 2, 2015, 10:42:30 PM
    Author     : Kabiraj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Page</title>
    </head>
    <body>


        <p class="title">Products</p>
        <section id="cart_items">
            <div class="table-responsive cart_info">
                <table class="table table-condensed">
                    <thead>
                        <tr class="cart_menu">
                            
                            <th>Image</th>
                            <th>Name</th>
                            <th>Description</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Category</th>
                            <th>Vendor</th>
                            <th>Edit</th>
                            <th>Delete</th>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="product" items="${products}" varStatus="loopStatus" >
                            <tr>
                              

                                <td width="40%">
                                    <img src="productImage/${product.id}" />
                                </td>

                                <td width="20%">${product.name}</td>

                                <td> ${product.description}     </td>

                                <td> ${product.price}     </td>
                                <td> ${product.quantity}     </td>
                                <td> ${product.getProductCategory().name}     </td>
                                <td>${product.getVendor().companyName} </td>
                                <td><a href="productEdit/${product.id}"> Edit</a></td>
                                <td><a href="productDelete/${product.id}">DELETE</a></td>



                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </section>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://code.jquery.com/jquery.js"></script>
        <!-- Include all compiled plugins (below), or include individual files 
              as needed -->
        <script src="SmartMart/resources/js/bootstrap.min.js"></script>
    </body>

</html>
