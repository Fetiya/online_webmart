<%-- 
    Document   : addProductCategory
    Created on : Jan 1, 2015, 4:31:42 PM
    Author     : dipika
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Category</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    <f:form commandName="category" action="addCourse" method="post">
        <table>
            <tr>
                <td>Product Category Name:</td>
                <td><form:input type="text" path="productCategoryName" /> </td>
            <td><form:errors path="productCategoryName" cssClass="error" /> </td>
            </tr>
            <tr>
                <td>Product Category Description : </td>
                <td><form:input type="text" path="productCategoryDescName" /> </td>
            <td><form:errors path="productCategoryDescName" cssClass="error" /> </td>
            </tr>
            <tr>
            <f:button >register faculty</f:button>
            </tr>
        </table>
    </f:form>
</body>
</html>