<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18/7/2023
  Time: 1:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/Translate" method="post">
    <label for="english">English: </label>
    <input type="text" id="english" name="english" >
    <button>Translate</button>
    <p>Tiếng việt: ${vietnamese}</p>
</form>
</body>
</html>
