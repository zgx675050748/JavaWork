<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/show14" method="post">
        <input type="text" name="userModelList[0].username"><br>
        <input type="text" name="userModelList[0].password"><br>
        <input type="text" name="userModelList[1].username"><br>
        <input type="text" name="userModelList[1].password"><br>
        <input type="text" name="userModelList[2].username"><br>
        <input type="text" name="userModelList[2].password"><br>
        <input type="submit">
    </form>
</body>
</html>
