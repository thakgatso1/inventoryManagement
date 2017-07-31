<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Assets Management</title>
</head>
<body>
    <c:url var="logoutUrl" context="/invetory-management" value="/users/logout.htm">Logout</c:url>
    <a href="${logoutUrl}">Logout</a>
<h2 align="center">Welcome ${userInfo.username}</h2>

<h2 align="center">Assets assigned to you</h2>
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
        <th>Name</th>
        <th>Serial number</th>
        <th>Type</th>
        <th>Model</th>
        <th>Make</th>
        <th>Purchase Date</th>
        <th>Lifespan</th>
        <th>Comment</th>
    </tr>
    <tbody>
    <c:forEach items="${userInfo.assignedAssets}" var="myAsset">
        <tr>

            <td>${myAsset.asset.assetID}</td>
            <td>${myAsset.asset.name}</td>
            <td>${myAsset.asset.serialNo}</td>
            <td>${myAsset.asset.type}</td>
            <td>${myAsset.asset.model}</td>
            <td>${myAsset.asset.make.name}</td>
            <td>${myAsset.asset.purchaseDate}</td>
            <td>${myAsset.asset.lifeSpan}</td>
            <td>${myAsset.asset.comment}</td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>
