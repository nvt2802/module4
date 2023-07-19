<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18/7/2023
  Time: 11:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/calculator" method="post">
<input type="number" name="first" required value="0" placeholder="First number">
<input type="number" name="second" required value="0" placeholder="Second number">
<button name="operator" value="+">+</button>
<button name="operator" value="-">-</button>
<button name="operator" value="*">X</button>
<button name="operator" value="/">/</button>
</form>
<p>Result: ${result}</p>
</body>
</html>
