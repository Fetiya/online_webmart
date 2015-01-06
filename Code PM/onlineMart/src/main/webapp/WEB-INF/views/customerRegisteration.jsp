<%-- 
    Document   : CustomerRegisteration
    Created on : Jan 4, 2015, 12:47:53 AM
    Author     : Komal
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
        <form:form commandName="customer" action="addCustomer" method="POST" enctype="multipart/form-data">
            <table>
                
                 <tr>
                    <td>=====Customer Information</td>
                </tr>
                <tr>
                    <td>First Name :</td>
                    <td><form:input type="text" path="firstName" /> </td> 
                </tr>
                <tr>
                    <td>Middle Name :</td>
                    <td><form:input type="text" path="middleName" /> </td>
                    
                </tr>
                <tr>
                    <td>Last Name :</td>
                    <td><form:input type="text" path="lastName" /> </td>
                   
                </tr>
                <tr>
                    <td>Telephone Number :</td>
                    <td><form:input type="text" path="telnum" /> </td>
                    
                </tr>
                <tr>
                    <td>=======User Credential Information</td>
                </tr>
                <tr>
                    <td>Email id :</td>
                    <td><form:input type="text" path="credential.username" /> </td>
                   
                </tr>
                
                 <tr>
                    <td>Password :</td>
                    <td><form:password path="credential.password" /> </td>
                   
                </tr>
                <tr>
                    <td>==========User Address Information</td>
                </tr>
                <tr>
                    <td>Country :</td>
                    <td><form:input type="text" path="address.country" /> </td>
                    
                </tr>
                
                
                  <tr>
                    <td>City :</td>
                    <td><form:input type="text" path="address.city" /> </td>
                    <!--<td>< form:errors path="address.city" cssClass="error"/> </td>-->
                </tr>
                
                
                  <tr>
                    <td>Street :</td>
                    <td><form:input type="text" path="address.street" /> </td>
                    <!--<td>< form:errors path="address.street" cssClass="error"/> </td>-->
                </tr>
                
                
                  <tr>
                    <td>Zip Code :</td>
                    <td><form:input type="text" path="address.zip" /> </td>
                    <!--<td>< form:errors path="address.zip" cssClass="error"/> </td>-->
                </tr>
 
                
            </table>
                <%--<form:hidden path="credential.userName" />--%> 
                <%--<form:hidden path="credential.password" />--%> 
                <%--<form:hidden path="credential.confirmPassword" />--%> 
                <%--<form:hidden path="credential.role" />--%> 
           <form:button >Sign up</form:button>
           </form:form>
    </body>
</html>
