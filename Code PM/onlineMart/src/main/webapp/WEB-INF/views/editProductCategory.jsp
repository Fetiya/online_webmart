<%-- 
    Document   : editProductCategory
    Created on : Jan 3, 2015, 12:12:56 PM
    Author     : dipika
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
        <h2>Update Product Category</h2>
        <form:form commandName="productCategory" action="${pageContext.request.contextPath}/editCategory" method="POST">
            <table>
                <form:hidden path="id"/>
                <tr>
                    <td>Category Name : </td>
                    <td><form:input type="text" path="name" /> </td>   
                     <td><form:errors path="name" cssClass="error" /> </td>
                </tr>
                 <tr>
                    <td>Category Description : </td>
                    <td><form:input type="text" path="description" /> </td>
                     <td><form:errors path="description" cssClass="error" /> </td>
                </tr>
                <tr>
                    <td><input type="submit" value="UPDATE"/></td>
                </tr>
            </table>
        </form:form>
   
</body>
</html>
