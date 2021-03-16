<%--
  Created by IntelliJ IDEA.
  User: 67505
  Date: 2021/2/5
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>添加用户信息</h1>
    <form action="${pageContext.request.contextPath}/account/save"
          name="accountForm"
          method="post">
        账户名称：<input type="text" name="name"><br>
        账户金额：<input type="text" name="money"><br>
        <input type="submit" value="保存">
    </form>
</body>
</html>
