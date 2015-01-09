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
        <div class="row">  	
            <div class="col-sm-form">
                <div class="contact-form">
                    <h2 class="title text-center">Vendor Registration</h2>
                    <form:form commandName="vendorAdmin" action="addVendorAdmin" method="POST" enctype="multipart/form-data">
                        <table>

                            <p class="title ">Please fill up your Personal Information</p>

                            <tr class="form-group col-md-12">
                                <td class="td-label">First Name :</td>
                                <td class="td-input"><form:input type="text" path="firstName" class="form-control" placeholder="First Name" /> </td>
                                <td><form:errors path="firstName" cssClass="error" element="div" /> </td>
                            </tr>
                            <tr class="form-group col-md-12">
                                <td class="td-label">Middle Name :</td>
                                <td class="td-input"><form:input type="text" path="middleName" class="form-control" placeholder="Middle Name"/> </td>
                                <td><form:errors path="middleName" cssClass="error" /> </td>

                            </tr>
                            <tr class="form-group col-md-12">
                                <td class="td-label">Last Name :</td>
                                <td class="td-input"><form:input type="text" path="lastName" class="form-control" placeholder="Last Name" /> </td>
                                <td><form:errors path="lastName" cssClass="error" /> </td>

                            </tr>
                            <tr class="form-group col-md-12">
                                <td class="td-label">Telephone Number :</td>
                                <td class="td-input"><form:input type="text" path="telnum" class="form-control" placeholder="Telephone" /> </td>
                                <td><form:errors path="telnum" cssClass="error" /> </td>

                            </tr>


                            <tr class="form-group col-md-12">
                                <td class="td-label">Gender</td>
                                <td style="width:150px"><form:radiobutton path="gender"  value="Male" label="Male" /></td>
                                <td style="width:150px"><form:radiobutton path="gender"  value="Female" label="Female"  /></td>
                                <td><form:errors path="gender" cssClass="error" /> </td>
                           </tr>
                            <tr class="form-group col-md-12">
                                <td class="td-label">
                                    <form:button class="btn btn-primary" >Submit</form:button>
                                    </td>
                                </tr>
                            </table>


                    </form:form>
                    </body>
                    </html>
