<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 19/7/2023
  Time: 4:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        th{
            text-align: left;
        }
        td{
            padding: 20px;
        }
    </style>
</head>
<body>
<h1>Settings</h1>
<form:form modelAttribute="settings" action="/update" method="post">
    <table>
        <tr>
            <th>Languages:</th>
            <td><form:select path="languages">
                <form:options items="${language}" />
            </form:select></td>

        </tr>
        <tr>
            <th>Page size: </th>
            <td>show <form:select path="pageSize">
              <form:options items="${pageSizes}" />
            </form:select> emails per page</td>
        </tr>
        <tr>
            <th>Spams filter:</th>
            <td><form:checkbox path="spamsFilter" label="enable spams filter" /></td>
        </tr>
        <tr>
            <th>Signature:</th>
            <td><form:textarea path="signature" rows="4" cols="50"/></td>
        </tr>
        <tr>
            <td></td>
            <td><form:button>Update</form:button><a href="/info"><button>Back</button></a></td>
        </tr>
    </table>
</form:form>

</body>
</html>
