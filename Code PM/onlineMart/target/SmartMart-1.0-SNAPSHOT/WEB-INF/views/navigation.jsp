<%-- 
    Document   : navigation
    Created on : Jan 5, 2015, 6:06:42 PM
    Author     : dipika
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

        <c:forEach var="cat" items="${categories}" varStatus="loopStatus" >
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">

                        <a data-toggle="collapse" data-parent="#accordian" href="#${cat.id}">
                            <span class="badge pull-right"><i class="fa fa-plus"></i></span>
                                ${cat.name}
                        </a>
                    </h4>
                </div>
                <div id="${cat.id}" class="panel-collapse collapse">
                    <div class="panel-body">
                        <ul>
                            <li> 
                                <c:forEach var="v" items="${vendor}" varStatus="loopStatus" >
                                    <li><a href="getProductsByVendor/${v.id}/${cat.id}">${v.companyName} </a></li>
                                </c:forEach>
                            </li>

                        </ul>
                    </div>
                </div>
            </div>
        </c:forEach>
