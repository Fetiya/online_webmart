v<%-- 
    Document   : adminRegisteration
    Created on : Jan 7, 2015, 9:37:02 AM
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
        <form:form commandName="vendorAdmin" action="addVendorAdmin" method="POST" enctype="multipart/form-data">
            <table>

                <tr>
                    <td>Please fill up your Personal Information</td>
                </tr>
                <tr>
                    <td>First Name :</td>
                    <td><form:input type="text" path="firstName" /> </td>
                    <td><form:errors path="firstName" cssClass="error" element="div" /> </td>
                </tr>
                <tr>
                    <td>Middle Name :</td>
                    <td><form:input type="text" path="middleName" /> </td>
                    <td><form:errors path="middleName" cssClass="error" /> </td>

                </tr>
                <tr>
                    <td>Last Name :</td>
                    <td><form:input type="text" path="lastName" /> </td>
                    <td><form:errors path="lastName" cssClass="error" /> </td>

                </tr>
                <tr>
                    <td>Telephone Number :</td>
                    <td><form:input type="text" path="telnum" /> </td>
                    <td><form:errors path="telnum" cssClass="error" /> </td>

                </tr>
                <tr>

                <tr>
                    <td>Gender</td>
                    <td><form:radiobutton path="gender"  value="Male" label="Male" /></td>
                    <td><form:radiobutton path="gender"  value="Female" label="Female"  /></td>
                    <td><form:errors path="gender" cssClass="error" /> </td>

                    </td>
                </tr>
            </table>

            <form:button >Sign Up</form:button>
        </form:form>
    </body>
</html>
