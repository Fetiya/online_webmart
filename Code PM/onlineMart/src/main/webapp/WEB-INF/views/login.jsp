<%-- 
    Document   : login
    Created on : Oct 19, 2014, 11:41:58 PM
    Author     : weldu
--%><%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Categories</title>
    </head>
    <body>
        <div class="row">  	
            <div class="col-sm-form">
                <div class="contact-form">
                    <h2 class="title text-center">LOGIN</h2>

                    <div class="signupSuccess">${successfulSignup}</div>

                    <c:if test="${error eq true}">
                        <p>${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</p>
                    </c:if>
                    <table>
                        <form method="post" action="j_spring_security_check" />
                        <tr class="form-group col-md-12">
                            <td class="td-label">User: </td>
                            <td class="td-input"><input name="j_username" class="form-control" placeholder="User Name" /> </td>
                        </tr>
                        <tr class="form-group col-md-12">
                            <td class="td-label">Password: </td>
                            <td class="td-input"><input type="password" name='j_password'class="form-control" placeholder="Password" />  </td>
                        </tr>
                        <tr class="form-group col-md-12">
                            <td class="td-label">      
                                <input type="submit" value="Login"  class="btn btn-primary" />
                            </td>
                        </tr>

                        </form>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
