<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2021/11/4
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>欢颐游戏管理端</title>
    <link rel="shortcut icon"  type="images/x-icon" href="http://119.91.193.63:8080/HuanYiGamesStore/shortcut.png" />
    <script src="http://119.91.193.63:8080/HuanYiGamesStore/js/jquery-3.5.1.js" type="text/javascript"></script>
    <script src="https://www.layuicdn.com/layui/layui.js"></script>
    <link href="https://www.layuicdn.com/layui/css/layui.css" rel="stylesheet" />
    <link rel="stylesheet" href="http://119.91.193.63:8080/HuanYiGamesStore/css/font.css">

</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo layui-hide-xs layui-bg-black">欢颐游戏</div>
        <!-- 头部区域（可配合layui 已有的水平导航） -->
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;" id="gameAdmin">游戏管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" id="gameControl">游戏管理</a></dd>
                        <dd><a href="javascript:;" id="addGame">添加游戏</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">优惠卷管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:; " id="addCoupon">添加优惠卷</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="">
            <iframe style="width: 100%;height: 100%;" id="iframe" src="/admin/controlGame" >

            </iframe>
        </div>
    </div>


</div>

<script>
    //JS
    $(function () {
        $('#gameControl').click(function () {
            $('#iframe').attr('src','/admin/controlGame')
        })
        $('#addGame').click(function () {
            $('#iframe').attr('src','/admin/addGame')
        })
        $('#addCoupon').click(function () {
            $('#iframe').attr('src','/admin/coupon')
        })
    })
    
    layui.use(['element', 'layer', 'util'], function(){
        var element = layui.element
            ,layer = layui.layer
            ,util = layui.util
            ,$ = layui.$;

        //头部事件
        util.event('lay-header-event', {

            menuLeft: function(othis){

                layer.msg('展开左侧菜单的操作', {icon: 0});
            }

        });

    });
</script>
</body>
</html>
