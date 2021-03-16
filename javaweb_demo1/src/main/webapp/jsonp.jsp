<%--
  Created by IntelliJ IDEA.
  User: 67505
  Date: 2021/3/4
  Time: 9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsonp</title>
    <style>
        #username{
            width: 200px;
        }
        #msg1{
            width: 200px;
            height: 200px;
            border: 1px solid black;
        }
    </style>
    <script crossorigin="anonymous"
            src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
</head>
<body>
    用户名：<input type="text" id="username"/>
    <p></p>

    <button id="btn1">点击发送jsonp请求</button>
    <div id="msg1"></div>
<%--    原生js实现jsonp--%>
    <script>
        const input = document.getElementById("username");
        const p = document.querySelector('p');

        function handle(data){
            input.style.border = '1px solid red';
            p.innerHTML = data.msg;
        }
        input.onblur = function (){
            let username = this.value;
        //    1.创建script标签
            const script = document.createElement('script');
            //2.设置标签的src
            script.src =
                'http://127.0.0.1:8080/javaweb_demo1/JsonpServlet?username='+username;
        //    3.将script插入到文档中
            document.body.appendChild(script);
        };
    </script>

<%--    Jquery实现jsonp--%>
    <script>
        $('#btn1').click(function (){
            $.getJSON('http://127.0.0.1:8080/javaweb_demo1/JsonpServlet?callback=?&&username=123456',function (data){
                $('#msg1').text(data.msg);
            });
        });
    </script>
</body>
</html>
