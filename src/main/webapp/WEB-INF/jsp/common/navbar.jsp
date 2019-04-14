<%@ page contentType="text/html;charset=UTF-8" %>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand hidden-sm" href="index.jsp">景区信息管理系统</a>
        </div>
        <div class="navbar-collapse collapse" role="navigation" aria-expanded="false" style="height: 1px;">
            <ul class="nav navbar-nav">
                <li class="hidden-sm hidden-md">
                    <a href="file_manage.jsp">文件管理</a>
                </li>
                <li>
                    <a href="attraction_search.jsp">景点查询</a>
                </li>
                <li>
                    <a href="attraction_nav.jsp">旅游景点导航</a>
                </li>
                <li>
                    <a href="shortest_path.jsp">搜索最短路径</a>
                </li>
                <li>
                    <a href="prim.jsp">铺设电路规划</a>
                </li>
                <li>
                    <a href="data_manage.jsp">数据管理</a>
                </li>
            </ul>
        </div>
    </div>
</div>
