<%--
  Created by IntelliJ IDEA.
  User: cosmos
  Date: 2019/3/9
  Time: 上午11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="WEB-INF/jsp/common/head.jsp"%>
    <title>铺设电路规划</title>
</head>
<body class="vsc-initialized">
<%@include file="WEB-INF/jsp/common/navbar.jsp"%>

<div class="container">
    <div class="jumbotron">
        <h3>铺设电路规划</h3>
        <form method="get" action="algorithm/prim">
            <input type="submit" class="btn btn-primary btn-raised" value="查询">
        </form>
        <%--<span class="label label-danger" >${sessionScope.error_msg}</span>--%>
    </div>

    <c:if test="${sessionScope.prim.roads!=null}">
        <div class="jumbotron">
            <h4>规划信息</h4>
            <span class="label label-info">总距离：${sessionScope.prim.length}</span>
            <table class="table">
                <thead>
                <tr>
                    <td>道路</td>
                    <td>  </td>
                    <td>距离</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${sessionScope.prim.roads}">

                    <tr>
                        <td>${item.attractionFirst.name}</td>
                        <td>${item.attractionSecond.name}</td>
                        <td>${item.distance}</td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </c:if>
</div>
</body>
</html>
