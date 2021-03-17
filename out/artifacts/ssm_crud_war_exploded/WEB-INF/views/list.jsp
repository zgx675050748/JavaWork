<%--
  Created by IntelliJ IDEA.
  User: 67505
  Date: 2021/3/17
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <table class="table table-hover">
                    <tr>
                        <th>#</th>
                        <th>empName</th>
                        <th>gender</th>
                        <th>email</th>
                        <th>deptName</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${pageInfo.list}"
                               var="employee">
                        <tr>
                            <th>${employee.empId}</th>
                            <th>${employee.empName}</th>
                            <th>${employee.gender}</th>
                            <th>${employee.email}</th>
                            <th>${employee.department.deptName}</th>
                            <th>
                                <button class="btn btn-primary btn-sm">
                                    <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                    编辑
                                </button>
                                <button class="btn btn-danger btn-sm">
                                    <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                    删除
                                </button>
                            </th>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">当前${pageInfo.pageNum}页，总${pageInfo
            .pages}页，总${pageInfo.total}条记录</div>
            <div class="col-md-6">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <c:if test="${pageInfo.isFirstPage}">
                            <li class="disabled"><a href="#">首页</a></li>
                            <li class="disabled">
                                <a href="#" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:if>
                        <c:if test="${!pageInfo.isFirstPage}">
                            <li><a
                                    href="${pageContext.request.contextPath}/emps?pn=1">首页</a></li>
                            <li>
                                <a
                                        href="${pageContext.request.contextPath}/emps?pn=${pageInfo.prePage}" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:if>
                        <c:forEach items="${pageInfo.navigatepageNums}"
                                   var="page">
                            <c:if test="${page==pageInfo.pageNum}">
                                <li class="active"><a href="#">${page}</a></li>
                            </c:if>
                            <c:if test="${page!=pageInfo.pageNum}">
                                <li><a
                                        href="${pageContext.request.contextPath}/emps?pn=${page}">${page}</a></li>
                            </c:if>
                        </c:forEach>
                        <c:if test="${pageInfo.isLastPage}">
                            <li class="disabled">
                                <a href="#" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                            <li class="disabled"><a href="#">末页</a></li>
                        </c:if>
                        <c:if test="${!pageInfo.isLastPage}">
                            <li>
                                <a
                                        href="${pageContext.request.contextPath}/emps?pn=${pageInfo.nextPage}" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                            <li><a
                                    href="${pageContext.request.contextPath}/emps?pn=${pageInfo.pages}">末页</a></li>
                        </c:if>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</body>
</html>
