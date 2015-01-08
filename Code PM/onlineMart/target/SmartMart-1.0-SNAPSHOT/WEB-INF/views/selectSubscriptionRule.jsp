<%-- 
    Document   : selectSubscriptionRule
    Created on : Jan 7, 2015, 1:21:00 AM
    Author     : Komal
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form:form commandName="subscriptionRule" action="selectSubscriptionRule" method="POST" enctype="multipart/form-data">
            <table>
                <tr>
                    <td>==========Subscription Rule</td>
                </tr>    
                <tr>
                    <td>ProductRange-Fee</td>
                </tr>
                <!--<tbody>-->



                <c:forEach var="u" items="${rule}" varStatus="loopStatus"    >
                    <tr>

                        <td><form:radiobutton path="id"  value="${u.id}"  /></td>
                        <td><c:out value="${u.rangeProduct}-${u.fee}" /></td>
                        <td><form:errors path="id" cssClass="error"/> </td>
                    </tr>
                </c:forEach>
            </table>

            <form:button >Next</form:button>
        </form:form>
    </body>
</html>

