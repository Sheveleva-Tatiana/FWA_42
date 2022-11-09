<%--
  Created by IntelliJ IDEA.
  User: sshera
  Date: 11/9/22
  Time: 9:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <%@ page import="edu.school.cinema.test.Cart" %>
        <%
            Cart cart = (Cart) session.getAttribute("cart");
        %>

       <p> Наименование: <%= cart.getName() %> </p>
        <p> Количество: <%= cart.getQuantity() %> </p>
</body>
</html>
