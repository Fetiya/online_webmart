<%-- 
    Document   : setting
    Created on : Jan 6, 2015, 11:22:23 PM
    Author     : Kabiraj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
     <body>
        
        <h2> Setting</h2>
        <form:form commandName="setting" action="addSetting" method="post" enctype="multipart/form-data">
            
            <table>
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
                
                
                
                
                
                

                
            </table>
                
               <input type="submit" value="Insert"/>

        </form:form>
    </body>
</html>
