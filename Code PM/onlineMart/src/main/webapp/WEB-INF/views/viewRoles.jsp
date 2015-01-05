<%-- 
    Document   : viewRoles
    Created on : Jan 4, 2015, 11:58:37 AM
    Author     : Komal
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
              
                
                    <th>Role</th>
                 

                </tr>
            </thead>
            <tbody>
                <c:forEach var="u" items="${users}" varStatus="loopStatus" >


                
                <td width="20%">${u.role}</td>


            </tr>
        </c:forEach>
    </tbody>
</table>
    </body>
</html>
