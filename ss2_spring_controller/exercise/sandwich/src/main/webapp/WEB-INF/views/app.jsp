<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 19/7/2023
  Time: 10:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Sandwich Condiment</h1>
    <form action="/save" method="get">
    <input type="checkbox" id="Lettuce" name="condiment" value="Lettuce"><label for="Lettuce">Lettuce</label>
    <input type="checkbox" id="Tomato" name="condiment" value="Tomato"><label for="Tomato">Tomato</label>
    <input type="checkbox" id="Mustard" name="condiment" value="Mustard"><label for="Mustard">Mustard</label>
    <input type="checkbox" id="Sprouts" name="condiment" value="Sprouts"><label for="Sprouts">Sprouts</label><br>
        <hr>
        <button>Save</button>
    </form>
</body>
</html>
