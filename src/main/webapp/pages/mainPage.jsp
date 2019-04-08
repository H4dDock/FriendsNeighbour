<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Приветствуем <sec:authentication property="principal.username" />!</title>
</head>
<body>
<p>Приветствуем <sec:authentication property="principal.username" />!</p>
<c:forEach items="${companies}" var="temp">
    <ul>
        <li>${temp.getCompanyName()}</li>
    </ul>
</c:forEach>
<p><a class="btn btn-lg btn-danger" href="<c:url value="/logout" />" role="button">Выйти</a></p>
</body>
</html>