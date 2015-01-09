<%-- 
    Document   : weeklyReport
    Created on : Jan 8, 2015, 7:47:34 AM
    Author     : senai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@ taglib prefix="s" uri="/struts-tags" %>--%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title></title>

        <!--        <link rel="stylesheet" href="/resources/datepicker/jquery-ui.css">
                <script src="/resources/datepicker/external/jquery/jquery"></script>
                <script src="/resources/datepicker/jquery-ui.js"></script>
                <link rel="stylesheet" href="/resources/demos/style.css">-->
        <!--        <script>
                    $(function () {
                        $("#datepicker").datepicker();
                    });
                </script>-->
    </head>
    <body>
        <form action="report/pdf">
            <!--<s:date name="customDate" />-->
            <p>Report start Date: <input type="text" id="startdatepicker" value="${reportStartDate}"> <i>(YYYY/MM/DD)</i></p>
            <p>Report end Date: <input type="text" id="endDatepicker" value="${reportEndDate}"><i>(YYYY/MM/DD)</i></p>
            <input type="submit" value="Generate"/>
        </form>

    </body>
</html>