
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajax</title>
    <style>
        .message{
            width: 800px;
            height: 200px;
            border: 1px solid black;
        }
    </style>
    <script crossorigin="anonymous"
            src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>

</head>
<body>
    <button id="btn1">点击发送Ajax请求</button>
    <div id="message0" class="message"></div>
    <div id="message1" class="message"></div>
    <div id="message2" class="message"></div>
    <button id="btn2">点击发送Ajax请求</button>
    <button id="btn3">点击取消Ajax请求</button>
    <div id="message3" class="message"></div>
    <button id="btn4">点击发送Ajax请求</button>
    <div id="message4" class="message"></div>

    <button id="btn5">GET</button>
    <button id="btn6">POST</button>
    <button id="btn7">通用请求</button>

    <button id="btn8">AxiosGET</button>
    <button id="btn9">AxiosPOST</button>
    <button id="btn10">Axios通用请求</button>
<%--    原生js发送ajax--%>
    <script>
<%--    ajax get start--%>
        var btn = document.getElementById('btn1');
        btn.onclick = function (){
            //1.创建对象
            var xhr = new XMLHttpRequest();
            //2.初始化 设置请求类型和url
            xhr.open('GET','http://127.0.0.1:8080/javaweb_demo1/AjaxServlet?a=100');

            xhr.setRequestHeader('name','zgx');
            //3.发送ajax请求 带post参数
            xhr.send();
            //4.事件绑定 处理服务器返回的结果
            xhr.onreadystatechange = function (){
                //判断服务端返回了所有的结果
                if (xhr.readyState === 4){
                //    判断响应状态码  200 404 403 500
                    if(xhr.status >= 200&&xhr.status < 300){
                    //    处理结果
                        var message = document.getElementById("message0");
                        message.innerHTML
                            =
                            xhr.status+"<br>"+xhr.statusText+"<br>"+xhr.getAllResponseHeaders()+"<br>"+xhr.response;
                    }
                }
            }
        }
<%--    ajax get end--%>

<%--    ajax post start--%>
        const result = document.getElementById('message1');
        result.addEventListener('mouseover',function (){
            //1.创建对象
            var xhr = new XMLHttpRequest();
            //2.初始化 设置请求类型和url
            xhr.open('POST','http://127.0.0.1:8080/javaweb_demo1/AjaxServlet');

            xhr.setRequestHeader('name','zgx');
            //设置数据传输格式，若不设置后台使用getParameter获取不到传输参数
            xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
            //3.发送ajax请求 带post参数
            xhr.send('a=100');
            //4.事件绑定 处理服务器返回的结果
            xhr.onreadystatechange = function () {
                //判断服务端返回了所有的结果
                if (xhr.readyState === 4) {
                    //    判断响应状态码  200 404 403 500
                    if (xhr.status >= 200 && xhr.status < 300) {
                        //    处理结果
                        result.innerHTML
                            =
                            xhr.status + "<br>" + xhr.statusText + "<br>" + xhr.getAllResponseHeaders() + "<br>" + xhr.response;
                    }
                }
            }
        });
<%--    ajax post end--%>

<%--    ajax json start--%>
        window.onkeydown = function (){
            const result = document.getElementById('message2');
            const xhr = new XMLHttpRequest();
            //设置响应体类型
            xhr.responseType = 'json';
            //t = Date.now()可以解决ie的ajax缓存问题
            xhr.open('GET','http://127.0.0.1:8080/javaweb_demo1/JsonServlet?t='+Date.now());
            xhr.send();
            xhr.onreadystatechange = function (){
                if (xhr.readyState === 4 && xhr.status >= 200 && xhr.status <
                    300){
                    //手动对数据进行转化
                    // console.log(JSON.parse(xhr.response));
                    // result.innerHTML = JSON.parse(xhr.response).name;

                    //自动转换
                    console.log(xhr.response);
                    result.innerHTML = xhr.response.name;
                }
            };
        }
<%--    ajax json end--%>

<%--    ajax timeout start--%>
        var btn = document.getElementById('btn2');
        btn.onclick = function (){
            //1.创建对象
            var xhr = new XMLHttpRequest();
            //超时设置
            xhr.timeout = 2000;
            //超时回调
            xhr.ontimeout = function (){
                var message = document.getElementById("message3");
                message.innerHTML
                    = '请求超时,请稍后再试!';
            };
            //网络异常回调
            xhr.onerror =  function (){
                var message = document.getElementById("message3");
                message.innerHTML
                    = '网络异常,请稍后再试!';
            };
            //2.初始化 设置请求类型和url
            xhr.open('GET','http://127.0.0.1:8080/javaweb_demo1/DelayServlet');

            xhr.setRequestHeader('name','zgx');
            //3.发送ajax请求 带post参数
            xhr.send();
            //取消正在发送的请求
            const cancel = document.getElementById('btn3');
            cancel.onclick = function (){
                xhr.abort();
                var message = document.getElementById("message3");
                message.innerHTML0
                    = '请求已取消!';
            };
            //4.事件绑定 处理服务器返回的结果
            xhr.onreadystatechange = function (){
                //判断服务端返回了所有的结果
                if (xhr.readyState === 4){
                    //    判断响应状态码  200 404 403 500
                    if(xhr.status >= 200&&xhr.status < 300){
                        //    处理结果
                        var message = document.getElementById("message3");
                        message.innerHTML
                            =
                            xhr.status+"<br>"+xhr.statusText+"<br>"+xhr.getAllResponseHeaders()+"<br>"+xhr.response;
                    }
                }
            }
        }
<%--    ajax timeout end--%>

<%--    ajax 重复请求问题 start--%>
        var btn = document.getElementById('btn4');
        var xhr;
        //创建标识变量
        var isSending = false;

        btn.onclick = function (){
            //判断标识变量
            if (isSending) xhr.abort();  //如果请求正在发送，取消正在发送的请求，创建新的请求
            //1.创建对象
            xhr = new XMLHttpRequest();
            //修改标识变量
            isSending = true;
            //2.初始化 设置请求类型和url
            xhr.open('GET','http://127.0.0.1:8080/javaweb_demo1/DelayServlet');

            xhr.setRequestHeader('name','zgx');
            //3.发送ajax请求 带post参数
            xhr.send();
            //4.事件绑定 处理服务器返回的结果
            xhr.onreadystatechange = function (){
                //判断服务端返回了所有的结果
                if (xhr.readyState === 4){
                    //发送完成后修改标识变量为false
                    isSending = false;
                    //    判断响应状态码  200 404 403 500
                    if(xhr.status >= 200&&xhr.status < 300){
                        //    处理结果
                        var message = document.getElementById("message4");
                        message.innerHTML
                            =
                            xhr.response;
                    }
                }
            }
        }
<%--    ajax 重复请求问题 start--%>
    </script>
<%--    jquery发送ajax--%>
    <script>
        $('#btn5').click(function (){
            $.get('http://127.0.0.1:8080/javaweb_demo1/JqueryServlet',
                {a:100,b:200}, function (data){
                    console.log(data);
                });
        });
        $('#btn6').click(function (){
            $.post('http://127.0.0.2:8080/javaweb_demo1/JqueryServlet',
                {a:100,b:200}, function (data){
                    console.log(data);
                }, 'json');
        });
        $('#btn7').click(function (){
            $.ajax({
                url: 'http://127.0.0.1:8080/javaweb_demo1/JqueryServlet',
                data: {a:100,b:200},
                type: 'GET',
                dataType: 'JSON',
                success: function (data){
                    console.log(data);
                },
                timeout: 4000,
                error: function (){
                    console.log('error!')
                },
                headers: {
                    c:300,
                    d:400
                }
            });
        });
    </script>
<%--    axios发送ajax--%>
    <script>
        $('#btn8').click(function (){
            //GET
            axios.get('http://127.0.0.1:8080/javaweb_demo1/AxiosServlet', {
                params: {
                    id:10
                },
                headers: {
                    name: 'zgx',
                    age: 22
                }
            });
        });
    </script>

<%--    解决跨域--%>
</body>
</html>
