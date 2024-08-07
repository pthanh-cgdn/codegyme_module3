<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tphan
  Date: 1/7/24
  Time: 09:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Student</title>
</head>
<body>
<h1>Edit Student</h1>
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
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name" value="${student.name}">
                    <input type="hidden" name="id" id="id" value="${student.id}">
                </td>
            </tr>
            <tr>
                <td>Address: </td>
                <td><input type="text" name="address" id="address" value="${student.address}"></td>
            </tr>
            <tr>
                <td>Email: </td>
                <td><input type="text" name="email" id="email" value="${student.email}"></td>
            </tr>
            <tr>
                <td>Mark: </td>
                <td><input type="text" name="mark" id="mark" value="${student.mark}"></td>
            </tr>
            <tr>
                <label for="classId"><td>Class:</td></label>
                <td><select name="classId" id="classId">
                    <c:forEach var="classes" items="${classes}">
                        <option value=${classes.id}>${classes.name}</option>
                    </c:forEach>
                </select></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Edit student"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
