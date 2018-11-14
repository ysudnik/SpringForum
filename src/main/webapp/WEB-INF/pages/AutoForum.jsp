<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 13.11.2018
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>AutoForum</title>
</head>
<body>
<script type="text/javascript" src="index.js"></script>
<script type="text/javascript">
    setTimeout(func2, 7000)
</script>
<c:forEach items="${messagesAuto}" var="message">

    <div><c:out value="${message.date}" /></div>
    <div><c:out value="${message.getAuthor().getName()}" /><c:out value=": ${message.getText()}" /></div>
</c:forEach>
<form action="/autoMessage" method="post" >
    <input type="hidden" value="${userName}" name="userName">
    <input type="text"  name="message">
    <input type="submit" value="отправить">
</form>
<hr>
<form action="/sport" method="post" >
    <input type="hidden" value="${userName}" name="userName">
    <input type="submit" value="перейти на тему спорт">
</form>
</body>
</html>
