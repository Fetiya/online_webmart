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

        <!-- Bootstrap -->
        <link href="/SmartMart/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    </head>
    <body>
        <p class="title">All Users</p>
        <section id="cart_items">
            <div class="table-responsive cart_info">

                <table class="table table-condensed"> 
                    <thead>

                        <tr class="cart_menu">
                            <th>id</th>

                            <th>First Name</th>
                            <th>Last Name</th>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="u" items="${users}" varStatus="loopStatus" >
                            <tr>
                                <td>${u.id}</td>

                                <td width="20%">${u.firstName}</td>

                                <td> ${u.lastName}     </td>

                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </section>



        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://code.jquery.com/jquery.js"></script>
        <!-- Include all compiled plugins (below), or include individual files 
              as needed -->
        <script src="SmartMart/resources/js/bootstrap.min.js"></script>
    </body>

</html>

