<%-- 
    Document   : addEmployee
    Created on : 14 Jul 2017, 12:31:32 PM
    Author     : thakgatso
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form:form commandName="addUserForm" id ="addUserForm" action="/webapp/addUpdateUser.htm" method="post">
            <table class="displayForm" align="center" cellspacing="2"> 
            
             
            <tr>
                <td> 
                    UserName:      
                </td>
                <td>
                    <form:input type="text" path="userName" id="userName"/>
                </td>
            </tr>
          
            <tr>
                <td> 
                    Password:      
                </td>
                <td>
                    <form:input type="text" path="password" id="password"/>
                </td>
            </tr>
            <tr>
                <td> 
                   Business Unit:     
                </td>
                <td>
                    <form:input type="text" path="businessUnit" id="businessUnit"/>
                </td>
            </tr>
            <tr>
                <td> 
                    Comment:     
                </td>
                <td>
                    <form:input type="text" path="comment" id="comment"/>
                </td>
            </tr>
           
            <tr>

                <td><input type="submit" name="action" value="Add/UpdateUser"/>
                     <td> <input type="button" onclick="clearFields()" value="clear"></td>
                      </form:form>
                  

                </td>
            </tr>

        </table>
        
    </body>
</html>
