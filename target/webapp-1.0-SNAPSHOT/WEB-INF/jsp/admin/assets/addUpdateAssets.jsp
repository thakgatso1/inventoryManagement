<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Asset Management</title>
</head>
<body>
<a href="<c:url context="/invetory-management" value='/assets/viewAssets.htm'/>">Back</a>
    <c:url var="logoutUrl" context="/invetory-management" value="/users/logout.htm">Logout</c:url>
    <a href="${logoutUrl}">Logout</a>
<h2 align="center">Asset Management</h2>
<h3 align="center">Update/Add Asset</h3>
<form:form commandName="assetForm" id ="addAssetForm" action="/invetory-management/assets/addUpdateAsset.htm" method="post">
<table class="displayForm" align="center" cellspacing="2">
            <form:hidden path="assetID" />
                <tr>
                    <td>
                        Name:
                    </td>
                    <td>
                        <form:input type="text" path="name" id="serialNumber"/>
                    </td>
                </tr>
    <tr>
        <td>
            Serial NO:
        </td>
        <td>
            <form:input type="text" path="serialNo" id="serialNumber"/>
        </td>
    </tr>
    <tr>
        <td>
            Type:
        </td>
        <td>
            <form:input type="text" path="type" id="type"/>
        </td>
    </tr>
    <tr>
        <td>
            Model:
        </td>
        <td>
            <form:input type="text" path="model" id="model"/>
        </td>
    </tr>
    <tr>
        <td>
            Make:
        </td>
        <td>
            <form:select path="makeId" >
                <form:options items="${makes}" itemValue="makeId" itemLabel="name"/>
            </form:select>
        </td>
    </tr>
    <tr>
        <td>
            Purchase Date:
        </td>
        <td>
            <form:input type="date" path="purchaseDate" id="purchaseDate"/>
        </td>
    </tr>
    <tr>
        <td>
            Life Span:
        </td>
        <td>
            <form:input type="text" path="lifeSpan" id="lifeSpan"/>
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
        <td><input type="submit"  value="Add/Update"/>
        </form:form>
</body>
</html>
