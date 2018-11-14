<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 12.11.2018
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Выбрать тему</title>
</head>
<body>
Спорт
<form action="/sport" method="post" >
    <input type="hidden" value="${userName}" name="userName">
    <input type="hidden" value="sport" name="themaname">
    <input type="submit" value="send">
</form>
Авто
<form action="/auto" method="post">
    <input type="hidden" value="${userName}" name="userName">
    <input type="hidden" value="auto" name="themaname">
    <input type="submit" value="send">
</form>
</body>
</html>
