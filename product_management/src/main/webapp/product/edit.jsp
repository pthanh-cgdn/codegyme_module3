<%--
  Created by IntelliJ IDEA.
  User: tphan
  Date: 28/6/24
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create new customer</title>
    <style>
        .message{
            color:green;
        }
    </style>
</head>
<body>
<h1>Create new product</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/product">Back to student list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Student information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td>
                    <input type="text" name="name" id="name">
                    <input type="hidden" name="id" value="${id}">
                </td>
            </tr>
            <tr>
                <td>Category: </td>
                <td><input type="text" name="categoryName" id="categoryName"></td>
            </tr>
            <tr>
                <td>Manufacture: </td>
                <td><input type="text" name="manufacture" id="manufacture"></td>
            </tr>
            <tr>
                <td>Proce: </td>
                <td><input type="text" name="price" id="price"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create new product"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
