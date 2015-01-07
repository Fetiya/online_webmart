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
        <title>JSP Page</title>
    </head>
    <body>
        <form:form commandName="customer" action="addCustomer" method="POST" enctype="multipart/form-data">
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
        <div class="row">  	
            <div class="col-sm-8">
                <div class="contact-form">
                    <h2 class="title text-center">Customer Registration</h2>
                    <form:form id="main-contact-form" class="contact-form row" commandName="customer" action="addCustomer" method="POST" enctype="multipart/form-data">
                        <table>

                            <tr >
                                <td><p class="title ">Personal Information</p></td>
                            </tr>
                            <tr>
                                <td>First Name :</td>
                                <td><form:input type="text" path="firstName"  class="form-control" placeholder="First Name"/> </td> 
                            </tr>
                            <tr>
                                <td>Middle Name :</td>
                                <td><form:input type="text" path="middleName" class="form-control" placeholder="Middle Name" /> </td>

                            </tr>
                            <tr>
                                <td>Last Name :</td>
                                <td><form:input type="text" path="lastName" class="form-control" placeholder="Last Name" /> </td>

                            </tr>
                            <tr>
                                <td>Telephone Number :</td>
                                <td><form:input type="text" path="telnum" class="form-control" placeholder="Telephone Name" /> </td>

                            </tr>
                            <tr>
                                <td><p class="title ">User Credential</p></td>
                            </tr>
                            <tr>
                                <td>Email id :</td>
                                <td><form:input type="text" path="credential.username" class="form-control" placeholder="Email Id" /> </td>

                            </tr>

                            <tr>
                                <td>Password :</td>
                                <td><form:password path="credential.password" class="form-control" placeholder="Password" /> </td>

                            </tr>
                            <tr>
                                <td><p class="title">User Address</p></td>
                            </tr>
                            <tr>
                                <td>Country :</td>
                                <td><form:input type="text" path="address.country" class="form-control" placeholder="Country" /> </td>

                            </tr>


                            <tr>
                                <td>City :</td>
                                <td><form:input type="text" path="address.city" class="form-control" placeholder="City" /> </td>
                                <!--<td>< form:errors path="address.city" cssClass="error"/> </td>-->
                            </tr>


                            <tr>
                                <td>Street :</td>
                                <td><form:input type="text" path="address.street" class="form-control" placeholder="Street" /> </td>
                                <!--<td>< form:errors path="address.street" cssClass="error"/> </td>-->
                            </tr>


                            <tr>
                                <td>Zip Code :</td>
                                <td><form:input type="text" path="address.zip" class="form-control" placeholder="Zip" /> </td>
                                <!--<td>< form:errors path="address.zip" cssClass="error"/> </td>-->
                            </tr>
                        </table>
                        <form:button class="btn btn-primary">Sign up</form:button>
                    </form:form>
                </div>
            </div
        </div>
    </body>
</html>

