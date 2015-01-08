<%-- 
    Document   : vendorRegisteration
    Created on : Jan 2, 2015, 4:31:38 PM
    Author     : Komal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vendor Registeration</title>
    </head>
    <body>
        <form:form commandName="vendor" action="addVendor" method="POST" enctype="multipart/form-data">
            <table>
                <tr>
                    <td>Please provide Company Information</td>
                </tr>
                <tr>
                    <td>======Company Name :</td>
                    <td><form:input type="text" path="companyName" /> </td>
                    <td><form:errors path="companyName" cssClass="error" /> </td>
                </tr>
                <tr>
                    <td>Account Number :</td>
                    <td><form:input type="text" path="accountNum" /> </td>
                    <td><form:errors path="accountNum" cssClass="error"/> </td>
                </tr>

            </table>

            <form:button >Next</form:button>
        </form:form>
    </body>
</html>
