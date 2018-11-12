<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 09.11.2018
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Заголовок форума</title>
</head>
<body>
<h3>Окно регистрации пользователей:<br></h3>
<form action="/registration" method="post">
    <label>Пожалуйста, придумайте Ваше логин:</label><br>
    <input type="text" name="userName"  /><br>
    <label>Придумайте пароль:</label><br>
    <input type="password" name="passwordName"  /><br>
    <label>Повторите пароль:</label><br>
    <input type="password" name="password2Name"  /><br>
    <input type="submit" name="submit"  value="Зарегистрироваться"/><br>
</form>
<hr>
<h3>Окно авторизации пользователей:</h3>
<form action="/autorization" method="post">
    <label>Введите Ваш логин:</label><br>
    <input type ="text" name="user"><br>
    <label>Введите пароль:</label><br>
    <input type="password" name = "password"><br>
    <input type="submit" name="submit"  value="Авторизоваться"/><br>
</form>
</body>
</html>
