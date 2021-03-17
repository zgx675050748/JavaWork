<%--
  Created by IntelliJ IDEA.
  User: 67505
  Date: 2021/3/17
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工列表</title>

    <%--    不以/开始的相对路径，找资源，以当前资源的路径为基准，容易出问题
            以/开始的相对路径，以服务器的路径为标准
    --%>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<%--    搭建显示页面--%>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h1>SSM-CRUD</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-md-3 col-md-offset-9">
            <button class="btn btn-primary">新增</button>
            <button class="btn btn-danger">删除</button>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover" id="emps_table">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>empName</th>
                        <th>gender</th>
                        <th>email</th>
                        <th>deptName</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>

                </tbody>

            </table>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6" id="info"></div>
        <div class="col-md-6">
            <nav aria-label="Page navigation">
                <ul class="pagination" id="pageNav">
                    <li><a href="#">首页</a></li>
                    <li>
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li><a href="#"></a></li>
                    <li><a href="#"></a></li>
                    <li><a href="#"></a></li>
                    <li><a href="#"></a></li>
                    <li><a href="#"></a></li>
                    <li>
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                    <li><a href="#">末页</a></li>
                </ul>
            </nav>
        </div>
    </div>
</div>
<script type="text/javascript">
    //1.页面加载完成以后，直接发送一个ajax请求，获取分页数据
    $(sendAjax(1));

    function build_emps_table(data){
        var emps = data.extend.pageInfo.list;
        $("#emps_table tbody").empty();
        $.each(emps,function (index,item){
            var empId = $("<td></td>").append(item.empId);
            var empName = $("<td></td>").append(item.empName);
            var gender = $("<td></td>").append(item.gender);
            var email = $("<td></td>").append(item.email);
            var deptName = $("<td></td>").append(item.department.deptName);
            var editBtn =
                $("<button></button>").addClass("btn btn-primary btn-sm").append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");

            var delBtn =
                $("<button></button>").addClass("btn btn-danger btn-sm").append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
            var Btn = $("<td></td>").append(editBtn).append(" ").append(delBtn);
            $("#emps_table tbody").append($("<tr></tr>").append(empId).append(empName).append(gender).append(email).append(deptName).append(Btn));
        });
    }

    function build_page_nav(data){
        $("#info").empty();
        $("#info").append(
            "当前"+data.extend.pageInfo.pageNum+"页，总"+data.extend.pageInfo.pages+"页，总"+data.extend.pageInfo.total+"条记录");
        var nlist = document.getElementsByTagName("li");
        if(data.extend.pageInfo.isFirstPage){
            nlist[0].setAttribute("class","disabled");
            nlist[1].setAttribute("class","disabled");
            nlist[0].getElementsByTagName("a")[0].removeAttribute("onclick");
            nlist[1].getElementsByTagName("a")[0].removeAttribute("onclick");
        }
        else{
            nlist[0].removeAttribute("class");
            nlist[1].removeAttribute("class");
            nlist[0].getElementsByTagName("a")[0].setAttribute("onclick","sendAjax(1)");
            nlist[1].getElementsByTagName("a")[0].setAttribute("onclick","sendAjax("+data.extend.pageInfo.prePage+")");
        }
        if(data.extend.pageInfo.isLastPage){
            nlist[nlist.length-2].setAttribute("class","disabled");
            nlist[nlist.length-1].setAttribute("class","disabled");
            nlist[nlist.length-2].getElementsByTagName("a")[0].removeAttribute("onclick");
            nlist[nlist.length-1].getElementsByTagName("a")[0].removeAttribute("onclick");
        }
        else {
            nlist[nlist.length-2].removeAttribute("class");
            nlist[nlist.length-1].removeAttribute("class");
            nlist[nlist.length-2].getElementsByTagName("a")[0].setAttribute("onclick","sendAjax("+data.extend.pageInfo.nextPage+")");
            nlist[nlist.length-1].getElementsByTagName("a")[0].setAttribute("onclick","sendAjax("+data.extend.pageInfo.pages+")");
        }
        for (let i = 0; i < 5; i++){
            nlist[i+2].removeAttribute("class");
            if(data.extend.pageInfo.pageNum
                == data.extend.pageInfo.navigatepageNums[i]){
                nlist[i+2].setAttribute("class","active")
            }
            nlist[i+2].getElementsByTagName("a")[0].innerText =
                data.extend.pageInfo.navigatepageNums[i];
            nlist[i+2].getElementsByTagName("a")[0].setAttribute("onclick","sendAjax("+data.extend.pageInfo.navigatepageNums[i]+")");
        }
    }

    function sendAjax(pageNum){
        $.ajax({
            url:"${pageContext.request.contextPath}/emps",
            data:"pn="+pageNum,
            type:"get",
            success:function(data){
                console.log(data);
                //1.解析并显示员工数据
                build_emps_table(data);
                //2.解析并显示分页信息
                build_page_nav(data);
            }
        });
    }
</script>
</body>
</html>
