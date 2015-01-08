<%-- 
    Document   : weeklyReport
    Created on : Jan 8, 2015, 7:47:34 AM
    Author     : senai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>jQuery UI Datepicker - Default functionality</title>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
        <link rel="stylesheet" href="/resources/demos/style.css">
        <script>
            $(function () {
                $("#datepicker").datepicker();
            });
        </script>
    </head>
    <body>
        <form action="report/pdf">
            <p>Report start Date: <input type="text" id="datepicker" value="${reportStartDate}"></p>
            <p>Report start Date: <input type="text" id="datepicker" value="${reportEndDate}"></p>
        <input type="submit" value="Generate"/>
        </form>

    </body>
</html>