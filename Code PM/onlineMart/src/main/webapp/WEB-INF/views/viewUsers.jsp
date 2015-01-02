<%-- 
    Document   : viewUsers
    Created on : Dec 31, 2014, 3:07:46 PM
    Author     : Fetiya
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All users List</title>
    </head>
    <body>
        <h1>All Users View!</h1>


        <table> 
            <thead>

                <tr>
                    <th>id</th>
                
                    <th>First Name</th>
                    <th>Last Name</th>

                </tr>
            </thead>
            <tbody>
                <c:forEach var="u" items="${users}" varStatus="loopStatus" >

                <td>${u.id}</td>
                
                <td width="20%">${u.firstName}</td>

                <td> ${u.lastName}     </td>

            </tr>
        </c:forEach>
    </tbody>
</table>
</body>

</html>

