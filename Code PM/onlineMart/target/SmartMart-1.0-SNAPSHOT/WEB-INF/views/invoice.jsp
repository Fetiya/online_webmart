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
        <title>Invoice</title>
    </head>
    <body>

        <c:choose>
            <c:when test="${empty order}">
                <p>${message}</p>          
            </c:when>
            <c:otherwise>
                 <h4 class="text-center">Invoice</h4>
                <p class="title ">${message}</p> 
            </c:otherwise>
        </c:choose>
            </body>
        </html>
