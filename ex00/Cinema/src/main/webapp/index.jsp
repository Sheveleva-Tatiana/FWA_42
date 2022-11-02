<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Tatiana
  Date: 02.11.2022
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>First JSP</title>
</head>
<body>
    <h1>Testing JSP</h1>
    <p>
        <%
            java.util.Date now = new java.util.Date();
            String str = "текущая дата: " + now;

        %>
        <%= str %>
    </p>

</body>
</html>
