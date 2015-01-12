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

                <h2 class="title text-center">Report</h2>
                <div class="contact-form">
                    <form:form action="report/pdf" method="post" commandName="report">
                        <table>
                            <tr class="form-group col-md-12">
                                <td class="input-label">Report start Date:</td>      
                                <td class="input-text"><input type="date" name="reportStartDate" id="reportStartDate" class="form-control"/></td>

                            </tr>
                            <tr class="form-group col-md-12">
                                <td class="input-label">Report end Date: </td>
                                <td class="input-text"><input type="date" name="reportEndDate" id="reportEndDate" class="form-control"/></td>
                            </tr>
                            <tr class="form-group col-md-12">
                                <td colspan="2"><input type="submit" value="Generate" class="btn btn-primary"/></td>
                            </tr>
                        </table>

                    </form:form>
                </div>
            </div>
        </div>
    </body>
</html>