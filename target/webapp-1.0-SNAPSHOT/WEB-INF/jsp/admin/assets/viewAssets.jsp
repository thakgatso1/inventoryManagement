<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Assets Management</title>
</head>
<body>
<a href="<c:url context="/invetory-management" value='/users/viewUsers.htm'/>">Users</a>
    <c:url var="logoutUrl" context="/invetory-management" value="/users/logout.htm">Logout</c:url>
    <a href="${logoutUrl}">Logout</a>

<h2 align="center">Asset Management</h2>
<p align="center"><a  href="<c:url context="/invetory-management" value='/assets/viewAddAsset.htm'/>">Add Asset</a></p>

<c:choose>
    <c:when test="${not empty assetError}">
        <p align="center" style="color: red">${assetError}</p>

    </c:when>
    <c:when test="${not  empty assetMessage}">
        <p align="center">${assetMessage}</p>
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
        <th>asset ID</th>
        <th>NAme</th>
        <th>Serial number</th>
        <th>Type</th>
        <th>Model</th>
        <th>Make</th>
        <th>Purchase Date</th>
        <th>Lifespan</th>
        <th>Comment</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <tbody>
    <c:forEach items="${assetList}" var="asset">
        <tr>

            <td>${asset.assetID}</td>
            <td>${asset.name}</td>
            <td>${asset.serialNo}</td>
            <td>${asset.type}</td>
            <td>${asset.model}</td>
            <td>${asset.make.name}</td>
            <td>${asset.purchaseDate}</td>
            <td>${asset.lifeSpan}</td>
            <td>${asset.comment}</td>
            <form:form action="/invetory-management/assets/viewUpdateAsset.htm" method="post">
                <input type="hidden" value="${asset.assetID}" name="id">
                <td><input type="submit" name="action" value="Edit"/></td>
            </form:form>
            <form:form action="/invetory-management/assets/delete.htm" method="post">
                <input type="hidden" value="${asset.assetID}" name="id">
                <td><input type="submit" name="action" value="Delete"/></td>
            </form:form>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>
