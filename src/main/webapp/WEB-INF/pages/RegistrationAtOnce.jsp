<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 12.11.2018
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Повторная регистрация</title>
</head>
<body>
<h3>Пожалуйста, зарегистрируйтесь:</h3>
<form action="/registration" method="post">
    <label>Пожалуйста, придумайте Ваш логин:</label><br>
    <input type="text" name="user" placeholder="userName" /><br>
    <label>Придумайте пароль:</label><br>
    <input type="password" name="password"  /><br>
    <label>Повторите пароль:</label><br>
    <input type="password" name="password2"  /><br>
    <input type="submit" name="submit"  value="Зарегистрироваться"/><br>
</form>

</body>
</html>
