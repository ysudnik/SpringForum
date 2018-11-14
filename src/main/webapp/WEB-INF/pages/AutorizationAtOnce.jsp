<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 12.11.2018
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Повторная автоизация</title>
</head>
<body>
<h3>Неправильно введен логин или пароль, повторите ввод или <a href="/pages/registration.jsp">зарегистрируйтесь</a> </h3>
<form action="/autorization" method="post">
    <label>Введите Ваш логин:</label><br>
    <input type ="text" name="user" placeholder="enter your name"/><br>
    <label>Введите пароль:</label><br>
    <input type="password" name = "password" placeholder="enter your password"/><br>
    <input type="submit" name="submit"  value="Авторизоваться"/><br>
</form>
</body>
</html>
