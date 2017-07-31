<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Management</title>
</head>
<body>
<a href="<c:url context="/invetory-management" value='/assets/viewAssets.htm'/>">Assets</a>
    <c:url var="logoutUrl" context="/invetory-management" value="/users/logout.htm">Logout</c:url>
    <a href="${logoutUrl}">Logout</a>

<h2 align="center">User Management</h2>
<p align="center"><a  href="<c:url context="/invetory-management" value='/users/viewAddUser.htm'/>">Add User</a></p>

<c:choose>
    <c:when test="${not empty userError}">
        <p align="center" style="color: red">${userError}</p>

    </c:when>
    <c:when test="${not  empty userMessage}">
        <p align="center">${userMessage}</p>
    </c:when>
</c:choose>
<table class="table table-striped" align="center">
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
    <tr>
        <th>User ID</th>
        <th>Username</th>
        <th>Business Unit</th>
        <th>Role</th>
        <th>Assigned Assets </th>
        <th>Manage</th>
        <th>Delete</th>
    </tr>
    <tbody>
    <c:forEach items="${usersList}" var="user">
        <tr>
            <td>${user.userID}</td>
            <td>${user.username}</td>
            <td>${user.businessUnt}</td>
            <td>${user.userRole.name}</td>
            <td>
                <c:forEach items="${user.assignedAssets}" var="userAsset">
                    <c:out value="${userAsset.asset.name}"/><br/>
                </c:forEach>
            </td>

            <form:form action="/invetory-management/users/viewUpdateUser.htm" method="post">
                <input type="hidden" value="${user.userID}" name="id">
                <td><input type="submit" name="action" value="Manage"/></td>
            </form:form>
            <form:form action="/invetory-management/users/delete.htm" method="post">
                <input type="hidden" value="${user.userID}" name="id">
                <td><input type="submit" name="action" value="Delete"/></td>
            </form:form>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>
