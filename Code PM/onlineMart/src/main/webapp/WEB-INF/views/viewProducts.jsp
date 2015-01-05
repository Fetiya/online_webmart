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
        <h1>All Products View!</h1>


        <table> 
            <thead>

                <tr>
                    <th>id</th>
                    <th>Image</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Category</th>
                    <th>Vendor</th>
                    

                </tr>
            </thead>
            <tbody>
                <c:forEach var="product" items="${products}" varStatus="loopStatus" >

                <td>${product.id}</td>
                
                <td width="40%">
                        <img src="productImage/${product.id}" />
                </td>
                               
                <td width="20%">${product.name}</td>

                <td> ${product.description}     </td>
                
                <td> ${product.price}     </td>
                <td> ${product.quantity}     </td>
                <td> ${product.getProductCategory().name}     </td>
                <td>${product.getVendor().companyName} </td>
                
               
                
                

            </tr>
        </c:forEach>
    </tbody>
</table>
        
         <h1>Hello, world!</h1>

      <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
      <script src="https://code.jquery.com/jquery.js"></script>
      <!-- Include all compiled plugins (below), or include individual files 
            as needed -->
      <script src="SmartMart/resources/js/bootstrap.min.js"></script>
</body>

</html>
