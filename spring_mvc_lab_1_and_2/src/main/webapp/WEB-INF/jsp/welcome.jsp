<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>welcome</title>
</head>
<body>
<h1>Welcome! Please enter your details:</h1>

<form action="${pageContext.request.contextPath}/" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required>


    <button type="submit">Submit</button>
</form>
</body>
</html>
