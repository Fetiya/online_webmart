<%-- 
    Document   : weeklyReport
    Created on : Jan 8, 2015, 7:47:34 AM
    Author     : senai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>

    </head>
    <body>
        <form:form >
            <table>
                <tr>
                    <td>Report start Date:</td>
                    <td><form:input type="datetime-local" path="reportStartDate" /> </td>
                </tr>
                <tr>
                    <td>Report end Date: </td>
                    <td><form:input type="datetime-local" id="endDatepicker" path="${reportEndDate}" /></td>
                </tr>
                <tr>
                    <td colspan="2"><form:input path="/report/pdf" type="submit" value="Generate"/></td>
                </tr>
            </table>
                    
        </form:form>


    </body>
</html>