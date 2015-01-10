<%-- 
    Document   : vendorUnsubscribe
    Created on : Jan 4, 2015, 6:21:26 PM
    Author     : Stella
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>List of Active vendors </h1>
                
                <c:if test="${vendors.isEmpty()}" >
            <p>
                You don't have active vendors yet!
            </p>
        </c:if>
        <div id="body">
         
            <table class="CSSTableGenerator" style="width:70%">
                    <tr>
                        <td>Company Name</td>
<!--                        <td>Email</td>-->
                        <td>Subscription Rule</td>
                        <td>Account Number</td>
                    </tr>
                     <c:forEach var="vendor" items="${vendors}" >               
                        <tr>
                            <td class="tg-hv32">${vendor.companyName}</td>
<!--                            <td class="tg-bsv2">$ {vendor.email}</td>-->
                            <td class="tg-bsv2">${vedor.subscriptionRule}</td>
                             <td class="tg-bsv2">${vendor.accountNum}</td>
                            <td class="tg-bsv2">  <form action="unsubscribeVendors/${vendor.id}" method="post">
                    <input type="radio" name="Status" value="DEACTIVATE" /> Unsubscribe
                    <input type="submit" value="Apply" />
                                </form></td>

                        </tr>
                    </c:forEach>
                </table>
           </div>
    </body>
</html>
