<%-- 
    Document   : addAsset
    Created on : 23 Jun 2017, 2:31:24 PM
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
        <h1> ASSET TRACKING</h1>

        <form:form commandName="addAssetForm" action="/webapp/addAsset.htm" method="post">
            <table align="center" cellspacing="2"> 

                
                <tr>
                    <td> 
                        Serial NO:      
                    </td>
                    <td>
                        <form:input path="serialNo"/>
                    </td>
                </tr>
                <tr>
                    <td> 
                        Type:      
                    </td>
                    <td>
                        <form:input path="type"/>
                    </td>
                </tr>
                <tr>
                    <td> 
                        Model:      
                    </td>
                    <td>
                        <form:input path="model"/>
                    </td>
                </tr>
                <tr>
                    <td> 
                        Make:     
                    </td>
                    <td>
                        <form:input path="make"/>
                    </td>
                </tr>
                <tr>
                    <td> 
                        Purchase Date:     
                    </td>
                    <td>
                        <form:input path="purchaseDate"/>
                    </td>
                </tr>
                <tr>
                    <td> 
                        Life Span:     
                    </td>
                    <td>
                        <form:input path="lifeSpan"/>
                    </td>
                </tr>
                <tr>
                    <td> 
                        Comment:    
                    </td>
                    <td>
                        <form:input path="comment"/>
                    </td>
                </tr>
                <tr>

                    <td><input type="submit" name="action" value="Add Assets"</td>
                </tr>

            </table>

        </form:form>
        <p>${msg}</p>

        <table class="table table-striped">
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
                    <c:url context="/webapp" value="/delete.htm" var="deleteUrl">
                        <c:param name="id" value="${asset.assetID}"/>   
                    </c:url>
                      <c:url context="/webapp" value="/updateAsset.htm" var="editUrl">
                        
                    </c:url>
                    <tr>
                        <td>${asset.assetID}</td>
                        <td>${asset.serialNo}</td>
                        <td>${asset.type}</td>
                        <td>${asset.model}</td>
                        <td>${asset.make}</td>
                        <td>${asset.purchaseDate}</td>
                        <td>${asset.lifeSpan}</td>
                        <td>${asset.comment}</td>
                        <td><a href="${editUrl}">Edit</a></td>
                        <td><a href="${deleteUrl}">Delete</a></td>
                      
                    </tr>


                </c:forEach>
                      <p>${dltMsg}</p>

            </tbody>
        </table>

    </body>

</html>
