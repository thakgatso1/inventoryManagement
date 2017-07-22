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
     <script>
    function populate(assetId, sn, type, model, make, pd, ls, comment)
    {
         document.getElementById("assetID").value = assetId;
         document.getElementById("serialNumber").value = sn;
         document.getElementById("type").value = type;
         document.getElementById("model").value = model;
         document.getElementById("make").value = make;
         document.getElementById("purchaseDate").value = pd;
         document.getElementById("lifeSpan").value = ls;
         document.getElementById("comment").value = comment;
    
    
    }

function clear()
{
       document.getElementById("assetID").value='0';
       document.getElementById("serialNumber").value = "";
       document.getElementById("type").value = "";
       document.getElementById("model").value = "";
       document.getElementById("make").value = "";
       document.getElementById("purchaseDate").value = "";
       document.getElementById("lifeSpan").value = "";
       document.getElementById("comment").value = "";
}
function clearFields(){
   alert("test");
    document.getElementById("addAssetForm").reset();
}
</script>
        
     
        <h1> ASSET TRACKING</h1>

        <form:form commandName="addAssetForm" id ="addAssetForm" action="/webapp/addUpdateAsset.htm" method="post">
            <table class="displayForm" align="center" cellspacing="2"> 
            <tr>
                <td> 
                    Asset ID:      
                </td>
                <td>
                     <form:input type="text" path="assetID" id="assetID" readonly="true"/>
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
                    <form:input type="text" path="make" id="make"/>
                </td>
            </tr>
            <tr>
                <td> 
                    Purchase Date:     
                </td>
                <td>
                    <form:input type="text" path="purchaseDate" id="purchaseDate"/>
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

                <td><input type="submit" name="action" value="Add/Update Assets"/>
                     <td> <input type="button" onclick="clearFields()" value="clear"></td>
                      </form:form>
                  

                </td>
            </tr>

        </table>
        
 
    <p>${msg}</p>
    <td>  <input onclick="clear()"type="submit" name="action" value="Clear fields"></td>
                        

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


                <tr>
                    <td>${asset.assetID}</td>
                    <td>${asset.serialNo}</td>
                    <td>${asset.type}</td>
                    <td>${asset.model}</td>
                    <td>${asset.make}</td>
                    <td>${asset.purchaseDate}</td>
                    <td>${asset.lifeSpan}</td>
                    <td>${asset.comment}</td>
                        <td>  <input onclick="populate('${asset.assetID}','${asset.serialNo}','${asset.type}','${asset.model}','${asset.make}','${asset.purchaseDate}','${asset.lifeSpan}','${asset.comment}')"type="submit" name="action" value="Edit"></td>
                        
                         <form:form action="/webapp/delete.htm" method="post">
                <input type="hidden" value="${asset.assetID}" name="id">
                       <td><input type="submit" name="action" value="Delete"/></td>
                    </form:form>

                </tr>


            </c:forEach>
        <p>${dltMsg}</p>

    </tbody>
</table>

</body>

</html>
