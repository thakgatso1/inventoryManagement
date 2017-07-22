
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Asset</title>
    </head>
    <body>
        Select an asset :
        <div class="forms col-md-12 bounceInDown mainContent" data-wow-delay="0.2s">



           
                    </table>


                <h4 class="form-header">${title}</h4>

                <div class="forms col-md-12 bounceInDown mainContent" data-wow-delay="0.2s">



                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Task ID</th>
                                <th>Task Name</th>
                                <th>Task Description</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:if test="${empty task}">
                                <tr>
                                    <td colspan="8">No task to Display</td>
                                </tr>
                            </c:if>
                            <c:if test="${not empty task}">

                                <c:forEach items="${tasks}" var="task">
                                    <tr class="">
                                        <td>${task.taskid}</td>
                                        <td>${task.taskName}</td>
                                        <td>${task.taskDescription}</td>
                                        <td>
                                <fmt:message key="task.list.status.text.${task.status}" />
                                </td>

                                </tr>
                            </c:forEach>
                        </c:if>
                        </tbody>
                    </table>
                </div>
                </body>
                </html>
