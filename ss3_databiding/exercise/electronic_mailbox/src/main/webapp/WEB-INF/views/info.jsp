<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 20/7/2023
  Time: 11:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Configuration of an e-mail box</h1>
<p style="color:green;">${msg}</p>
Language:
<span>${settings.languages}</span><br>
Page size:
<span>${settings.pageSize}</span><br>
Spams filter:
<span>${settings.spamsFilter}</span><br>
Signature:
<span>${settings.signature}</span><br>
<a href="/update"><button>Update</button></a>
</body>
</html>
