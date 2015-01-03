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
        <h1>Hello World!</h1>
        <div id="body">
                
                <h1>List of pending vendors </h1>
                
                <c:if test="${pendingWaivers.isEmpty()}" >
            <p>
                You don't have any waiver requests!
            </p>
        </c:if>
            
            <c:forEach var="vendor" items="${pendingVendors}" >
            <div>
                <label>Company Name: </label>${vendor.companyName}
                <label>City: </label>${vendor.address.city} 
                <label>Street </label>$ {vendor.address.street}
                 <label>Zip Code </label>$ {vendor.address.zip}
                 <label>Country</label>${vendor.address.country}
                 <label>Email</label>${vendor.email}
                 <label>Subscription Rule</label>${vedor.subscriptionRule}
                 <label>Account Number</label>${vendor.accountNum}
                 
                
                <form action="approveWaiver/$ {vendor.id}" method="post">
                    <input type="radio" name="Status" value="ACTIVE" />Approve
                    <input type="radio" name="Status" value="REJECTED" />Reject
                    <input type="submit" value="Apply" />
                </form>
                
            </div>
            
        </c:forEach>

            </div>
    </body>
</html>
