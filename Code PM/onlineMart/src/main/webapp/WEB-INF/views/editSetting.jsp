<%-- 
    Document   : editProduct
    Created on : Jan 5, 2015, 1:38:19 PM
    Author     : Kabiraj
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
       
        <h2>Update Setting </h2>
        <form:form modelAttribute="setting" action="../editSetting" method="post">
            <table>
                <form:hidden path="id"/>
                 <tr>
                    <td>Name: </td>
                    <td> <form:input path="name" /> </td>
                    <td><form:errors path="name" cssClass="error" /> </td>
                </tr>               
                
                <tr>
                    <td>Account Number:  </td>
                    <td><form:input path="accountNum" /></td>
                    <td><form:errors path="price" cssClass="error" /> </td>
                </tr>
                
                <tr>
                    <td>Value </td>
                    <td><form:input path="price" /></td>
                    <td><form:errors path="price" cssClass="error" /> </td>
                </tr>
                
                <tr>
                    <td>Profit Percentage: </td>
                    <td><form:input path="profitpercentage" /></td>
                    <td><form:errors path="price" cssClass="error" /> </td>
                </tr>
                
                
                <tr>
                    <td><input type="submit" value="UPDATE"/></td>
                </tr>
            </table>
        </form:form>
   

    </body>
</html>
