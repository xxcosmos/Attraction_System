<%--
  Created by IntelliJ IDEA.
  User: cosmos
  Date: 2019/3/6
  Time: 下午8:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="WEB-INF/jsp/common/head.jsp" %>
    <title>搜索最短路径</title>
</head>
<body class="vsc-initialized">
<%@include file="WEB-INF/jsp/common/navbar.jsp" %>

<div class="container">
    <div class="jumbotron">
        <h3>搜索最短路径</h3>
        <form method="post" action="algorithm/shortest_path">
            <input class="form-control" type="text" id="beginID" name="beginID" required="required"
                   placeholder="请输入起始景点的编号"/>
            <input class="form-control" type="text" id="endID" name="endID" required="required"
                   placeholder="请输入终点的编号"/>
            <br/>
            <input type="submit" class="btn btn-primary btn-raised" value="查询路线">
        </form>
        <span class="label label-danger">${sessionScope.error_msg}</span>
    </div>

    <c:if test="${sessionScope.shortestPath.path!=null}">
    <div class="jumbotron">
        <h4>路线信息</h4>
        <table class="table">
            <thead>
            <tr>
                <td>路线</td>
                <td>距离</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${sessionScope.shortestPath.path}">

            <tr>
                <td>${item}</td>
                <td>${sessionScope.shortestPath.length}</td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    </c:if>
</div>
</body>
</html>
