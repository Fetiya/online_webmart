<%-- 
    Document   : vendorRegisteration
    Created on : Jan 2, 2015, 4:31:38 PM
    Author     : Komal
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>vendor Registeration</title>
    </head>
    <body>
        <form:form commandName="vendor" action="addVendor" method="POST" enctype="multipart/form-data">
            <table>
                <tr>
                    <td>Company Information</td>
                </tr>
                <tr>
                    <td>======Company Name :</td>
                    <td><form:input type="text" path="companyName" /> </td>
                    <!--<td>< form:errors path="companyName" cssClass="error" /> </td>-->
                </tr>
                <tr>
                    <td>Account Number :</td>
                    <td><form:input type="text" path="accountNum" /> </td>
                    <!--<td>< form:errors path="accountNum" cssClass="error"/> </td>-->
                </tr>

                <td>=======Company Address Information</td>
            </tr>
            <tr>
                <td>Company Country :</td>
                <td><form:input type="text" path="address.country" /> </td>

            </tr>


            <tr>
                <td>Company City :</td>
                <td><form:input type="text" path="address.city" /> </td>
                <!--<td>< form:errors path="address.city" cssClass="error"/> </td>-->
            </tr>


            <tr>
                <td>Company Street :</td>
                <td><form:input type="text" path="address.street" /> </td>
                <!--<td>< form:errors path="address.street" cssClass="error"/> </td>-->
            </tr>


            <tr>
                <td>Company Zip Code :</td>
                <td><form:input type="text" path="address.zip" /> </td>
                <!--<td>< form:errors path="address.zip" cssClass="error"/> </td>-->
            </tr>



            <tr>
                <td>=====Company User Information</td>
            </tr>
            <tr>
                <td>First Name :</td>
                <td><form:input type="text" path="vendorAdmin.firstName" /> </td> 
            </tr>
            <tr>
                <td>Middle Name :</td>
                <td><form:input type="text" path="vendorAdmin.middleName" /> </td>

            </tr>
            <tr>
                <td>Last Name :</td>
                <td><form:input type="text" path="vendorAdmin.lastName" /> </td>

            </tr>
            <tr>
                <td>Telephone Number :</td>
                <td><form:input type="text" path="vendorAdmin.telnum" /> </td>

            </tr>
            <tr>
                <td>=======Company User Credential Information</td>
            </tr>
            <tr>
                <td>Email id :</td>
                <td><form:input type="text" path="vendorAdmin.credential.username" /> </td>

            </tr>

            <tr>
                <td>Password :</td>
                <td><form:password  path="vendorAdmin.credential.password" /> </td>

            </tr>
            <tr>
                <td>==========Company User Address Information</td>
            </tr>
            <tr>
                <td>Country :</td>
                <td><form:input type="text" path="vendorAdmin.address.country" /> </td>

            </tr>


            <tr>
                <td>City :</td>
                <td><form:input type="text" path="vendorAdmin.address.city" /> </td>
                <!--<td>< form:errors path="address.city" cssClass="error"/> </td>-->
            </tr>


            <tr>
                <td>Street :</td>
                <td><form:input type="text" path="vendorAdmin.address.street" /> </td>
                <!--<td>< form:errors path="address.street" cssClass="error"/> </td>-->
            </tr>


            <tr>
                <td>Zip Code :</td>
                <td><form:input type="text" path="vendorAdmin.address.zip" /> </td>
                <!--<td>< form:errors path="address.zip" cssClass="error"/> </td>-->
            </tr>


            <tr>
                <td>==========Subscription Rule</td>
            </tr>    
            <tr>
                <td>Start Range-End Range Fee</td>
            </tr>
            <!--<tbody>-->

           

                <c:forEach var="u" items="${subscriptionRule}" varStatus="loopStatus"    >
                    <tr>
                        <td>
                        <td><form:radiobutton path="subscriptionRule.id"  value="${u.id}"  /></td>
                        <td><c:out value="${u.startRange}-${u.endRange} ${u.fee}" /></td>

                        </td>
                   </tr>
                </c:forEach>
        </table>
        <%--<form:hidden path="credential.userName" />--%> 
        <%--<form:hidden path="credential.password" />--%> 
        <%--<form:hidden path="credential.confirmPassword" />--%> 
        <%--<form:hidden path="credential.role" />--%> 
        <form:button >Sign up</form:button>
    </form:form>
</body>
</html>
