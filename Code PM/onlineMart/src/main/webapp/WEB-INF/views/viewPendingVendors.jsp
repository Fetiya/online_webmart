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
<!--                <label>City: </label>$ {waiver.course.courseName} 
                <label>Street </label>$ {waiver.reason}
                 <label>Zip Code </label>$ {waiver.reason}
                 <label>Country</label>$ {waiver.reason}
                 <label>Email</label>$ {waiver.reason}
                 <label>Subscription Rule</label>$ {waiver.reason}
                 <label>Account Number</label>$ {waiver.reason}
                 
                
                <form action="approveWaiver/$ {waiver.id}" method="post">
                    <input type="radio" name="waiverStatus" value="yes" />Approve
                    <input type="radio" name="waiverStatus" value="no" />Reject
                    <input type="submit" value="Apply" />
                </form>
                
-->            </div>
            
        </c:forEach>

            </div>
    </body>
</html>
