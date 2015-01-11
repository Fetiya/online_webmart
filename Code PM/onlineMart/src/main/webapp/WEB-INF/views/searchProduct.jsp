<%-- 
    Document   : searchProduct
    Created on : Jan 5, 2015, 11:42:53 AM
    Author     : dipika
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Product</title>
    </head>
    <body>
        
        <form action="searchProduct" method="POST">  
            <input type="text" name="productName" required="required" placeholder="search Product"/>   
            <div class="search_box pull-right">
                <input type="submit" value = ""/>
            </div>
        </form>   
    </body>
</html>
