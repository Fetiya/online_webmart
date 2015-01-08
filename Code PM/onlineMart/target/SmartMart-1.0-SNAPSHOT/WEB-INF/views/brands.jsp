<%-- 
    Document   : brands
    Created on : Jan 6, 2015, 3:45:22 PM
    Author     : dipika
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="brands-name">

    <ul class="nav nav-pills nav-stacked">
        <c:forEach var="v" items="${vendorList}">
            <li><a href="getProductByVendorOnly/${v.id}"> <span class="pull-right"></span>${v.companyName}</a></li>
        </c:forEach>
    </ul>
</div>
