
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>TODO LIST</title>
</head>
<body>
<h1>ToDo List</h1>
<c:if test="${not empty message}">
    <div class="alert alert-success">
            ${message}
    </div>
</c:if>
<c:if test="${not empty error}">
    <ul>
        <c:forEach items="${error}" var="error" varStatus="status">
            <li><b>${error.key}:</b> ${error.value}</li>
        </c:forEach>
    </ul>
</c:if>
<form action="${pageContext.request.contextPath}/add" method="post">
    <input type="text" name="title" placeholder="Add a new task" required />
    <input type="date" name="dueDate" required/>
    <button type="submit">Add</button>
</form>
<ul>
    <!-- Check if todos is not null and has elements -->
    <c:if test="${not empty todos}">
        <c:forEach items="${todos}" var="todo">
            <li>
                <span style="${todo.completed ? 'text-decoration: line-through;' : ''}">
                        ${todo.title} (Due: ${todo.dueDate})
                </span>
                <form action="${pageContext.request.contextPath}/complete/${todo.id}" method="post" style="display:inline;">
                    <button type="submit" ${todo.completed ? 'disabled' : ''}>Complete</button>
                </form>
                <a href="${pageContext.request.contextPath}/edit/${todo.id}">Edit</a>
            </li>
        </c:forEach>
    </c:if>
    <!-- Optionally, show a message if no todos are present -->
    <c:if test="${empty todos}">
        <p>No tasks available.</p>
    </c:if>
</ul>
</body>
</html>
