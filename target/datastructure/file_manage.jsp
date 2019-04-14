<%--
  Created by IntelliJ IDEA.
  User: cosmos
  Date: 2019/1/24
  Time: 上午10:18
  To change this template use File | Settings | File Templates.
--%>
<html lang="zh-CN">
<%@ page contentType="text/html;charset=UTF-8" %>

<head>
    <%@include file="WEB-INF/jsp/common/head.jsp" %>
    <title>文件管理</title>
</head>
<body>

<%@include file="WEB-INF/jsp/common/navbar.jsp" %>
<div class="container">
    <div class="jumbotron">
        <h3>文件上传</h3>
        <form method="post" action="file/upload" enctype="multipart/form-data" role="form">
            <label class="label label-primary" for="vexFile">Choose Vex File to upload:</label>
            <br/><br/>
            <input  type="file" name="vexFile" id="vexFile" required="required" />
            <br/><br/>
            <label class="label label-primary" for="edgeFile">Choose Edge file to upload:</label>
            <br/><br/>
            <input  type="file" name="edgeFile" id="edgeFile" required="required" />
            <br/>
            <button type="submit" class="btn btn-primary">上传</button>
            <label class="alert-danger">
                ${sessionScope.result}
            </label>
        </form>

    </div>
    <div class="jumbotron">
        <h3>文件下载</h3>
        <form method="get" action="file/vex/download"  class="form-horizontal" role="form">
            <button type="submit" class="btn btn-primary">下载景点信息</button>
        </form>

        <form method="get" action="file/edge/download"  class="form-horizontal" role="form">
            <button type="submit" class="btn btn-primary">下载道路信息</button>
        </form>

    </div>
</div>


</body>
</html>
