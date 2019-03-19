<%--
  Created by IntelliJ IDEA.
  User: cosmos
  Date: 2019/1/27
  Time: 下午6:54
  To change this template use File | Settings | File Templates.
--%>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>
<head>
    <%@include file="WEB-INF/jsp/common/head.jsp" %>
    <title>景点查询</title>
</head>

<body class="vsc-initialized">

<%@include file="WEB-INF/jsp/common/navbar.jsp" %>

<div class="container">

    <div class="jumbotron">
        <h3>查询景点</h3>
        <form method="post" action="database/search">
            <input class="form-control" type="text" id="attractionId" name="attractionId" required="required"
                   placeholder="请输入景点编号"/>
            <br/>
            <input type="submit" class="btn btn-primary btn-raised" value="查询景点">
        </form>
        <span class="label label-danger">${sessionScope.error}</span>
        <br/><br/>
        <form method="get" action="database/list">
            <input type="submit" class="btn btn-primary btn-raised" value="景点列表">
        </form>
        <form method="get" action="database/graph">
            <input type="submit" class="btn btn-primary btn-raised" value="图的邻接矩阵">
        </form>
    </div>

    <c:if test="${sessionScope.graph!=null}">
        <div class="jumbotron">
            <h4>邻接矩阵</h4>
            <table class="table">
                <thead>
                <tr>
                    <td></td>
                    <c:forEach var="item" items="${sessionScope.graph.attractionList}">

                        <td>${item.name}</td>

                    </c:forEach>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="i" begin="0" end="${sessionScope.graph.vexNum-1}">
                    <tr>
                        <td>${sessionScope.graph.attractionList[i].name}</td>

                        <c:forEach var="j" begin="0" end="${sessionScope.graph.vexNum-1}">
                            <td>
                                <c:choose>
                                    <c:when test="${sessionScope.graph.matrix[i][j]>2147483600}">
                                        -
                                    </c:when>
                                    <c:otherwise>
                                        ${sessionScope.graph.matrix[i][j]}
                                    </c:otherwise>
                                </c:choose>

                            </td>
                        </c:forEach>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </c:if>
    <c:if test="${sessionScope.attractionList!=null}">
        <div class="jumbotron">
            <h4>景点信息</h4>
            <table class="table">
                <thead>
                <tr>
                    <td>景点编号</td>
                    <td>景点名称</td>
                    <td>景点介绍</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="attraction" items="${sessionScope.attractionList}">
                    <tr>
                        <td>${attraction.id}</td>
                        <td>${attraction.name}</td>
                        <td>${attraction.introduction}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

        <c:if test="${sessionScope.attractionInfo!=null}">
            <div class="jumbotron">
                <h4>相邻景点信息</h4>
                <table class="table">
                    <thead>
                    <tr>
                        <td>景点名称</td>
                        <td>距离</td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="road" items="${sessionScope.attractionInfo.roads}">
                        <tr>
                            <td>
                                <c:choose>
                                    <c:when test="${road.attractionFirst.id==sessionScope.attractionInfo.attraction.id}">
                                        ${road.attractionSecond.name}
                                    </c:when>
                                    <c:otherwise>
                                        ${road.attractionFirst.name}
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td> ${road.distance}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:if>
    </c:if>
</div>

</body>
</html>
