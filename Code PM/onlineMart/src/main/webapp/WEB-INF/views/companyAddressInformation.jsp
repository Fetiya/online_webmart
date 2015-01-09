<%-- 
    Document   : companyAddressInformation
    Created on : Jan 7, 2015, 1:18:53 AM
    Author     : Komal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Company Address Information</title>
    </head>
    <body>
        <div class="row">  	
            <div class="col-sm-form">
                <div class="contact-form">
                    <form:form commandName="companyAddress" action="companyAddressInformation" method="POST" enctype="multipart/form-data">
                        <table>
                            <p class="title ">Please provide Company address information</p>
                            
                            <tr class="form-group col-md-12">
                                <td class="td-label">Country :</td>
                                <td class="td-input"><form:input type="text" path="country" class="form-control" placeholder="Country" /> </td>
                                <td><form:errors path="country" cssClass="error" /> </td>

                            </tr>


                            <tr class="form-group col-md-12">
                                <td class="td-label">City :</td>
                                <td class="td-input"><form:input type="text" path="city" class="form-control" placeholder="City" /> </td>
                                <td><form:errors path="city" cssClass="error"/> </td>
                            </tr>


                            <tr class="form-group col-md-12">
                                <td class="td-label">Street :</td>
                                <td class="td-input"><form:input type="text" path="street" class="form-control" placeholder="Street" /> </td>
                                <td><form:errors path="street" cssClass="error"/> </td>
                            </tr>


                            <tr class="form-group col-md-12">
                                <td class="td-label">Zip Code :</td>
                                <td class="td-input"><form:input type="text" path="zip" class="form-control" placeholder="Zip" /> </td>
                                <td><form:errors path="zip" cssClass="error"/> </td>
                            </tr>

                            <tr class="form-group col-md-12">
                                <td class="td-label"><form:button class="btn btn-primary" >Next</form:button></td>
                            </tr>
                        </table>
                        
                    </form:form>
                </div>
            </div>
        </div>
    </body>
</html>
