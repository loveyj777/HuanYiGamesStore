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
		<link rel="stylesheet" href="../../css/font.css">
		<link rel="stylesheet" href="../../css/footer.css">


		<script type="text/html" id="colTool">
			<button class="layui-btn layui-btn-xs" lay-event="pay"><i class="layui-icon">&#xe642;</i>支付</button>
			<button class="layui-btn layui-btn-xs layui-btn-danger" lay-event="delete"><i class="layui-icon">&#xe640;</i>取消订单</button>
		</script>
		<script>
			$(function(){
				myOrderA=$('#myOrderA');

				myOrder_items=$('.person-items:eq(0)');
				myOrderA.css("background-color","#FF6D3F")
				myOrder();

				flushImg()

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
	</div>
	<div class=" layui-fluid " id="section" style="margin-top: 30px;height:1300px;">

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

				<!-- my orders	 -->
				<div class="person-items" style="padding:0px 15px 10px 15px;">

					<div class="layui-row  order-item">

						<div class="layui-col-lg4 "><a href="#" id="allorder" >全部订单</a></div>

						<div class="layui-col-lg4 "><a href="#" id="finishorder">已完成</a></div>

						<div class="layui-col-lg4 "><a href="#" id="nopay">未付款</a></div>

					</div>

					<div class="orderTables" style="display: unset;"><table class="layui-hide"  id="allOrderTable"></table></div>
					<div class="orderTables"><table class="layui-hide " id="finishOrderTable" ></table></div>
					<div class="orderTables"><table class="layui-hide " id="noPayTable" lay-filter="noPayTable"></table></div>

				</div>
			</div>

		</div>
	</div>
		<div id="footer" style="width: 100%;height: 300px;background-color: rgb(71,71,71);position: relative">

			<div id="download">
				<p>下载客户端:</p>
				<div id="pc">
					<span>PC端</span>
					<div class="yuan">
					</div>
				</div>
			</div>

			<div id="official">
				<p>官方渠道:</p>
				<div id="qvdao1">
					<span>微博</span>
					<div class="yuan1">
					</div>
				</div>
				<div id="qvdao2">
					<span>微信</span>
					<div class="yuan2">
					</div>
				</div>
			</div>

			<div id="friend">
				<p id="p">友情连接:</p>
				<div id="ftxt">
					<a id="p1" href="">凤凰游戏</a>
					<a href="" id="p2">杉果游戏</a>
					<a id="p3" href="">WeGame</a>
					<a href="" id="p4">Steam</a>
				</div>
			</div>

			<div id="bqtxt">
				<p>关于我们| AboutWe|服务条款│软件许可及服务协议│隐私保护指引|儿童隐私保护指引侵权通知|广告服务│客服中心│网站导航</p>
				<p>COPYRIGHT @ 2021- 2021 LoveYJ.ALL RIGHTS RESERVED.</p>
				<p>LoveYJ版权所有</p>
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
