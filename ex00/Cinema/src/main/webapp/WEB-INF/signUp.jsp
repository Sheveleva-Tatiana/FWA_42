<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>

<body>
    <form action="signUp" method="post">
        <input placeholder="First name" type="text" id="first" name="firstname" autocomplete="off" required/>
        <input placeholder="Last name" type="text" id="last" name="lastname" autocomplete="off" required/>
        <input placeholder="Phone" type="tel" id="phone" name="phone" autocomplete="off" required/>
        <input placeholder="Password" type="password" name="password" autocomplete="off" required/>
        <button id="regBtn" class="btn">Register</button>
    </form>
</body>
</html>
