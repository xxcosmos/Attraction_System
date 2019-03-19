<%--
  Created by IntelliJ IDEA.
  User: cosmos
  Date: 2019/2/26
  Time: 下午8:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="WEB-INF/jsp/common/head.jsp"%>
    <title>旅游景点导航</title>
</head>
<body class="vsc-initialized">
<%@include file="WEB-INF/jsp/common/navbar.jsp"%>

<div class="container">
    <div class="jumbotron">
        <h3>旅游景点导航</h3>
        <form method="post" action="algorithm/nav">
            <input class="form-control" type="text" id="attractionId" name="attractionId" required="required"
                   placeholder="请输入景点编号"/>
            <br/>
            <input type="submit" class="btn btn-primary btn-raised" value="查询路线">
        </form>
        <span class="label label-danger">${sessionScope.algorithm_error}</span>

    </div>

    <c:if test="${sessionScope.methods!=null}">
        <div class="jumbotron">
            <h4>路线信息</h4>
            <table class="table">
                <tbody>
                <c:forEach var="method" items="${sessionScope.methods}">
                    <tr>
                        <td>${method}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </c:if>
</div>
</body>
</html>
