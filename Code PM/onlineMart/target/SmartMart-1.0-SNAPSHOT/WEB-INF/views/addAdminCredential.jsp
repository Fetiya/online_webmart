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
        <div class="row">  	
            <div class="col-sm-form">
                <div class="contact-form">
                    <h2 class="title text-center">Vendor Registration</h2>
                    <form:form commandName="credential" action="addAdminCredential" method="POST" enctype="multipart/form-data">
                        <table>


                            <p class="title ">Please provide your Credential Information</p>

                            <tr class="form-group col-md-12">
                                <td class="td-label">Email id :</td>
                                <td class="td-input"><form:input type="text" path="username" class="form-control" placeholder="Email ID as UserName" /> </td>
                                <td><form:errors path="username" cssClass="error" /> </td>

                            </tr>

                            <tr class="form-group col-md-12">
                                <td class="td-label">Password :</td>
                                <td class="td-input"><form:password path="password" class="form-control" placeholder="Password" /> </td>
                                <td><form:errors path="password" cssClass="error" /> </td>

                            </tr>

                            <tr class="form-group col-md-12">
                                <td class="td-label">Confirm Password :</td>
                                <td class="td-input"><form:password path="confirmPassword" class="form-control" placeholder="Confirm Password" /> </td>
                                <td><form:errors path="confirmPassword" cssClass="error" /> </td>

                            </tr>
                            <tr class="form-group col-md-12">
                                <td class="td-label"> <form:button class="btn btn-primary" >Next</form:button></td>
                            </tr>
                        </table>
                        
                    </form:form>
                    </body>
                    </html>
