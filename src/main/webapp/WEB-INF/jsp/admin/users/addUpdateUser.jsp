<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserManagement</title>
</head>
<body>
<a href="<c:url context="/invetory-management" value='/users/viewUsers.htm'/>">Back</a>
    <c:url var="logoutUrl" context="/invetory-management" value="/users/logout.htm">Logout</c:url>
    <a href="${logoutUrl}">Logout</a>

<h2 align="center">User Management</h2>
<h3 align="center">Update/Add User</h3>
<form:form commandName="userForm" id="addAssetForm" action="/invetory-management/users/addUpdateUser.htm" method="post">
<table class="displayForm" align="center" cellspacing="2">
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }

        th, td {
            padding: 5px;
            text-align: left;
        }
    </style>
    <form:hidden path="userID"/>
    <%--<form:hidden path="userRole"/>--%>
    <form:hidden path="userRoleId"/>
    <tr>
        <td>
            Username:
        </td>
        <td>
            <form:input type="text" path="username"/>
        </td>
    </tr>
    <tr>
        <td>
           Password:
        </td>
        <td>
            <form:input type="text" path="password"/>
        </td>
    </tr>
    <tr>
        <td>
            Business Unit:
        </td>
        <td>
            <form:input type="text" path="businessUnt"/>
        </td>
    </tr>
    <tr>
        <td>
            Model:
        </td>
        <td>
            <form:input type="text" path="comment"/>
        </td>
    </tr>

    <tr>
        <td>
            User Assets:
        </td>
        <td>
            <form:checkboxes path="userAssets" items="${assetsList}" itemValue="assetID" itemLabel="name" />
        </td>
    </tr>
    <tr>
        <td><input type="submit" value="Add/Update"/>
        </td>
    </tr>

</table>
    </form:form>
</body>
</html>
