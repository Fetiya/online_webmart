<%-- 
    Document   : invoice
    Created on : Jan 6, 2015, 1:09:23 AM
    Author     : Fetiya
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>invoice</title>
    </head>
    <body>
        <div class="row">  	
            <div class="col-sm-form">
                <div class="contact-form">
                    <h2 class="title text-center">Invoice</h2>
                    <c:choose>
                        <c:when test="${empty order}">
                            <p style="color:red">${message}</p>          
                        </c:when>
                        <c:otherwise>


                            <p style="color:red">${message}</p>    
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </body>
</html>
