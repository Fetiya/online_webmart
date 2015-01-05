<%-- 
    Document   : ProductCategory
    Created on : Jan 3, 2015, 11:24:59 AM
    Author     : dipika
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <table> 
            <thead>

                <tr>
                    <th>id</th>
                
                    <th>Category Name</th>
                    <th>Category Description</th>

                </tr>
            </thead>
            <tbody>
                <c:forEach var="c" items="${categories}" varStatus="loopStatus" >

                <td>${c.id}</td>
                
                <td width="20%">${c.name}</td>

                <td> ${c.description}     </td>
                <td><a href="productCategoryEdit/${c.id}"> Edit Product Category</a></td>
                   <td><a href="productCategoryDelete/${c.id}">DELETE</a></td>

            </tr>
        </c:forEach>
    </tbody>
</table>
        <h1>Hello World!</h1>
    </body>
</html>
