<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 7/30/17
  Time: 9:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inventory Management</title>
</head>
<body>
<h2>Menu</h2>

<a href="<c:url context="/invetory-management" value='/assets/viewAssets.htm'/>">Assets</a>
<br/>
<a href="<c:url context="/invetory-management" value='/users/viewUsers.htm'/>">Users</a>
<c:url var="logoutUrl" context="/invetory-management" value="/users/logout.htm">Logout</c:url>
<br/>
<a href="${logoutUrl}">Logout</a>
</body>
</html>
