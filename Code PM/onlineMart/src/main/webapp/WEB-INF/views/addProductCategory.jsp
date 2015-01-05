<%-- 
    Document   : addCategory
    Created on : Jan 2, 2015, 9:18:31 PM
    Author     : dipika
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Add Product Category</h2>
        <form:form commandName="category" action="addProductCategory" method="Post">
            <form:errors path="*" cssClass="alert alert-danger" element="div"/> 
            <table>
                <tr>
                    <td>Category Name : </td>
                    <td><form:input type="text" path="name" /> </td>  
                    <td><form:errors path="name" cssClass="error" /> </td>
                </tr
                <tr>
                    <td>Category Description : </td>
                    <td><form:input type="text" path="description" /> </td>
                    <td><form:errors path="description" cssClass="error" /> </td>
                </tr>
                <tr>
                    <td><input type="submit" value="Add Product Category"/></td>
                </tr>
        </table>
    </form:form>
</body>
</html>
