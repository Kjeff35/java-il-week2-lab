<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit ToDo</title>
</head>
<body>
<h1>Edit ToDo</h1>
<form action="${pageContext.request.contextPath}/edit/${todo.id}" method="post">
    <label for="title">Title</label>
    <input id="title" type="text" name="title" value="${todo.title}" required />
    <br>
    <label for="date">Date</label>
    <input id="date" type="date" name="dueDate" value="${todo.dueDate}" />
    <br>
    <label for="completed">Completed</label>
    <input id="completed" type="checkbox" name="completed" value="true" ${todo.completed ? 'checked' : ''} />
    <br>
    <button type="submit">Save changes</button>
</form>
</body>
</html>
