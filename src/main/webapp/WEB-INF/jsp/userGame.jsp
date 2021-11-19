<%--
Created by IntelliJ IDEA.
User: LoveYJ
Date: 2021/10/8
Time: 9:13
To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta charset="utf-8">
		<title>欢颐游戏</title>


		<link rel="shortcut icon" href="../../img/shortcut.png" />
		<script src="../../js/jquery-3.5.1.js" type="text/javascript"></script>
		<script src="../../layui/layui/layui.js"></script>
		<script src="../../js/userInfo.js"></script>
		<script src="../../js/header.js"></script>
		<link href="../../layui/layui/css/layui.css" rel="stylesheet" />
		<link   rel="stylesheet" href="../../css/header.css"/>
		<link rel="stylesheet" href="../../css/userInfo.css">


		<script type="text/html" id="colTool">
			<button class="layui-btn layui-btn-xs" lay-event="pay"><i class="layui-icon">&#xe642;</i>支付</button>
			<button class="layui-btn layui-btn-xs layui-btn-danger" lay-event="delete"><i class="layui-icon">&#xe640;</i>取消订单</button>
		</script>
		<script>

			$(function(){

				myGamesA=$('#myGamesA');

				myGames_items=$('.person-items:eq(0)');
				myGames();
				myGamesA.css("background-color","#FF6D3F")
				search();
			});





		</script>
	</head>
	<body>


	<div id="header">
		<div class=" layui-row ">

			<div class="layui-col-lg2 logo ">

				<img src="../img/logo.png" style="width: 190px;height: 67px;" />

			</div>

			<div class=" layui-col-lg4   nav_list ">
				<ul>
					<li><a href="/index" style="color: white">首页</a></li>

					<li><a href="/games" style="color: white">商城</a></li>
					<li><a href="/pointsShop" style="color: white">积分商城</a></li>
				</ul>
			</div>




			<div class="layui-col-lg4 search"id="">

				<div style="  display: inline-block; padding: 14px 0px; ">
					<div class="search-border">
						<div style=" display: inline-block;"><input type="text" id="searchText" placeholder="请输入关键词" class="search-input" />
						</div>
						<div class="search-icon">&nbsp;</div>
					</div>
				</div>
			</div>


			<div class="layui-col-lg2 " id="header-right" style="height: 67px;  overflow: hidden;display: inline-block;">

				<div style="padding: 14px 0px;">
					<a href="/shopCar">
						<span class="shopcar">&nbsp;</span>
					</a>
					<a href="/user/order" id="flushImg">
						<img   src="../img/userHeadImg/${sessionScope.user.headImg}" class="person-icon"></img>
					</a>
				</div>
			</div>
		</div>



	<div class=" layui-fluid " id="section" style="margin-top: 30px;">

			<div id="person-meau-left">
				<dl style="height: 600px;">
					<dt>订单中心</dt>
					<dd class="dd-line"></dd>
					<dd><a href="/user/order" id="myOrderA">我的订单</a></dd>
					<dd><a href="/user/games" id="myGamesA">我的游戏</a></dd>


					<dt>我的财产</dt>
					<dd class="dd-line"></dd>

					<dd><a href="/user/coupon" id="myCouponA">我的优惠</a></dd>
					<dd><a href="/user/points" id="myPointsA">我的积分</a></dd>



					<dt>我的账户</dt>
					<dd class="dd-line"></dd>
					<dd><a href="/user/setting"id="myInfoA">基本信息</a></dd>


				</dl>
			</div>



				<div id="person-meau-middle">

				<!-- my games -->

				<div class="person-items" style="padding:0px 15px 10px 15px;">
					<div class="myGames"><table class="layui-hide " id="myGames" ></table></div>
				</div>

				</div>

			</div>
		</div>
	</body>


<style>
	th .layui-table-cell {

		max-height: 40px;
		line-height: 30px;
	}
	.layui-table-cell {

		white-space: normal;
		height:90px !important;
		word-break: break-all;
	}
	.layui-table img {

		max-height: 90px;
		max-width: 200px;
	}

</style>
</html>
