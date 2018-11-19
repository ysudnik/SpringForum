<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 13.11.2018
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>SportForum</title>
</head>
<body>
<script type="text/javascript" src="index.js"></script>
<script type="text/javascript">
    setTimeout(func, 7000)
</script>
<c:choose>
    <c:when test="${messagesSport==null}">
        <h3>Чат пуст, напишите первым</h3>
        <form action="/sportMessage" method="post">
            <input type="hidden" value="${userName}" name="userName">
            <input type="text" name="message">
            <input type="submit" value="отправить">
        </form>
        <hr>
        <form action="/auto" method="post">
            <input type="hidden" value="${userName}" name="userName">
            <input type="submit" value="перейти на тему авто">
        </form>
    </c:when>
    <c:when test="${messagesSport!=null}">
        <c:forEach items="${messagesSport}" var="message">

            <div><c:out value="${message.date}"/></div>
            <div><c:out value="${message.getAuthor().getName()}"/><c:out value=": ${message.getText()}"/></div>
        </c:forEach>
        <form action="/sportMessage" method="post">
            <input type="hidden" value="${userName}" name="userName">
            <input type="text" name="message">
            <input type="submit" value="отправить">
        </form>
        <hr>
        <form action="/auto" method="post">
            <input type="hidden" value="${userName}" name="userName">
            <input type="submit" value="перейти на тему авто">
        </form>
    </c:when>
</c:choose>

</body>
</html>
