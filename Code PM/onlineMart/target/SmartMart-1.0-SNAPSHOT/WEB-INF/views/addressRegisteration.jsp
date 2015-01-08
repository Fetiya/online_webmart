<%-- 
    Document   : CustomerRegisteration
    Created on : Jan 4, 2015, 12:47:53 AM
    Author     : Komal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Address Information</title>
    </head>
    <body>
        <form:form commandName="address" action="addAddress" method="POST" enctype="multipart/form-data">
            <table>
                <tr>
                    <td>Please provide your Personal address information</td>
                </tr>
                <tr>
                    <td>Country :</td>
                    <td><form:input type="text" path="country" /> </td>
                    <td><form:errors path="country" cssClass="error" /> </td>

                </tr>


                <tr>
                    <td>City :</td>
                    <td><form:input type="text" path="city" /> </td>
                    <td><form:errors path="city" cssClass="error"/> </td>
                </tr>


                <tr>
                    <td>Street :</td>
                    <td><form:input type="text" path="street" /> </td>
                    <td><form:errors path="street" cssClass="error"/> </td>
                </tr>


                <tr>
                    <td>Zip Code :</td>
                    <td><form:input type="text" path="zip" /> </td>
                    <td><form:errors path="zip" cssClass="error"/> </td>
                </tr>


            </table>
            <form:button >Next</form:button>
        </form:form>
    </body>
</html>
