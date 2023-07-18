<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18/7/2023
  Time: 10:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/currency/calculation" method="post">
<input type="number" name="usd" min="0" value="${usd}"><br>
<button>Result</button>
    <p>Result: <fmt:setLocale value="vi_VN"/>
        <fmt:formatNumber value="${vnd}" type="currency"/></p>
</form>
</body>
</html>
