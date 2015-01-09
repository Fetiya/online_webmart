<%-- 
    Document   : adminViewVendor
    Created on : Jan 2, 2015, 6:22:01 PM
    Author     : Stella
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p class="title">Pending vendors</p>



        <c:if test="${pendingVendors.isEmpty()}" >
            <p>
                You don't have any pending requests!
            </p>
        </c:if>
        <div id="body">
            <section id="cart_items">
                <div class="table-responsive cart_info">
                    <table class="table table-condensed">
                        <thead>
                            <tr class="cart_menu">
                                <th>Company Name</th>
                                <th>Email</th>
                                <th>Subscription Rule</th>
                                <th>Account Number</th>
                            </tr>
                            <c:forEach var="vendor" items="${pendingVendors}" >               
                                <tr>
                                    <td class="tg-hv32">${vendor.companyName}</td>
                                    <td class="tg-bsv2">${vendor.email}</td>
                                    <td class="tg-bsv2">${vedor.subscriptionRule}</td>
                                    <td class="tg-bsv2">${vendor.accountNum}</td>
                                    <td class="tg-bsv2">  <form action="approveVendors/${vendor.id}" method="post">
                                            <input type="radio" name="Status" value="ACTIVE" />Approve
                                            <input type="radio" name="Status" value="REJECTED" />Reject
                                            <input type="submit" value="Apply" />
                                        </form></td>

                                </tr>
                            </c:forEach>
                    </table>
                </div>
            </section>
        </div>

    </body>
</html>
