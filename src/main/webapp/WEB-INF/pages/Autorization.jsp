<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 12.11.2018
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Авторизация</title>
</head>
<body>
<h3>Поздравляем, Вы успешно зарегистрированы, для входа на форум введите данные</h3>
<form action="/autorization" method="post">
    <label>Введите Ваш логин:</label><br>
    <input type ="text" name="user" placeholder="enter your name"/><br>
    <label>Введите пароль:</label><br>
    <input type="password" name = "password" placeholder="enter your password"/><br>
    <input type="submit" name="submit"  value="Авторизоваться"/><br>
</form>
</body>
</html>


