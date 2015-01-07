<%-- 
    Document   : viewSetting
    Created on : Jan 7, 2015, 12:47:29 AM
    Author     : Kabiraj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
     <body>
        <h1>All Products View!</h1>


        <table> 
            <thead>

                <tr>
                    <th>id</th>
                    <th>Name</th>
                    <th>Account Number</th>
                    <th>Profit Percentage</th>
                    <th>Value</th>
                    
                    

                </tr>
            </thead>
            <tbody>
                <c:forEach var="setting" items="${settings}" varStatus="loopStatus" >
            <tr>
                <td>${setting.id}</td>
                
               
                               
                <td width="20%">${setting.name}</td>

                <td> ${setting.accountNum}     </td>
                
                <td> ${setting.profitpercentage}     </td>
                
                <td> ${setting.value}     </td>
                
                <td><a href="settingEdit/${setting.id}"> Edit</a></td>
                <td><a href="settingDelete/${setting.id}">DELETE</a></td>
               
                

            </tr>
        </c:forEach>
    </tbody>
</table>
        
         <h1>Hello, world!</h1>

      <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
      <script src="https://code.jquery.com/jquery.js"></script>
      <!-- Include all compiled plugins (below), or include individual files 
            as needed -->
      <script src="SmartMart/resources/js/bootstrap.min.js"></script>
</body>
</html>
