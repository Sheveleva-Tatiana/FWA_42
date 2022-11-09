<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Tatiana
  Date: 02.11.2022
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>First JSP</title>
</head>
<body>
    <h1>Testing JSP</h1>
    <p>
        <%
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
        %>
        <%= "<p1> Hello, " + name + " " + surname + "!</p1>"%>
    </p>

</body>
</html>
