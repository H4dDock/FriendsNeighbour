<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Spring Security</title>
</head>

<body>

<div class="container" style="width: 300px;">
    <form name="add" action="/TestRegister_war_exploded/newUser" method="post">
        <input name="username" type="text" />
        <input name="password" type="text" />
        <input type="submit" value="Submit">
        </form>
</div>

</body>
</html>