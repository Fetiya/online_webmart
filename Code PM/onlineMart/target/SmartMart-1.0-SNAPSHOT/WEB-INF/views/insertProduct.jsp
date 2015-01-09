<%-- 
    Document   : insertProduct
    Created on : Jan 2, 2015, 5:40:27 PM
    Author     : Kabiraj
--%>

<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Product</title>

    </head>
    <body>
        <div class="row">  	
            <div class="col-sm-form">
                <div class="contact-form">
                    <h2 class="title text-center">Product</h2>


                    <p class="title ">Add Product</p>
                    <form:form commandName="product" action="addProduct" method="post" enctype="multipart/form-data">

                        <table>
                            <tr class="form-group col-md-12">
                                <td class="td-label">Name: </td>
                                <td class="td-input"> <form:input path="name" class="form-control" placeholder="Name" /> </td>
                                <td><form:errors path="name" cssClass="error" /> </td>
                            </tr>




                            <tr class="form-group col-md-12">
                                <td class="td-label">Categories: </td>
                                <td class="td-input" >
                                    <form:select path="productCategory" >
                                        <form:options items="${categories}"  itemLabel="name" itemValue="id" class="form-control" />

                                    </form:select>

                                </td>
                            </tr>

                            <tr class="form-group col-md-12">
                                <td class="td-label" >Vendor: </td>
                                <td class="td-input">
                                    <form:select path="vendor" >
                                        <form:options items="${vendors}"  itemLabel="companyName" itemValue="id" class="form-control" />

                                    </form:select>

                                </td>
                            </tr>

                            <tr class="form-group col-md-12">
                                <td class="td-label">Price: </td>
                                <td class="td-input">
                                    <form:input path="price" class="form-control" placeholder="Price"  />
                                </td>
                                <td><form:errors path="price" cssClass="error" /> </td>
                            </tr>
                            <tr class="form-group col-md-12">
                                <td class="td-label">Quantity: </td>
                                <td class="td-input"><form:input path="quantity" class="form-control" placeholder="Quantity"  /> </td>
                                <td><form:errors path="quantity" cssClass="error"/> </td>
                            </tr>

                            <tr class="form-group col-md-12">
                                <td class="td-label">Description: </td>
                                <td class="td-input"><form:textarea path="description" rows="5" cols="40" class="form-control" placeholder="Description"></form:textarea></td>
                                <td><form:errors path="description" cssClass="error" /> </td>
                            </tr>

                            <tr class="form-group col-md-12">
                                <td>Image:</td>
                                <td class="td-input"><input type="file" name="file"  /> </td>
                            </tr>

                            <tr class="form-group col-md-12">

                                <td><input type="submit" value="Insert" class="btn btn-primary"/></td>
                            </tr>

                        </table>



                    </form:form>
                    </body>
                    </html>
