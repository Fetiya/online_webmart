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
        <div class="row">  	
            <div class="col-sm-form">
                <div class="contact-form">
                    <form:form commandName="subscriptionRule" action="selectSubscriptionRule" method="POST" enctype="multipart/form-data">
                        <table>
                            <p class="title ">Subscription Rule</p>

                            <tr class="form-group col-md-12">
                                <td class="td-label">ProductRange-Fee</td>
                                <td class="td-label">
                                    <c:forEach var="u" items="${rule}" varStatus="loopStatus"    >
                                    <tr class="form-group col-md-12">

                                        <td class="td-input"><form:radiobutton path="id"  value="${u.id}"  /></td>
                                        <td class="td-input"><c:out value="${u.rangeProduct}-${u.fee}" /></td>
                                        <td class="td-input"><form:errors path="id" cssClass="error"/> </td>
                                    </tr>
                                    </c:forEach>
                                </td>    
                            </tr>
                            <tr class="form-group col-md-12">
                                <td class="td-label">
                                    <form:button  class="btn btn-primary">Next</form:button>
                                </td>
                            </tr>
                        </table>

                        
                    </form:form>
                </div>
            </div>
        </div>

    </body>
</html>

