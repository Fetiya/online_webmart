<%-- 
    Document   : weeklyReport
    Created on : Jan 8, 2015, 7:47:34 AM
    Author     : senai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
        <%--<sx:head />--%>
        <link href="<c:url value="/resources/css/jquery-ui.min.css" />"
              rel="stylesheet">
    </head>
    <body>

        <!--<s:date name="customDate" />-->
        <p>Report start Date: <input type="text" id="startdatepicker" value="${reportStartDate}"> <i>(YYYY/MM/DD)</i></p>
        <p>Report end Date: <input type="text" id="endDatepicker" value="${reportEndDate}"><i>(YYYY/MM/DD)</i></p>
        <input type="submit" value="Generate"/>


        <%--<s:form action="report/pdf" namespace="/" method="POST" >--%>

        <!--<p>Report start Date:< sx:datetimepicker name="startDate" label="Format (MM-dd-yyyy)" displayFormat="MM-dd-yyyy" value="$ {reportStartDate}" /></p>-->
        <!--<p>Report end Date:< sx:datetimepicker name="endDate" label="Format (MM-dd-yyyy)" displayFormat="MM-dd-yyyy" value="$ {reportEndDate}"/></p>-->
        <!--<p>Report Type  </p>-->
        <%--<s:submit value="submit" name="submit" />--%>

        <%--</s:form>--%>

        <form:form action="report/pdf" >
            <div class="form-group">
                <label for="datepicker" class="col-sm-2 control-label">Date
                    Of Birth</label>
                <div class="col-sm-10">
                    <input type="text" id="datepicker"
                           class="form-control validate[required,funcCall[checkAge]] text-input datepicker"
                           style="width: 200px" name="dateOfBirth"
                           placeholder="Date of Birth"
                           data-errormessage-value-missing="Date of Birth is required!">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-primary signIn">Sign
                        in</button>
                </div>
            </div>
        </form:form>

    </body>
</html>