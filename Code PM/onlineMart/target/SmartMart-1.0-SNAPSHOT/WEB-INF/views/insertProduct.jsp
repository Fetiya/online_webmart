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
        
        <h2> Insert Product</h2>
        <form:form commandName="product" action="addProduct" method="post" enctype="multipart/form-data">
            
            <table>
                <tr>
                    <td>Name: </td>
                    <td> <form:input path="name" /> </td>
                    <td><form:errors path="name" cssClass="error" /> </td>
                </tr>
                
                
                
                
                <tr>
                    <td>Categories: </td>
                    <td>
                        <form:select path="productCategory" >
                            <form:options items="${categories}"  itemLabel="name" itemValue="id"/>
                            
                        </form:select>
                        
                    </td>
                </tr>
                
                <tr>
                    <td>Vendor: </td>
                    <td>
                        <form:select path="vendor" >
                            <form:options items="${vendors}"  itemLabel="companyName" itemValue="id"/>
                            
                        </form:select>
                        
                    </td>
                </tr>
                
                <tr>
                    <td>Price: </td>
                    <td><form:input path="price" /></td>
                    <td><form:errors path="price" cssClass="error" /> </td>
                </tr>
                <tr>
                    <td>Quantity: </td>
                    <td><form:input path="quantity" /> </td>
                    <td><form:errors path="quantity" cssClass="error"/> </td>
                </tr>
                
                <tr>
                    <td>Description: </td>
                    <td><form:textarea path="description" rows="5" cols="40"></form:textarea></td>
                    <td><form:errors path="description" cssClass="error" /> </td>
                </tr>
                
                <tr>
                    <td>Image:</td>
                    <td><input type="file" name="file"/> </td>
                </tr>
                
                
                

                
            </table>
                
               <input type="submit" value="Insert"/>

        </form:form>
    </body>
</html>
