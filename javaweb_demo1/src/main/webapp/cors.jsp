<%--
  Created by IntelliJ IDEA.
  User: 67505
  Date: 2021/3/4
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cors</title>
    <style>
        #msg1{
            width: 200px;
            height: 200px;
            border: 1px solid #000000;
        }
    </style>
    <script crossorigin="anonymous"
            src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
</head>
<body>
    <button id="btn1">点击发送jsonp请求</button>
    <div id="msg1"></div>
    <script>
        $('#btn1').click(function (){
            $.ajax({
                url: 'http://127.0.0.1:8080/javaweb_demo1/AjaxServlet',
                type: 'GET',
                success: function (data){
                    $('#msg1').text(data);
                }
            })
        });
    </script>
</body>
</html>
