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
        <title>Report Selection</title>

    </head>
    <body>
        <div class="row">  	
            <div class="col-sm-form">
                <form:form action="report/pdf" method="post" commandName="report">
                    <table>
                        <tr>
                            <td>Report start Date:</td>      
                            <td><input type="date" name="reportStartDate" id="reportStartDate"/></td>

                        </tr>
                        <tr>
                            <td>Report end Date: </td>
                            <td><input type="date" name="reportEndDate" id="reportEndDate"/></td>
                        </tr>
                        <tr>
                            <td colspan="2"><input type="submit" value="Generate"/></td>
                        </tr>
                    </table>

                </form:form>
            </div>
        </div>
    </body>
</html>