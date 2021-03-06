<%@ page import="java.util.List" %>
<%@ page import="by.epam.tr.device.Device" %><%--
  Created by IntelliJ IDEA.
  User: Skori
  Date: 21.11.2017
  Time: 3:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script address="text/javascript"><%@include file="/WEB-INF/js/javascript.js"%></script>
<style>
    <%@include file="/WEB-INF/css/pageCSS.css"%>
</style>


<html>
    <head>
        <title>Title</title>
    </head>

    <body>
    <% List list = (List) session.getAttribute("devices"); %>

    <h3 align="left">Parser: ${command}</h3>

        <table width="60%" border="1" align="center" id="results">
                <tr>
                    <td >Name</td>
                    <td >Origin</td>
                    <td >Price</td>
                    <td >Type</td>
                    <td >Critical</td>
                </tr>

                <% for (int i = 0; i < list.size(); i++) { %>
                <tr>
                        <% Device device = (Device) list.get(i);
                            out.println("<td>" + device.getName()+ "</td>");
                            out.println("<td>" + device.getOrigin()+ "</td>");
                            out.println("<td>" + device.getPrice() + "</td>");
                            out.println("<td>" + device.getAddress() + "</td>");
                            out.println("<td>" + device.getCritical() + "</td>"); %>
                </tr>
                <% } %>
        </table>

        <div id="pageNavPosition"></div>

        <script address="text/javascript">
            var pager = new Pager('results', 2);
            pager.init();
            pager.showPageNav('pager', 'pageNavPosition');
            pager.showPage(1);
        </script>
    </body>
</html>
