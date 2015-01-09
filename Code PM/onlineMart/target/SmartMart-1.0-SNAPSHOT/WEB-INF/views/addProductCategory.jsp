<%-- 
    Document   : addCategory
    Created on : Jan 2, 2015, 9:18:31 PM
    Author     : dipika
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <h2 class="title text-center">Product Category</h2>

                    <form:form commandName="category" action="addProductCategory" method="Post">
                        <form:errors path="*" cssClass="alert alert-danger" element="div"/> 
                        <table>
                            <p class="title ">Add Product Category</p>
                            <tr class="form-group col-md-12">
                                <td class="td-label">Category Name : </td>
                                <td class="td-input"><form:input type="text" path="name" class="form-control" placeholder="Category Name" /> </td>  
                                <td><form:errors path="name" cssClass="error" /> </td>
                            </tr>
                            <tr class="form-group col-md-12">
                                <td class="td-label">Category Description : </td>
                                <td class="td-input"><form:input type="text" path="description"  class="form-control" placeholder="Category Description"/> </td>
                                <td><form:errors path="description" cssClass="error" /> </td>
                            </tr>
                            <tr class="form-group col-md-12">
                                <td class="td-label"><input type="submit" value="Add Product Category" class="btn btn-primary"/></td>
                            </tr>
                        </table>
                    </form:form>
                </div>
            </div>
        </div>
    </body>
</html>
