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
        <div class="row">  	
            <div class="col-sm-form">
                <div class="contact-form">
                    <form:form commandName="vendor" action="addVendor" method="POST" enctype="multipart/form-data">
                        <table>

                            <p class="title ">Please provide Company Information</p>

                            <tr class="form-group col-md-12">
                                <td class="td-label">Company Name :</td>
                                <td class="td-input"><form:input type="text" path="companyName" class="form-control" placeholder="Company Name" /> </td>
                                <td><form:errors path="companyName" cssClass="error" /> </td>
                            </tr>
                            <tr class="form-group col-md-12">
                                <td class="td-label">Account Number :</td>
                                <td class="td-input"><form:input type="text" path="accountNum" class="form-control" placeholder="Account Num" /> </td>
                                <td><form:errors path="accountNum" cssClass="error"/> </td>
                            </tr>
                            <tr class="form-group col-md-12">
                                <td class="td-label">
                                    <form:button class="btn btn-primary" >Sign up</form:button>
                                    </td>
                                </tr>
                            </table>


                    </form:form>
                </div>
            </div>
        </div>
    </body>
</html>
