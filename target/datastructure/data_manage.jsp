<%--
  Created by IntelliJ IDEA.
  User: cosmos
  Date: 2019/3/9
  Time: 上午11:51
  To change this template use File | Settings | File Templates.
--%>
--%>
<html>
<%@ page contentType="text/html;charset=UTF-8"%>
<head>
    <%@include file="WEB-INF/jsp/common/head.jsp"%>
    <title>数据管理</title>
</head>

<body class="vsc-initialized">

<%@include file="WEB-INF/jsp/common/navbar.jsp"%>

<div class="container">
    <br/><br/>
    <h3>数据管理</h3>
    <div class="jumbotron">

        <h4>新增景点</h4>
        <form method="post" action="database/attraction/add">
            <input class="form-control" type="text" id="id" name="id" required="required"
                   placeholder="请输入景点编号"/>
            <br/>
            <input class="form-control" type="text" id="name" name="name" required="required"
                   placeholder="请输入景点名称"/>
            <br/>
            <input class="form-control" type="text" id="introduction" name="introduction" required="required"
                   placeholder="请输入景点介绍"/>
            <br/>
            <input type="submit" class="btn btn-primary btn-raised" value="提交">
        </form>
        <span class="label label-danger">${sessionScope.attraction_add_msg}</span>
    </div>
    <div class="jumbotron">

        <h4>删除景点</h4>
        <form method="post" action="database/attraction/delete">
            <input class="form-control" type="text" id="deleteId" name="deleteId" required="required"
                   placeholder="请输入景点编号"/>
            <br/>
            <input type="submit" class="btn btn-primary btn-raised" value="提交">
        </form>
        <span class="label label-danger">${sessionScope.attraction_delete_msg}</span>
    </div>

    <div class="jumbotron">

        <h4>修改景点信息</h4>
        <form method="post" action="database/attraction/update">
            <input class="form-control" type="text" id="updateId" name="updateId" required="required"
                   placeholder="请输入景点编号"/>
            <br/>
            <input class="form-control" type="text" id="updateName" name="updateName" required="required"
                   placeholder="请输入新的景点名称"/>
            <br/>
            <input class="form-control" type="text" id="updateIntroduction" name="updateIntroduction" required="required"
                   placeholder="请输入新的景点介绍"/>
            <br/>
            <input type="submit" class="btn btn-primary btn-raised" value="提交">
        </form>
        <span class="label label-danger">${sessionScope.attraction_update_msg}</span>
    </div>


    <div class="jumbotron">

        <h4>新增道路</h4>
        <form method="post" action="database/road/add">
            <input class="form-control" type="text" id="addFirstId" name="addFirstId" required="required"
                   placeholder="请输入景点编号"/>
            <br/>
            <input class="form-control" type="text" id="addSecondId" name="addSecondId" required="required"
                   placeholder="请输入景点编号"/>
            <br/>
            <input class="form-control" type="text" id="addDistance" name="addDistance" required="required"
                   placeholder="请输入距离"/>
            <br/>
            <input type="submit" class="btn btn-primary btn-raised" value="提交">
        </form>
        <span class="label label-danger">${sessionScope.road_add_msg}</span>
    </div>

    <div class="jumbotron">

        <h4>删除道路</h4>
        <form method="post" action="database/road/delete">
            <input class="form-control" type="text" id="deleteFirstId" name="deleteFirstId" required="required"
                   placeholder="请输入景点编号"/>
            <br/>
            <input class="form-control" type="text" id="deleteSecondId" name="deleteSecondId" required="required"
                   placeholder="请输入景点编号"/>
            <br/>

            <input type="submit" class="btn btn-primary btn-raised" value="提交">
        </form>
        <span class="label label-danger">${sessionScope.road_delete_msg}</span>
    </div>

    <div class="jumbotron">

        <h4>修改道路信息</h4>
        <form method="post" action="database/road/update">
            <input class="form-control" type="text" id="updateFirstId" name="updateFirstId" required="required"
                   placeholder="请输入景点编号"/>
            <br/>
            <input class="form-control" type="text" id="updateSecondId" name="updateSecondId" required="required"
                   placeholder="请输入景点编号"/>
            <br/>
            <input class="form-control" type="text" id="updateDistance" name="updateDistance" required="required"
                   placeholder="请输入修改后的距离"/>
            <br/>
            <input type="submit" class="btn btn-primary btn-raised" value="提交">
        </form>
        <span class="label label-danger">${sessionScope.road_update_msg}</span>
    </div>


</div>

</body>
</html>
