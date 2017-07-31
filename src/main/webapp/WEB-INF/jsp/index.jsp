<%-- 
    Document   : homePage
    Created on : 26 Jul 2017, 10:06:13 AM
    Author     : thakgatso
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Inventory Management Application</title>
</head>
<body>
<h2 align="center">Welcome to Inventory Management Application</h2>
<form:form commandName="loginForm" action="/invetory-management/users/login.htm" method="post">
    <table align="center">

        <c:choose>
            <c:when test="${not empty loginFailed}">
                <tr>
                    <td style="color: red">Login failed</td>
                </tr>
            </c:when>
            <c:otherwise>
                <tr>
                    <td>Login</td>
                </tr>
            </c:otherwise>
        </c:choose>
        <tr>
            <td>Username</td>
            <td>
                <form:input path="username"/>
            </td>
        </tr>
        <tr>
            <td>Password</td>
            <td>
                <form:password path="password"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="Login"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
