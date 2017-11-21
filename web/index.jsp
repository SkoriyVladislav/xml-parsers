<%--
  Created by IntelliJ IDEA.
  User: Skori
  Date: 19.11.2017
  Time: 0:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Parse</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  </head>

  <body>

  <br/>
      <form action="Controller" method="get">
            <input type="hidden" name="command" value="SAX" />
            <input type="submit" value="SAX" style="border: solid #000000;
                   border-width: 1px 1px 1px 1px;
                   border-radius: 7px 7px 7px 7px;
                   background: #ffffff;"/>
      </form>

      <form action="Controller" method="get">
            <input type="hidden" name="command" value="StAX" />
            <input type="submit" value="StAX" style="border: solid #000000;
                   border-width: 1px 1px 1px 1px;
                   border-radius: 7px 7px 7px 7px;
                   background: #ffffff;"/>
      </form>

      <form action="Controller" method="get">
            <input type="hidden" name="command" value="DOM"/>
            <input type="submit" value="DOM" style="border: solid #000000;
                   border-width: 1px 1px 1px 1px;
                   border-radius: 7px 7px 7px 7px;
                   background: #ffffff;"/>
      </form>

  </body>
</html>
