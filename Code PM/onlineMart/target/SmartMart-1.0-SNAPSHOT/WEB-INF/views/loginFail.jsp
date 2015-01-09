<%-- 
    Document   : login
    Created on : JAN 4, 2015, 4:15:49 PM
    Author     : Senai
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <div class="row">  	
            <div class="col-sm-form">
                <div class="contact-form">
                    <h2 class="title text-center">LOGIN</h2>

                    <c:if test="${error eq true}">
                        <p>${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</p>
                    </c:if>
                        <p class="title " style="color:red">login Failure, please check username/password</p>
                    <form method="post" action="<c:url value='j_spring_security_check' />">
                        <table>
                            <tr class="form-group col-md-12">
                                 <td class="td-label">User: </td>
                                 <td class="td-input"><input  class="form-control" placeholder="UserName" name="j_username" value='<c:if test="${not empty param.login_error}"><c:out value="${SPRING_SECURITY_LAST_USERNAME}" /></c:if>'/> <br /></td>
                               
                            </tr>
                             <tr class="form-group col-md-12">
                                 <td class="td-label">Password :  </td>
                                 <td class="td-input">
                                     <input type="password" name='j_password' class="form-control" placeholder="Password"/>
                                 </td>
                             </tr>
                             <tr class="form-group col-md-12"> 
                                <input type="hidden" name="<c:out value="${_csrf.parameterName}"/>" value="<c:out value="${_csrf.token}"/>"/>
                            <td class="td-input">
                            <input type="submit" class="btn btn-primary" />
                            </td>
                            
                        </tr>
                        </table>
                            <br />
                            <a href="addCredential">sign up</a>
                    </form>
                    
                    </body>