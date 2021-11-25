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


		<link rel="shortcut icon"  type="images/x-icon" href="http://119.91.193.63:8080/HuanYiGamesStore/shortcut.png" />
		<script src="http://119.91.193.63:8080/HuanYiGamesStore/js/jquery-3.5.1.js" type="text/javascript"></script>
		<script src="http://lib.h-ui.net/jquery.cookie/1.4.1/jquery.cookie.js"></script>
		<script src="https://www.layuicdn.com/layui/layui.js"></script>
		<script src="http://119.91.193.63:8080/HuanYiGamesStore/js/header.js"></script>
		<script src="http://119.91.193.63:8080/HuanYiGamesStore/js/userInfo.js"></script>
		<link href="https://www.layuicdn.com/layui/css/layui.css" rel="stylesheet" />
		<link   rel="stylesheet" href="http://119.91.193.63:8080/HuanYiGamesStore/css/header.css"/>
		<link rel="stylesheet" href="http://119.91.193.63:8080/HuanYiGamesStore/css/footer.css">
		<link rel="stylesheet" href="http://119.91.193.63:8080/HuanYiGamesStore/css/font.css">
		<link rel="stylesheet" href="http://119.91.193.63:8080/HuanYiGamesStore/css/userInfo.css">

		<script>
			var nameInput;
			var nameSpan;
			$(function(){

				console.log("ok")

				myInfoA=$('#myInfoA');

				myInfo_items=$('.person-items:eq(0)');

				 nameInput=$('#nameInput');
				 nameSpan=$('#checkName');
				myInfoA.css("background-color","#FF6D3F")
				myInfo();
				nameBlur();
				flushImg()

				search();
			});
	function nameBlur() {
		nameInput.blur(function (){
			if (nameInput.val().length<2){
				nameSpan.text("昵称不符合规定")
				nameSpan.css('color','red')
				$('#submit').attr("disabled",true)
				$('#submit').css('cursor','not-allowed')
			}else if(nameInput.val()!=originalName){
				console.log(originalName)
				console.log(nameInput.val());
				$.ajax({
					type:'post',
					url:'/user/setting/checkUserNameAndPhone',
					dataType:'text',
					data:{'userName':nameInput.val(),'phone':''},
					success:function (data) {
						if (data==='ok'){
							nameSpan.text('该用户名可使用')
							nameSpan.css('color','red')
							$('#submit').attr("disabled",false)
							$('#submit').css('cursor','pointer')
						}else{
							nameSpan.text('该用户名已存在')
							nameSpan.css('color','red')
							$('#submit').attr("disabled",true)
							$('#submit').css('cursor','not-allowed')
						}
					}
				})
			}else {
				nameSpan.text(" ")
			}
		})
	}


		</script>
	</head>
	<body>


	<div id="header">
		<div class=" layui-row ">

			<div class="layui-col-lg2 logo ">

				<img src="http://119.91.193.63:8080/HuanYiGamesStore/img/logo.png" style="width: 190px;height: 67px;" />

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

			<c:choose>
				<c:when test="${sessionScope.user == null}">
					<div class="layui-col-lg2 " id="header-right" style="height: 67px;  overflow: hidden;display: inline-block;">

						<div style="padding: 14px 0px;">
							<a href="/login" style="text-align: center;">
								<span style="color: white;line-height: 35px;font-size: 12px;">登录</span>
							</a>
						</div>
					</div>
				</c:when>
				<c:when test="${ sessionScope.user.userName != null}">
					<div class="layui-col-lg2 " id="header-right" style="height: 67px;  overflow: hidden;display: inline-block;">

						<div style="padding: 14px 0px;">
							<a href="/shopCar">
								<span class="shopcar">&nbsp;</span>
							</a>
							<a href="/user/order" id="flushImg" target="_blank">
								<img   src="http://119.91.193.63:8080/HuanYiGamesStore/img/userHeadImg/${sessionScope.user.headImg}" class="person-icon"></img>
							</a>
						</div>
					</div>
				</c:when>
			</c:choose>
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


<%--				<!-- my info -->--%>

				<div class="person-items" style="height: 500px;">

						<form  class="layui-form" novalidate="novalidate"  lay-filter="infoForm" enctype="multipart/form-data" >
					<div class="layui-row person-info-panel-top" >
						<div class="layui-col-lg2"  id="person-img-div" >
							<div class="file-upicon"><button type="button" style="position: absolute;left: -13px;top: -4px;background-color: black"  class="layui-btn " id="imgUpload"><i class="layui-icon"  >&#xe67c;</i></button></div>
						</div>

						<div class="layui-col-lg9" style=" margin-left: 40px;">
							<div class="layui-row">
							<div class="layui-col-12"><p>个性介绍不超过50字</p></div>
							<div class="layui-col-12" style="margin-top: 25px;"><textarea  id="person-introduce" placeholder="你会对别人怎么形容自己..."name="introduce" maxlength="50"></textarea></div>
							</div>

						</div>

					</div>

							<div class="layui-row person-info-panel-bottom" >

								<div class="layui-col-lg2" ><p style="font-size:18px;">昵称:</p></div>
								<div class="layui-col-lg9" style="margin-left: 40px;"><input type="text" class="person-info-bottom-input" maxlength="16" id="nameInput" lay-verify="required|username"  name="username"/><span id="checkName"></span></div>
								<div class="layui-col-lg12" ><p style="font-size: 12px;padding:15px 0px 40px 170px;">2-16个字符，可由中英文、数字、“_”组成</p></div>


								<div class="layui-col-lg2"><p style="font-size:18px;">手机:</p></div>
								<div class="layui-col-lg9" style="margin-left: 40px;" id="phone-div"></div>
								<div class="layui-col-lg12" style="padding-bottom:40px;"></div>


								<div class="layui-col-lg2"><p style="font-size:18px;">密码:</p></div>
								<div class="layui-col-lg9" style="margin-left: 40px;"><a href="javascript:updatePwd()">修改密码</a></div>

							</div>


						<div style="position: absolute;right: 100px;bottom: 0px;"><button class="submit-btn" lay-submit  lay-filter="personInfo" id="submit"  >保存全部修改</button></div>
				</form>
				</div>


				</div>
			</div>
		</div>

		<div id="footer" style="width: 100%;height: 300px;background-color: rgb(71,71,71);position: relative;float: left;margin-top: 200px">

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
				<p>COPYRIGHT @ 2021 LoveYJ.ALL RIGHTS RESERVED. LoveYJ 版权所有</p>


				<p><a href="https://beian.miit.gov.cn/#/Integrated/index" target="_blank" style="color: grey">湘ICP备2021018874号</a></p>
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
