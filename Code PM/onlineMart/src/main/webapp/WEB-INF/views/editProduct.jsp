<%-- 
    Document   : editProduct
    Created on : Jan 5, 2015, 1:38:19 PM
    Author     : Kabiraj
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
       
        <h2>Update Product </h2>
        <form:form modelAttribute="product" action="../editProduct" method="post">
            <table>
                <form:hidden path="id"/>
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
                
<!--                <tr>
                    <td>Image:</td>
                    <td><input type="file" name="file"/> </td>
                </tr>-->
                <tr>
                    <td><input type="submit" value="UPDATE"/></td>
                </tr>
            </table>
        </form:form>
   

    </body>
</html>
