<%--
  Created by IntelliJ IDEA.
  User: Skori
  Date: 21.11.2017
  Time: 3:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
    <body>
        <table width="60%" border="1" align="center">

            <tr>
                <td >Name</td>
                <td >Origin</td>
                <td >Price</td>
                <td >Type</td>
                <td >Critical</td>

            </tr>

            <c:forEach items="${devices}" var="device">
                <tr>
                    <td>${device.name}</td>
                    <td>${device.origin}</td>
                    <td>${device.price}</td>
                    <td>${device.type}</td>
                    <td>${device.critical}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
