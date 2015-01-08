<%-- 
    Document   : addAdminCredential
    Created on : Jan 7, 2015, 9:24:15 AM
    Author     : Komal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form:form commandName="credential" action="addAdminCredential" method="POST" enctype="multipart/form-data">
            <table>

                <tr>
                    <td>Please provide your Credential Information</td>
                </tr>
                <tr>
                    <td>Email id :</td>
                    <td><form:input type="text" path="username" /> </td>
                    <td><form:errors path="username" cssClass="error" /> </td>

                </tr>

                <tr>
                    <td>Password :</td>
                    <td><form:password path="password" /> </td>
                    <td><form:errors path="password" cssClass="error" /> </td>

                </tr>

                <tr>
                    <td>Confirm Password :</td>
                    <td><form:password path="confirmPassword" /> </td>
                    <td><form:errors path="confirmPassword" cssClass="error" /> </td>

                </tr>

            </table>
            <form:button >Next</form:button>
        </form:form>
    </body>
</html>
