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

<!-- 新建模态框 -->
<div class="modal fade" id="empAddModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">员工添加</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="empName"
                               class="col-sm-2 control-label">empName</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control"
                                   id="empName" placeholder="empName"
                                   name="empName">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email"
                               class="col-sm-2 control-label">email</label>
                        <div class="col-sm-10">
                            <input type="email" class="form-control"
                                   id="email" placeholder="Email" name="email">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label
                               class="col-sm-2 control-label">gender</label>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                                <input type="radio" name="gender"
                                       id="gender1" value="男" checked> 男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="gender"
                                       id="gender2" value="女"> 女
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label
                                class="col-sm-2 control-label">deptName</label>
                        <div class="col-sm-4">
<%--                            数据库查询，提交部门id--%>
                            <select class="form-control" name="dId">

                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default"
                        data-dismiss="modal">关闭</button>
                <button type="button" id="saveEmp" class="btn btn-primary">保存
                </button>
            </div>
        </div>
    </div>
</div>

<%--员工修改模态框--%>
<div class="modal fade" id="empUpdateModel" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">员工修改</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="empName"
                               class="col-sm-2 control-label">empName</label>
                        <div class="col-sm-10">
                            <p class="form-control-static"
                               id="empName_update"></p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email"
                               class="col-sm-2 control-label">email</label>
                        <div class="col-sm-10">
                            <input type="email" class="form-control"
                                   id="email_update" placeholder="Email"
                                   name="email">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label
                                class="col-sm-2 control-label">gender</label>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                                <input type="radio" name="gender" value="男" checked> 男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="gender" value="女"> 女
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label
                                class="col-sm-2 control-label">deptName</label>
                        <div class="col-sm-4">
                            <%--                            数据库查询，提交部门id--%>
                            <select class="form-control" name="dId">

                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default"
                        data-dismiss="modal">关闭</button>
                <button type="button" id="updateEmp" class="btn btn-primary">保存
                </button>
            </div>
        </div>
    </div>
</div>


<%--    搭建显示页面--%>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h1>SSM-CRUD</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-md-3 col-md-offset-9">
            <button class="btn btn-primary"
                    id="addBtn"><span class="glyphicon glyphicon-pencil"></span>新增</button>
            <button class="btn btn-danger" id="delAll"><span
                    class="glyphicon glyphicon-trash"
            ></span>删除
            </button>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover" id="emps_table">
                <thead>
                    <tr>
                        <th><input type="checkbox" id="check_all"></th>
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
    //总记录数
    var currentPage,totalRecord;
    //1.页面加载完成以后，直接发送一个ajax请求，获取分页数据
    $(sendAjax(1));

    function build_emps_table(data){
        var emps = data.extend.pageInfo.list;
        $("#emps_table tbody").empty();
        $.each(emps,function (index,item){
            var checkBox =
                $("<td><input type='checkbox' class='check_item'/></td>");
            var empId = $("<td></td>").append(item.empId);
            var empName = $("<td></td>").append(item.empName);
            var gender = $("<td></td>").append(item.gender);
            var email = $("<td></td>").append(item.email);
            var deptName = $("<td></td>").append(item.department.deptName);
            var editBtn =
                $("<button></button>").addClass("btn btn-primary btn-sm edit_btn").append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
            editBtn.attr("edit-id",item.empId);
            var delBtn =
                $("<button></button>").addClass("btn btn-danger btn-sm del_btn").append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
            delBtn.attr("del-id",item.empId);
            var Btn = $("<td></td>").append(editBtn).append(" ").append(delBtn);
            $("#emps_table tbody").append($("<tr></tr>").append(checkBox).append(empId).append(empName).append(gender).append(email).append(deptName).append(Btn));
        });
    }

    function build_page_nav(data){
        $("#info").empty();
        $("#info").append(
            "当前"+data.extend.pageInfo.pageNum+"页，总"+data.extend.pageInfo.pages+"页，总"+data.extend.pageInfo.total+"条记录");
        currentPage = data.extend.pageInfo.pageNum;
        totalRecord = data.extend.pageInfo.total+1;
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
            nlist[1].getElementsByTagName("a")[0].setAttribute("onclick","$('#check_all').prop('checked',false);sendAjax("+data.extend.pageInfo.prePage+");");
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
            nlist[nlist.length-2].getElementsByTagName("a")[0].setAttribute("onclick","$('#check_all').prop('checked',false);sendAjax("+data.extend.pageInfo.nextPage+")");
            nlist[nlist.length-1].getElementsByTagName("a")[0].setAttribute("onclick","$('#check_all').prop('checked',false);sendAjax("+data.extend.pageInfo.pages+")");
        }
        for (let i = 0; i < 5; i++){
            nlist[i+2].removeAttribute("class");
            if(data.extend.pageInfo.pageNum
                == data.extend.pageInfo.navigatepageNums[i]){
                nlist[i+2].setAttribute("class","active")
            }
            nlist[i+2].getElementsByTagName("a")[0].innerText =
                data.extend.pageInfo.navigatepageNums[i];
            nlist[i+2].getElementsByTagName("a")[0].setAttribute("onclick","$('#check_all').prop('checked',false);sendAjax("+data.extend.pageInfo.navigatepageNums[i]+")");
        }
    }

    function sendAjax(pageNum){
        $.ajax({
            url:"${pageContext.request.contextPath}/emps",
            data:"pn="+pageNum,
            type:"get",
            success:function(data){
                //1.解析并显示员工数据
                build_emps_table(data);
                //2.解析并显示分页信息
                build_page_nav(data);
            }
        });
    }

    $("#addBtn").click(function (){
        //发送ajax查询部门信息,显示在下拉列表
            getDepts("#empAddModel select");
        //弹出模态框
        $("#empAddModel").modal({
            backdrop:"static"
        });
    });

    //查询所有部门信息显示在下拉列表
    function getDepts(ele){
        $(ele).empty();

        $.ajax({
            url:"${pageContext.request.contextPath}/depts",
            type:"GET",
            async:false,
            success:function (data){
                for (var x in data.extend.depts) {
                    $(ele).append($("<option value="+data.extend.depts[x].deptId+"></option>").append(data.extend.depts[x].deptName))
                }
            }
        });
    }

    $("#saveEmp").click(function (){
        //对数据进行校验
        if(!validate_add_form()) return false;
        //将模态框中表单数据提交
        $.ajax({
            url:"${pageContext.request.contextPath}/saveemp",
            type:"POST",
            data:$("#empAddModel form").serialize(),
            success:function (data){
                if (data.code === 100){
                //1.关闭模态框
                $("#empAddModel").modal('hide');
                //2.去到最后一页，发送ajax请求，显示最后一页数据即可
                sendAjax(totalRecord);
                }
                else{
                    //显示失败信息
                    //console.log(data);
                    //有哪个错误信息就显示哪个
                    if (data.extend.errorFields.email != undefined){
                        showMsg($("#email"),data.extend.errorFields.email,"error")
                    }
                    if (data.extend.errorFields.empName != undefined){
                        showMsg($("#empName"),data.extend.errorFields.empName,"error")
                    }
                }
            }
        });
    });

    //校验表单数据
    function validate_add_form(){
        var flag1;
        var flag2;
        var empName = $("#empName").val();
        var regName = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
        $("#empName").parent().removeClass("has-error has-success");
        $("#email").parent().removeClass("has-error has-success");
        if(!regName.test(empName)){
            //alert("用户名可以是2-5位中文或者6-16位英文和数字组合");
            showMsg($("#empName"),"用户名可以是2-5位中文或者6-16位英文和数字组合","error")
            // $("#empName").parent().addClass("has-error");
            // $("#empName").next("span").text("用户名可以是2-5位中文或者6-16位英文和数字组合");
            flag1 = false;
        }else {
            showMsg($("#empName"),"","success")
            // $("#empName").parent().addClass("has-success");
            // $("#empName").next("span").text("");
            flag1 = true;
        }

        var email = $("#email").val();
        var regEmail = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
        if(!regEmail.test(email)){
            //alert("请输入正确的邮箱格式");
            showMsg($("#email"),"请输入正确的邮箱格式","error")
            flag2 = false;
        }
        else{
            showMsg($("#email"),"","success")
            flag2 = true;
        }
        return flag1&&flag2;
    }

    function showMsg(dom,msg,statu){
        if ("success" === statu){
            dom.parent().addClass("has-success");
            dom.next("span").text("");
        }
        else{
            dom.parent().addClass("has-error");
            dom.next("span").text(msg);
        }
    }

    //为编辑按钮绑定事件，但是编辑按钮不是一开始就存在的，而是在发送ajax请求后才产生，需要使用特殊方法on，使用如下：
    $(document).on("click",".edit_btn",function (){

        //查出部门信息
        getDepts("#empUpdateModel select");
        //查出员工信息
        getEmp($(this).attr("edit-id"));
        //弹出模态框
        $("#empUpdateModel").modal({
            backdrop:"static"
        });
        //把员工id传递给更新按钮
        $("#updateEmp").attr("edit-id",$(this).attr("edit-id"));
    });

    function getEmp(id){
        $.ajax({
            url:"${pageContext.request.contextPath}/emp/"+id,
            type:"GET",
            success: function (data){
                var empData = data.extend.emp;
                $("#empName_update").text(empData.empName);
                $("#email_update").val(empData.email);
                $("#empUpdateModel input[name=gender]").val([empData.gender]);
                $("#empUpdateModel select").val([empData.dId]);
            }
        });
    }

    $("#updateEmp").click(function (){
        //验证邮箱是否合法
        var email = $("#email_update").val();
        var regEmail = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
        if(!regEmail.test(email)){
            //alert("请输入正确的邮箱格式");
            showMsg($("#email_update"),"请输入正确的邮箱格式","error")
            return false;
        }
        else{
            showMsg($("#email_update"),"","success");
            //ajax保存更新的用户信息
            $.ajax({
                url:"${pageContext.request.contextPath}/emp/"+$(this).attr("edit-id"),
                type:"PUT",
                data:$("#empUpdateModel form").serialize(),
                success:function (data){
                    //1.关闭模态框
                    $("#empUpdateModel").modal('hide');
                    //2.去到修改数据所在页，送ajax请求，显示最后一页数据即可
                    sendAjax(currentPage);
                }
            });
        }
    });

    $(document).on("click",".del_btn",function (){

        //弹出是否确认框
        var empName = $(this).parents("tr").find("td:eq(2)").text();
        if (confirm("确认删除"+empName+"?")){
            $.ajax({
                url:"${pageContext.request.contextPath}/emp/"+$(this).attr("del-id"),
                type:"DELETE",
                success:function (data){
                    alert(data.msg);
                    sendAjax(currentPage);
                }
            });
        }
    });

    //全选/全不选
    $("#check_all").click(function (){
        $(".check_item").prop("checked",$(this).prop("checked"));
    });

    $(document).on("click",".check_item",function (){
        $("#check_all").prop("checked",$(".check_item:checked").length === $(".check_item").length);
    });

    //批量删除
    $("#delAll").click(function (){
        var empNames = "";
        $.each($(".check_item:checked"),function (){
            empNames += $(this).parents("tr").find("td:eq(2)").text()+"，";
        });
        empNames = empNames.substring(0,empNames.length-1);
        if (empNames != ""){
            if (confirm("确认删除【"+empNames+"】吗？")){
                //发送ajax请求
                var del_ids = "";
                $.each($(".check_item:checked"),function (){
                    del_ids += $(this).parents("tr").find("td:eq(1)").text()+"-";
                });
                del_ids = del_ids.substring( 0,del_ids.length-1);
                $.ajax({
                    url:"${pageContext.request.contextPath}/emp/"+del_ids,
                    type:"DELETE",
                    success:function (data){
                        alert(data.msg);
                        sendAjax(currentPage);
                        $("#check_all").prop("checked",false);
                    }
                });
            }
        }
    });
</script>
</body>
</html>
