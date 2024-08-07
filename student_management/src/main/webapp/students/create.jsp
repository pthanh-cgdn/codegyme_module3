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
        .message {
            color: green;
        }
    </style>
</head>
<body>
<h1>Create new student</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/students">Back to student list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Student information</legend>
        <table>
            <%--            <tr>--%>
            <%--                <td>ID: </td>--%>
            <%--                <td><input type="text" name="id" id="id"></td>--%>
            <%--            </tr>--%>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><input type="text" name="address" id="address"></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="text" name="email" id="email"></td>
            </tr>
            <tr>
                <td>Mark:</td>
                <td><input type="text" name="mark" id="mark"></td>
            </tr>
            <tr>
                <label for="classId"><td>Class:</td></label>
                <td><select name="classId" id="classId">
                    <c:forEach var="classes" items="${classes}">
                        <option value=${classes.id}>${classes.name}</option>
                    </c:forEach>
<%--                    <option value="">No Class</option>--%>
                </select></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create new student"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
