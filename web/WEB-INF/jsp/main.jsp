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
    <table
            style="border-style: solid; border-width: 1px; width: 250px; border-collapse: collapse;">
        <thead>
        <tr>
            <td style="width: 50px;">name</td>
            <td style="width: 50px;">origin</td>
            <td style="width: 50px;">price</td>
            <td style="width: 50px;">type</td>
            <td style="width: 50px;">critical</td>

        </tr>
        </thead>
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
